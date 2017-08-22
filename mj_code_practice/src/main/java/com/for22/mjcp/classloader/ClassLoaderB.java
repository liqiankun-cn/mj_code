/**
 * 
 */
package com.for22.mjcp.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author liqiankun
 *
 */
public class ClassLoaderB extends ClassLoader {


	/*@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		InputStream inputStream =null;
		try {
			
//			inputStream = new FileInputStream(new File("E:/workspace_git/mj_code/mj_code_practice/target/classes/"+name));
			String filename = name.substring(name.lastIndexOf(".")+1)+".class";
			inputStream = getClass().getResourceAsStream(filename);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(inputStream == null)
			return super.loadClass(name);
		try {
			byte[] b = new byte[inputStream.available()];
			inputStream.read(b);
			inputStream.close();
			return super.defineClass(name, b, 0,b.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return super.loadClass(name);
	}
	
*/}
