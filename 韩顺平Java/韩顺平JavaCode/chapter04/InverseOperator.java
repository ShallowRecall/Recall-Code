//!和^案例演示

public class InverseOperator {
	public static void main(String[] args) {
		
		//! 操作是取反 T -> F ，F -> T		
		System.out.println(60 > 20);//true
		System.out.println(!(60 > 20));//false

		//a^b：叫逻辑异或，当a 和 b 不同时，则结果为true，否则为false
		boolean b = (10 > 1) ^ (3 < 5);
		System.out.println("b="+b);//F
	}
}