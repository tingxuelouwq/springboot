package com.kevin.springboot.common.exceptionhandler;

import com.kevin.springboot.common.constant.StatusCode;
import com.kevin.springboot.common.ret.RetFormatter;
import com.kevin.springboot.common.ret.RetJson;
import com.kevin.springboot.common.util.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @类名：BaseExceptionHandler
 * @包名：com.kevin.exceptionhandler
 * @作者：kevin[wangqi2017@xinhua.org]
 * @时间：2017/7/7 15:29
 * @版本：1.0
 * @描述：异常处理器基础支撑类
 */
@RestControllerAdvice
public class BaseExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(BaseExceptionHandler.class);

    /**
     * 处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public RetJson MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> msgList = fieldErrors.stream()
                .map(fieldError -> fieldError.getField() + ":" + fieldError.getDefaultMessage())
                .collect(Collectors.toList());
        log.error(msgList.toString());
        return RetFormatter.format(StatusCode.ERROR_PARAMETER, msgList.toString());
    }

    /**
     * 处理Get请求中,使用@Valid验证路径中请求实体校验失败后抛出的异常
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public RetJson BindExceptionHandler(BindException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> msgList = fieldErrors.stream()
                .map(fieldError -> fieldError.getField() + ":" + fieldError.getDefaultMessage())
                .collect(Collectors.toList());
        log.error(msgList.toString());
        return RetFormatter.format(StatusCode.ERROR_PARAMETER, msgList.toString());
    }

    /**
     * 处理400错误
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public RetJson request400(MissingServletRequestParameterException ex) {
        log.error("ex", ex);
        return RetFormatter.format(StatusCode.BAD_REQUEST, "缺少请求参数");
    }

    /**
     * 处理400错误
     */
    @ExceptionHandler(TypeMismatchException.class)
    public RetJson request400(TypeMismatchException ex) {
        log.error("ex", ex);
        return RetFormatter.format(StatusCode.BAD_REQUEST, "参数类型不匹配");
    }

    /**
     * 处理405错误
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public RetJson request405(HttpRequestMethodNotSupportedException ex) {
        log.error("ex", ex);
        return RetFormatter.format(StatusCode.METHOD_NOT_SUPPORTED, "请求方式错误");
    }

    /**
     * 处理406错误
     */
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public RetJson request406(HttpMediaTypeNotAcceptableException ex) {
        log.error("ex", ex);
        return RetFormatter.format(StatusCode.HTTP_MEDIA_TYPE_NOT_ACCEPTABLE, "找不到可访问的多媒体类型");
    }

    /**
     * 处理500错误
     */
    @ExceptionHandler({ConversionNotSupportedException.class,
            HttpMessageNotWritableException.class})
    public RetJson request500(RuntimeException ex) {
        log.error("ex", ex);
        return RetFormatter.format(StatusCode.INTERNAL_SERVER_ERROR, "服务器内部错误");
    }

    /**
     * 处理运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public RetJson runtimeExceptionHandler(RuntimeException ex) {
        log.error("ex", ex);
        return RetFormatter.format(StatusCode.RUNTIME_EXCEPTION, "服务器运行时异常");
    }

    /**
     * 处理空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    public RetJson nullPointExceptionHandler(NullPointerException ex) {
        log.error("ex", ex);
        return RetFormatter.format(StatusCode.NULL_POINT_EXCEPTION, "空指针异常");
    }

    /**
     * 处理类型转换异常
     */
    @ExceptionHandler(ClassCastException.class)
    public RetJson classCastExceptionHandler(ClassCastException ex) {
        log.error("ex", ex);
        return RetFormatter.format(StatusCode.CLASS_CAST_EXCEPTION, "类型转换异常");
    }

    /**
     * 处理IO异常
     */
    @ExceptionHandler(IOException.class)
    public RetJson ioExceptionHandler(IOException ex) {
        log.error("ex", ex);
        return RetFormatter.format(StatusCode.IO_EXCEPTION, "IO异常");
    }

    /**
     * 处理未知方法异常
     */
    @ExceptionHandler(NoSuchMethodException.class)
    public RetJson noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        log.error("ex", ex);
        return RetFormatter.format(StatusCode.NO_SUCH_METHOD_EXCEPTION, "未知方法异常");
    }

    /**
     * 处理数组越界异常
     */
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public RetJson arrayIndexOutOfBoundsExceptionHandler(ArrayIndexOutOfBoundsException ex) {
        log.error("ex", ex);
        return RetFormatter.format(StatusCode.ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION, "数组越界异常");
    }
}
