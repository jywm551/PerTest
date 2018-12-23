package com.example.utils;


import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: StringUtil
 * @Description: 字符串帮助类
 * @author: luorui
 * @date: 2018年4月19日 下午3:52:58
 */
@SuppressWarnings("unchecked")
public class StringUtil {
    /**
     * 该功能压缩字符串的左边空格
     *
     * @param value ：源串
     * @return
     */
    public static String trimLeft(String value) {
        if (value == null) {
            return "";
        }
        String result = value;
        char ch[] = result.toCharArray();
        int index = -1;
        for (int i = 0; i < ch.length; i++) {
            if (Character.isWhitespace(ch[i])) {
                index = i;
            } else {
                break;
            }
        }
        if (index != -1) {
            result = result.substring(index + 1);
        }
        return result;
    }

    /**
     * 该功能压缩字符串的右边空格
     *
     * @param value ：源串
     * @return String src结果字符串
     */
    public static String trimRight(String value) {
        if (value == null) {
            return "";
        }
        String result = value;
        char ch[] = result.toCharArray();
        int endIndex = -1;
        for (int i = ch.length - 1; i > -1; i--) {
            if (Character.isWhitespace(ch[i])) {
                endIndex = i;
            } else {
                break;
            }
        }
        if (endIndex != -1) {
            result = result.substring(0, endIndex);
        }
        return result;
    }

    /**
     * *****************************************************
     * 功    能：在字符串前面添加多个"0",返回固定长度
     * 入口参数：param str:待处理的字符串
     * param len：返回固定长度
     * 返    回：Stirng
     * <p/>
     * 编写日期：
     * 修改备注：
     * ******************************************************
     */
    public static String fillHeadCharsLen(String strOri, int len) {
        return fillHeadCharsLen(strOri, "0", len);
    }

    /**
     * *****************************************************
     * 功    能：在字符串后面添加多个"0",返回固定长度
     * 入口参数：param str:待处理的字符串
     * param len：返回固定长度
     * 返    回：Stirng
     * <p/>
     * 编写日期：
     * 修改备注：
     * ******************************************************
     */
    public static String fillBackCharsLen(String strOri, int len) {
        return fillBackCharsLen(strOri, "0", len);
    }

    /**
     * *****************************************************
     * 功    能：在字符串前面添加多个重复字符串,返回固定长度
     * 入口参数：param str:待处理的字符串
     * param subStr:重复的子字符串
     * param len：返回固定长度
     * 返    回：Stirng
     * <p/>
     * 编写日期：
     * 修改备注：
     * ******************************************************
     */
    public static String fillHeadCharsLen(String strOri, String subStr, int len) {
        if (strOri == null || strOri.trim().length() == 0) {
            strOri = "";
        }
        if (subStr == null) {
            subStr = " ";
        }
        String fillStr = "";
        for (int i = 0; i < len; i++) {
            fillStr = fillStr + subStr;
        }
        subStr = fillStr + strOri;

        return (subStr.substring(subStr.length() - len, subStr.length()));
    }

    /**
     * *****************************************************
     * 功    能：在字符串后面添加多个重复字符串,返回固定长度
     * 入口参数：param str:待处理的字符串
     * param subStr:重复的子字符串
     * param len：返回固定长度
     * 返    回：Stirng
     * <p/>
     * 编写日期：
     * 修改备注：
     * ******************************************************
     */
    public static String fillBackCharsLen(String strOri, String subStr, int len) {
        if (strOri == null || strOri.trim().length() == 0) {
            strOri = "";
        }
        if (subStr == null) {
            subStr = " ";
        }
        String fillStr = "";
        for (int i = 0; i < len; i++) {
            fillStr = fillStr + subStr;
        }
        subStr = strOri + fillStr;

        return (subStr.substring(0, len));
    }

    /**
     * *****************************************************
     * 功    能：在字符串前面添加多个"0"
     * 入口参数：param str:待处理的字符串
     * param counter：重复的数次
     * 返    回：Stirng
     * <p/>
     * 编写日期：
     * 修改备注：
     * ******************************************************
     */
    public static String fillHeadChars(String strOri, int counter) {
        return fillHeadChars(strOri, "0", counter);
    }

    /**
     * *****************************************************
     * 功    能：在字符串后面添加多个"0"
     * 入口参数：param str:待处理的字符串
     * param counter：重复的数次
     * 返    回：Stirng
     * <p/>
     * 编写日期：
     * 修改备注：
     * ******************************************************
     */
    public static String fillBackChars(String strOri, int counter) {
        return fillBackChars(strOri, "0", counter);
    }

