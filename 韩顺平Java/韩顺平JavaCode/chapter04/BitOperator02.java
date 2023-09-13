
public class BitOperator02 {

	public static void main(String[] args) {
		System.out.println(1 >> 2);//0
		System.out.println(1 << 2);//4
		System.out.println(4 << 3);//32  4 * 2 * 2 * 2 = 32
		System.out.println(15 >> 2);//0  15 /2 / 2  = 3
		System.out.println(10 / 3);//3
		System.out.println(10 / 5);//2
		System.out.println(10 % 2);//0
		System.out.println(-10.5 % 3);//-1.5
		int i = 66;
		System.out.println(++i+i);//134
	}
}