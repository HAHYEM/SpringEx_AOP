package kr.co.hhm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hhm.dao.TestDAO;

@Service
public class TestService {
	
	@Autowired
	TestDAO testDAO;
	
	//실제 사용자가 호출하려고 했었던 JoinPoint가 된다.
	//AOP를 사용함에 따라서 프록시에 의해 대신 호출된다.(proceed() 호출 시)
	public String testService1() {
		System.out.println("Service실행 - joinpoint");
		return "Hello";
	}
	
	public String doBService() {
		System.out.println("Service실행 - joinpoint");
		return "ByeBye";
	}
}
