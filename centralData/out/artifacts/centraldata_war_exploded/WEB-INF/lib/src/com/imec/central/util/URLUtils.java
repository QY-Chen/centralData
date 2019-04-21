package com.imec.central.util;

public class URLUtils {
	/**
	 * 返回后两个"/"组成的地址
	 * @param url 如nsgoves/admin/index
	 * @return 返回admin/index
	 */
	public static String getUrlFromRequestUrl(String url){
		if(url == null || url.length() == 0){
			return "";
		}
		String rUrl = "";
		String[] urls = url.trim().split("/");
		if(urls.length==1){
			rUrl = urls[urls.length-1];
		}else if(urls.length > 1){
			rUrl = urls[urls.length-2]+"/"+urls[urls.length-1];
		}
		return rUrl;
	}
	/**
	 * 返回后两个"/"组成的无参数地址
	 * @param url 如nsgoves/admin/index
	 * @return 返回admin/index
	 */
	public static String getUrlNoParamFromRequestUrl(String url){
		String rUrl = getUrlFromRequestUrl(url);
		if(rUrl == null || rUrl.length() == 0){
			return "";
		}
		String[] urls = rUrl.split("[?]");
		if(urls.length>=1){
			rUrl = urls[0];
		}
		return rUrl;
		
	}
}
