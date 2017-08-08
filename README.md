# CLI tool for static analysis of hive queries

This tool verifies that a hive query given as input on stdin parses. If it does not it throws an error.

- `brew install leiningen`
- `lein uberjar`
- Put some hql (hive query language) query in `test.hql`
- Run with `cat test.hql|  java -jar target/uberjar/hive-static-0.1.0-SNAPSHOT-standalone.jar`
- You can get a cleaner output with `cat test.hql|  java -jar target/uberjar/hive-static-0.1.0-SNAPSHOT-standalone.jar 2>&1 | grep -v ERROR`
