package kr.co.softsoldesk.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import kr.co.softsoldesk.beans.DataBean1;
import kr.co.softsoldesk.beans.DataBean2;
import kr.co.softsoldesk.beans.DataBean3;
import kr.co.softsoldesk.beans.TestBean1;
import kr.co.softsoldesk.beans.TestBean2;
import kr.co.softsoldesk.beans.TestBean3;

@Configuration
public class BeanConfigClass {
	// 생성자 주입
	@Bean
	public TestBean1 java1() {
		return new TestBean1(200, "soldesk", new DataBean1()); 
	}
	
	// setter 주입
	@Bean
	public TestBean1 java2() {
		TestBean1 t1 = new TestBean1();
		t1.setData1(400);
		t1.setData2("soft");
		t1.setData3(new DataBean1());
		return t1;
	}
	
	// byName(매서드명이 변수명과 같아야 함)
	// 매서드를 통해 변수 선언 1
	@Bean
	public DataBean2 data1() {
		return new DataBean2();
	}
	
	// 매서드를 통해 변수 선언 2
	@Bean
	public DataBean2 data2() {
		return new DataBean2();
	}
	// Spring 5.1부터 권장하지 않음(@Deprecate)
	@Bean(autowire = Autowire.BY_NAME)
	public TestBean2 java3() {
		return new TestBean2();
	}
	
	// byType(변수 타입과 일치하는 매서드가 있으면 되지만 중복되는 경우(@primary 사용시 제외)에러 발생함)
	@Bean
	@Primary
	@Scope("prototype")
	public DataBean3 data100() {
		return new DataBean3();
	}
	
	@Bean
	public DataBean3 data200() {
		return new DataBean3();
	}
	
	@Bean(autowire = Autowire.BY_TYPE)
	public TestBean3 java4() {
		return new TestBean3();
	}
	
	// byType
	
}
