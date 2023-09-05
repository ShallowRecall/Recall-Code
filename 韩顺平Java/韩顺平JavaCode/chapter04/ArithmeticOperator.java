/**
 * 演示算术运算符的使用
*/
public class ArithmeticOperator {

	public static void main(String[] args) {
		// /使用
		System.out.println(10 / 4); //从数学来看2.5，java中 2
		System.out.println(10.0 / 4);//java是2.5
		double d = 10 / 4;//java中10 / 4 = 2，2=>2.0
		System.out.println(d);// 是2.0

		// % 取模，取余
		// 在 % 的本质 看一个公式 a % b = a - a / b * b
		// -10 % 3 => -10-(-10) / 3 *3 = -10 + 9 = -1
		//10 % -3 = 10 - 10 /(-3) * (-3) = 10 - 9 =1 
		// -10 % -3 = (-10) - (-10) / (-3) * (-3) = (-10) - 3 * (-3) = -1
		System.out.println(10 % 3);	// 1
		System.out.println(-10 % 3);// -1
		System.out.println(10 % -3);// 1
		System.out.println(-10 % -3);// -1

		//++的使用
		//
		int i = 10;
		i++;//自增 等价于 i = i + 1;=> i = 11
		++i;//自增 等价于 i = i + 1;=> i = 12
		System.out.println("i=" + i);//12

		/*
		作为表达式使用
		前++：++i 先自增后赋值
		后++：i++ 先赋值后自增
		*/
		int j = 8;
		//int k = ++j;//等价 j = j + 1;k = j;
		int k = j++;//等价 k = j;j=j+1;
		//System.out.println("k=" + k + " j=" +j);//k = 9;j = 9;
		System.out.println("k=" + k + " j=" +j);//k = 8;j = 9;

	}
}