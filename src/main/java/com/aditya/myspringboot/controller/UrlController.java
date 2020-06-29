package com.aditya.myspringboot.controller;

import com.aditya.myspringboot.model.UrlMapping;
import com.aditya.myspringboot.service.UrlGeneratorService;
import com.aditya.myspringboot.service.UrlMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

@RestController
public class UrlController {

    @Autowired
    private UrlGeneratorService urlGeneratorService;

    @Autowired
    private UrlMappingService urlMappingService;

    @PostMapping(value="/url/generate")
    public String generateURL(@RequestBody String url) throws IOException{
        return urlGeneratorService.getNewURL(url);
    }


    @RequestMapping(value="/urls/{tinyUrl}", method=RequestMethod.GET)
    public void getOriginalUrl(@PathVariable(value="tinyUrl") String sTinyUrl, HttpServletResponse response) throws IOException
    {
        try {
            UrlMapping urlMap = urlMappingService.getByNewUrl(sTinyUrl);
            if(urlMap == null || urlMap.getOldUrl() == null || urlMap.getOldUrl().isEmpty())
            {
                response.sendError(404);
            }
            else
                response.sendRedirect(urlMap.getOldUrl());
        } catch (IOException e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }
}