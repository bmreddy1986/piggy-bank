package com.piggy.bank;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.piggy.bank.domain.impl.AdminModuleDomainService;
import com.piggy.bank.domain.interfaces.IAdminModuleDomainService;
import com.piggy.bank.repository.IdentifierUtil;

@Configuration
@EnableAutoConfiguration
public class AppConfig {

	@Bean
	public IdentifierUtil indentifierUtil() {
		return new IdentifierUtil();
	}
	
	@Bean public IAdminModuleDomainService adminModuleDomainService() {
		return new AdminModuleDomainService();
	}
	
}
