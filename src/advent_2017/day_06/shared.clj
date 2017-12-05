(ns advent-2017.day-06.shared
  (:require [clojure.java.io :as io]))

(def input (->> "resource/advent_2017/day_06/input.txt"
                io/reader
                line-seq
                (map read-string)
                vec))



