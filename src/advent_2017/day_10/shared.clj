(ns advent-2017.day-10.shared)

(defn spy
  [info x]
  (do
    (print (str info "-"))
    (println x)
    x))

(defn sublist
  [pos len xs]
  (->> (cycle xs)
       (drop pos)
       (take len)))

(defn norm-idx
  [idx max]
  (mod idx max))

(defn merge
  [pos sublist coll]
  (let [len (count coll)]
    (first
      (reduce (fn [[coll idx] x]
                [(assoc coll (norm-idx idx len) x) (norm-idx (inc idx) len)])
              [coll pos]
              sublist))))

(defn reverse-sublist
  [pos cnt coll]
  (merge pos
         (reverse (sublist pos cnt coll))
         coll))

(defn hash
  [coll shift-list]
  (first (reduce (fn [[coll pos skip] shift]
                   [(reverse-sublist pos shift coll) (+ pos shift skip) (inc skip)])
                 [coll 0 0]
                 shift-list)))
