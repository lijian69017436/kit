package com.zbxsoft.core.test.mock;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

public class MockLog4jAppender extends AppenderSkeleton {
	private List<LoggingEvent> logs = new ArrayList();

	public LoggingEvent getFirstLog() {
		if (this.logs.isEmpty()) {
			return null;
		}
		return (LoggingEvent) this.logs.get(0);
	}

	public LoggingEvent getLastLog() {
		if (this.logs.isEmpty()) {
			return null;
		}
		return (LoggingEvent) this.logs.get(this.logs.size() - 1);
	}

	public List<LoggingEvent> getAllLogs() {
		return this.logs;
	}

	public void clearLogs() {
		this.logs.clear();
	}

	public void addToLogger(Logger logger) {
		logger.addAppender(this);
	}

	public void addToLogger(String loggerName) {
		Logger logger = Logger.getLogger(loggerName);
		logger.addAppender(this);
	}

	public void addToLogger(Class<?> loggerClass) {
		Logger logger = Logger.getLogger(loggerClass);
		logger.addAppender(this);
	}

	protected void append(LoggingEvent event) {
		this.logs.add(event);
	}

	public void close() {
	}

	public boolean requiresLayout() {
		return false;
	}
}
