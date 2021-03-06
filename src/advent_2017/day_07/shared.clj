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

(defn is-node?
  [[name data]]
  (-> data :child-names nil? not))

(defn node-by-name
  [nodes name]
  [name (nodes name)])

(defn get-childs
  [nodes [name data]]
  (->> (:child-names data)
       (map (partial node-by-name nodes))))

(defn node-seq
  [nodes root]
  (tree-seq is-node? (partial get-childs nodes) root))

(defn build-tree
  [nodes]
  (->> (into [] nodes)
       (filter is-node?)
       (map (partial tree-seq is-node? (partial get-childs nodes)))
       (sort-by count >)
       (first)
       (first)))








