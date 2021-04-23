package io.kentec.CoreBanking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreBankingApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(CoreBankingApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CoreBankingApplication.class, args);
		LOGGER.info("Core Banking started..");
	}

}
