(ns advent-2017.day-04.shared
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def input (->> "resource/advent_2017/day_04/input.txt"
                io/reader
                line-seq
                vec))

(defn check-phrase
  [normalize-fn]
  (fn [str]
    (->>
      (str/split str #" ")
      (map normalize-fn)
      (apply distinct?))))


