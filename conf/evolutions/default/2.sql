# --- !Ups

CREATE TABLE "product" (
  "ean"         BIGINT NOT NULL PRIMARY KEY,
  "name"        VARCHAR,
  "description" VARCHAR
);

# --- !Downs

drop table "product";