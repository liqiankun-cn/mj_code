/**
 * 
 */
package com.for22.mjcp.io;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author liqiankun
 *
 */
public class IOTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String str = "HELLOWORLD";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(str.getBytes());
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		int tmp = 0;
		while((tmp=inputStream.read()) != -1){
			outputStream.write(tmp);
		}
		System.out.println(outputStream.toString());
		
		File file = new File("E://bookmarks_2017_1_8.html");
		FileInputStream fileInputStream = new FileInputStream(file);
		int tmpb = 0;
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
		while((tmpb=fileInputStream.read()) != -1){
			bufferedOutputStream.write(tmpb);
		}
		bufferedOutputStream.flush();
		String bs = bufferedOutputStream.toString();
		System.out.println(bs);
		
	}

}
