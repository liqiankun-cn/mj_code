package com.for22.mjcp.classloader;

/**
 * 1：如果自定义classloader，继承了系统的classloader，此时不重写loadClass方法，则子类的加载器依然是系统默认的加载器
 * 即 sun.misc.Launcher$AppClassLoader
 * 2： 如果子类重写了loadClass方法，则认为是自定义了classLoad方法，此时调用loadClass方法则采用子类的加载方式；
 * 此时的classLoader对象为子类的对象，此时各自加载相同的class对象之间是不能相互转换的 instanceOf也会返回false
 * 
 * @author liqiankun
 *
 */
public class TestClassLoader {

	public static void main(String[] args) {

		ClassLoader c0 =Thread.currentThread().getContextClassLoader();
 		ClassLoaderA cla = new ClassLoaderA();
		ClassLoaderB clb = new ClassLoaderB();
		ClassLoader c1 = cla.getClass().getClassLoader();
		ClassLoader c2 = clb.getClass().getClassLoader();
		
		System.out.println( c0 == c1);
		System.out.println( c2 == c1);
		System.out.println( c2.toString());
		String name="com.for22.mjcp.classloader.AB";
		try {
			Class<?> cl = c0.loadClass(name);
			System.out.println("默认加载器---"+cl.getName());
			
			Object ab2 = clb.loadClass(name).newInstance();
			Object ab1=cla.loadClass(name).newInstance();
			System.out.println(ab1.getClass().getClassLoader());
			System.out.println(ab2.getClass().getClassLoader());
			System.out.println(ab1 instanceof AB);
			System.out.println(ab1.getClass().isInstance(cl.newInstance()));
			System.out.println(ab1.getClass().isInstance(ab2));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
