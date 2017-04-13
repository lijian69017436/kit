/*package com.ejz.wechat.main.task;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.wechat.api.MediaAPI;
import com.baomidou.wechat.api.MessageAPI;
import com.baomidou.wechat.api.impl.MediaAPIImpl;
import com.baomidou.wechat.api.impl.MessageAPIImpl;
import com.baomidou.wechat.common.enums.MediaType;
import com.baomidou.wechat.common.enums.MessageType;
import com.baomidou.wechat.vo.ApiResult;
import com.baomidou.wechat.vo.api.Media;
import com.ejz.wechat.dao.entity.Staff;
import com.ejz.wechat.service.StaffService;
import com.ejz.wechat.util.DateUtils;

@Service("sendMsgJob")
public class SendMsgJob {

	MediaAPI meApi=new MediaAPIImpl();
	
	@Autowired
	StaffService staffService;
	@Test
	public void sendMsgAll(){
		System.out.println("定时任务 推送生日祝福到 微信公众号关注用户");
		//1查询 姓名和生日   
		List<Staff> staffResult = staffService.queryStaffBytime(DateUtils.formatDate_ymdhms(new Date()));
		
		//2拼成 图文信息   上传图文信息 
		String media_id=testUpload(staffResult);
		
		//3发送信息
		sendPicture( media_id);
		
		
	}
   //发送消息
	private void sendPicture(String meida_id) {
		MessageAPI messageApi = new MessageAPIImpl();
		JSONObject media_id=new JSONObject();
		media_id.put("media_id",meida_id);
		JSONObject json = new JSONObject();
		json.put("touser","opnqpxAJuvsq7nEDJfEHVRzNvY2M" );
		json.put(MessageType.mpnews+"", media_id );
		json.put("msgtype",MessageType.mpnews );
		ApiResult	result=messageApi.sendMsgPreview(json.toString());
		System.out.println("预览结果 ："+JSONObject.toJSONString(result));
	}
	
	
	
	@Test //测试 上传图片
	public void testUploda(){
		
		//1上传 临时 文件图片
//		Media media = meApi.upMedia(MediaType.IMAGE, new File("C:\\Users\\li\\Pictures\\151337systc8ocxp9ox077.jpg"));
//		media_id=media.getMedia_id();
//		System.out.println(JSONObject.toJSON(media));
		
		//上传 永久素材 ： 
		Media media = meApi.add_meterial(MediaType.IMAGE, new File("C:\\Users\\Administrator\\Pictures\\03.jpg"));
		System.out.println(JSONObject.toJSON(media));
		
		//上次 上传成功的media_id
		//OCxStrQhIbHIkohmGX7qj4aK9YpMkoUGMg0S88ofTtA
	}
	
	@Test //上传图文素材
	public String testUpload(List<Staff> data){
		StringBuffer content=new StringBuffer();
		for(Staff staf:data){
			String name=staf.getName();
			String MM=DateUtils.formateString_format(staf.getBirthday(),"MM");
			String dd=DateUtils.formateString_format(staf.getBirthday(),"dd");
			content.append(name+"  "+MM+"/"+dd +"  ,");
		}
		
		StringBuffer json=new StringBuffer();
		
		json.append("{");
		json.append("\"articles\": [");
		json.append("   {");
		json.append("     \"thumb_media_id\":\"OCxStrQhIbHIkohmGX7qj6Oz5DwkiGNB3XGLvuqxcvk\",");
		json.append("     \"author\" :\"hr\",");
		json.append("     \"title\"  :\" Happy birthday 标题\",");
		json.append("     \"content\":\" "+content+"\"");
		json.append("   } ");
		json.append("");
		json.append("]");
		json.append("}");
		
		System.out.println(json.toString());
		Media uploadNews = meApi.add_news(json.toString()); //上传图文素材
		System.out.println(JSONObject.toJSON(uploadNews));
		return uploadNews.getMedia_id();
		//上次上传 成功 的 media_id
		//OCxStrQhIbHIkohmGX7qj8mOwHCXD8A-9xJ02HkURIQ
		//OCxStrQhIbHIkohmGX7qj9FyJsFxQqVtMkqMJEkAVY8
	}
}
*/