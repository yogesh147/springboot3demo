package com.springboot.demo.WebAwareScopes;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("scopes/")
@Slf4j
public class ScopesController {

    @Resource(name = "requestScopedBean")
    HelloMessageGenerator requestScopedBean;

    @Resource(name = "sessionScopedBean")
    HelloMessageGenerator sessionScopedBean;

    @Resource(name = "applicationScopedBean")
    HelloMessageGenerator applicationScopedBean;

    @GetMapping("request")
    public HttpEntity<Map<String, Object>> getRequestScopeMessage(final Model model) {
        model.addAttribute("previousMessage", requestScopedBean.getMessage());
        requestScopedBean.setMessage("Request Scope Message!");
        model.addAttribute("currentMessage", requestScopedBean.getMessage());
        return new ResponseEntity<>(model.asMap(), HttpStatus.OK);
    }

    @GetMapping("session")
    public HttpEntity<Map<String, Object>> getSessionScopeMessage(final Model model) {
        model.addAttribute("previousMessage", sessionScopedBean.getMessage());
        sessionScopedBean.setMessage("Session Scope Message!");
        model.addAttribute("currentMessage", sessionScopedBean.getMessage());
        return new ResponseEntity<>(model.asMap(), HttpStatus.OK);
    }

    @GetMapping("session2")
    public HttpEntity<Map<String, Object>> getSession2ScopeMessage(final Model model) {
        model.addAttribute("previousMessage", sessionScopedBean.getMessage());
        sessionScopedBean.setMessage("Session2 Scope Message!");
        model.addAttribute("currentMessage", sessionScopedBean.getMessage());
        return new ResponseEntity<>(model.asMap(), HttpStatus.OK);
    }

    @GetMapping("application")
    public HttpEntity<Map<String, Object>> getApplicationScopeMessage(final Model model) {
        model.addAttribute("previousMessage", applicationScopedBean.getMessage());
        applicationScopedBean.setMessage("Application Scope Message!");
        model.addAttribute("currentMessage", applicationScopedBean.getMessage());
        return new ResponseEntity<>(model.asMap(), HttpStatus.OK);
    }

    @GetMapping("application2")
    public HttpEntity<Map<String, Object>> getApplication2ScopeMessage(final Model model) {
        model.addAttribute("previousMessage", applicationScopedBean.getMessage());
        applicationScopedBean.setMessage("Application2 Scope Message!");
        model.addAttribute("currentMessage", applicationScopedBean.getMessage());
        return new ResponseEntity<>(model.asMap(), HttpStatus.OK);
    }

}