    /**
     * *****************************************************
     * 功    能：在字符串前面添加多个重复字符串
     * 入口参数：param str:待处理的字符串
     * param subStr:重复的子字符串
     * param counter：重复的数次
     * 返    回：Stirng
     * <p/>
     * 编写日期：
     * 修改备注：
     * ******************************************************
     */
    public static String fillHeadChars(String strOri, String subStr, int counter) {
        if (strOri == null || strOri.trim().length() == 0) {
            strOri = "";
        }
        if (counter <= 0 || subStr == null) {
            return strOri;
        }
        String fillStr = "";
        for (int i = 0; i < counter; i++) {
            fillStr = fillStr + subStr;
        }
        return (fillStr + strOri);
    }

    /**
     * *****************************************************
     * 功    能：在字符串后面添加多个重复字符串
     * 入口参数：param str:待处理的字符串
     * param subStr:重复的子字符串
     * param counter：重复的数次
     * 返    回：Stirng
     * <p/>
     * 编写日期：
     * 修改备注：
     * ******************************************************
     */
    public static String fillBackChars(String strOri, String subStr, int counter) {
        if (strOri == null || strOri.trim().length() == 0) {
            strOri = "";
        }
        if (counter <= 0 || subStr == null) {
            return strOri;
        }
        String fillStr = "";
        for (int i = 0; i < counter; i++) {
            fillStr = fillStr + subStr;
        }
        return (strOri + fillStr);
    }

