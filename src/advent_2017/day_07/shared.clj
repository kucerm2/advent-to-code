(ns advent-2017.day-07.shared
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(defn parse-child-list [child-list-str]
  (if (nil? child-list-str)
    nil
    (drop 2 (->
              child-list-str
              (str/replace #"," "")
              (str/split #" ")))))

(defn parse-tower
  [[name weight childs]]
  [name (-> {}
          (assoc :weight (Integer. weight))
          (assoc :child-names (parse-child-list childs)))])

(defn read-tower-line
  [line-str]
  (->
    (select-keys
      (re-find #"(\w*) \((\d*)\)(\s->\s([\w]+(, )?)+)?" line-str)
      [1 2 3])
    vals))

(defn parse-input
  [file]
  (into {} (->> file
             io/reader
             line-seq
             (map read-tower-line)
             (map parse-tower))))


(defn build-tree
  [towers]
  (->> (into [] towers)
       (filter #(-> % second :child-names nil? not))
       (map (fn [tower]
              (tree-seq
                (fn [[name data]]
                  (-> data :child-names nil? not))
                (fn [[name data]]
                  (->> (:child-names data)
                       (map #(-> [% (towers %)]))))
                tower)))
       (sort-by count >)
       (first)
       (first)))







