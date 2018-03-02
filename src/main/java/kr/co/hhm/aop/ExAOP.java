package kr.co.hhm.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//AOP클래스 생성시
@Component	//Component-scan에 의한 Bean설정을 위한 annotation
@Aspect		//ExAOP클래스에 Advice가 들어있다 라는 것을 알려줌
public class ExAOP {

	//Advice: 실제 실행할 수 있는 부가적인 작업들(메소드)
	//@Around 포인트컷을 활용할 때는 항상 매개변수에 ProceedingJoinPoint가 있어야 한다.
	@Around("execution(* kr.co.hhm.service..test*(..))") //pointCut 
	// 어떤 메소드가 실행될 떄 execution // ..: 안 쪽에 위치한 모든 클래스, 패키지 
	// test*: test로 시작되는 모든 메소드 // (..): 있든지 없든지 0개 이상인 메소드
	//<--주황색 표시 Around Point cut제대로 걸린 것임
	public Object testAOP1(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("testAOP1 - Advice 실행함. JoinPoint 실행 이전.");
		Object obj = null;	//proceed에 의한 return을 받아낼 용도
		try {
			obj = joinPoint.proceed();
		}finally {
			System.out.println("testAOP1 - advice실행함. JoinPoint 실행 이후.");
		}
		return obj;
	}
	
	@Around("execution(* kr.co.hhm.service..doB*(..))")
	public Object doBAOP(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("doBAOP - Advice 실행함. JoinPoint 실행 이전.");
		Object obj = null;
		try {
			obj = joinPoint.proceed();
		}finally {
			System.out.println("doBAOP - Advice 실행함. JoinPoint 실행 이후.");
		}
		return obj;
	}
	@Around("within(kr.co.hhm.service2..*)")	//within의 경우 패키지의 이름만으로 가능하다는 점
	void withInAOP(ProceedingJoinPoint joinPoint) {
		
	}
	
	
	
	
	
	
}
