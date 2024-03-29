[![Codacy Badge](https://api.codacy.com/project/badge/grade/51da0a5952884822a2abbf64bebb9239)](https://www.codacy.com/app/bazard-philippe/play-slick-silhouette-postgres)
[![Build Status](https://travis-ci.org/vahana-team/play-slick-silhouette-postgres.svg?branch=master)](https://travis-ci.org/vahana-team/play-slick-silhouette-postgres)                                                      
          
          
        ██████╗ ██╗      █████╗ ██╗   ██╗    ██╗    ██╗██╗████████╗██╗  ██╗    ██╗   ██╗ █████╗ ██╗  ██╗ █████╗ ███╗   ██╗ █████╗    ██╗ ██████╗ 
        ██╔══██╗██║     ██╔══██╗╚██╗ ██╔╝    ██║    ██║██║╚══██╔══╝██║  ██║    ██║   ██║██╔══██╗██║  ██║██╔══██╗████╗  ██║██╔══██╗   ██║██╔═══██╗
        ██████╔╝██║     ███████║ ╚████╔╝     ██║ █╗ ██║██║   ██║   ███████║    ██║   ██║███████║███████║███████║██╔██╗ ██║███████║   ██║██║   ██║
        ██╔═══╝ ██║     ██╔══██║  ╚██╔╝      ██║███╗██║██║   ██║   ██╔══██║    ╚██╗ ██╔╝██╔══██║██╔══██║██╔══██║██║╚██╗██║██╔══██║   ██║██║   ██║
        ██║     ███████╗██║  ██║   ██║       ╚███╔███╔╝██║   ██║   ██║  ██║     ╚████╔╝ ██║  ██║██║  ██║██║  ██║██║ ╚████║██║  ██║██╗██║╚██████╔╝
        ╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝        ╚══╝╚══╝ ╚═╝   ╚═╝   ╚═╝  ╚═╝      ╚═══╝  ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝╚═╝ ╚═════╝ 
                                                                                                                                       





# play-slick-silhouette-postgre
This template can be used to scaffold a project based on Play 2.5.x, Slick 3.1.x, Silhouette 4.0.0-BETA4, 
Scala 2.11.x and PostgreSQL 9.4.x.

# Dependencies: build.sbt

```scala
"com.typesafe.play" %% "play-slick" % "2.0.0"
"com.typesafe.play" %% "play-slick-evolutions" % "2.0.0"
"com.mohiva" %% "play-silhouette" % "4.0.0-BETA4",
"com.mohiva" %% "play-silhouette-password-bcrypt" % "4.0.0-BETA4",
"com.mohiva" %% "play-silhouette-persistence-memory" % "4.0.0-BETA4",
"com.mohiva" %% "play-silhouette-testkit" % "4.0.0-BETA4" % "test",
```

# Configuration: conf/application.conf

Replace the database section by the parameters below:

```scala
slick.dbs.default.driver = "slick.driver.PostgresDriver$"
slick.dbs.default.db.driver = "org.postgresql.Driver"
slick.dbs.default.db.url = "jdbc:postgresql://localhost:5432/changeme"
slick.dbs.default.db.user = "changeme"
slick.dbs.default.db.password = "changeme"
```

# Configuration: conf/silhouette.conf
You can add some OAuth credentials. Taking Facebook for example:

```
# Facebook provider
facebook.authorizationURL="https://graph.facebook.com/v2.3/oauth/authorize"
facebook.accessTokenURL="https://graph.facebook.com/v2.3/oauth/access_token"
facebook.redirectURL="http://localhost:9000/authenticate/facebook"
facebook.clientID="changeme"
facebook.clientID=${?FACEBOOK_CLIENT_ID}
facebook.clientSecret="changeme"
facebook.clientSecret=${?FACEBOOK_CLIENT_SECRET}
facebook.scope="email"
```