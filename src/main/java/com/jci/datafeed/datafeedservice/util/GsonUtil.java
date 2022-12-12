package com.jci.datafeed.datafeedservice.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {

	private static Gson gson;
	private static Gson gsonWtihDateFormat;

	public static Gson getGson() {
		if (gson == null) {
			gson = new Gson();
		}
		return gson;
	}

	public static Gson getGsonWithDateFormat() {
		if (gsonWtihDateFormat == null) {
			gsonWtihDateFormat = new GsonBuilder().setDateFormat(Constants.DATE_YYYY_MM_DD).create();
		}
		return gsonWtihDateFormat;
	}

}
