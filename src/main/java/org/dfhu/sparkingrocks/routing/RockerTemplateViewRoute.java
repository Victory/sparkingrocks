package org.dfhu.sparkingrocks.routing;

import org.dfhu.sparkingrocks.config.PropertiesConfig;
import org.dfhu.sparkingrocks.session.VicSession;
import org.dfhu.sparkingrocks.templateengine.RockerTemplateModel;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class RockerTemplateViewRoute implements TemplateViewRoute {
  private final TemplateRoute templateRoute;
  private final PropertiesConfig config;

  public RockerTemplateViewRoute(TemplateRoute templateRoute, PropertiesConfig config) {
    this.templateRoute = templateRoute;
    this.config = config;
  }

  @Override
  public ModelAndView handle(Request request, Response response) throws Exception {
    return new RockerTemplateModel(
      templateRoute.getRockerModel(
        request,
        response,
        new VicSession(request, response, config)));
  }
}
