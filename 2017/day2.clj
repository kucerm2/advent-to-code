(require '[clojure.string :as str])

(defn checksum [str decode]
  (->> (str/split str #"\n")
       (map #(str/split % #"\t"))
       (map #(map (fn [xs] (Integer. xs)) %))
       (map decode)
       (reduce +)))

(defn min-max-decoder [coll]
  (let [max (apply max coll)
        min (apply min coll)]
    (- max min)))

(defn div-decoder [coll]
  (->> (let [xs (sort coll)]
         (for [x xs y xs :while (not= x y)]
           [x y]))
       (filter #(= 0 (mod (first %) (second %))))
       (map #(/ (first %) (second %)))
       (first)))

(defn part1 [str]
  (checksum str min-max-decoder))

(defn part2 [str]
  (checksum str div-decoder))