    /**
     * *****************************************************
     * 功    能：判断字符串是否为空或者null(压缩空格后)
     * 入口参数：param str:待处理的字符串
     * 出口参数：
     * 返    回：空，null：true; 不空：false
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static boolean isEmpty(Object strObj) {
        if (strObj == null || strObj.toString().trim().length() < 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * *****************************************************
     * 功    能：判断一个字符串是否为空值（null或者(压缩空格后)）
     * 入口参数：param str:待判断的字符串
     * 出口参数：
     * 返    回：true：空，false：非空
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static boolean isStrEmpty(String str) {
        if ((str == null) || (str.trim().length() < 1)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * *****************************************************
     * 功    能：返回一个字符串去掉右边空格后的值，如果为null则返回空串
     * 入口参数：param str:待处理的字符串
     * 出口参数：
     * 返    回：去掉右边空格后的字符串或者空串
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String getValue(String str) {
        if (str == null) {
            return "";
        }
        if (str.trim().length() <= 0) {
            return "";
        }
        str = "H" + str;
        str = str.trim();
        str = str.substring(1);
        return str;
    }

    /**
     * *****************************************************
     * 功    能：判断一个字符串是否超出给定长度
     * 入口参数：param text:待判断的字符串；param len:给定的长度
     * 出口参数：
     * 返    回：return true：未超过，false：为空或者超过
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static boolean chkTextLen(String text, int len) {
        if (text == null || text.length() > len) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * *****************************************************
     * 功    能：判断一个字符串去掉空格是否超出给定长度
     * 入口参数：param text:待判断的字符串；param len:给定的长度
     * 出口参数：
     * 返    回：return true：未超过，false：为空或者超过
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static boolean chkTextTrimLen(String text, int len) {
        if (text == null || text.trim().length() > len) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * *****************************************************
     * 功    能：判断一个字符串是否只有english
     * 入口参数：param text:待判断的字符串；
     * 出口参数：
     * 返    回：return true：合法，false:含有中文或者其它非法字符
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static boolean isStrEn(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) > 127) {
                return false;
            }
        }
        return true;
    }

    /**
     * *****************************************************
     * 功    能：判断一个字符串是否数字
     * 入口参数：param ch:待判断的字符
     * 出口参数：
     * 返    回：return true：数字，false:非数字
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static boolean isCharNum(char ch) {
        if (ch > 47 && ch < 58) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * *****************************************************
     * 功    能：判断一个字符串是否含有非数字的字符
     * 入口参数：param str:待判断的字符串
     * 出口参数：
     * 返    回：return true：Null或者不全是数字，false:全是数字
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static boolean isStrNum(String str) {
        if (isStrEmpty(str)) {
            return true;
        }
        boolean notNum = false;
        for (int i = 0; i < str.length(); i++) {
            if (!isCharNum(str.charAt(i))) {
                notNum = true;
            }
        }
        return !notNum;
    }

    /**
     * *****************************************************
     * 功    能：判断一个字符串是否含有非数字的字符
     * 入口参数：param strSrc:待判断的字符串
     * 出口参数：
     * 返    回：return true：全是数字，false:不全是数字
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static boolean isNum(String strSrc) throws Exception {
        for (int i = 0; i < strSrc.length(); i++) {
            if (!isCharNum(strSrc.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * *****************************************************
     * 功    能：判断一个字符是否是英文字母
     * 入口参数：param ch:待判断的字符
     * 出口参数：
     * 返    回：return true：是英文字母，false:不是英文字母
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static boolean isCharLetter(char ch) {
        if ((ch >= 65 && ch <= 90) && (ch >= 97 && ch <= 122)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * *****************************************************
     * 功    能：判断一个字符串是否全是英文字母
     * 入口参数：param str:待判断的字符串
     * 出口参数：
     * 返    回：return true：NULL或含有非英文字母，false:全是英文字母
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static boolean isStrLetter(String str) {
        if (isStrEmpty(str)) {
            return true;
        }
        boolean notLetter = false;
        for (int i = 0; i < str.length(); i++) {
            if (!isCharLetter(str.charAt(i))) {
                notLetter = true;
            }
        }
        return !notLetter;
    }

    /**
     * *****************************************************
     * 功    能：假如传入的字符串是null则转成空串，否则返回原字符串
     * 入口参数：param Content:待转换的字符串
     * 出口参数：
     * 返    回：如果字符串是null则转成空串，否则返回原字符串
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public String nullToSpace(String Content) {
        if (Content == null) {
            Content = "";
        }
        return Content;
    }

    /**
     * *****************************************************
     * 功    能：将传入的字符串取出第一个字符返回
     * 入口参数：param src:传入的字符串
     * 出口参数：
     * 返    回：return 将传入的字符串取出第一个字符返回
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static char strToChar(String src) {
        src = src.trim();
        char result = src.charAt(0);
        return result;
    }

    /**
     * *****************************************************
     * 功    能：将传入的字符串转成对应的ASCII码串
     * 入口参数：param sql:待编码的sql条件串
     * 出口参数：
     * 返    回：编码后的字符串
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String encodeSQL(String sql) {
        StringBuffer tempBuff = new StringBuffer();
        for (int i = 0; i < sql.length(); i++) {
            tempBuff.append(Integer.toHexString(sql.charAt(i)));
        }
        return tempBuff.toString();
    }

    /**
     * *****************************************************
     * 功    能：将传入的ASCII码串解码为对应的字符串
     * 入口参数：param encoded:待解码的字符串
     * 出口参数：
     * 返    回：解码后的字符串
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String decodeSQL(String encoded) {
        StringBuffer tempBuff = new StringBuffer();
        for (int i = 0; i < encoded.length(); i += 2) {
            tempBuff.append((char) Integer.parseInt(
                    encoded.substring(i, i + 2), 16));
        }
        return tempBuff.toString();
    }

    /**
     * *****************************************************
     * 功    能：获取相对路径
     * 入口参数：param path1:绝对路径，param context1:上下文
     * 出口参数：
     * 返    回：return 相对路径
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String getAbsolutePath(String path1, String context1) {
        int i1 = path1.indexOf(context1);
        if (i1 < 0) {
            return path1;
        } else {
            return path1.substring(path1.indexOf(context1) + context1.length());
        }
    }

    /**
     * *****************************************************
     * 功    能：获取子串
     * 入口参数：param str1:待取子串的字符串，param sindex:起始位置，param eindex:结束位置
     * 出口参数：
     * 返    回：返回从起始位置开始结束位置结束的子串，如果结束位置小于0，则返回从起始位置开始的子串
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String getSubString(String str1, int sindex, int eindex) {
        if (str1 == null) {
            return "";
        }
        if (str1.trim().length() <= 0) {
            return "";
        }
        if (str1.length() > sindex) {
            if (eindex >= 0) {
                return str1.substring(sindex, eindex);
            } else if (eindex < 0) {
                return str1.substring(sindex);
            }
        }
        return "";
    }

    /**
     * *****************************************************
     * 功    能：将字符串数组扩充到指定的大小，不足的用空串补齐
     * 入口参数：param strs:待扩充的字符串数组，param size1:给定的数组长度
     * 出口参数：
     * 返    回：return 括充后的字符串数组
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String[] getValues(String[] strs, int size1) {
        String[] strs1 = new String[size1];
        for (int i = 0; i < size1; i++) {
            strs1[i] = "";
        }
        if (strs == null) {
            return strs1;
        } else {
            if (strs.length < size1) {
                for (int i = 0; i < strs.length; i++) {
                    strs1[i] = strs[i];
                }
                return strs1;
            } else {
                return strs;
            }
        }
    }

    /**
     * *****************************************************
     * 功    能：字符串全局替换函数
     * 入口参数：param strSource  待替换的字符串，param strFrom  源字符串，param strTo  目的字符串
     * 出口参数：
     * 返    回：替换后的字符串
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String replaceStrAll(String strSource, String strFrom,
                                       String strTo) {
        String strDest = "";
        int intFromLen = strFrom.length();
        int intPos;
        while ((intPos = strSource.indexOf(strFrom)) != -1) {
            strDest = strDest + strSource.substring(0, intPos);
            strDest = strDest + strTo;
            strSource = strSource.substring(intPos + intFromLen);
        }
        strDest = strDest + strSource;
        return strDest;
    }

    /**
     * *****************************************************
     * 功    能：把换行符替换成指定的字符串
     * 入口参数：param strTarget  待处理的字符串，param strNew  要替掉\n的串
     * 出口参数：
     * 返    回：替换后的字符串
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String replaceStr(String strTarget, String strNew) {

        int iIndex = -1;
        while (true) {

            iIndex = strTarget.indexOf('\n');

            if (iIndex < 0) {
                break;
            }

            String strTemp = null;
            strTemp = strTarget.substring(0, iIndex);

            strTarget = strTemp + strNew + strTarget.substring(iIndex + 1);

        }

        return strTarget;

    }

    /**
     * *****************************************************
     * 功    能：判断字符串数组中是否含有该字符串
     * 入口参数：param str1 待寻找的字符串，param strarray 待寻找的字符串数组，
     * 出口参数：
     * 返    回：return true：含有;false：未含有
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static boolean includestr(String str1, String[] strarray) {
        if (strarray == null || strarray.length <= 0) {
            return false;
        }
        for (int i = 0; i < strarray.length; i++) {
            if (strarray[i] == null) {
                if (str1 == null) {
                    return true;
                } else {
                    continue;
                }
            }
            if (strarray[i].trim().equals(str1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * *****************************************************
     * 功    能：用\n作为分隔符，把字符串分隔成数组，并去掉\r
     * 入口参数：param fvalue 待转换的字符串
     * 出口参数：
     * 返    回：return 转换后的数组
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String[] getAreaValues(String fvalue) {
        String tmpstr = fvalue;
        int i = 0;
        if (tmpstr == null) {
            return null;
        }
        if (tmpstr.trim().equals("")) {
            return null;
        }
        while (tmpstr.indexOf("\n") >= 0) {
            i++;
            tmpstr = tmpstr.substring(tmpstr.indexOf("\n") + 1);
        }
        if (tmpstr.trim().equals("")) {
            i--;
        }
        String[] fvalues = new String[i + 1];
        tmpstr = fvalue;
        i = 0;
        while (tmpstr.indexOf("\n") >= 0) {
            fvalues[i] = tmpstr.substring(0, tmpstr.indexOf("\n"));
            if (fvalues[i].indexOf("\r") >= 0) {
                fvalues[i] = fvalues[i].substring(0, fvalues[i].indexOf("\r"));
            }
            i++;
            tmpstr = tmpstr.substring(tmpstr.indexOf("\n") + 1);
        }
        if (!tmpstr.trim().equals("")) {
            fvalues[i] = tmpstr;
        }
        return fvalues;
    }

    /**
     * *****************************************************
     * 功    能：将字符串中的|转成带\n
     * 入口参数：param fvalue 待转换的字符串
     * 出口参数：
     * 返    回：转换后的字符串
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String getrealAreaValues(String fvalue) {
        String tmpstr = fvalue;
        String returnstr = "";
        if (tmpstr == null) {
            return null;
        }
        if (tmpstr.trim().equals("")) {
            return "";
        }
        while (tmpstr.indexOf("|") > 0) {
            returnstr += tmpstr.substring(0, tmpstr.indexOf("|")) + "\n";
            tmpstr = tmpstr.substring(tmpstr.indexOf("|") + 1);
        }
        return returnstr;
    }

    /**
     * *****************************************************
     * 功    能：计算字符串中含有的指定字符的个数
     * 入口参数：param strInput 待计算的字符串，param chr 待寻找的字符
     * 出口参数：
     * 返    回：return 计算的字符个数
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static int countChar(String strInput, char chr) {
        int iCount = 0;
        char chrTmp = ' ';

        if (strInput.trim().length() == 0) {
            return 0;
        }
        //计算分割出多少割字符串
        for (int i = 0; i < strInput.length(); i++) {
            chrTmp = strInput.charAt(i);
            if (chrTmp == chr) {
                iCount++;
            }
        }
        return iCount;
    }

    /**
     * *****************************************************
     * 功    能：将二维数组转成一串字符串送出
     * 入口参数：param strs 待转换的字符串数组
     * 出口参数：
     * 返    回：无
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String strArrayToStr(String[] strs) {
        return strArrayToStr(strs, null);
    }

    /**
     * *****************************************************
     * 功    能：换行的打印出字符串数组的数据
     * 入口参数：param strs 待打印的字符串数组
     * 出口参数：
     * 返    回：无
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static void printStrs(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }

    /**
     * *****************************************************
     * 功    能：二维不换行，一维换行的打印出字符串数组的数据
     * 入口参数：param strs 待打印的二维字符串数组
     * 出口参数：
     * 返    回：无
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static void printDualStr(String[][] dualStr) {
        for (int i = 0; i < dualStr.length; i++) {
            for (int j = 0; j < dualStr[i].length; j++) {
                System.out.print(dualStr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * *****************************************************
     * 功    能：将二维数组横数颠倒，将行变为列，将列变为行
     * 入口参数：param dualStr 输入的二维数组
     * 出口参数：
     * 返    回：return 颠倒后的二维数组
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String[][] rowToColumn(String[][] dualStr) {
        String[][] returnDualStr = null;
        if (dualStr != null) {
            returnDualStr = new String[dualStr[0].length][dualStr.length];
            for (int i = 0; i < dualStr.length; i++) {
                for (int j = 0; j < dualStr[0].length; j++) {
                    returnDualStr[j][i] = dualStr[i][j];
                }
            }
        }
        return returnDualStr;
    }

    /**
     * *****************************************************
     * 功    能：将要赋值给页面显示域的String内容中的特殊字符加上转意符
     * 入口参数：param inStr 输入的字符串
     * 出口参数：
     * 返    回：return 添加转意符后的字符串
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String latinString(String inStr) {
        String res = inStr;
        if (null == res) {
            return null;
        }
        res = replaceStrAll(res, "\"", "\\\"");
        res = replaceStrAll(res, "'", "\\'");
        return res;
    }

    /**
     * *****************************************************
     * 功    能：将字符串所有空格替换成指定串
     * 入口参数：param String strTarget, String strNew
     * 出口参数：
     * 返    回：return String 返回已被替换的字串
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String replaceWhiteSpace(String strTarget, String strNew) {

        int iIndex = -1;
        while (true) {
            char cRep = 32;
            iIndex = strTarget.indexOf(cRep);

            if (iIndex < 0) {
                break;
            }

            String strTemp = null;
            strTemp = strTarget.substring(0, iIndex);

            strTarget = strTemp + strNew + strTarget.substring(iIndex + 1);

        }

        return strTarget;

    }

    /**
     * *****************************************************
     * 功    能：将金额改写成符合要求的小数点位数，只去掉多余的小数点位数，不扩展位数；
     * 入口参数：param amount 输入的金额, param length 指定的小数位长度
     * 出口参数：
     * 返    回：return 添加转意符后的字符串
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String double2str(double amount, int length) {
        String strAmt = Double.toString(amount);

        int pos = strAmt.indexOf('.');

        if (pos != -1 && strAmt.length() > length + pos + 1) {
            strAmt = strAmt.substring(0, pos + length + 1);
        }

        return strAmt;
    }

    /**
     * *****************************************************
     * 功    能：根据chr分割字符串，因为String类自带的split不支持以"|"为分割符；
     * 入口参数：param str 将要被分割的串,param chr 分割符号
     * 出口参数：
     * 返    回：return String[] 分割后的字符串数组,不包含最后一个|后面的字符串
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String[] doSplit(String str, char chr) {
        int iCount = 0;
        char chrTmp = ' ';
        //计算分割出多少割字符串
        for (int i = 0; i < str.length(); i++) {
            chrTmp = str.charAt(i);
            if (chrTmp == chr) {
                iCount++;
            }
        }
        String[] strArray = new String[iCount];
        for (int i = 0; i < iCount; i++) {
            int iPos = str.indexOf(chr);
            if (iPos == 0) {
                strArray[i] = "";
            } else {
                strArray[i] = str.substring(0, iPos);
            }
            str = str.substring(iPos + 1); //从iPos+1到结束,str长度逐步缩小
        }
        return strArray;
    }

    /**
     * *****************************************************
     * 功    能：根据s分割字符串，因为String类自带的split不支持以"|"为分割符，
     * 入口参数：param str 将要被分割的串,param s 分割字符串
     * 出口参数：
     * 返    回：return String[] 分割后的字符串数组,包含最后一个|后面的字符串
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String[] strSplit(String src, String splitchar) {
        int resultSize = 0;
        int len = src.length();
        int idx = 0;
        String strTemp = "";
        for (int i = 0; i < len; i++) {
            if (src.substring(i, i + 1).equals(splitchar)) {
                resultSize++;

            }
        }
        if ((len > 1) & (!src.substring(len - 1, len).equals(splitchar))) {
            resultSize++;
        }
        String result[] = new String[resultSize];
        for (int i = 0; i < len; i++) {
            if (src.substring(i, i + 1).equals(splitchar)) {
                result[idx] = strTemp;
                idx++;
                strTemp = "";
            } else {
                strTemp = String.valueOf(strTemp)
                        + String.valueOf(src.charAt(i));
            }
        }

        if (!strTemp.equals("")) {
            result[idx] = strTemp;
        }
        return result;
    }

    /**
     * *****************************************************
     * 功    能：根据strSeparator分割字符串，只分隔出指定大小的字符串
     * 入口参数：param strToSplit 将要被分割的串,param strSeparator 分割字符串,param iLimit 指定大小
     * 出口参数：
     * 返    回：return String[] 分割后的字符串数组
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String[] split(String strToSplit, String strSeparator,
                                 int iLimit) {
        ArrayList tmpList = new ArrayList();
        int iFromIndex = 0;
        int iCurIndex = strToSplit.length();
        String strUnitInfo = "";
        int iCurCounts = 0;
        while ((iCurIndex != -1) && (iFromIndex < strToSplit.length())
                && (iCurCounts < iLimit)) {
            iCurIndex = strToSplit.indexOf(strSeparator, iFromIndex);
            if (iCurIndex == -1) {
                strUnitInfo = strToSplit.substring(iFromIndex, strToSplit.length());
            } else {
                strUnitInfo = strToSplit.substring(iFromIndex, iCurIndex);
                iFromIndex = iCurIndex + 1;
            }
            tmpList.add(strUnitInfo);
            iCurCounts++;
        }
        int iCounts = tmpList.size();
        String tmpArray[] = new String[iCounts];
        for (int i = 0; i < iCounts; i++) {
            tmpArray[i] = (String) tmpList.get(i);
        }
        return tmpArray;
    }

    /**
     * *****************************************************
     * 功    能：将字符串缩小到指定长度，多余的部分用...概括
     * 入口参数：param src 将要被处理的串,param len  指定大小
     * 出口参数：
     * 返    回：return String 缩小到指定长度，多余的部分用...概括的字符串
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String strIntercept(String src, int len) {
        if (src == null) {
            return "";
        }
        if (src.length() > len) {
            src = String.valueOf(String.valueOf(src.substring(0, len))).concat(
                    "...");
        }
        return src;
    }

    /**
     * *****************************************************
     * 功    能：将字符串转成ISO8859_1编码
     * 入口参数：param str_in 要被处理的字符串；
     * 出口参数：
     * 返    回：return String 转换后的字符串；
     * <p/>
     * 编写日期：20051220
     * 修改备注：
     * ******************************************************
     */
    public static String strtochn(String str_in) {
        try {
            String temp_p = str_in;
            if (temp_p == null) {
                temp_p = "";
            }
            String temp = "";
            if (!temp_p.equals("")) {
                byte[] byte1 = temp_p.getBytes("ISO8859_1");
                temp = new String(byte1);
            }
            return temp;
        } catch (Exception e) {
        }
        return "null";
    }

