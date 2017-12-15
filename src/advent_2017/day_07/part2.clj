(ns advent-2017.day-07.part2
  (:require
    [clojure.java.io :as io]
    [clojure.string :as str]
    [clojure.spec.alpha :as s]
    [clojure.set :as set])
  (:import (java.io PushbackReader)))


(def input (->> "resource/advent_2017/day_07/input.txt" io/reader PushbackReader.))

(s/def ::weight (s/coll-of int? :kind list? :min-count 1 :max-count 1))
(s/def ::program (s/alt ::solo (s/cat :name symbol? :weight ::weight)
                        ::deps (s/cat :name symbol? :weight ::weight ::arrow #{'->} :held (s/* symbol?))))

(s/check-asserts true)
(def data (->> (repeatedly #(read {:eof nil} input))
               (take-while some?)
               (s/assert (s/* ::program))
               (s/conform (s/* ::program))
               (map second)
               (map #(update % :weight first))))

(let [index (set/index data [:name])]
  (defn lookup [name]
    (first (index {:name name}))))

(defn weight [name]
  (let [program (lookup name)]
    (apply + (:weight program) (map weight (:held program)))))

(defn solution []
  (some (fn [program]
          (when-let [held (:held program)]
            (let [weights (map weight held)]
              (when-not (apply == weights)
                (let [unique-weight ((set/map-invert (frequencies weights)) 1)]
                  (+ (:weight (lookup (nth held (.indexOf weights unique-weight))))
                     (- (apply min weights) (apply max weights))))))))
        data))
