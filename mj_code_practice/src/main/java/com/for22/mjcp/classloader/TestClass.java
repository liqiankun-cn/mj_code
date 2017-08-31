/**
 * 
 */
package com.for22.mjcp.classloader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.ArchUtils;

/**
 * @author liqiankun
 *
 */
public class TestClass {
	public static void testClass1() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

		try {
			System.out.println(Integer.MAX_VALUE);
			System.out.println(Integer.MV);
			System.out.println(Integer.class.getClassLoader());
			System.out.println(TestClass.class.getClassLoader());
			Class<?> cs = Class.forName("java.lang.Integer",true,TestClass.class.getClassLoader().getParent());
			System.out.println(cs.isLocalClass());
			Constructor<?> c =	cs.getConstructor(int.class);
			Integer it = (Integer)c.newInstance(1);
			System.out.println(it.toString());
			Field[] fields =  cs.getDeclaredFields();
			for(Field f :fields){
//				if(f.getType().isAssignableFrom(Integer.class))
					if(f.getType().isPrimitive() && f.getType()==int.class){
						f.setAccessible(true);
						System.out.println(f.getName()+":"+f.getInt(f));
					}
			}
			Thread.sleep(800000);
			//Integer in = (Integer)cs.newInstance();
			//System.out.println(in.SIZE);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void testClass2() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		System.out.println(ArchUtils.class.getClassLoader());
		Class<?> cs = Class.forName("org.apache.commons.lang3.ArchUtils");
//		ArchUtils ar = (ArchUtils)cs.newInstance();
		Field[] fields =  cs.getDeclaredFields();
		for(Field f :fields){
//			if(f.getType().isAssignableFrom(Integer.class))
				if(f.getType().isPrimitive() && f.getType()==int.class){
					f.setAccessible(true);
					System.out.println(f.getName()+":"+f.getInt(f));
				}
		}
//		System.out.println(ar.age);

		
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
//		testClass1();
		testClass2();
		
	}
}
