package com.zbxsoft.core.log;

import com.zbxsoft.core.utils.IdUtils;
import org.apache.log4j.MDC;

public abstract class TraceUtils {
	public static final String TRACE_ID_KEY = "traceId";

	public static void beginTrace() {
		String traceId = IdUtils.randomBase62();
		MDC.put("traceId", traceId);
	}

	public static void endTrace() {
		MDC.remove("traceId");
	}
}
