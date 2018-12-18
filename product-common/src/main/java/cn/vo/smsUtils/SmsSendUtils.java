package cn.vo.smsUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
/**
 * 发送模板短信请求
 * @author yuanst
 *
 */
public class SmsSendUtils {
	
	  private static final String SERVER_URL = "https://api.netease.im/sms/sendtemplate.action";
	  public static final String APP_KEY = "24ef6223468afce0053793593f087a82";
	  public static final String APP_SECRET = "7e720eea1aaa";
	  private static final String NONCE = "123456";
	  private static final String TEMPLATEID = "3962906";
	  private static final String MOBILES = "['13002506997','18272712690']";
	  private static final String PARAMS = "['1','2','3','4','5','6','7']";

	  public static Map smsCode(String phoneParms, String contesParms)
	  {
	    Map map = new HashMap();
	    map.put("flag", "flase");
	    map.put("msg", "成功");
	    map.put("code", "200");
	    try {
	      DefaultHttpClient httpClient = new DefaultHttpClient();
	      HttpPost httpPost = new HttpPost("https://api.netease.im/sms/sendtemplate.action");
	      String curTime = String.valueOf(new Date().getTime() / 1000L);
	      String checkSum = CheckSumBuilder.getCheckSum("7e720eea1aaa", "123456", curTime);

	      httpPost.addHeader("AppKey", "24ef6223468afce0053793593f087a82");
	      httpPost.addHeader("Nonce", "123456");
	      httpPost.addHeader("CurTime", curTime);
	      httpPost.addHeader("CheckSum", checkSum);
	      httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

	      List nvps = new ArrayList();

	      nvps.add(new BasicNameValuePair("templateid", "3962906"));
	      nvps.add(new BasicNameValuePair("mobiles", phoneParms));
	      nvps.add(new BasicNameValuePair("params", contesParms));

	      httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

	      HttpResponse response = httpClient.execute(httpPost);

	      String json = EntityUtils.toString(response.getEntity(), "utf-8");
	   //   LOGGER.info("调用短信接口返回:" + json);
	      JSONObject jsonObj = JSONObject.parseObject(json);
	      String code = jsonObj.getString("code");
	      String msg = jsonObj.getString("msg");
	      if ("200".equalsIgnoreCase(code)) {
	        map.put("flag", "true");
	      }
	      System.out.println(json);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

	    return map;
	  }

	  public static void main(String[] args)
	    throws Exception
	  {
	    DefaultHttpClient httpClient = new DefaultHttpClient();
	    HttpPost httpPost = new HttpPost("https://api.netease.im/sms/sendtemplate.action");
	    String curTime = String.valueOf(new Date().getTime() / 1000L);

	    String checkSum = CheckSumBuilder.getCheckSum("7e720eea1aaa", "123456", curTime);

	    httpPost.addHeader("AppKey", "24ef6223468afce0053793593f087a82");
	    httpPost.addHeader("Nonce", "123456");
	    httpPost.addHeader("CurTime", curTime);
	    httpPost.addHeader("CheckSum", checkSum);
	    httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

	    List nvps = new ArrayList();

	    nvps.add(new BasicNameValuePair("templateid", "3962906"));
	    nvps.add(new BasicNameValuePair("mobiles", "['13002506997','18272712690']"));
	    nvps.add(new BasicNameValuePair("params", "['1','2','3','4','5','6','7']"));

	    httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

	    HttpResponse response = httpClient.execute(httpPost);

	    System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
	  }

	  /**
	  
	  //发送验证码的请求路径URL
	    private static final String
	            SERVER_URL="https://api.netease.im/sms/sendtemplate.action";
	    //网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
	    private static final String
	            APP_KEY="fd460d34e786e7754e505bc4fab0f027";
	    //网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
	    private static final String APP_SECRET="xxxxxxxx";
	    //随机数
	    private static final String NONCE="123456";
	    //短信模板ID
	    private static final String TEMPLATEID="3057527";
	    //手机号，接收者号码列表，JSONArray格式，限制接收者号码个数最多为100个
	    private static final String MOBILES="['13888888888','13666666666']";
	    //短信参数列表，用于依次填充模板，JSONArray格式，每个变量长度不能超过30字,对于不包含变量的模板，不填此参数表示模板即短信全文内容
	    private static final String PARAMS="['xxxx','xxxx']";
**/
	 
}
