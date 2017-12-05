(ns advent-2017.day5.shared)

(defn step
  [transform-state-fn]
  (fn [states steps position]
    (let [offset (get states position)]
      (if (nil? offset)
        steps
        (recur (assoc states position (transform-state-fn offset))
               (inc steps)
               (+ position offset))))))
