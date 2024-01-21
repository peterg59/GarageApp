package com.springboot.garageApp.initializer;

import com.springboot.garageApp.configuration.SecurityConfiguration;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityGarageInitializer extends AbstractSecurityWebApplicationInitializer {
    public SecurityGarageInitializer() {
        super(SecurityConfiguration.class);
    }
}