    /**
     * *****************************************************
     * 功    能：将ISO8859_1字符串转成GB2312编码
     * 入口参数：param strvalue 要被处理的字符串；
     * 出口参数：
     * 返    回：return String 转换后的字符串；
     * 修改备注：
     * ******************************************************
     */
    public static String ISO2GB2312(String strvalue) {
        try {
            if (strvalue == null) {
                return null;
            } else {
                strvalue = new String(strvalue.getBytes("ISO8859_1"), "GB2312");
                return strvalue;
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * *****************************************************
     * 功    能：将GB2312字符串转成ISO8859_1编码
     * 入口参数：param strvalue 要被处理的字符串；
     * 出口参数：
     * 返    回：return String 转换后的字符串；
     * 修改备注：
     * ******************************************************
     */
    public String GB23122ISO(String strvalue) throws Exception {
        try {
            if (strvalue == null) {
                return null;
            } else {
                strvalue = new String(strvalue.getBytes("GB2312"), "ISO8859_1");
                return strvalue;
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * *****************************************************
     * 功    能：在页面要显示中文对其进行编码转化
     * 入口参数：param str 要被处理的字符串；
     * 出口参数：
     * 返    回：return String 转换后的字符串；
     * 修改备注：
     * ******************************************************
     */
    public static String cnCodeTrans(String str) {
        String s = "";
        try {
            s = new String(str.getBytes("GB2312"), "8859_1");
        } catch (UnsupportedEncodingException a) {
            System.out.print("chinese thansform exception");
        }
        return s;
    }

    /**
     * *****************************************************
     * 功    能：判断源串是否符合规则，例：STaaaa符合ST******
     * 入口参数：param strSource要被处理的字符串；param strRule规则串
     * 出口参数：
     * 返    回：return false:源串不匹配规则，true:源串匹配规则
     * 修改备注：
     * ******************************************************
     */
    public static boolean judgeMatch(String strSource, String strRule) {
        int i = 0;
        //源串长度判断
        if ((null == strSource) || (strSource.length() == 0)) {
            return false;
        }
        //规则串长度判断
        if ((null == strRule) || (strRule.length() == 0)) {
            return false;
        }
        //长度不可超长
        if (strSource.length() > strRule.length()) {
            return false;
        }
        //每一位的判断
        for (i = 0; i < strRule.length(); i++) {
            //源串比规则串短
            if (strSource.length() < i + 1) {
                break;
            }
            if ((strRule.charAt(i) != '*')
                    && (strSource.charAt(i) != strRule.charAt(i))) {
                return false;
            }
        }
        //对于源串比规则串短的情况，若规则串后不是均为'*'，则匹配不上
        for (; i < strRule.length(); i++) {
            if (strRule.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    public static String column2Property(String column) {
        column = column.toLowerCase();
        int i = column.indexOf("_");
        while (i != -1) {
            if (i != column.length() - 1) {
                char temp = column.charAt(i + 1);
                String strTemp = String.valueOf(temp);
                column = column.replaceFirst("_" + strTemp, strTemp.toUpperCase());
                i = column.indexOf("_");
            } else {
                break;
            }
        }
        return column;
    }

    public static String strArrayToStr(String[] strs, String separator) {
        StringBuffer returnstr = new StringBuffer("");

        if (strs == null) {
            return "";
        }
        if (separator == null) {
            separator = "";
        }

        for (int i = 0; i < strs.length; i++) {
            returnstr.append(strs[i]);
            if (i < strs.length - 1) {
                returnstr.append(separator);
            }
        }
        return returnstr.toString();
    }

    public static String objectArrayToStr(Object[] objects, String separator) {
        StringBuffer returnstr = new StringBuffer("");

        if (objects == null) {
            return "";
        }
        if (separator == null) {
            separator = "";
        }

        for (int i = 0; i < objects.length; i++) {
            returnstr.append(String.valueOf(objects[i]));
            if (i < objects.length - 1) {
                returnstr.append(separator);
            }
        }
        return returnstr.toString();
    }

    public static String listToStr(List element, String separator) {

        StringBuffer returnstr = new StringBuffer("");

        if (element == null) {
            return "";
        }
        if (separator == null) {
            separator = "";
        }

        Iterator it = element.iterator();

        while (it.hasNext()) {
            returnstr.append(String.valueOf(it.next()));
            if (it.hasNext()) {
                returnstr.append(separator);
            }
        }

        return returnstr.toString();
    }

    public static String[] listToStrArray(List element) {

        if (element == null || element.size() == 0) {
            return null;
        }

        Iterator it = element.iterator();
        String[] strArray = new String[element.size()];
        int i = 0;

        while (it.hasNext()) {
            strArray[i] = String.valueOf(it.next());
            i++;
        }
        return strArray;
    }

    public static List strToList(String str, String separator) {

        if (str == null || str.equals("")) {
            return null;
        }
        if (separator == null) {
            separator = "";
        }

        String[] strArr = str.split(separator);
        int size = strArr.length;
        List list = new ArrayList();

        for (int i = 0; i < size; i++) {
            list.add(strArr[i]);
        }
        return list;
    }

    public static StringBuffer populate(StringBuffer bf, String value, boolean isNotLast) {
        if (value == null) {
            return bf;
        }
        //把字符串的每个单引号替换成两个单引号（注意：不是双引号），在SQL语句查询中有用
        bf.append("'").append(value.replaceAll("'", "''")).append("'");
        if (isNotLast) {
            bf.append(",");
        }
        return bf;
    }

    public static boolean isExist(String str, String substr, String sepatator) {
        if (str == null || str.trim().equals("")) {
            return false;
        }
        if (substr == null || substr.trim().equals("")) {
            return false;
        }
        String[] strArr = str.split(sepatator);
        int size = strArr.length;
        for (int i = 0; i < size; i++) {
            if (strArr[i].equals(substr)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExist(String str, String substr) {
        return isExist(str, substr, ",");
    }

    public static String leftInclude(String str) {
        if (str == null || str.equals("")) {
            return str;
        }
        return str + "%";
    }

    public static String rightInclude(String str) {
        if (str == null || str.equals("")) {
            return str;
        }
        return "%" + str;
    }

    public static String include(String str) {
        if (str == null || str.equals("")) {
            return str;
        }
        return "%" + str + "%";
    }

    /**
     * 准确判断是否合法的手机号码
     * 移动：134、135、136、137、138、139、150、151、157（TD）、158、159、187、188
     * 联通：130、131、132、152、155、156、185、186
     * 电信：133、153、180、189、（1349卫通）
     *
     * @param phoneNum 手机号码
     * @return true- 是，false-否
     */
    public static boolean isPhone(String phoneNum) {
        String regExp = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phoneNum);
        return m.matches();
    }

    /**
     * 判断是否合法的电子邮件地址
     *
     * @param email
     * @return true- 是，false-否
     */
    public static boolean isEmail(String email) {
        String regExp = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(email);
        return m.matches();
    }


    public static ArrayList splitString(String targetString, String seperator) {
        if (targetString == null || targetString.trim().equals(""))
            return new ArrayList();
        ArrayList resultStrs = new ArrayList();
        String singleStatement = "";
        int fromIndex = 0;
        int endIndex = 0;
        boolean breakFor = false;
        while (fromIndex < targetString.length()) {
            endIndex = targetString.indexOf(seperator, fromIndex);
            if (endIndex == -1) {
                endIndex = targetString.length();
                breakFor = true;
            }
            singleStatement = targetString.substring(fromIndex, endIndex);
            if (singleStatement != null && !singleStatement.trim().equals(""))
                resultStrs.add(singleStatement);
            fromIndex = endIndex + 1;
            if (breakFor)
                break;
        }
        return resultStrs;
    }

    public static String trim(String string) {
        return string != null ? string.trim() : "";
    }

    /**
     * 格式化数字，例如：将5转化为4位字符，则得到0005
     *
     * @param dValue 被格式化的数值
     * @param nWidth 需要转换的位数
     * @return
     */
    public static String formatInt(int lValue, int nWidth) {
        String strReturn = "" + lValue;
        int initLength = strReturn.length();
        for (int i = nWidth; i > initLength; i--) {
            strReturn = "0" + strReturn;
        }
        return strReturn;
    }

    /**
     * 将以"ad,cd,ed"此类以","分开的字符串，转换成"'ad','cd','ed'"
     *
     * @param ids 逗号分开的字符串     张会粉
     */
    public static String toStringIds(String ids, String pattern) {
        StringBuffer sb = new StringBuffer();
        String[] aryIds = ids.split(pattern);
        for (String strId : aryIds) {
            sb.append("'").append(strId.trim()).append("'").append(",");
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }


    /*
     * 判断是否是数字
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true; //是数字
    }

    /**
     * @param percent
     * @Description: 百分比转换小数
     * @reutrn float
     * @author luorui
     * @date 2017-11-11
     */
    public static float changePercentToPoint(String percent) {
        return new Float(percent.substring(0, percent.indexOf("%"))) / 100;
    }

    /**
     * @param str
     * @Description:
     * @reutrn String
     * @author luorui
     * @date 2017-11-15
     */
    public static String empty(String str) {
        if (StringUtil.isEmpty(str)) {
            return "";
        }
        return str;
    }

    /**
     * @param str
     * @return
     * @throws
     * @Description:
     * @reutrn String
     * @author luorui
     * @date 2017-11-15
     */
    public static String isExitSpot(String str) {
        if (StringUtil.isEmpty(str)) {
            return "";
        }
        try {
            Float.valueOf(str);
        } catch (Exception e) {
            return str;
        }
        if (str.indexOf(".") == 0) {
            str = "0" + str;
        }
		/*Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");    
	    if(!pattern.matcher(str).matches()) {*/
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(Float.valueOf(str));
	    /*}
	    return str;*/
    }

    /**
     * @param str
     * @Description: TODO
     * @reutrn String
     * @author luorui
     * @date 2017-11-22
     */
    public String isExitNull(String str) {
        String symbol = str;
        if (StringUtil.isEmpty(str)) {
            symbol = "/";
        }
        return symbol;
    }

    /** 判断集合是否为空
     *
     * @param collection
     * @return 2017-12-19 niuyongfei */
    public static boolean checkListIsNotEmpty(Collection<?> collection)
    {
        if (collection != null && !collection.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 生成随机文件名：当前年月日时分秒+五位随机数
     *
     * @return
     */
    public static String getOnlyCode() {

        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");

        Date date = new Date();

        String str = simpleDateFormat.format(date);

        Random random = new Random();

        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数

        return  str + rannum;// 当前时间
    }
}

