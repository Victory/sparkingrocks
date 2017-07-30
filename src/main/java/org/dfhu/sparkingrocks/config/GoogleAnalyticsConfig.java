package org.dfhu.sparkingrocks.config;

public interface GoogleAnalyticsConfig {
  default String getAnalyticsTrackingId() {
    return "not implemented";
  }
}
