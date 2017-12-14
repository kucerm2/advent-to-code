(ns advent-2017.day-08.part2
  (:require [advent-2017.day-08.shared :as sh]))

(defn solve
  [ops]
  (second (sh/evaluate ops {})))
