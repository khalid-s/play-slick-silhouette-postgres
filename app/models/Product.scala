package models

/**
  *
  * @param ean
  * @param name
  * @param description
  */

case class Product(ean: Option[Long], name: Option[String], description: Option[String])