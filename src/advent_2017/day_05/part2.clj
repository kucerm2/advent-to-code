(ns advent-2017.day-05.part2
  (:require [clojure.string :as str]
            [advent-2017.day-05.shared :refer [step]]))

(defn solve
  [states]
  ((step #((if (> % 2) dec inc) %)) states 0 0))
