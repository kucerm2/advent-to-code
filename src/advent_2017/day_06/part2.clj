(ns advent-2017.day-06.part2
  (:require [advent-2017.day-06.shared :as sh]))

(defn solve
  [coll]
  (let [res (sh/solve coll)]
    (- (first res) (second res))))

