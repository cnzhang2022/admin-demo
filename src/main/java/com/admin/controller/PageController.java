package com.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/page/")
public class PageController {

    @RequestMapping("/**")
    public String page(HttpServletRequest request) {
        String uri = request.getRequestURI();
        uri = uri.substring(uri.indexOf("page")+5, uri.length());
        return uri;
    }
}
