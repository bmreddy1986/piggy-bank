package com.piggy.bank;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.piggy.bank.domain.impl.GroupDomainService;
import com.piggy.bank.domain.impl.CalculateEMIService;
import com.piggy.bank.domain.impl.CalculateInterestService;
import com.piggy.bank.domain.interfaces.IGroupDomainService;
import com.piggy.bank.domain.interfaces.ICalculateEMIService;
import com.piggy.bank.domain.interfaces.ICalculateInterestService;
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

}
