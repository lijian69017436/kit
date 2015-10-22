package com.zbxsoft.audit.aoplog.aspect;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.zbxsoft.common.AppConstants;
import com.zbxsoft.common.AuditLogStr;
import com.zbxsoft.common.JsonUtil;
import com.zbxsoft.core.web.struts2.Struts2Utils;
import com.zbxsoft.uct.auth.AuthTools;
import com.zbxsoft.uct.auth.LoginUser;

/**
 * 声明一个日志切面 采用Spring Aspectj模式的AOP代理 进行日志处理
 * 
 * @author hexin
 * @version V1.0
 */  
@Component
@Aspect
public class AopLogAspect {
	private static final Logger logger = Logger.getLogger(AopLogAspect.class);
	public static Map<String, String> map = new HashMap<String, String>();

	static {
		/** 库存系统业务功能包 */
		map.put("bjkc.auditinfo", "库存单据审核操作");
		map.put("bjkc.kcservice", "提供的接口管理");
		map.put("bjkc.materialoperate", "原料入库/出库/借用单据操作");
		map.put("bjkc.prodoperate", "商品入库/出库/借用/调拨单据操作");
		map.put("bjkc.prodhouse", "库房商品/原料操作");
		map.put("bjkc.prodinfo", "商品/原料基本信息操作");
		map.put("bjkc.storeinfo", "库存仓库基本信息操作");
		map.put("bjkc.prodpackcert", "产品包装证书匹配操作");
		map.put("bjkc.statreport", "产品/原料出入台账/报表结存操作");
		map.put("bjkc.receipt", "库存处理实物代保管的业务操作");

		/** 实物系统业务功能包 */
		map.put("bjsw.allocation", "调拨操作");
		map.put("bjsw.commission", "返佣操作");
		map.put("bjsw.pricingsale", "定价直销操作");
		map.put("bjsw.prodpricereal", "产品报价/基准价费用操作");
		map.put("bjsw.purchase", "生产采购操作");
		map.put("bjsw.repurchase", "回购操作");
		map.put("bjsw.returnchange", "退换货操作");
		map.put("bjsw.sellgold", "销售操作");
		map.put("bjsw.swservice", "提供的接口操作");
		map.put("bjsw.trade", "套保及交易明细管理");

		/** 代保管系统业务功能包 */
		map.put("bjxs.buytrust", "购买定期托管操作");
		map.put("bjxs.card", "卡片管理操作");
		map.put("bjxs.cardmanager", "卡片管理操作");// ?
		map.put("bjxs.commission", "返佣操作");
		map.put("bjxs.outgold", "出金操作");
		map.put("bjxs.prodprice", "产品报价操作");
		map.put("bjxs.repurchase", "回购操作");
		map.put("bjxs.sellgold", "买金操作");
		map.put("bjxs.takecontract", "提金/预约操作");
		map.put("bjxs.trusteeships", "托管操作");
		map.put("bjxs.buytrust", "购买定期托管操作");
		map.put("bjxs.investment", "定投操作");
		map.put("bjxs.xsservice", "提供的接口管理");

		/** 公用业务功能包 */
		map.put("comservice.breach", "违约金操作");
		map.put("comservice.invoice", "发票操作");
		map.put("comservice.quotabond", "会员额度");
		map.put("comservice.scheme", "业务方案操作");
		map.put("comservice.tradeflow", "交易流水及明细操作");
		map.put("comservice.tradeworkflow", "审核记录操作");
		map.put("comservice.wflow", "业务审核工作流操作");
		map.put("comservice.commission", "实物返佣结算操作");
		map.put("comservice.commissiondbg", "代保管返佣结算操作");

		/** 工作流管理包 */
		map.put("wflow.core", "工作流管理操作");
	}

	@Around("execution(* com.zbxsoft.*.*.manager.*.save*(..))")
	public Object saveAround(ProceedingJoinPoint joinPoint) throws Throwable {
		return aroundOperate(joinPoint);
	}

