[![Codacy Badge](https://api.codacy.com/project/badge/grade/51da0a5952884822a2abbf64bebb9239)](https://www.codacy.com/app/bazard-philippe/play-slick-silhouette-postgres)
[![Build Status](https://travis-ci.org/vahana-team/play-slick-postgres.svg?branch=master)](https://travis-ci.org/vahana-team/play-slick-postgres)
                                                      
             __     ___    _   _    _    _   _    _      ___ ___  
             \ \   / / \  | | | |  / \  | \ | |  / \    |_ _/ _ \ 
              \ \ / / _ \ | |_| | / _ \ |  \| | / _ \    | | | | |
               \ V / ___ \|  _  |/ ___ \| |\  |/ ___ \ _ | | |_| |
                \_/_/   \_\_| |_/_/   \_\_| \_/_/   \_(_)___\___/ 
                                                                  

# play-slick-silhouette-postgre
This template can be used to scaffold a project based on Play 2.5.x, Slick 3.1.x, Scala 2.11.x and PostgreSQL 9.4.x.

# Dependencies: build.sbt

```scala
"com.typesafe.play" %% "play-slick" % "2.0.0"
"com.typesafe.play" %% "play-slick-evolutions" % "2.0.0"
```

# Configuration: application.conf

Replace the database section by the parameters below:

```scala
slick.dbs.default.driver = "slick.driver.PostgresDriver$"
slick.dbs.default.db.driver = "org.postgresql.Driver"
slick.dbs.default.db.url = "jdbc:postgresql://localhost:5432/changeme"
slick.dbs.default.db.user = "changeme"
slick.dbs.default.db.password = "changeme"
```
