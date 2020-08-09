package com.auth.service;

import com.auth.clients.ResourceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class PermissionService {

    @Autowired
    private ResourceClient resourceClient;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 判断某用户是否具有该request
     */
    public Boolean hasPermission(HttpServletRequest request, Authentication authentication) {
       Object principal =  authentication.getPrincipal();

       if (principal instanceof UserDetails) {
           List<String> urls = this.resourceClient.getPermissionByUsername(((UserDetails) principal).getUsername());
           
           // 是否包含访问路径
           return urls.stream().anyMatch(
                   url -> antPathMatcher.match(url,request.getRequestURI())
           );
       }
       return false;
    }

}
