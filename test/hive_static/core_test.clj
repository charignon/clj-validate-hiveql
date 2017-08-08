(ns hive-static.core-test
  (:require [clojure.test :refer :all]
            [hive-static.core :refer :all]))

(deftest parse-hiveql-or-fail-test
  (testing "With a valid query"
    (is (= true (parse-hiveql-or-fail "SELECT * FROM FOO"))))
  (testing "With an erroneous query"
    (is  (thrown? org.apache.hadoop.hive.ql.parse.ParseException
                  (parse-hiveql-or-fail "SELEC * FROM FOO")))))
