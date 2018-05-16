package com.jsoup.libaoran;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestLi {

	@Test
	public void d() {
		try {

			for (int i = 1; i < 1000; i++) {

				// 45 10分钟不够

				String url = "https://www.wenjuan.com/s/iyyaAj/";
				// url+="&submitdata=1$地方}2$2}3$1}4$3}5$1}6$2}7$2}8$4}9$1}10$1<1,2<1,3<1,4<1,5<1,6<1}11$1}12$2}13$2}14$2}15$4}16$2}17$4}18$2}19$1}20$2}21$2}22$2}23$1}24$5}25$2}26$地方";
				Map<String, String> cookies = new HashMap<String, String>();
				cookies.put("UM_distinctid", "15e11da9d8c289-0916cfcf6677b4-6316157a-100200-15e11da9d8d251");
				cookies.put("ASPXANONYMOUS",
						"LOSoFApT0wEkAAAANDI5NjgxMjYtNmYwZC00ZjVlLTgzM2YtNDY4YWYyMTdmNzliv-Ru-uvlllnRdbdBks4mKbpCxik1");
				cookies.put("CNZZDATA4478442", "cnzz_eid%3D2105914366-1503536190-%26ntime%3D1503536190");
				cookies.put("jac16018239", "40799416");

				Map<String, String> param = new HashMap<String, String>();
				param.put("total_answers_str",
						"{\"5af826c792beb5230c264441\":[\"5af826c892beb5230c264443\"],\"5af8271092beb522dec6f163\":[\"5af8271092beb522dec6f165\"],\"5af8277092beb521f8bcdc15\":[\"5af8277492beb5225476ffc6\"],\"5af8279992beb5245b3ce147\":[\"5af8279992beb5245b3ce149\"],\"5af827e292beb522268832f8\":[\"5af827e292beb522268832fa\"],\"5af8283892beb5225476ffd0\":[[\"5af8283a92beb5230c26446a\"]],\"5af8288692beb5225476ffdb\":[[\"5af828a992beb52282aa1382\"]],\"5af828e992beb522b08166b2\":[\"5af828e992beb522b08166b4\"],\"5af828eb92beb5233fd2083c\":[\"5af828eb92beb5233fd2083d\"],\"5af828ec92beb5233fd2083f\":[\"5af8290a92beb52226883314\"],\"5af828ed92beb5242d63c770\":[\"5af8290392beb521b4a972a9\"],\"5af828f092beb524897e8726\":[\"5af828ff92beb523fff078f0\"],\"5af828f292beb521b4a972a3\":[\"5af828fb92beb52226883313\"],\"5af828f392beb522b08166b5\":[\"5af828f392beb522b08166b6\"]}");
				param.put("pconvert_data", "");
				param.put("finish_status", "1");
				param.put("timestr",JSON.toJSONString( new Date()));
				param.put("idy_uuid", "6f1a949fedc346a2da3de9aa2def3a87");
				param.put("svc", "8d60d2b34d9aeb15b25bf483272c2dc2");
				param.put("project_version", "1");
				param.put("s_code", "-20");
				param.put("s_func_id", "28");
				param.put("vvv", "d37765c52b73b6d5c8a71b153357b1cf");
				param.put("rand_int", "3");
				param.put("question_captcha_map_str", "");
				param.put("_xsrf", "bb8bf73bddab4c77b317d135ca710ef4");
				Connection con= Jsoup.connect(url)
						.data(param);
				con.cookie("_xsrf", "bb8bf73bddab4c77b317d135ca710ef4");
				con.cookie("sessionid", "eXoxSDhnTkxscm5CUkFGcDVhZmE2ZTE2");
				Document d = con.post();
				System.out.println(d.body());
				Thread.sleep(1000);
//				if (i % 4 == 0) {
//					Thread.sleep(1000 * 60 * 2);
//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	// total_answers_str:
	// pconvert_data: {}
	// : -20
	// : 28
	// vvv:
	// : 3
	// : {}
	// :

}
