(ns advent-2017.day5.part2
  (:require [clojure.string :as str]
            [advent-2017.day5.shared :refer [step]]))

(defn solve
  [states-str]
  (let [states (->> (str/split-lines states-str)
                    (map #(Integer. %))
                    (into []))]
    ((step #((if (> % 2) dec inc) %)) states 0 0)))
