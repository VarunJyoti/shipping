package com.shore.access.jobrunner;

/**
 * Job runner configuration
 */
public class JobRunnerConfig {
  private String runnerName;
  private long interval;
  private long threads;

  public JobRunnerConfig(String runnerName, long interval, long threads) {
    this.runnerName = runnerName;
    this.interval = interval;
    this.threads = threads;
  }

  public String getRunnerName() {
    return runnerName;
  }

  public void setRunnerName(String runnerName) {
    this.runnerName = runnerName;
  }

  public long getInterval() {
    return interval;
  }

  public void setInterval(long interval) {
    this.interval = interval;
  }

  public long getThreads() {
    return threads;
  }

  public void setThreads(long threads) {
    this.threads = threads;
  }

}

