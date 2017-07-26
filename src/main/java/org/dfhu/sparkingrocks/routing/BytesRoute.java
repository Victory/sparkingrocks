package org.dfhu.sparkingrocks.routing;

import org.dfhu.sparkingrocks.config.PropertiesConfig;
import spark.Request;
import spark.Response;
import spark.Spark;


public abstract class BytesRoute extends RouteAdder<BytesRoute> implements Route {

  public BytesRoute(PropertiesConfig config) {
    super(config);
  }

  public abstract byte[] getBytes(Request req, Response res);

  @Override
  public void doGet(RouteAdder<BytesRoute> routeAdder) {
    Spark.get(getPath(), this::getBytes);
  }
}
