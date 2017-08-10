package com.for22.mjcp.testfor;

public class TestGoto {

	public static void main(String[] args) {
	
		System.out.println("begin");
		num:
		for(int i=0;;i++){
			System.out.println("i="+i);
			if(i==5)
				break num;
			
			System.out.println("----");
			
			for(int j = 0;;j++){
				System.out.println("j="+j);
				if(j==5)continue num;
			}
		}
		
		System.out.println("end");	
		
	}

}
