package org.dfhu.sparkingrocks.routing;

import static spark.Spark.exception;
import static spark.Spark.halt;

public class Halting {
  // TODO use template
  private static final String notFoundPage = "not found";

  public static void haltNotFound() {
    halt(404, notFoundPage);
  }

  public static void haltNotImplemented() {
    halt(501, notFoundPage);
  }

  public static void bindInternalServerError() {
    exception(Exception.class, (exc, req, res) -> {

      // TODO log error
      res.body(notFoundPage);
      res.status(500);
    });
  }
}
