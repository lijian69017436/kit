package com.zbxsoft.core.test.groups;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.internal.runners.InitializationError;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.notification.RunNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class GroupsTestRunner extends JUnit4ClassRunner {
	public static final String PROPERTY_NAME = "test.groups";
	public static final String PROPERTY_FILE = "application.test.properties";
	private static Logger logger = LoggerFactory.getLogger(GroupsTestRunner.class);
	private static List<String> groups;

	public GroupsTestRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}

	public void run(RunNotifier notifier) {
		if (!isTestClassInGroups(getTestClass().getJavaClass())) {
			notifier.fireTestIgnored(getDescription());
			return;
		}

		super.run(notifier);
	}

	protected void invokeTestMethod(Method method, RunNotifier notifier) {
		if (!isTestMethodInGroups(method)) {
			notifier.fireTestIgnored(getDescription());
			return;
		}

		super.invokeTestMethod(method, notifier);
	}

	public static boolean isTestClassInGroups(Class<?> testClass) {
		if (groups == null) {
			initGroups();
		}

		if (groups.contains("all")) {
			return true;
		}

		Groups annotationGroup = (Groups) testClass.getAnnotation(Groups.class);
		if ((annotationGroup != null) && (!groups.contains(annotationGroup.value()))) {
			return false;
		}

		Method[] methods = testClass.getMethods();
		for (Method method : methods) {
			if ((method.getAnnotation(Test.class) != null) && (method.getAnnotation(Ignore.class) == null)
					&& (isTestMethodInGroups(method))) {
				return true;
			}
		}

		return false;
	}

	public static boolean isTestMethodInGroups(Method testMethod) {
		if (groups == null) {
			initGroups();
		}

		if (groups.contains("all")) {
			return true;
		}

		Groups annotationGroup = (Groups) testMethod.getAnnotation(Groups.class);
		if ((annotationGroup == null) || (groups.contains(annotationGroup.value()))) {
			return true;
		}

		return false;
	}

	protected static void initGroups() {
		String groupsDef = getGroupsFromSystemProperty();

		if (groupsDef == null) {
			groupsDef = getGroupsFromPropertyFile();

			if (groupsDef == null) {
				groupsDef = "all";
			}
		}

		groups = Arrays.asList(groupsDef.split(","));
	}

	protected static String getGroupsFromSystemProperty() {
		return System.getProperty("test.groups");
	}

	protected static String getGroupsFromPropertyFile() {
		try {
			Properties p = PropertiesLoaderUtils.loadAllProperties("application.test.properties");
			return p.getProperty("test.groups");
		} catch (IOException e) {
			logger.warn(e.getMessage(), e);
		}
		return null;
	}
}
