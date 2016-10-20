package com.shore.access;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shore.access.exception.ThreadExceptionHandler;
import com.shore.access.jobrunner.Infinity;
import com.shore.access.jobrunner.JobRunnerConfig;
import com.shore.access.jobrunner.JobRunnerService;
import com.shore.access.util.PropertiesReader;
import com.shore.access.util.Version;

/**
 * @author harpreet.billing
 */

public class StartServer {

  private static Logger LOG = LoggerFactory.getLogger(StartServer.class);

  /**
   * This class cannot be instantiated.
   */
  private StartServer() {
  }

  public static void main(String[] args) {
    StartServer server = new StartServer();
    server.start();
  }

  /**
   * The syntax for a job runner is job.jobRunnerName.*
   */
  private static Set<String> getJobRunnerNames(PropertiesReader propertiesReader) {
    Set<String> jobNames = new HashSet<String>();
    Enumeration enumeration = propertiesReader.getPropertyNames();
    while (enumeration.hasMoreElements()) {
      String key = (String) enumeration.nextElement();
      if (key.startsWith("job.")) {
        jobNames.add(StringUtils.split(key, ".")[1]);
      }
    }
    return jobNames;
  }

  /**
   * Get and convert the property, return the default value if an invalid value is specified in the
   * properties file.
   */
  private static long getProperty(String propertyName, long defaultValue, PropertiesReader propertiesReader) {
    long propVal = defaultValue;
    String propertyValue = propertiesReader.getProperty(propertyName);
    try {
      propVal = Long.parseLong(propertyValue);
    } catch (NumberFormatException number) {
      LOG.debug("Invalid property value for property " + propertyName + ", using default value " + defaultValue);
    }
    return propVal;
  }

  private void start() {
    LOG.info("Starting shore-access. Version " + Version.getVersion());

    BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:access-context.xml");

    ThreadExceptionHandler exceptionHandler = new ThreadExceptionHandler();

    // Start the processes
    PropertiesReader propertiesReader = (PropertiesReader) beanFactory.getBean("properties");
    for (JobRunnerConfig jobRunnerConfig : getJobRunnerConfigurations(propertiesReader)) {
      String runnerName = jobRunnerConfig.getRunnerName();
      JobRunnerService jobRunnerService = (JobRunnerService) beanFactory.getBean(runnerName);
      if (!jobRunnerService.supportsMultipleInstances() && jobRunnerConfig.getThreads() != 1) {
        throw new RuntimeException("Job runner " + runnerName + " is configured incorrectly. It can only have one thread");
      }

      // create the specified number of threads for the job runner
      for (long i = 0; i < jobRunnerConfig.getThreads(); i++) {
        jobRunnerService = (JobRunnerService) beanFactory.getBean(runnerName);
        Infinity infinity = new Infinity(jobRunnerService, jobRunnerConfig.getInterval());
        LOG.info("Creating thread for " + jobRunnerService.toString());
        Thread t = new Thread(infinity);
        t.setName(runnerName + "-" + i);
        t.setUncaughtExceptionHandler(exceptionHandler);
        t.start();
      }
    }
    LOG.info("shore-access started...");
  }

  /**
   * Get a collection of job runner configurations from the properties file.
   */
  private List<JobRunnerConfig> getJobRunnerConfigurations(PropertiesReader propertiesReader) {

    List<JobRunnerConfig> configuration = new ArrayList<JobRunnerConfig>();
    for (String jobRunnerName : getJobRunnerNames(propertiesReader)) {
      long threads = getProperty("job." + jobRunnerName + ".threads", 1, propertiesReader);
      long interval = getProperty("job." + jobRunnerName + ".interval", 10000, propertiesReader);

      // noinspection NumericCastThatLosesPrecision
      JobRunnerConfig jobRunnerConfig = new JobRunnerConfig(jobRunnerName, interval, threads);
      jobRunnerConfig.setRunnerName(jobRunnerName);
      jobRunnerConfig.setInterval(interval);
      jobRunnerConfig.setThreads(threads);
      configuration.add(jobRunnerConfig);
    }

    if (configuration.isEmpty()) {
      LOG.error("No Job runners are configured");
    }
    return configuration;
  }

}
