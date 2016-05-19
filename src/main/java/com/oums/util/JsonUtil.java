package com.oums.util;

import com.google.gson.Gson;
import com.google.gson.JsonNull;

/**
 * Json转换工具
 * @author fantasy
 *
 */
public class JsonUtil  
{  
      
    private static Gson gson = new Gson();  
  
  
    /** 
     * @MethodName : toJson 
     * @Description : 转换成Json字符串 
     * @param src 
     *            :��Ҫ��ת���Ķ��� 
     * @return :ת�����JSON�� 
     */  
    public static String toJson(Object src) {  
        if (src == null) {  
            return gson.toJson(JsonNull.INSTANCE);  
        }  
        return gson.toJson(src);  
    }  
}
