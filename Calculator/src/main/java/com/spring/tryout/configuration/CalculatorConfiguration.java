package com.spring.tryout.configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * Created by rarulswamy on 5/7/17.
 */
public class CalculatorConfiguration
{
    @Autowired
    IClientConfig ribbonClientConfig;
    @Bean
    public IPing ribbonPing(IClientConfig config) {
        return new PingUrl(false,"info");
    }
    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new AvailabilityFilteringRule();
    }
}
