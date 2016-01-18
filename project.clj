(defproject guessnumber "1.0.0-SNAPSHOT"
  :description "Guess number game"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :aot [guessnumber.core]
  :main guessnumber.core)
