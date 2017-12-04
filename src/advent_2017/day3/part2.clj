(ns advent-2017.day3.part2)

(defn candidate-locations
  "Given a location, produces the four candidate adjacent locations in
  counter-clockwise order."
  [[x y]]
  (map (fn [[dx dy]]
         [(+ x dx) (+ y dy)])
       [[0 -1] [-1 0] [0 1] [1 0]]))

(defn step
  "Given a vector containing a location and the set of used locations,
  produces a vector containing the next location and set of used locations."
  [[location used-locations]]
  (let [next-location (->> location
                           candidate-locations
                           (map (fn [candidate-location]
                                  [candidate-location (contains? used-locations candidate-location)]))
                           cycle
                           (drop-while (complement second))
                           (drop-while second)
                           ffirst)]
    [next-location (conj used-locations next-location)]))

(def spiral
  "A lazy sequnce of the memory locations."
  (->> [[1 0] #{[0 0] [1 0]}]
       (iterate step) (map first)
       (cons [0 0])))

(defn adjacent-locations
  "Given a location, produces the eight adjacent locations."
  [[x y]]
  (map (fn [[dx dy]]
         [(+ x dx) (+ y dy)])
       [[-1 1] [0 1] [1 1]
        [-1 0] [1 0]
        [-1 -1] [0 -1] [1 -1]]))

(defn solve
  "Solves the puzzle for a memory square. If none provided, solves using the
  main puzzle input."
  ([] (solve 368078))
  ([x]
   (reduce (fn [acc location]
             (let [value (apply + (map #(acc % 0) (adjacent-locations location)))]
               (if (< x value)
                 (reduced value)
                 (assoc acc location value))))
           {[0 0] 1}
           (rest spiral))))