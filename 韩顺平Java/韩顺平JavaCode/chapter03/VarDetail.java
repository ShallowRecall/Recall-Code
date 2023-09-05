

public class VarDetail{
	public static void main(String[] args) {
		//变量必须先声明，后使用，即有顺序
		int a = 50;//int 
		System.out.println(a);//50
		//a = "jack";//x
		a = 88; //对的
		System.out.println(a);//88

		//变量在同一个作用域不能重名
		//int a = 77;//错误
	}
}

class Dog {
	public static void main(String[] args) {
		int a = 666;//对
	}
}