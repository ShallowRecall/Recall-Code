//演示四种进制

public class BinaryTest {
	public static void main(String[] args) {
		//n1 二进制
		int n1 = 0b1010;
		//n2 10进制
		int n2 = 1010;
		//n3 8进制
		int n3 = 01010;
		//n4 16进制
		int n4 = 0x10101;
		System.out.println("n1=" + n1);
		System.out.println("n2=" + n2);
		System.out.println("n3=" + n3);
		System.out.println("n4=" + n4);
		System.out.println(0x23A);
		System.out.println(0b110001100);
		System.out.println(02456);
		System.out.println(0xA45);
		System.out.println(0b01111011);
		System.out.println(01246);
		System.out.println(0x22D0);
		if (0b11100101 == 0345) {
			System.out.println("0b11100101和0345相等");
			
		}
		if (0b1110010110 == 0x396) {
			System.out.println("0b1110010110和0x396相等");
			
		}
	}
}