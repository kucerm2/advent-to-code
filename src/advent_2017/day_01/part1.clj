(ns advent-2017.day-01.part1)

(defn to-ints
  [str]
  (map #(- (int %) 48) str))

(defn reducer
  [[acc last] curr]
  (if (= last curr) [(+ acc curr) curr] [acc curr]))

(defn solve
  [str]
  (let [xs (to-ints str)]
    (reduce reducer [0 (last xs)] xs)))



1543
612
789