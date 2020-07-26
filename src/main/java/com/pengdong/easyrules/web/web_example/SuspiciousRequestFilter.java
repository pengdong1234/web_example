package com.pengdong.easyrules.web.web_example;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;



@WebFilter("/*")
public class SuspiciousRequestFilter implements Filter {

    private Rules rules;
    private RulesEngine rulesEngine;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        rulesEngine = new DefaultRulesEngine();
        rules = new Rules();
        rules.register(new SuspiciousRequestRule());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        Facts facts = new Facts();
        facts.put("request", request);
        rulesEngine.fire(rules, facts);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        
    }
}