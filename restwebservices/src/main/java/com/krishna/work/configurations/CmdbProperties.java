package com.krishna.work.configurations;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
 
@Configuration
@ConfigurationProperties("cmdb")
public class CmdbProperties {
 
    @NotEmpty
    private String resourceUrl;
 
    private List<Integer> resourcePort;
 
    @Max(5)
    @Min(0)
    private Integer resourceCount;
 
    @Override
    public String toString() {
 
        return "resourceUrl: "+ this.resourceUrl+"\n"
                + "resourcePort: "+this.resourcePort+"\n"
                + "resourceCount: "+this.resourceCount+"\n";
    }
 
    public String getResourceUrl() {
        return resourceUrl;
    }
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }
    public List<Integer> getResourcePort() {
        return resourcePort;
    }
    public void setResourcePort(List<Integer> resourcePort) {
        this.resourcePort = resourcePort;
    }
 
    public Integer getResourceCount() {
        return resourceCount;
    }
 
    public void setResourceCount(Integer resourceCount) {
        this.resourceCount = resourceCount;
    }
}