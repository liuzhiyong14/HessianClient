package com.hessian.serializable;

public class ExceptionTest {

	public static void main(String[] args) {
		ExceptionTest ex = new ExceptionTest();
		try {
			int aa = ex.Test(3, 0);
			System.out.println("aa===" + aa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int Test(int i, int j) throws Exception{
		int result;
		try{
			result = i/j;
		}catch(Exception e){
			throw e;
		}finally{
			return 1;
		}
	}

}
