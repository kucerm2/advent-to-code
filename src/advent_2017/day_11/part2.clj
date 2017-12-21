(ns advent-2017.day-11.part2
  (:require [advent-2017.day-11.shared :as sh]))

(defn solve
  [ops]
  (second (sh/evaluate ops {})))
