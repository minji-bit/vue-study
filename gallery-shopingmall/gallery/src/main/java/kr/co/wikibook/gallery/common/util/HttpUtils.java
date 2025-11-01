package kr.co.wikibook.gallery.common.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HttpUtils {
    public static void setSession(HttpServletRequest req, String key, Object value) {
        req.getSession().setAttribute(key, value);
    }

    public static Object getSessionValue(HttpServletRequest req,String key) {
        return req.getSession().getAttribute(key);
    }

    public static void removeSession(HttpServletRequest req,String key) {
        req.getSession().removeAttribute(key);
    }
}
