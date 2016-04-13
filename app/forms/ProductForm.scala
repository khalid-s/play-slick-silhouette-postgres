package forms

import play.api.data.Form
import play.api.data.Forms._

object ProductForm {

  val form = Form(
    mapping(
      "ean" -> longNumber,
      "name" -> nonEmptyText,
      "description" -> nonEmptyText
    )(Data.apply)(Data.unapply)
  )

  case class Data(ean: Long, name: String, description: String)
}