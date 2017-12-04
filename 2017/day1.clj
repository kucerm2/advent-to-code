(defn to-ints
  [str]
  (map #(- (int %) 48) str))

(defn reducer
  [[acc last] curr]
  (if (= last curr) [(+ acc curr) curr] [acc curr]))

(defn part1
  [str]
  (let [xs (to-ints str)]
    (reduce reducer [0 (last xs)] xs)))

(defn part2
  [str]
  (let [half (/ (count str) 2)
        [xs ys] (split-at half (to-ints str))]
    (->> (map vector (concat xs ys) (concat ys xs))
         (filter #(= (first %) (second %)))
         (map first)
         (reduce +))))

(defn test1 []
  (= 6 (part2 "1212")))
(defn test2 []
  (= 0 (part2 "1221")))
(defn test3 []
  (= 4 (part2 "123425")))
(defn test4 []
  (= 12 (part2 "123123")))
(defn test5 []
  (= 4 (part2 "12131415")))
