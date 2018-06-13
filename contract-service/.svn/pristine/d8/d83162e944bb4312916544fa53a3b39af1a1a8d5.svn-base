package com.jzt56.jlp.contractservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.jzt56.jlp.contractservice.property.UrlProperty;
import com.jzt56.jlp.contractservice.template.DataGatewayTemplate;

@SpringBootApplication
@EnableConfigurationProperties(UrlProperty.class)
@ComponentScan(basePackages="com.jzt56.jlp.contractservice")
public class ContractServiceApplication {
	
	@Bean
	public RestTemplate restTemplate() {
		return  new RestTemplate();
	}
	
	@Bean
	public DataGatewayTemplate dataGatewayTemplate() {
		return new DataGatewayTemplate().initDataGatewayTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ContractServiceApplication.class, args);
	}
}
