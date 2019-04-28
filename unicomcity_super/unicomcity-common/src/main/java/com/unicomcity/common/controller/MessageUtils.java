package com.unicomcity.common.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.beanutils.BeanUtils;

/**
 * 
 * @author 刘冰
 * 主要处理json返回数据的封装
 *
 */
public class MessageUtils {
	
	/**
	 * 对象转json
	 **/
	public static String ObjectTojson(MessageObject messageObject){
		if(messageObject!=null){
			if(messageObject.getCode() == null || messageObject.getCode().isEmpty()){
				messageObject.setCode("1001");
			}
		}
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		String json = JSON.toJSONString(messageObject,SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.WriteDateUseDateFormat);
		return json;
	}
	/**
	 * json转 对象
	 * @param <T>
	**/
	public static <T> Object JsonToObject(String json,Class<T> clazz){
		Object obj = JSON.parseObject(json,clazz);
		return obj;
	}

	public static MessageObject ObectToClass(String json,Class<?> classs){
		MessageObject messageObject = new MessageObject();
		if(json == null || json.isEmpty()){
			messageObject.setCode("1002");
			messageObject.setContent("您输入的数据不完整，请完善您输入的数据！");
		}else{
			messageObject = (MessageObject) MessageUtils.JsonToObject(json,MessageObject.class);
			if(messageObject==null){
				messageObject.setCode("1002");
				messageObject.setContent("您输入的数据无法解析为对象");
			}else{
				try {
					JSONObject content = (JSONObject) messageObject.getContent();
					Object object_cont =  MessageUtils.JsonToObject(content.toJSONString(),classs);
					if(object_cont!=null) {
						messageObject.setCode("1000");
						messageObject.setContent(object_cont);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		return messageObject;
	}
}
