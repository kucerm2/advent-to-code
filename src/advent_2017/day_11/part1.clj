(ns advent-2017.day-11.part1
  (:require [advent-2017.day-11.shared :as sh]))

(defn solve
  [ops]
  (val (apply max-key val (first (sh/evaluate ops {})))))
