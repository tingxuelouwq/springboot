package com.kevin.springboot.common.constant;

/**
 * @interface: CommonStatusCode
 * @package: org.xinhua.common.constant
 * @author: kevin[wangqi2017@xinhua.org]
 * @date: 2018/1/30 14:10
 * @version: 1.0
 * @desc: 状态码
 */
public interface StatusCode {

    // 响应异常码
    Integer BAD_REQUEST = 400;
    Integer FORBIDDEN = 403;
    Integer METHOD_NOT_SUPPORTED = 405;
    Integer HTTP_MEDIA_TYPE_NOT_ACCEPTABLE = 406;
    Integer INTERNAL_SERVER_ERROR = 500;
    Integer BAD_GATEWAY = 502;
    Integer SERVICE_UNAVAILABLE = 503;

    // 程序异常码
    Integer RUNTIME_EXCEPTION = 100100;
    Integer NULL_POINT_EXCEPTION = 100101;
    Integer CLASS_CAST_EXCEPTION = 100102;
    Integer IO_EXCEPTION = 100103;
    Integer NO_SUCH_METHOD_EXCEPTION = 100104;
    Integer ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION = 100105;
    Integer HTTP_URL_CONNECTION_EXCEPTION = 100106;
    Integer ERROR_PARAMETER = 100107;
}
