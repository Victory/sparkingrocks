package org.dfhu.sparkingrocks.session;

import org.dfhu.sparkingrocks.config.PropertiesConfig;
import spark.Request;
import spark.Response;

public class VicSession {
  private final Request request;
  private final Response response;
  private final PropertiesConfig config;

  public VicSession(Request request, Response response, PropertiesConfig config) {
    this.request = request;
    this.response = response;
    this.config = config;
  }
}
