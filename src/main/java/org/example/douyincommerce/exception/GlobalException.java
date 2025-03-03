package org.example.douyincommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class GlobalException {
    {
        System.out.println("出现异常");
    }
    /**
     * @desc 处理参数异常 IllegalArgumentException
     * @author 田子健
     * @date 2025/2/5 上午10:26
     */
    @ExceptionHandler({IllegalStateException.class,IllegalStateException.class})
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(Exception e) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", 500);
        response.put("message", e.getMessage());
        response.put("data", "处理参数异常");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    /***
     * @desc
     * @author 田子健
     * @date 2025/2/5 上午10:26
     */
    @ExceptionHandler({NullPointerException.class, MissingServletRequestParameterException.class})
    public ResponseEntity<Map<String, Object>> handlerNullPointerException(Exception e) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", 500);
        response.put("message", e.getMessage());
        response.put("data", "空指针异常,请查看参数是否完整");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    /**
     * @desc 处理IO异常
     * @author 田子健
     * @date 2025/2/5 上午10:26
     */
    @ExceptionHandler(IOException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IOException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", 500);
        response.put("msg", e.getMessage());
        response.put("data", "IO写入异常");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
    /**
     * @desc 处理运行时异常
     * @author 田子健
     *@date 2025/2/5 上午10:26
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(Exception e) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", 500);
        response.put("msg", e.getMessage());
        response.put("data", "服务器内部错误");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
