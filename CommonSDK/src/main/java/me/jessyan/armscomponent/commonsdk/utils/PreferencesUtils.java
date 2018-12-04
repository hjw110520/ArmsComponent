package me.jessyan.armscomponent.commonsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * @author hjw
 * 2018/12/1
 */
public class PreferencesUtils {
    /**
     * SharedPreferences
     */
    private static SharedPreferences SHARED_CONFIG;


    /**
     * 添加公共信息
     * @param context Context
     * @param key String
     * @param value T
     * @param <T> String or boolean or Long
     */
    public static <T> void addConfigInfo(Context context, String key, T value) {
        if ( value != null && !"".equals(value)) {
            SHARED_CONFIG = context.getSharedPreferences( context.getPackageName(), Context.MODE_PRIVATE );
            Editor conEdit = SHARED_CONFIG.edit();
            if ( value instanceof String) {
                conEdit.putString( key.trim(), ( (String) value ).trim() );
            }
            else if ( value instanceof Long) {
                conEdit.putLong( key, (Long) value );
            }
            else if ( value instanceof Boolean) {
                conEdit.putBoolean( key, (Boolean) value );
            }
            conEdit.commit();
        }
    }

    /**
     * 更具key删除公共信息
     * @param context Context
     * @param key String
     */
    public static void removeConfigInfo(Context context, String key) {
        if ( key != null && !"".equals(key)) {
            SHARED_CONFIG = context.getSharedPreferences( context.getPackageName(), Context.MODE_PRIVATE );
            Editor conEdit = SHARED_CONFIG.edit();
            conEdit.remove(key);
            conEdit.commit();
        }
    }

    /**
     * 删除所有公共信息
     * @param context Context
     */
    public static  void removeAllInfo(Context context) {
        removeAllInfo(context,null);
    }

    /**
     * 根据key获取信息
     * @param context Context
     * @param key String
     * @param typeClass 信息的类型
     * @param <T> String or Long or Boolean or Integer
     * @return T
     */
    public static <T> T getValueByKey(Context context, String key, Class<T> typeClass ) {
        SHARED_CONFIG = context.getSharedPreferences( context.getPackageName(), Context.MODE_PRIVATE );
        if(key == null || "".equals(key) || null == SHARED_CONFIG){
            return null;
        }

        if (typeClass.equals( String.class ) ) {
            return (T) SHARED_CONFIG.getString( key, "" );
        }
        if (typeClass.equals( Long.class ) ) {
            return (T) Long.valueOf( SHARED_CONFIG.getLong( key, 0 ) );
        }
        if (typeClass.equals( Boolean.class ) ) {
            return (T) Boolean.valueOf( SHARED_CONFIG.getBoolean( key, true ) );
        }

        return null;
    }

    /**
     * 根据key得到信息
     * @param context Context
     * @param key String
     * @return String信息
     */
    public static String getStringByKey(Context context, String key) {
        String value = null;
        SHARED_CONFIG = context.getSharedPreferences( context.getPackageName(), Context.MODE_PRIVATE );
        if (null != SHARED_CONFIG) {
            value = SHARED_CONFIG.getString(key, "");
        }
        return value;
    }

    /**
     * 删除node下所有公共信息
     * @param context Context
     * @param node Desired preferences file. If a preferences file by this name
     *      * does not exist, it will be created when you retrieve an
     */
    public static void removeAllInfo(Context context, String node) {
        if(null == node){
            node = context.getPackageName();
        }
        SHARED_CONFIG = context.getSharedPreferences(node, Context.MODE_PRIVATE);
        if(null != SHARED_CONFIG){
            SHARED_CONFIG.edit().clear().commit();
        }

    }
}
