package de.postbank.springsample.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

//@EnableBinding(Source.class)
@EnableDiscoveryClient
@SpringBootApplication
public class AccountserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountserviceApplication.class, args);
	}
}

@RestController
class AccountService {
	@Autowired
	private RestTemplate restTemplate;

//	@Autowired
//	private Source source;

	@RequestMapping("/accounts")
	public List<Account> getAccounts() {
		Message<String> msg = MessageBuilder.withPayload("John").build();
//		this.source.output().send(msg);
		return Arrays.asList(new Account[] {new Account("")});
	}
}

class Account {
	private String accountHolder;

	public Account() {
	}

	public Account(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
}
