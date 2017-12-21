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

(defn merge-sublist
  [pos sublist coll]
  (let [len (count coll)]
    (first
      (reduce (fn [[coll idx] x]
                [(assoc coll (norm-idx idx len) x) (norm-idx (inc idx) len)])
              [coll pos]
              sublist))))

(defn reverse-sublist
  [pos cnt coll]
  (merge-sublist pos
                 (reverse (sublist pos cnt coll))
                 coll))

(defn khash
  [coll shift-list rep]
  (let [coll-cnt (count coll)
        shift-cnt (* rep (count shift-list))
        shifts (take shift-cnt (cycle shift-list))]
    (reduce (fn [[coll pos skip] shift]
              [(reverse-sublist (mod pos coll-cnt) shift coll) (+ pos shift skip) (inc skip)])
            [coll 0 0]
            shifts)))

(defn knot-hash
  ([coll shift-list] (first (khash coll shift-list 1)))
  ([coll shift-list rep] (first (khash coll shift-list rep))))

