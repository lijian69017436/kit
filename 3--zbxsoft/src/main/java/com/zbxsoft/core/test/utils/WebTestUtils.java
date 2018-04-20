package com.zbxsoft.core.test.utils;

import com.opensymphony.xwork2.ActionContext;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class WebTestUtils {
	private static boolean struts2ContextInited = false;

	public static void initWebApplicationContext(MockServletContext servletContext, String[] configLocations) {
		String configLocationsString = StringUtils.join(configLocations, ",");
		servletContext.addInitParameter("contextConfigLocation", configLocationsString);
		new ContextLoader().initWebApplicationContext(servletContext);
	}

	public static void initWebApplicationContext(MockServletContext servletContext,
			ApplicationContext applicationContext) {
		ConfigurableWebApplicationContext wac = new XmlWebApplicationContext();
		wac.setParent(applicationContext);
		wac.setServletContext(servletContext);
		wac.setConfigLocation("");
		servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, wac);
		wac.refresh();
	}

	public static void closeWebApplicationContext(MockServletContext servletContext) {
		new ContextLoader().closeWebApplicationContext(servletContext);
	}

	public static void setRequestToStruts2(HttpServletRequest request) {
		initStruts2ActionContext();
		ServletActionContext.setRequest(request);
	}

	public static void setResponseToStruts2(HttpServletResponse response) {
		initStruts2ActionContext();
		ServletActionContext.setResponse(response);
	}

	private static void initStruts2ActionContext() {
		if (!struts2ContextInited) {
			ActionContext.setContext(new ActionContext(new HashMap()));
			struts2ContextInited = true;
		}
	}
}
