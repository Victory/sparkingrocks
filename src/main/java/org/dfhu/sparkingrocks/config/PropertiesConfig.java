package org.dfhu.sparkingrocks.config;

import java.util.Objects;
import java.util.Properties;

public class PropertiesConfig implements DatabaseInfoConfig {

  private final boolean isDevelopment;
  private final String databaseHostname;
  private final String databaseName;

  private PropertiesConfig(boolean isDevelopment, String databaseHostname, String databaseName) {
    this.isDevelopment = isDevelopment;
    this.databaseHostname = databaseHostname;
    this.databaseName = databaseName;
  }

  public boolean isDevelopment() {
    return isDevelopment;
  }

  @Override
  public String getDatabaseHostname() {
    return databaseHostname;
  }

  @Override
  public String getDatabaseName() {
    return databaseName;
  }

  public static class Builder {
    private boolean isDevelopment;
    private String mongoHostname;
    private String databaseName;

    public Builder() {
      this(new Properties());
    }

    public Builder(Properties properties) {
      isDevelopment(asBoolean("isDevelopment", false, properties));
      databaseHostname(properties.getProperty("databaseHostname", "localhost"));

      String property = properties.getProperty("databaseName");
      if (property != null) {
        databaseName(property);
      }
    }

    private static boolean asBoolean(String propertyKey, boolean defaultValue, Properties properties) {
      if (properties.getProperty(propertyKey) == null) {
        return defaultValue;
      }
      return properties.getProperty(propertyKey).equals("true");
    }

    public Builder isDevelopment(boolean v) {
      this.isDevelopment = v;
      return this;
    }

    public Builder databaseHostname(String v) {
      Objects.requireNonNull(v, "databaseHostname");
      this.mongoHostname = v;
      return this;
    }

    public Builder databaseName(String v) {
      Objects.requireNonNull(v, "databaseName");
      this.databaseName = v;
      return this;
    }

    public PropertiesConfig build() {
      return new PropertiesConfig(isDevelopment, mongoHostname, databaseName);
    }
  }
}
