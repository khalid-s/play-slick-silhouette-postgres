package models.daos

import javax.inject.Inject

import models.Product
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import slick.driver.JdbcProfile

import scala.concurrent.Future


class ProductDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  import driver.api._

  private val Products = TableQuery[ProductTableDef]

  def all(): Future[Seq[Product]] = db.run(Products.result)

  def insert(product: Product): Future[Unit] = db.run(Products += product).map { _ => () }

  private class ProductTableDef(tag: Tag) extends Table[Product](tag, "product") {

    def * = (ean, name, description) <>(Product.tupled, Product.unapply _)

    def ean = column[Long]("ean")

    def name = column[String]("name")

    def description = column[String]("description")
  }

}