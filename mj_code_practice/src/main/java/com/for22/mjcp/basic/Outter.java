/**
 * 
 */
package com.for22.mjcp.basic;

/**
 * @author liqiankun
 *
 */
public class Outter {

	public  static class Inner{
		public String test(String name){
			return "hello "+name;
		}
	}
	
	public class InnerApp{
		public InnerApp() {
			// TODO Auto-generated constructor stub
		}
	}
}
