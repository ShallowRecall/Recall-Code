import java.util.Scanner;
public class ArrayReduce{
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int len = arr.length-1;
		Scanner myScanner = new Scanner(System.in);
		do{
			int[] arrNew = new int[len];

			for (int i = 0; i < arrNew.length;i++ ) {
				arrNew[i] = arr[i];
			}

			arr = arrNew;
			System.out.println("====arr缩减后元素情况====");
			for (int i = 0;i < arr.length ;i++ ) {
			System.out.print(arr[i]+"\t");
			}
			if (arr.length == 1) {
				System.out.println();
				System.out.println("缩减完成");
				break;
			}
			System.out.println("是否继续删除 y/n");
			char key = myScanner.next().charAt(0);
			if ( key == 'n') {//如果输入n，就结束
				break;
			}
			len--;
		}while(true);
		System.out.println("你退出来了缩减...");
	}
}