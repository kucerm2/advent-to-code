(ns advent-2017.day-11.part1
  (:require [advent-2017.day-11.shared :as sh]))

(defn solve
  [dirs]
  (sh/dist (reduce sh/move [0 0 0] dirs)))
