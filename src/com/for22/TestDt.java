/**
 * 
 */
package com.for22;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author qiankun.li
 *
 */
public class TestDt {

	static void testDt(){
		Date d = new Date();
		System.out.println(d.toString());
		String dt="[18/Jul/2016:00:00:01 +0800]";
		SimpleDateFormat dateFormat = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z]",Locale.US);        
		try {
			System.out.println(dateFormat.parse(dt));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
static void testString(){
	String s = "http://www.howbuy.com/uac/ha.do?hutmwv=1.1.1&hutmn=1482335620&hutmhn=www.howbuy.com&hutmcs=UTF-8&hutmsr=1366x768&hutmsc=24-bit&hutmul=zh-cn&hutmje=0&hutmfl=21.0%20r0&hutmdt=%E5%A5%BD%E4%B9%B0%E5%9F%BA%E9%87%91%E7%BD%91%20-%20%E5%A5%BD%E4%B9%B0%E8%B4%A2%E5%AF%8C%20%7C%20%E5%9F%BA%E9%87%91%20%7C%20%E7%A7%81%E5%8B%9F%20%7C%20%E4%BF%A1%E6%89%98%20%7C%20%E4%B8%93%E4%B8%9A%E7%9A%84%E6%8A%95%E8%B5%84%E9%A1%BE%E9%97%AE&hutmhid=647411749&hutmr=-&hutmp=%2F&hutmos=Windows&hutmbro=Chrome47&hutmdur=-1&hutmref=&hutmac=UA-10946093-1&hutmcc=__hutma%3D92262275.883280687.1468205096.1469424327.1469502087.7%3B%2B__hutmz%3D92262275.1468205096.1.1.hutmcsr%3D(direct)%7Chutmccn%3D(direct)%7Chutmcmd%3D(none)%3B&aip=1&hutmu=q&hutmcch=&HTAG=&pageid=&pagelevel=&proid=1001";
	System.out.println(s);
}
	public static void main(String[] args) {
		//testDt();
		testString();
	}

}
