package com.fidesol.bcp.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = { "com.fidesol.bcp.domain.model.mysql"})
@EnableJpaRepositories( basePackages  = { "com.fidesol.bcp.domain.repository.mysql" })
public class MysqlConfig {
}
