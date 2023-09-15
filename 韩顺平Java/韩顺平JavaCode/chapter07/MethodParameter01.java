public class MethodParameter01{
	public static void main(String[] args) {
		

		int a = 10;
		int b = 20;
		//创建AA对象
		AA obj = new AA();
		obj.swap(a,b);//调用swap

		System.out.println("main方法 a=" + a + " b=" + b);//a=10 b=20
	}
}

class AA{
	public void swap(int a,int b){
		System.out.println("\na和b交换之前的值a="+a+"\tb="+b);//a=10 b=20
		//完成了a 和 b 的交换
	    int temp = a;
	    a = b;
	    b = temp;
	    System.out.println("\na和b交换之后的值a="+a+"\tb="+b);//a=20 b=10
	}
}