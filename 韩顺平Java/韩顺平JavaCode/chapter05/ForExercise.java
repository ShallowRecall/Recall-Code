
public class ForExercise {
	public static void main(String[] args) {
		//打印1~100之间所有是9的倍数的整数，统计个数 及 总和.
		//两个编程思想（技巧）
		//1.化繁为简：即将复杂的需求，拆解成简单的需求，逐步完成
		//2.先死后活：先考虑固定的值，然后转成可以灵活变化的值
		//
		//思路分析
		//打印1~100之间所有是9的倍数的整数，统计个数 及 总和
		//化繁为简
		//(1) 完成 输出 1-100的值
		//(2) 在输出的过程中，进行过滤，只输出9的倍数 i % 9 == 0
		//(3) 统计个数 定义一个变量 int count = 0;当条件满足时 count++;
		//(4) 总和，定义一个变量 int sum = 0; 当条件满足时累积 sum += i;
		//先死后活
		//(1)为了适应更好的需求，把范围的起始值和结束的值，做成变量
		//(2)还可以更进一步 9 倍数也做成变量 int t = 9;

		int sum = 0;//总和
		int count = 0;//统计9的倍数个数 变量
		int start = 1;
		int end = 100;
		int t = 9;// 倍数
		for (int i = start;i <= end ;i++ ) {
			if (i % t == 0) {
				System.out.print(i+" ");
				count++;
				sum += i;//累积
			}
		}
		System.out.println();
		System.out.println("打印1~100之间所有是9的倍数的整数个数和和分别为："+ count+" "+sum);
	}
}