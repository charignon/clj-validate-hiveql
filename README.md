# CLI tool for static analysis of hive queries

This tool verifies that a hive query given as input on stdin parses. If it does not it throws an error.

- `brew install leiningen`
- `lein uberjar`
- Put some hql (hive query language) query in `test.hql`
- Run with `cat test.hql|  java -jar ./target/uberjar/hive-static-0.1.0-SNAPSHOT-standalone.jar`
- You can get a cleaner output with `cat test.hql|  java -jar ./target/uberjar/hive-static-0.1.0-SNAPSHOT-standalone.jar 2>&1 | grep -v ERROR`

Example:
```
$ cat test.hql|  java -jar ./target/uberjar/hive-static-0.1.0-SNAPSHOT-standalone.jar 2>&1 | grep -v ERROR
=========> Evaluating
SELECT
 VARIANCE(a),
 SUM(b),
 COUNT(c)
FROM
  foo
WHERE
  ds = 42
GROUP BY
  bar
=========> OK
$ # Change test.hql to have a typo
$ cat test.hql|  java -jar ./target/uberjar/hive-static-0.1.0-SNAPSHOT-standalone.jar 2>&1 | grep -v ERROR
=========> Evaluating
SELECT
 VARIANCE(a),
 SUM(b),
 COUNT(c)
FROM
  foo
WHER
  ds = 42
GROUP BY
  bar
Exception in thread "main" org.apache.hadoop.hive.ql.parse.ParseException: line 8:2 missing EOF at 'ds' near 'WHER'
        at org.apache.hadoop.hive.ql.parse.ParseDriver.parse(ParseDriver.java:215)
        at org.apache.hadoop.hive.ql.parse.ParseDriver.parse(ParseDriver.java:166)
        at org.apache.hadoop.hive.ql.parse.ParseDriver.parse(ParseDriver.java:161)
        at hive_static.core$parse_hiveql_or_fail.invokeStatic(core.clj:9)
        at hive_static.core$parse_hiveql_or_fail.invoke(core.clj:6)
        at hive_static.core$_main.invokeStatic(core.clj:18)
        at hive_static.core$_main.doInvoke(core.clj:12)
        at clojure.lang.RestFn.invoke(RestFn.java:397)
        at clojure.lang.AFn.applyToHelper(AFn.java:152)
        at clojure.lang.RestFn.applyTo(RestFn.java:132)
        at hive_static.core.main(Unknown Source)
```
