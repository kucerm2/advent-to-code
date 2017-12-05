(ns advent-2017.day-03.part1)

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

(defn location
  "Gives the location for a given memory square."
  [square]
  (nth spiral (dec square)))

(defn distance
  "Determines the Manhattan distance of a location from the origin."
  [[x y]]
  (+ (Math/abs x) (Math/abs y)))

(defn solve
  "Solves the puzzle for a memory square. If none provided, solves using the
  main puzzle input."
  ([] (solve 368078))
  ([square]
   (distance (location square))))
