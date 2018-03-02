package kr.co.hhm.service2;

import org.springframework.stereotype.Service;

@Service
public class TestService2 {

	public void doCFoo() {
		System.out.println("doCService 호출함 - joinPoint");
	}
	
	public void doDGoo() {
		System.out.println("doDService 호출함 - joinPoint");
	}
	
}
