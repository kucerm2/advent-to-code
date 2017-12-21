(ns advent-2017.day-10.part2
  (:require [advent-2017.day-10.shared :as sh]))

(defn to-hex
  [coll]
  (apply str (map #(format "%02x" %) coll)))

(defn finalize-str
  [str]
  (into (concat (mapv int str) [17 31 73 47 23])))

(defn dense
  [coll]
  (apply bit-xor coll))


(defn solve
  [str]
  (let [hash (sh/knot-hash (into [] (range 256))
                           (finalize-str str)
                           64)]
    (to-hex (map dense (partition 16 hash)))))




