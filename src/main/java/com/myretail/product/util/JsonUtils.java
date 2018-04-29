package com.myretail.product.util;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonUtils {
	
	
	public static <E> String getJsonStringFromList(List<E> list) {
		return Optional.of(list).map(x -> (new JSONArray(x)).toString()).get();
	}
	
	public static String getStringValue(String json, String key) throws InvocationTargetException{
		JSONObject jsonObject = new JSONObject(json);
		String value = null;
		String[] nodes = key.split(Pattern.quote("."));
		if(nodes!=null) {
			for(int i = 0; i<nodes.length-1; i++) {
				jsonObject = jsonObject.getJSONObject(nodes[i]);
				if(jsonObject==null) break;
			}
			if(jsonObject!=null)
				value = jsonObject.getString(nodes[nodes.length-1]);
		}
		return value;
	}
	
}
