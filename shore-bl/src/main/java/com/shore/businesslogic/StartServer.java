package com.shore.businesslogic;

import java.io.File;

import org.apache.catalina.startup.Tomcat;

import com.shore.businesslogic.config.ServerConfig;

/**
 * @author harpreet.billing
 */
public class StartServer {

  private final ServerConfig serverConfiguration = new ServerConfig();

  public StartServer() throws Exception {
    System.out.println(String.format("Starting server on port: %s, root : %s", serverConfiguration.getPort(), serverConfiguration.getWebRoot()));
    startTomcat();


  }

  public static void main(String[] list) throws Exception {
    new StartServer();
  }

  private void startTomcat() throws Exception {
    Tomcat tomcat = new Tomcat();

    String webPort = serverConfiguration.getPort();
    String webappDirLocation = serverConfiguration.getWebAppDirectory();
    String rootPath = serverConfiguration.getWebRoot();

    tomcat.setPort(Integer.valueOf(webPort));
    tomcat.addWebapp(rootPath, new File(webappDirLocation).getAbsolutePath());

    tomcat.start();
    System.out.println("Server started succefully...");
    tomcat.getServer().await();
  }

}
