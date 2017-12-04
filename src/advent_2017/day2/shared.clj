(ns advent-2017.day2.shared
  (:require '[clojure.string :as str]))

(defn checksum [str decode]
  (->> (str/split str #"\n")
       (map #(str/split % #"\t"))
       (map #(map (fn [xs] (Integer. xs)) %))
       (map decode)
       (reduce +)))
