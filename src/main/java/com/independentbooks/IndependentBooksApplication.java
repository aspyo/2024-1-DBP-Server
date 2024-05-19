package com.independentbooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // Jpa Auditing 기능(생성일, 수정일 자동 생성 기능)을 사용할 수 있도록 추가
@SpringBootApplication
public class IndependentBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndependentBooksApplication.class, args);
	}

}
