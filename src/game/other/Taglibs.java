package game.other;

import com.google.gson.Gson;

//自定义标签库。toJson是el表达式可用的自定义函数。
public class Taglibs {
	private static final Gson gson = new Gson();
	
	public static String toJson(Object object) {
	    return gson.toJson(object);
	}
}
