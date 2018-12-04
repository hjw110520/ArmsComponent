package me.jessyan.armscomponent.commonsdk.utils;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Json和java转换工具类
 * @author hjw
 * 2018/12/1
 */
public class JsonUtils {

    /**
     * 将java对象转换成json对象
     * @param  obj Object
     * @return  String
     */
    public static String parseObj2Json(Object obj) {

        if (null == obj) {
            return null;
        }

        Gson gson = new Gson();
        String objstr = gson.toJson(obj);
        return objstr;
    }

    /**
     * 将json对象转换成java对象
     * @param jsonData String
     * @param c class T
     * @param <T>  Class<T>
     * @return Object<T>
     */
    public static <T> Object parseJson2Obj(String jsonData, Class<T> c) {
        if (StringUtils.isEmpty(jsonData)) {
            return null;
        }

        Gson gson = new Gson();
        Object obj = gson.fromJson(jsonData.trim(), c);
        return obj;
    }


    /**
     * 将json对象转换成数组对象
     * @param jsonData String
     * @param c Class T
     * @param <T>  Class<T>
     * @throws JSONException exception
     * @return List<T>
     */
    public static <T> ArrayList<T> parseJson2List(String jsonData, Class<T> c)
            throws JSONException {

        if (null == jsonData || "".equals(jsonData)) {
            return null;
        }

        Gson gson = new Gson();
        ArrayList<T> list = new ArrayList<T>();
        JSONArray jsonArray = new JSONArray(jsonData.trim());
        JSONObject objItem;
        T objT;
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            objItem = (JSONObject) jsonArray.get(i);
            if (null != objItem) {
                objT = gson.fromJson(objItem.toString(), c);
                list.add(objT);
            }
        }

        return list;
    }

}
