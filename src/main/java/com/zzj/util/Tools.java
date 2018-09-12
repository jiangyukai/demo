package com.zzj.util;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @类名 classTools
 * @描述 TODO
 * @作者 yk
 * @日期 2018-9-12 17:27
 **/
public class Tools {
    /***
     * @名称 生成UUID
     * @描述 //TODO
     * @参数 []
     * @返回值 java.lang.String
     * @作者 yk
     * @时间 2018-9-12 17:28
     */
    public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }


    /**
     * @名称 获取IP
     * @描述 //TODO
     * @参数 [request]
     * @返回值 java.lang.String
     * @作者 yk
     * @时间 2018-9-12 17:28
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
