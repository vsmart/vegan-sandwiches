(defproject vegan-sandwiches "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [quil "2.4.0"]
                 [org.clojure/clojurescript "1.8.34"]]
  :plugins [[lein-cljsbuild "1.1.3"]
            [lein-figwheel "0.5.8"]]
  :hooks [leiningen.cljsbuild]
  :cljsbuild
  {:builds [{:source-paths ["src"]
             :id "dev"
             :figwheel true
             :compiler
             {:output-to "js/main.js"
              :output-dir "out"
              :main "vegan_sandwiches.core"
              :optimizations :none
              :pretty-print true}}]})
