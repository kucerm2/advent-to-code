(ns advent-2017.day-11.shared
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

(def lookup-operation
  {'<  <
   '>   >
   '<=  <=
   '>=  >=
   '!=  not=
   '==  =
   'inc +
   'dec -})

(defn to-operation
  [op-str val]
  #(let [prev (if (nil? %) 0 %)] ((lookup-operation op-str) prev val)))


(defn to-instruction
  [instruction]
  (let [[reg op-name op-val _ if-reg if-op if-val] instruction
        pred? (lookup-operation if-op)
        op (to-operation op-name op-val)]
    [(fn [regs]
       (if (pred? (get regs if-reg 0) if-val)
         (update regs reg op)
         regs))
     instruction]))


(defn parse-instruction
  [str]
  (->> (format "[%s]" str)
       (edn/read-string)
       (to-instruction)))


(defn parse-input
  [file]
  (->> file
       io/reader
       line-seq
       (map parse-instruction)))


(defn evaluate
  [ops regs]
  (reduce (fn [[rs highest] op]
            (let [result ((first op) rs)]
              [result (if-not (empty? result)
                        (max highest (val (apply max-key val result)))
                        highest)]))
          [regs Integer/MIN_VALUE] ops))