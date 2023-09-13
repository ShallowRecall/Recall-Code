public class DoWhileExercise {
	public static void main(String[] args) {
		// //打印1-100
		// int i = 1;
		// do{
		// 	System.out.println(i+" ");
		// 	i++;
		// }while(i <= 100);

		//计算1-100的和
		int sum = 0;
		int i = 1;
		do{
			sum+=i;
			i++;
		}while(i <= 100);
		System.out.println("sum="+sum);
	}
}