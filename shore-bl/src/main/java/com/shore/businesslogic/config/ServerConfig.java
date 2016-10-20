package com.shore.businesslogic.config;

import java.util.Optional;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ServerConfig {
  private static final Config CONFIG = ConfigFactory.load();

  private final String port = getPropertyFromEnvironmentOrFile("server.port", "8080");
  private final String webAppDirectory = getPropertyFromEnvironmentOrFile("web.directory", "");
  private final String webRoot = getPropertyFromEnvironmentOrFile("web.root", "/");


  private String getPropertyFromEnvironmentOrFile(String propertyName, String defaultValue) {
    return getObjectQuietly(propertyName).orElse(defaultValue);
  }

  private int getIntPropertyFromEnvironmentOrFile(String propertyName, int defaultValue) {
    return Integer.parseInt(getPropertyFromEnvironmentOrFile(propertyName, "" + defaultValue));
  }

  public String getWebAppDirectory() {
    return webAppDirectory;
  }

  public String getPort() {
    return port;
  }

  public String getWebRoot() {
    return webRoot;
  }

  private Optional<String> getObjectQuietly(String key) {
    try {
      return Optional.ofNullable(CONFIG.getString(key));
    } catch (Exception e) {
      return Optional.empty();
    }
  }
}
