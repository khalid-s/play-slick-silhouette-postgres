package controllers

import scala.concurrent.Future
import javax.inject._

import com.mohiva.play.silhouette.api.Silhouette
import com.mohiva.play.silhouette.api.repositories.AuthInfoRepository
import com.mohiva.play.silhouette.api.util.Clock
import com.mohiva.play.silhouette.impl.providers.{CredentialsProvider, SocialProviderRegistry}
import forms.ProductForm
import models.Product
import models.daos.ProductDAO
import models.services.UserService
import play.api.Configuration
import play.api.i18n.I18nSupport
import play.api.i18n.MessagesApi
import play.api.libs.concurrent.Execution.Implicits._
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

  def list = silhouette.SecuredAction.async { request =>
    productDAO.all().map { case (products) => Ok(views.html.products.list(request.identity, ProductForm.form, products)) }
  }

  def add = silhouette.SecuredAction.async { implicit request =>

    ProductForm.form.bindFromRequest.fold(
      form => Future.successful(BadRequest(views.html.products.details(request.identity,ProductForm.form))),
      data => {
        val product = Product(
          ean = Some(data.ean),
          name = Some(data.name),
          description = Some(data.description)
        )
        productDAO.insert(product).map(_ => Redirect(routes.ProductController.list))
      }
    )
  }

}