	@Around("execution(* com.zbxsoft.*.*.manager.*.add*(..))")
	public Object addAround(ProceedingJoinPoint joinPoint) throws Throwable {
		return aroundOperate(joinPoint);
	}

	@Around("execution(* com.zbxsoft.*.*.manager.*.update*(..))")
	public Object updateAround(ProceedingJoinPoint joinPoint) throws Throwable {
		return aroundOperate(joinPoint);
	}

	@Around("execution(* com.zbxsoft.*.*.manager.*.delete*(..))")
	public Object deleteAround(ProceedingJoinPoint joinPoint) throws Throwable {
		return aroundOperate(joinPoint);
	}

	/**
	 * 打印WebService接口操作日志
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* com.zbxsoft.webservice.bank.BankInterfaceImpl.perform(..))")
	public Object BankService(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("【WebService start...】");
		Class<? extends Object> invokeClass = joinPoint.getTarget().getClass();
		Object[] paramValues = joinPoint.getArgs();// 获取参数值
		logger.info("【WebService接口执行类】：" + invokeClass.getName());
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if (paramValues != null && paramValues.length > 0) {
			int i = 0;
			for (Object paramObj : paramValues) {
				if (paramObj != null) {
					Class<? extends Object> paramClazz = paramObj.getClass();
					// 参数中有LoginUser对象，则不记载
					String paramType = paramClazz.getName();
					paramMap.put("param[" + i + "][type=" + paramType + "]",
							paramObj);
				}
				i++;
			}
		}
		logger.info("【WebService接口输入参数】："
				+ JsonUtil.getJsonString4JavaPOJO(paramMap));
		Object object = joinPoint.proceed();
		logger.info("【WebService接口输出参数】："
				+ JsonUtil.getJsonString4JavaPOJO(object));
		logger.info("【WebService end......】");
		return object;
	}

	/**
	 * 通知处理操作
	 * 
	 * @param joinPoint
	 *            切入点
	 * @return
	 * @throws Throwable
	 */
	public Object aroundOperate(ProceedingJoinPoint joinPoint) throws Throwable {
	  
		Object object = null;
		StringBuffer logInfo = new StringBuffer();
		Object[] paramValues = joinPoint.getArgs();// 获取参数值
		Class<? extends Object> invokeClass = joinPoint.getTarget().getClass();//得到 类名
		if (isAddLog(invokeClass.getName())) {
			String sysName = getSysNameAndModule(invokeClass.getName());// 获取对应的业务系统
			String moduleName = getModuleName(invokeClass.getName());// 获取对应的业务功能
			// System.out.println(invokeClass.getName()+"--"+isAddLog(invokeClass.getName()));
			logInfo.append("执行类：" + invokeClass.getSimpleName() + "；");// 执行的类
			String signatureName = joinPoint.getSignature().getName();// 当前执行的方法名称
			logInfo.append("执行方法：" + signatureName + "；");// 执行方法名称
			String title = moduleName + getMethodType(signatureName);// 获取业务功能执行的操作
			logInfo.append("\n执行操作:" + title + "；");
			// 入参日志
			logInfo.append("\n输入参数：");
			if (paramValues != null && paramValues.length > 0) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				int i = 1;
				for (Object paramObj : paramValues) {
					if (paramObj != null) {
						Class<? extends Object> paramClazz = paramObj
								.getClass();
						if (!"loginuser".equals(paramClazz.getSimpleName()
								.toLowerCase())) {
							// 参数中有LoginUser对象，则不记载
							String paramType = paramClazz.getName();
							paramMap.put("param[" + i + "][type=" + paramType
									+ "]", paramObj);
						}
					} else {
						paramMap.put("param[" + i + "]", paramObj);
					}
					i++;
				}
				logInfo.append(JsonUtil.getJsonString4JavaPOJO(paramMap));// 请求的参数
			}
			logInfo.append("；");

			long time1 = System.currentTimeMillis();
			object = joinPoint.proceed();
			long time2 = System.currentTimeMillis();

			// 出参日志
			if (object != null) {
				logInfo.append("\n输出参数：" + object + "；");
			}

			// 执行时间
			logInfo.append("\n执行时间: " + (time2 - time1) + " ms。");
			LoginUser loginUser = new LoginUser();
			try {
				loginUser = AuthTools.getLoginUser(Struts2Utils.getSession());
			} catch (Exception e) {
				loginUser.setUserId("system");
				loginUser.setUserCname("系统发起");
			} finally {
				AuditLogStr.addAuditLog(sysName, moduleName, title,
						logInfo.toString(), null, 0, loginUser);
			}
		} else {
			object = joinPoint.proceed();
		}
		return object;
	}

	/**
	 * 根据类名判断当前操作是否需要记录业务日志
	 * 
	 * @param className
	 *            类名称
	 * @return true:记录，false:不记录
	 */
	private boolean isAddLog(String className) {
		if ((className.indexOf("com.zbxsoft.audit") > -1)
				|| (className.indexOf("com.zbxsoft.dict") > -1)
				|| (className.indexOf("com.zbxsoft.seq") > -1)
				|| (className.indexOf("com.zbxsoft.uct") > -1)
				|| (className.indexOf("com.zbxsoft.bjkc.prodoperateflow") > -1)
				|| (className.indexOf("com.zbxsoft.webservice.message.manager") > -1)) {
			/**
			 * 不需要记录日志的模块： 1.审计日志 2.数据字典管理 3.uct权限 4.库存操作流水包 5.webservice记录日志的
			 */
			return false;
		} else {
			return true;
		}

	}

	/**
	 * 获取应用系统【库存，实物，代保管...】 根据类的全名称判断出此业务所属应用系统
	 * 
	 * @param className
	 *            className 类的全名称
	 * @return 返回系统名称
	 */
	private String getSysNameAndModule(String className) {
		String sysEName = "";
		// if (Struts2Utils!=null && loginUser!=null &&
		// StrUtil.isNotNull(loginUser.getSysEname())) {
		// LoginUser loginUser =
		// AuthTools.getLoginUser(Struts2Utils.getSession());
		// sysEName = loginUser.getSysEname();
		// }else{
		if (className.indexOf("bjkc") > -1) {
			sysEName = AppConstants.SYSTEM_BJKC;
		} else if (className.indexOf("bjsw") > -1) {
			sysEName = AppConstants.SYSTEM_BJSW;
		} else if (className.indexOf("bjxs") > -1) {
			sysEName = AppConstants.SYSTEM_BJXS;
		}
		// }
		return AppConstants.getSysCNameAndModule(sysEName);
	}

	/**
	 * 获取业务模块【用户管理，出库管理，销售管理...】 根据执行类的名称判断出对应的业务模块
	 * 
	 * @param className
	 *            类的全名称
	 * @return 返回业务模块名称
	 */
	private String getModuleName(String className) {
		className = className.toLowerCase();
		String[] packs = className.split("\\.");
		if (packs != null && packs.length > 3) {
			String key = packs[2] + "." + packs[3];
			return map.get(key);
		} else {
			return "";
		}
	}

	/**
	 * 获取执行操作【增，删，改，查】 根据方法名称前缀判断出此方法执行类型
	 * 
	 * @param methodName
	 *            方法名称
	 * @return 
	 *         返回方法执行类型。【save*->保存，add*->新增，update*->更新，delete*->删除，find*、get*->查询
	 *         】
	 */
	private String getMethodType(String methodName) {
		String methodPrefix = methodName;
		if (methodName.indexOf("save") > -1) {
			methodPrefix = "[保存]";
		} else if (methodName.indexOf("add") > -1) {
			methodPrefix = "[新增]";
		} else if (methodName.indexOf("update") > -1) {
			methodPrefix = "[更新]";
		} else if (methodName.indexOf("delete") > -1) {
			methodPrefix = "[删除]";
		} else if (methodName.indexOf("find") > -1
				|| methodName.indexOf("get") > -1) {
			methodPrefix = "[查询]";
		}
		return methodPrefix;
	}
}
