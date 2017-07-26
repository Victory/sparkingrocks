package org.dfhu.sparkingrocks.routing;

import org.dfhu.sparkingrocks.config.PropertiesConfig;
import spark.Request;
import spark.Response;
import spark.Spark;

/**
 * Processes Request and Response without returning a body, such as when
 * redirecting
 */
public abstract class BodylessRoute extends RouteAdder<BodylessRoute> implements Route {

  public BodylessRoute(PropertiesConfig config) {
    super(config);
  }

  public abstract void updateResponse(Request req, Response res);

  @Override
  public void doPost(RouteAdder<BodylessRoute> routeAdder) {
    Spark.post(getPath(), (req, res) -> {
      updateResponse(req, res);
      return "";
    });
  }
}
