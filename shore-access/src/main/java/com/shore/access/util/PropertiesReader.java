package com.shore.access.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;


public class PropertiesReader {
  private static final Logger LOG = Logger.getLogger(PropertiesReader.class);

  private Properties p;

  public PropertiesReader(String propertyFile) {
    // read directory from propertyfile
    InputStream in = null;
    try {
      ResourceLoader resourceLoader = new DefaultResourceLoader();
      Resource resource = resourceLoader.getResource("classpath:" + propertyFile);
      in = new FileInputStream(resource.getFile());
      p = new Properties();
      p.load(in);
    } catch (FileNotFoundException e) {
      LOG.error("Property file " + propertyFile + " is missing.", e);
    } catch (IOException ex) {
      LOG.error("Failed to load property file.", ex);
    } finally {
      try {
        if (in != null) {
          in.close();
        }
      } catch (IOException ex) {
      }
    }
  }

  public String getProperty(String key) {
    return p.getProperty(key);
  }

  public Enumeration<?> getPropertyNames() {
    return p.propertyNames();
  }
}

