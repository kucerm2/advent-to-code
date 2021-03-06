(defproject advent-to-code "0.1.0-SNAPSHOT"
  :description "Advent calendar sheet"
  :url "http://github.com/kucerm2"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [criterium "0.4.4"]]

  :plugins [[cider/cider-nrepl "0.15.1"]
            [lein-auto "0.1.3"]]


  :source-paths ["src"]
  :test-paths ["test"]
  :resource-paths ["resource"]

  :target-path "target/%s/"

  :auto {:default {:file-pattern #"\.(clj|cljs|cljx|cljc|edn)$"}})