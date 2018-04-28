package com.myretail.product.util;

import java.util.List;
import java.util.Optional;

import org.json.JSONArray;

public class JsonUtils {
	
	
	
	public static <E> String getJsonStringFromList(List<E> list) {
		return Optional.of(list).map(x -> (new JSONArray(x)).toString()).get();
	}
	
}
