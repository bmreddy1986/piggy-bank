package com.piggy.bank;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.piggy.bank.domain.impl.CalculateEMIService;
import com.piggy.bank.domain.impl.CalculateInterestService;
import com.piggy.bank.domain.impl.GroupDomainService;
import com.piggy.bank.domain.interfaces.ICalculateEMIService;
import com.piggy.bank.domain.interfaces.ICalculateInterestService;
import com.piggy.bank.domain.interfaces.IGroupDomainService;
import com.piggy.bank.repository.IdentifierUtil;

@Configuration
@EnableAutoConfiguration
public class AppConfig {

	@Bean
	public IdentifierUtil indentifierUtil() {
		return new IdentifierUtil();
	}

	@Bean
	public IGroupDomainService adminModuleDomainService() {
		return new GroupDomainService();
	}

	@Bean
	public ICalculateInterestService calculateInterestService() {
		return new CalculateInterestService();
	}

	@Bean
	public ICalculateEMIService calculateEMIService() {
		return new CalculateEMIService();
	}

	/*
	 * @Bean public ObjectMapper objectMapper() { ObjectMapper mapper = new
	 * ObjectMapper();
	 * mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	 * mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
	 * 
	 * return mapper; }
	 */
}
