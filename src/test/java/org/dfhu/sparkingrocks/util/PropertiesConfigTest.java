package org.dfhu.sparkingrocks.util;

import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

public class PropertiesConfigTest {

  private final String dbName = "myDb";
  private final String hostname = "example.com";

  @Test
  public void buildsWithEmptyProperties() {
    final boolean isDevelopment = true;
    PropertiesConfig config = new PropertiesConfig.Builder()
      .isDevelopment(isDevelopment)
      .databaseName(dbName)
      .databaseHostname(hostname)
      .build();

    assertEquals(hostname, config.getDatabaseHostname());
    assertEquals(dbName, config.getDatabaseName());
    assertEquals(isDevelopment, config.isDevelopment());
  }

  @Test
  public void buildsFromProperties() {
    final String isDevelopment = "true";

    Properties properties = new Properties();
    properties.setProperty("isDevelopment", isDevelopment);
    properties.setProperty("databaseName", dbName);
    properties.setProperty("databaseHostname", hostname);

    properties.setProperty("", dbName);
    PropertiesConfig config = new PropertiesConfig.Builder(properties).build();

    assertEquals(hostname, config.getDatabaseHostname());
    assertEquals(dbName, config.getDatabaseName());
    assertEquals(true, config.isDevelopment());
  }
}