
public class ForceConvertDetail {
	public static void main(String[] args) {
		
		//演示强制类型转换
		//强转符号只针对于最近的操作数有效，往往会使用小括号提升优先级
		//int x = (int)10*3.5+6*1.5;
		int y = (int)(10*3.5+6*1.5);//(int)44.0
		System.out.println(y);



		char c1 = 100;//ok
		int m = 100;//ok
		//char c2 = m;//错误
		char c3 = (char)m;//ok
		System.out.println(c3);//100对应的字符，d字符
	}
}