package org.dfhu.sparkingrocks.config;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadSystemProperties {
  /**
   * Reads in config.properties
   */
  public static PropertiesConfig read() {
    try {
      System.getProperties().load(new FileInputStream("config.properties"));
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException("Could not find config file config.properties");
    }

    return new PropertiesConfig
      .Builder(System.getProperties())
      .build();
  }
}
