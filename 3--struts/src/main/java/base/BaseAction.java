package base;

import com.opensymphony.xwork2.ActionSupport;
import com.zbxsoft.core.web.struts2.Struts2Utils;
import com.zbxsoft.uct.auth.AuthTools;
import com.zbxsoft.uct.auth.LoginUser;

/**
 * ajax  提交 返回 都是 这个 
 * 
 * 所有  servlet 继承这个 类  规范 返回信息 
 * 返回 json 串   
 * 
 * @author Administrator
 *
 */
/** 前台 提交 内容
 *  $.ajax( {
        url : '${ctx}/bjsw/sellgold/gold-sales!getWaringValue.action?prodType=T&d='+new Date().getTime(),
        success : function(data) {
          var result = jQuery.parseJSON(data); //jquery 解析 json串
            if(result.isok=='T'){
              
            }else{
              ZBXTools.disableButton("#addid");
              ZBXTools.disableButton("#print");
              ZBXTools.disableButton("#subbut");
              $.messager.alert('提示', result.msg, 'info');
            }
        }
      });
 * @author Administrator
 *
 */
public class UctBaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 当前登录用户
	 */
	protected LoginUser loginUser = AuthTools.getLoginUser(Struts2Utils
			.getSession());

	protected String showOk(Object msg) throws Exception {
		net.sf.json.JSONObject jvo = new net.sf.json.JSONObject();
		jvo.put("isok", "T");
		jvo.put("msg", msg);

		Struts2Utils.getResponse().setContentType("text/html;charset=UTF-8");
		Struts2Utils.getResponse().getWriter().write(jvo.toString());

		return null;
	}

	protected String showError(Object msg) throws Exception {
		net.sf.json.JSONObject jvo = new net.sf.json.JSONObject();
		jvo.put("isok", "F");
		jvo.put("msg", msg);

		Struts2Utils.getResponse().setContentType("text/html;charset=UTF-8");
		Struts2Utils.getResponse().getWriter().write(jvo.toString());

		return null;
	}

	protected String showError(Object msg, String flag) throws Exception {
		net.sf.json.JSONObject jvo = new net.sf.json.JSONObject();
		jvo.put("isok", "F");
		jvo.put("flag", flag);
		jvo.put("msg", msg);

		Struts2Utils.getResponse().setContentType("text/html;charset=UTF-8");
		Struts2Utils.getResponse().getWriter().write(jvo.toString());

		return null;
	}

}
