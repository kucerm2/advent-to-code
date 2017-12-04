(ns advent-2017.day1.part2)

(defn to-ints
  [str]
  (map #(- (int %) 48) str))

(defn solve
  [str]
  (let [half (/ (count str) 2)
        [xs ys] (split-at half (to-ints str))]
    (->> (map vector (concat xs ys) (concat ys xs))
         (filter #(= (first %) (second %)))
         (map first)
         (reduce +))))

(defn test1 []
  (= 6 (solve "1212")))
(defn test2 []
  (= 0 (solve "1221")))
(defn test3 []
  (= 4 (solve "123425")))
(defn test4 []
  (= 12 (solve "123123")))
(defn test5 []
  (= 4 (solve "12131415")))


1543
612
789