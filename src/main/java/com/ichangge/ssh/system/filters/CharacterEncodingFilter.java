package com.ichangge.ssh.system.filters;

import org.apache.struts2.dispatcher.mapper.ActionMapper;

import javax.servlet.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class CharacterEncodingFilter implements Filter {

    private Charset encoding = Charset.defaultCharset();
    private Boolean encodingForce = Boolean.FALSE;

    public void init(FilterConfig filterConfig) throws ServletException {
        String encode = filterConfig.getInitParameter("encoding");
        String encodeForce = filterConfig.getInitParameter("encodingForce");
        try {
            encoding = Charset.forName(encode);
            encodingForce = Boolean.valueOf(encodeForce);
        }catch(Exception e){
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            servletRequest.setCharacterEncoding(encoding.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            if(encodingForce) {
                try {
                    servletRequest.setCharacterEncoding(encoding.name());
                } catch (UnsupportedEncodingException e1) {
                }
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
