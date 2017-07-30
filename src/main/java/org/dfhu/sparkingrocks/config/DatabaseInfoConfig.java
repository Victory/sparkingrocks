package org.dfhu.sparkingrocks.config;

public interface DatabaseInfoConfig {
  /** Get mongo hostname */
  String getDatabaseHostname();

  /** get the name of this project's collection */
  String getDatabaseName();
}
