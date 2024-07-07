package crf.util;

public class CallSendSMS {
	public CallSendSMS() {
		super();
	}

	public static  void callSendSms(String mobilePhone,String content) {
		SendSMS ss = new SendSMS();
		ss.setUsername("601008");
		ss.setPassword("2314cfc7aeb43662a033cf77e8639efc");
		ss.setMessage(content);
		ss.setMobiles(mobilePhone);
		ss.setServicesHost(" http://sms.c8686.com");
		//ss.setServicesHost(" http://61.129.86.73");
		
		
		ss.setServicesRequestAddRess("/Api/BayouSmsApiEx.aspx");
		ss.setSmstype(0);
		ss.setTimerid("0");
		ss.setTimertype(0);
		ss.sendSMS();
//		Map<String, String> map = ss.sendSMS();
//		Iterator<Entry<String, String>> it = map.entrySet().iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
	}
	
	public static void main(String[] args) {
		callSendSms("18611163318", "牛牛牛，曲项向天歌，白毛浮绿水，牛哥啵啵啵！！！");
	}


}