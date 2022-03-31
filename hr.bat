call mvn -B -DskipTests=true clean package
call java -jar target/dependency/webapp-runner.jar target/*.war
