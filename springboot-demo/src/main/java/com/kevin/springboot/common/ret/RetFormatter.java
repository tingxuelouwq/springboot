package com.kevin.springboot.common.ret;

/**
 * @类名: RetFormat
 * @包名：org.xinhua.common.ret
 * @作者：kevin[wangqi2017@xinhua.org]
 * @时间：2018/1/30 14:46
 * @版本：1.0
 * @描述：格式化响应为Json格式响应
 */
public class RetFormatter {

    public static RetJson format(int code, String message) {
        RetJson retJson = new RetJson(code, message, null);
        return retJson;
    }

    public static RetJson format(int code, String message, Object data) {
        RetJson retJson = new RetJson(code, message, data);
        return retJson;
    }
}
