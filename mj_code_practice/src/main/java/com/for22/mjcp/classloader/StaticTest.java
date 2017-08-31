/**
 * 
 */
package com.for22.mjcp.classloader;

/**
 * @author liqiankun
 *
 */
public class StaticTest {
	public static void main(String[] args)
    {
        staticFunction();
    }
 
	static
	{
		System.out.println("1");
	}
    static StaticTest st = new StaticTest();
 
 
    StaticTest()
    {
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }
    {
    	System.out.println("2");
    }
    
 
    public static void staticFunction(){
        System.out.println("4");
    }
 
    int a=110;
    static int b =112;
}
