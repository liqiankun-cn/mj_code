/**
 * 
 */
package com.for22.mjcp.java8;

import java.util.Arrays;
import java.util.List;

/**
 * @author liqiankun
 *
 */
public class LambdaTest {

	public void test1(){
		new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();	
	}
	
	public void test2(){
		List<String> as = Arrays.asList("1","2","3");
		as.forEach(v -> System.out.println(v));
		as.forEach(System.out::println);
	}
	
	public void test3(){
		List<A> as = Arrays.asList(new A("1"),new A("2"),new A("3"));
		as.forEach(v -> System.out.println(v.getA()));
		as.forEach(System.out::println);
		
	}
	
	public void test4(){
		List<A> as = Arrays.asList(new A("1"),new A("2"),new A("3"));
		as.stream().allMatch(s -> s.equals("2"));
	}
	
	public void test5(){
		List<A> as = Arrays.asList(new A("1"),new A("2"),new A("3"));
		as.stream().filter(s -> s.getA().equals("2")).forEach(a -> System.out.println(a.getA()));
		System.out.println("==========");
		as.stream().filter(s -> !s.getA().equals("2")).forEach(a -> System.out.println(a.getA()));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LambdaTest  t = new LambdaTest();
		//t.test1();
		//t.test2();
		//t.test3();
		//t.test4();
		t.test5();
	}

}
class A{
	public A(String a) {
		this.a = a;
	}
	String a ;
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	
}
