package com.yuanlrc.controller.admin.config;

import com.yuanlrc.dao.studentDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 网站基础信息配置类
 */
@Component
@PropertySource(value="site.properties")
public class SiteConfig {
    @Value("${lizitong.site.name}")
    private String siteName;
    @Value("${lizitong.site.url}")
    private String siteUrl;

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }
}


