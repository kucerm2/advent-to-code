(ns advent-2017.day-08.part1
  (:require [advent-2017.day-08.shared :as sh]))

(defn solve
  [ops]
  (val (apply max-key val (first (sh/evaluate ops {})))))
