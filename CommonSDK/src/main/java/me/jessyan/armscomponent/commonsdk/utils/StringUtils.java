package me.jessyan.armscomponent.commonsdk.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @author hjw
 * 2018/12/1
 */
public final class StringUtils {
    /**
     * no instance needed
     */
    private StringUtils() { /*no instance*/ }

    /**
     * null-value String
     */
    private static final String NULL = "null";

    /**
     * check this target string is NULL or empty; <br/>
     * if <code>checkContentNull</code> is set true,
     * it'll also check if it is a "null" string, ignoring Case.
     * @param target target string to check
     * @param checkContentNull if is set true,
     * it'll also check if it is a "null" string, ignoring Case.
     * @return boolean
     */
    public static boolean isEmpty(final String target, boolean checkContentNull) {
        // check if target is null, or a len == 0 string
        return (("null".equals(target))||(null == target)
                || (target.length() == 0)
                || (checkContentNull && NULL.equalsIgnoreCase(target)));
    }

    /**
     * check this target string is null or empty;
     * @param target target string to check
     * //@see #isEmpty(String, false)
     * @return boolean
     */
    public static boolean isEmpty(final String target) {
        return isEmpty(target, false);
    }

    /**
     * check this target string is null or "null" String, ignoring case;
     *
     * @param target target string to check
     * @return boolean
     */
    public static boolean isNull(final String target) {
        return null == target || NULL.equalsIgnoreCase(target);
    }



    /**
     * 判断输入是否是数字或者字母
     * @param str String
     * @return boolean
     */
    public static boolean isNumOrLetter(String str) {
        String strPattern = "(?!^[0-9]+$)(?!^[a-zA-Z]+$)[0-9a-zA-Z]+";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(str.trim());
        return m.matches();
    }

    /**
     * check if it is a phone number
     * @param phone number
     * @param strict if false,only check start with 1 and is it 11 numbers；
     *               if true,check strict
     * @return boolean
     */
    public static boolean isPhone(String phone,boolean strict) {

        if(strict){
            return isPhone(phone);
        }

        Pattern pattern = Pattern.compile("([1]{1})([0-9]{10})");
        Matcher m = pattern.matcher(phone.trim());
        if (m.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 严格检查是否是手机号码
     * @param phone number
     * @return boolean
     */
    private static boolean isPhone(String phone) {
        boolean isValid = false;
        String expression = "((^(13|15|18|17)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
        CharSequence inputStr = phone;

        Pattern pattern = Pattern.compile(expression);

        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;

    }

    /**
     * 判断给定字符串是否空白串。<br> 空白串是指由空格、制表符、回车符、换行符组成的字符串<br>
     * @param data String
     * @return boolean
     */
    public static boolean isBlank(String data) {
        if (data == null || "".equals(data)) {
            return true;
        }

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }

    /**
     * @param strEmail email String
     * @return boolean
     */
    public static boolean isEmail(String strEmail) {
        String strPattern = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(strEmail);
        return m.matches();
    }

    /**
     * 是否全是数字(整数)
     * @param str 只能检查证书，不支持含小数点的数字
     * @return boolean
     */
    public static boolean isPureNumber(String str) {
        String strPattern = "^[0-9]*$";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(str);
        return m.matches();
    }


    /**
     * 检查是否是数字，支持含小数点的数字
     * @param str 支持含小数点的数字
     * @return boolean
     */
    public static boolean isValidNumber(String str) {
        String strPattern = "^\\d+\\.{0,1}\\d*$";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(str);
        return m.matches();
    }




    /**
     * 手机号码前三位与后三位之间用*代替
     * @param phoneNum String
     * @return phoneNum with *
     */
    public static String replacePhoneStr(String phoneNum) {
        char[] cs = phoneNum.toCharArray();
        int numLen = phoneNum.length();
        for (int i = 0; i < numLen; i++) {
            if (i > 3 && i < (numLen - 3)) {
                cs[numLen - i - 1] = '*';
            }
        }
        return String.valueOf(cs);
    }


    /**
     * @param str String
     * @return boolean
     */
    public static boolean isChinese(String str) {
        String strPattern = "[\u0391-\uFFE5]*";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(str.trim());
        return m.matches();
    }


    /**
     * 判断输入是否是6-20位数字或字母组合,常用语注册密码的设置
     * @param str String
     * @return boolean
     */
    public static boolean isNumAndLetter(String str) {
        String strPattern = "(?!^[0-9]+$)(?!^[a-zA-Z]+$)[0-9a-zA-Z]{6,18}";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(str.trim());
        return m.matches();
    }
}
