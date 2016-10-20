package com.shore.access.exception;

/**
 * Thrown by JobProcesses when it needs to interrupt.
 */
@SuppressWarnings({ "serial", "ClassWithTooManyConstructors", "SerializableHasSerializationMethods" })
public class JobProcessException extends Exception {

  private long errorCode = 9999L;
  private Integer scanId;

  public JobProcessException(Throwable cause) {
    super(cause);
  }

  public JobProcessException(String s, Exception e) {
    super(s, e);
  }

  public JobProcessException(String s) {
    super(s);
  }

  public JobProcessException(Throwable cause, long errorCode) {
    super(cause);
    this.errorCode = errorCode;
  }

  public JobProcessException(String s, long errorCode) {
    super(s);
    this.errorCode = errorCode;
  }

  public JobProcessException(Throwable cause, long errorCode, Integer scanId) {
    this(cause, errorCode);
    this.scanId = scanId;
  }

  public long getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(long errorCode) {
    this.errorCode = errorCode;
  }

  public Integer getScanId() {
    return scanId;
  }

}

