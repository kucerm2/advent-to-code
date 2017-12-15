(ns advent-2017.day-09.shared
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

(defn parse-input
  [file]
  (->> file
       io/reader
       slurp))

(defn reducer
  [[acc ignore? score garbage? garbage-count :as state] c]
  (cond
    ignore? [acc false score garbage? garbage-count]
    (= c \!) [acc true score garbage? garbage-count]
    (and garbage? (= c \>)) [acc false score false garbage-count]
    garbage? [acc false score true (inc garbage-count)]
    (= c \<) [acc false score true garbage-count]
    (= c \{) [acc false (inc score) false garbage-count]
    (= c \}) [(conj acc score) false (dec score) false garbage-count]
    :else state))

(defn group-score
  [seq]
  (reduce reducer
          [[] false 0 false 0]
          seq))
