/*package com.ejz.wechat.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.wechat.api.WechatAPIImpl;
import com.baomidou.wechat.common.enums.MediaType;
import com.baomidou.wechat.vo.MPAccount;
import com.baomidou.wechat.vo.api.Media;
import com.baomidou.wechat.vo.api.Menu;
import com.baomidou.wechat.vo.api.MenuButton;
import com.baomidou.wechat.vo.api.QRTicket;

public class ApiTest {

	public static void main(String[] args) {
		MPAccount ma = new MPAccount();
		ma.setAppId("wx8fef7296e4bfc38c");
		ma.setAppSecret("033e8496ea4bb6b9e15f4ca7a2bab090");
		ma.setMpId("10001212");
		WechatAPIImpl wa = new WechatAPIImpl(ma, new WechatCacheMap());
		System.out.println("微信服务凭证:"+wa.getAccessToken());
		List<String> ipList = wa.getServerIps();
		System.out.println((ipList == null) ? "not get ip!" : ipList.get(0));
		List<String> openIds = wa.getFollowerList("").getOpenIds();
		System.out.println("得到用户列表:"+openIds== null ? "没有用户" : openIds.toString());

		System.out.println("用户基本信息:"+wa.getFollower("owvMfwSh9FbWDyW3ihBRdgK65e_g", "zh_CN").toString());
		QRTicket qt = wa.createQR(0, 123);
		System.out.println("二维码:"+qt != null ? qt.getTicket() : "qt is null");

		String longUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQGt7zoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL09qb0lWVFhsUjVnX2JOTEgwQlFHAAIEa/Q2VgMEewAAAA==";
		System.out.println("shortUrl: " + wa.getShortUrl(longUrl));
		
		
		wa.getMenu();
		System.out.println("删除菜单：" + wa.delMenu());
		
		List<Menu> button = new ArrayList<Menu>();
		Menu m = new Menu();
		m.setType("click");
		m.setName("易久州");
		m.setKey("V1001_TODAY_MUSIC");
		Menu m2 = new Menu();
		m2.setType("view");
		m2.setName("视频");
		m2.setUrl("http://v.qq.com/");
//		m2.setUrl("http://lifeislikeaboat.com/");//node.js 聊天室   桌面 Chatbox
		
		button.add(m);
		button.add(m2);
		Menu m1 = new Menu("菜单");
		List<Menu> sub_button = new ArrayList<Menu>();
		sub_button.add(new Menu("微社区", "view", "http://114.254.31.239:10008/WebSocket/chat.jsp"));
		sub_button.add(new Menu("企业相册", "view", "http://114.254.31.239:10008/ejz/photo.html"));
		sub_button.add(new Menu("水果忍者", "view", "http://114.254.31.239:10008/ejz/shuiguo/index.html"));
		m1.setSub_button(sub_button);
		button.add(m1);
		MenuButton btn = new MenuButton();
		btn.setButton(button);
		System.out.println("菜单创建：" + wa.createMenu(btn));
		
		//删除菜单
		//wa.delMenu();
		
		 File file = new File("e://FD6A.jpg");
		 Media media = wa.upMedia(MediaType.IMAGE, file);
		 if (media != null && media.isOK()) {
			 System.out.println(media.getMedia_id());
		 }

		 String
		 mid="g0pW6j9P3QxY9DqBvmOuk85BU-NX_T97XnGhmh85jZUJnwhAs0CsuN1IgrlBOyXU";
		 Attachment att = wa.dlMedia(mid);
		 StreamUtil.outputFile(att.getFileStream(), new File("e://bg_link10.jpg"));
	}

}
*/