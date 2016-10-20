package com.shore.access.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Catches uncaught exceptions thrown by Threads.
 */
public class ThreadExceptionHandler implements Thread.UncaughtExceptionHandler {
  private static final Logger LOG = LoggerFactory.getLogger(ThreadExceptionHandler.class);

  public void uncaughtException(Thread t, Throwable e) {
    Thread.State state = t.getState();
    LOG.error("Uncaught exception occurs in " + t.toString() + ". State is " + state.name(), e);
  }
}
