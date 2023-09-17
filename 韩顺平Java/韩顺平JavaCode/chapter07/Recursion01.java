public class Recursion01{
	public static void main(String[] args) {
		
		T t1=new T();
		t1.test(4);//2 3 4
		int res=t1.factorial(5);
		System.out.println("res=" + res);
	}
}

class T {
	pubilc void test(int n){
		if (n > 2) {
			test(n - 1);
		}
		System.out.println("n=" + n);
	}

	//factorial阶乘
	public int factorial(int n){
		if (n == 1) {
			return 1;
		}else {
			return factorial(n-1) * n;
		}
	}
}