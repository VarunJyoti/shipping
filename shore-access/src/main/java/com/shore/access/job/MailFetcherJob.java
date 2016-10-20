package com.shore.access.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.shore.access.exception.JobProcessException;
import com.shore.access.jobrunner.JobRunnerService;

@Service(value = "mailFetcher")
public class MailFetcherJob implements JobRunnerService {
  private static final Logger LOG = LoggerFactory.getLogger(MailFetcherJob.class);

  @Override
  public boolean run() throws JobProcessException {
    if (LOG.isDebugEnabled()) {
      LOG.debug("MailFetcherJob#run....");
    }
    LOG.info("Fetching mails...");
    return true;
  }

  @Override
  public boolean supportsMultipleInstances() {
    return false;
  }
}

