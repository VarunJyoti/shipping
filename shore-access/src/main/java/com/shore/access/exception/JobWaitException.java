package com.shore.access.exception;

/**
 * Thrown when we want to retry processing after a while. This may happen in a case there's a
 * temporary failure (db outage for example).
 */
public class JobWaitException extends Exception {

  private long waitUntil;

  public JobWaitException(long waitUntil) {
    this.waitUntil = waitUntil;
  }

  public JobWaitException(String s, long waitUntil) {
    super(s);
    this.waitUntil = waitUntil;
  }

  public long getwaitUntil() {
    return waitUntil;
  }

  public void setwaitUntil(long waitUntil) {
    this.waitUntil = waitUntil;
  }

}

