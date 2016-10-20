package com.shore.access.jobrunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shore.access.exception.JobProcessException;

/**
 * Indefinitely executes a job runner.
 */
public class Infinity implements Runnable {
  private static final Logger LOG = LoggerFactory.getLogger(Infinity.class);

  private final long interval;
  private final JobRunnerService jobRunnerService;

  public Infinity(JobRunnerService jobRunnerService, long interval) {
    this.interval = interval;
    this.jobRunnerService = jobRunnerService;
  }

  private static void printThreadState() {
    Thread thread = Thread.currentThread();
    Enum e = thread.getState();
    LOG.debug(thread.getName() + " is " + e.name());
  }

  /**
   * Runs forever.
   */
  @SuppressWarnings({ "InfiniteLoopStatement" })
  public void run() {
    // Run forever
    while (true) {
      printThreadState();
      // noinspection CatchGenericClass
      try {
        boolean sleep = jobRunnerService.run();
        if (sleep) {
          sleep();
        }
      } catch (JobProcessException e) {
        LOG.warn("Warning:", e);
      } catch (Exception e) {
        LOG.error("Exception in processing", e);
      }
    }
  }

  /**
   * Sleep for the specified interval.
   */
  private void sleep() {
    try {
      LOG.debug("Sleeping");
      printThreadState();
      Thread.sleep(interval);
      LOG.debug("Waking up");
      printThreadState();
    } catch (InterruptedException e) {
      // noinspection ProhibitedExceptionThrown
      throw new RuntimeException(e);
    }
  }
}
