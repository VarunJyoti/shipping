package com.shore.access.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * For displaying version.
 */
public final class Version {
  private static final Logger log = Logger.getLogger(Version.class);

  private static Properties p = new Properties();

  /**
   * To mark that this is a static class.
   */
  private Version() {
  }

  static {
    // read directory from propertyfile
    InputStream is = null;
    try {
      ResourceLoader resourceLoader = new DefaultResourceLoader();
      Resource resource = resourceLoader.getResource("classpath:version.properties");
      is = resource.getInputStream();
      p.load(is);
    } catch (IOException ex) {
      log.error("Failed to load property file.", ex);
    } finally {
      IOUtils.closeQuietly(is);
    }
  }

  public static String getVersion() {
    return p.getProperty("Implementation-Version");
  }

}

