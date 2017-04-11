package com.zbxsoft.core.log;

import com.zbxsoft.core.utils.AssertUtils;
import java.util.Enumeration;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.slf4j.LoggerFactory;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;

/**
 * mx4j 管理 这个bean 实施监控
 * @author Administrator
 *
 */
@ManagedResource(objectName = "Log4j:name=log4j", description = "Log4j Management Bean")
public class Log4jMBean {
	public static final String LOG4J_MBEAN_NAME = "Log4j:name=log4j";
	private static org.slf4j.Logger mbeanLogger = LoggerFactory.getLogger(Log4jMBean.class);
	private String projectLoggerName;
	private String traceAppenderName;
	private Level projectLoggerOrgLevel;
	
//得到日志级别
	@ManagedOperation(description = "Get logging level of the logger")
	@ManagedOperationParameters({
			@org.springframework.jmx.export.annotation.ManagedOperationParameter(name = "loggerName", description = "Logger name") })
	public String getLoggerLevel(String loggerName) {
		org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(loggerName);
		return logger.getEffectiveLevel().toString();
	}

	//设置 日志级别
	@ManagedOperation(description = "Set new logging level to the logger")
	@ManagedOperationParameters({
			@org.springframework.jmx.export.annotation.ManagedOperationParameter(name = "loggerName", description = "Logger name"),
			@org.springframework.jmx.export.annotation.ManagedOperationParameter(name = "newlevel", description = "New level") })
	public void setLoggerLevel(String loggerName, String newLevel) {
		org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(loggerName);
		Level level = Level.toLevel(newLevel);
		logger.setLevel(level);
		mbeanLogger.info("设置{}级别为{}", loggerName, newLevel);
	}

	//得到 项目默认日志级别
	@ManagedAttribute(description = "Project default logging level of the logger")
	public String getProjectLoggerLevel() {
		return getLoggerLevel(this.projectLoggerName);
	}

	//设置 项目级别
	@ManagedAttribute(description = "Project default logging level of the logger")
	public void setProjectLoggerLevel(String newLevel) {
		setLoggerLevel(this.projectLoggerName, newLevel);
	}

	//开始追述
	@ManagedOperation(description = "Start trace")
	public void startTrace() {
		AssertUtils.hasText(this.traceAppenderName);
		org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.projectLoggerName);
		this.projectLoggerOrgLevel = logger.getLevel();
		logger.setLevel(Level.DEBUG);
		setTraceAppenderThreshold(logger, Level.DEBUG);
		mbeanLogger.info("Start trace");
	}

	@ManagedOperation(description = "Stop trace")
	public void stopTrace() {
		AssertUtils.hasText(this.traceAppenderName);
		org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.projectLoggerName);
		logger.setLevel(this.projectLoggerOrgLevel);
		setTraceAppenderThreshold(logger, Level.OFF);
		mbeanLogger.info("Stop trace");
	}

	private void setTraceAppenderThreshold(org.apache.log4j.Logger logger, Level level) {
		Enumeration e = logger.getAllAppenders();
		while (e.hasMoreElements()) {
			AppenderSkeleton appender = (AppenderSkeleton) e.nextElement();
			if (appender.getName().equals(this.traceAppenderName))
				appender.setThreshold(level);
		}
	}

	public void setProjectLoggerName(String projectLoggerName) {
		this.projectLoggerName = projectLoggerName;
	}

	public void setTraceAppenderName(String traceAppenderName) {
		this.traceAppenderName = traceAppenderName;
	}
}
