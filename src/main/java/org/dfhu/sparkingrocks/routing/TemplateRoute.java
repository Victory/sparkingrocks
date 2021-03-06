package org.dfhu.sparkingrocks.routing;

import com.fizzed.rocker.RockerModel;
import org.dfhu.sparkingrocks.config.PropertiesConfig;
import org.dfhu.sparkingrocks.session.VicSession;
import org.dfhu.sparkingrocks.templateengine.RockerTemplateEngine;
import spark.Request;
import spark.Response;
import spark.Spark;

/**
 * A TemplateRoute take uses morphs, templates, requests to perform business logic
 * and return a template modifying the response if needed.
 */
public abstract class TemplateRoute extends RouteAdder<TemplateRoute> implements Route {

  public TemplateRoute(PropertiesConfig config) {
    super(config);
  }

  public abstract RockerModel getRockerModel(Request req, Response res, VicSession vicSession);

  @Override
  public void doGet(RouteAdder<TemplateRoute> route) {
    Spark.get(
      getPath(),
      new RockerTemplateViewRoute(this, getPropertiesConfig()),
      RockerTemplateEngine.getInstance());
  }

  @Override
  public void doPost(RouteAdder<TemplateRoute> route) {
    Spark.post(
      getPath(),
      new RockerTemplateViewRoute(this, getPropertiesConfig()),
      RockerTemplateEngine.getInstance());
  }
}
