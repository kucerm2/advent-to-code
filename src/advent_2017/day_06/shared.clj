(ns advent-2017.day-06.shared)


(def input [10 3 15 10 5 15 5 15 9 2 5 8 5 2 3 6])

(defn reallocate
  [next-fn v]
  (let [val (apply max v)
        max-ndx (.indexOf v val)]
    (->>
      (range val)
      (map #(next-fn (+ (next-fn (inc max-ndx)) %)))
      (frequencies)
      (reduce (fn [res [k v]] (update res k + v)) (assoc v max-ndx 0)))))

(defn solve
  [coll]
  (let [next-fn #(mod % (count coll))]
    (->> (iterate (partial reallocate next-fn) coll)
         (reduce (fn [[last-seen step] x]
                   (if (last-seen x)
                     (reduced [step (last-seen x)])
                     [(assoc last-seen x step) (inc step)]))
                 [{} 0]))))