(ns advent-2017.day-05.shared
  (:require [clojure.java.io :as io]))

(defn step
  [transform-state-fn]
  (fn [states steps position]
    (let [offset (get states position)]
      (if (nil? offset)
        steps
        (recur (update states position transform-state-fn)
               (inc steps)
               (+ position offset))))))


(def input (->> "resource/advent_2017/day_05/input.txt"
                io/reader
                line-seq
                (map read-string)
                vec))
