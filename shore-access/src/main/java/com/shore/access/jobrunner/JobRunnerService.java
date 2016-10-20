package com.shore.access.jobrunner;

import com.shore.access.exception.JobProcessException;

public interface JobRunnerService {
  /**
   * Run the job.
   *
   * @return boolean indicating if the process should sleep.
   */
  boolean run() throws JobProcessException;

  /**
   * Indicates if multiple instances of this job runner are allowed.
   */
  boolean supportsMultipleInstances();
}

