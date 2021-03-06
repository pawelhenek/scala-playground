import com.twitter.finagle.http.{Request, Response}
import com.twitter.finagle.{Http, Service, http}
import com.twitter.util.{Await, Future}

object FinagleServerHelloWorld extends App {

  val service = new Service[http.Request, http.Response] {
    override def apply(request: Request): Future[Response] =
      Future.value(
        http.Response(request.version, http.Status.Ok)
      )
  }

  val server = Http.serve(":8080", service)
  Await.ready(server)
}
