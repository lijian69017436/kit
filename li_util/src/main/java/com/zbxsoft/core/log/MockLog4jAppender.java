package com.zbxsoft.core.log;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

/**
 * 重写 log4j 打印 
 * 自定义
 * @author Administrator
 *
 */
public class MockLog4jAppender extends AppenderSkeleton {
	private List<LoggingEvent> logs = new ArrayList();

	public LoggingEvent getFirstLog() {
		if (this.logs.isEmpty()) {
			return null;
		}
		return (LoggingEvent) this.logs.get(0);
	}

	public String getFirstMessage() {
		return getFirstLog().getMessage().toString();
	}

	public String getFirstRenderedMessage() {
		return getLayout().format(getFirstLog());
	}

	public LoggingEvent getLastLog() {
		if (this.logs.isEmpty()) {
			return null;
		}
		return (LoggingEvent) this.logs.get(this.logs.size() - 1);
	}

	public String getLastMessage() {
		return getLastLog().getMessage().toString();
	}

	public String getLastRenderedMessage() {
		return getLayout().format(getLastLog());
	}

	public List<LoggingEvent> getAllLogs() {
		return this.logs;
	}

	public boolean isEmpty() {
		return this.logs.isEmpty();
	}

	public void clearLogs() {
		this.logs.clear();
	}

	public void addToLogger(String loggerName) {
		Logger logger = Logger.getLogger(loggerName);
		logger.addAppender(this);
	}

	public void addToLogger(Class<?> loggerClass) {
		Logger logger = Logger.getLogger(loggerClass);
		logger.addAppender(this);
	}

	public void removeFromLogger(String loggerName) {
		Logger logger = Logger.getLogger(loggerName);
		logger.removeAppender(this);
	}

	public void removeFromLogger(Class<?> loggerClass) {
		Logger logger = Logger.getLogger(loggerClass);
		logger.removeAppender(this);
	}

	public void setLayout(String pattern) {
		super.setLayout(new PatternLayout(pattern));
	}

	protected void append(LoggingEvent event) {
		this.logs.add(event);
	}

	public void close() {
		this.logs.clear();
	}

	public boolean requiresLayout() {
		return false;
	}
}
