(ns advent-2017.day-02.part2
  [require [advent-2017.day2.shared :as sh]])

(defn div-decoder [coll]
  (->> (let [xs (sort coll)]
         (for [x xs y xs :while (not= x y)]
           [x y]))
       (filter #(= 0 (mod (first %) (second %))))
       (map #(/ (first %) (second %)))
       (first)))

(defn solve [str]
  (sh/checksum str div-decoder))

