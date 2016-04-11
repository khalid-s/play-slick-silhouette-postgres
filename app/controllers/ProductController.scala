package controllers

import javax.inject._

import com.mohiva.play.silhouette.api.Silhouette
import com.mohiva.play.silhouette.api.repositories.AuthInfoRepository
import com.mohiva.play.silhouette.api.util.Clock
import com.mohiva.play.silhouette.impl.providers.{CredentialsProvider, SocialProviderRegistry}
import models.Product
import models.daos.ProductDAO
import models.services.UserService
import play.api.Configuration
import play.api.data.Form
import play.api.data.Forms._
import play.api.i18n.I18nSupport
import play.api.i18n.MessagesApi
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc.Action
import play.api.mvc.Controller
import utils.auth.DefaultEnv

@Singleton
class ProductController @Inject()(val messagesApi: MessagesApi,
                                  silhouette: Silhouette[DefaultEnv],
                                  userService: UserService,
                                  authInfoRepository: AuthInfoRepository,
                                  credentialsProvider: CredentialsProvider,
                                  socialProviderRegistry: SocialProviderRegistry,
                                  configuration: Configuration,
                                  clock: Clock,
                                  productDAO: ProductDAO,
                                  implicit val webJarAssets: WebJarAssets)
  extends Controller with I18nSupport {

  val productForm = Form(
    mapping(
      "ean" -> longNumber,
      "name" -> nonEmptyText,
      "description" -> nonEmptyText
    )(Product.apply)(Product.unapply)
  )

  def list = Action.async {
    productDAO.all().map { case (products) => Ok(views.html.products.list(products)) }
  }

  def add = Action.async { implicit request =>
    val product: Product = productForm.bindFromRequest.get
    productDAO.insert(product).map(_ => Redirect(routes.ProductController.list))
  }

}