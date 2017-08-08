(ns hive-static.core
(:import
(org.apache.hadoop.hive.ql.parse ParseDriver))
  (:gen-class))

(defn parse-hiveql-or-fail [query]
  (println "=========> Evaluating")
  (println query)
  (.parse (ParseDriver.) query)
  true)

(defn -main
  [& args]

  (loop [input (read-line) acc []]
    (if (nil? input)
      (do
        (parse-hiveql-or-fail (clojure.string/join "\n" acc))
        (println "=========> OK")
        (System/exit 0))
      (recur (read-line) (conj acc input)))))
