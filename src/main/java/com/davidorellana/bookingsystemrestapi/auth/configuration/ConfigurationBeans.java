package com.davidorellana.bookingsystemrestapi.auth.configuration;

import com.davidorellana.bookingsystemrestapi.auth.security.jwt.OperationJwt;
import com.davidorellana.bookingsystemrestapi.auth.security.jwt.OperationJwtImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {

    @Bean
    public OperationJwt generationToken() {
        return new OperationJwtImpl();
    }
}
