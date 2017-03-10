/**
 * 
 */
package com.for22.mjcp.basic;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Copyright 2017 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 *
 * Class Name: FileReadTest.java
 * @author liqiankun
 * Modifications:
 * </pre>
 */
public class FileReadTest {

	List<Long> timeList=  new ArrayList<>();
	
	Map<String,String> fileTimeNameMap = new HashMap<>();
	
	void readFile(File file){
		
		if(null!=file && file.isFile()){
			String filePath= file.getAbsolutePath();
			Long modifyTime = file.lastModified();
			timeList.add(modifyTime);
			fileTimeNameMap.put(modifyTime.toString(), filePath);
		}else if(null!=file && file.isDirectory()){
			File[] fileArray = file.listFiles();
			for(File f:fileArray){
				readFile(f);
			}
		}
	}
	
	
	public static void main(String[] args) {
		String readPath = "D:\\workspace";
		FileReadTest ft = new FileReadTest();
		ft.readFile(new File(readPath));
		//排序list
		ft.timeList.sort(new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				return o1-o2<0L?-1:(o1-o2==0L?0:1);
			}
		});
		Map<String,String> fm = ft.fileTimeNameMap;
		for(Long t:ft.timeList){
			String key = t.toString();
			String path = fm.get(key);
			System.out.println(new Date(t).toLocaleString()+"-"+path);
		}
	}
}
