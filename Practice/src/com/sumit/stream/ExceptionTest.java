package com.sumit.stream;

public class ExceptionTest
{

	
	public static void main(String[] args) throws Exception {
		test();
	}
	
	public static void test() throws Exception {
		
		
		try {
			int i = 1/0;
			
		}catch(Exception e){
			 throw new Exception();
		}finally {
			System.out.println("ad");
		}
	}
}
