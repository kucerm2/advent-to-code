(ns advent-2017.day-11.part2
  (:require [advent-2017.day-11.shared :as sh]))

(defn solve
  [dirs]
  (apply max (map sh/dist (reductions sh/move [0 0 0] dirs))))
