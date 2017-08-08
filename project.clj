(defproject hive-static "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
                 [org.clojure/clojure "1.8.0"]
                 [org.apache.hive/hive-exec "2.3.0"]
                 [org.apache.hadoop/hadoop-core "1.2.1"]
                 ]
  :main ^:skip-aot hive-static.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
