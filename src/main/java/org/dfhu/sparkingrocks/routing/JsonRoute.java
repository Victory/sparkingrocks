package org.dfhu.sparkingrocks.routing;

import com.google.gson.Gson;
import org.dfhu.sparkingrocks.session.VicSession;
import spark.Request;
import spark.Response;
import spark.Spark;

public abstract class JsonRoute extends RouteAdder<JsonRoute> implements Route {

  /**
   * Get an object that you can Gson.toJson()
   */
  public abstract JsonResponse getJsonResponse(Request req, Response res, VicSession vicSession);

  @Override
  public void doPost(RouteAdder<JsonRoute> routeAdder) {
    Spark.post(getPath(),
      (req, res) -> new Gson().toJson(getJsonResponse(req, res, new VicSession(req, res))));

  }
}
