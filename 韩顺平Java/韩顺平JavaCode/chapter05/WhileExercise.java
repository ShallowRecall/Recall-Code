
public class WhileExercise {
	public static void main(String[] args) {
		
		//打印 1-100 之间所有能被3整除的数
		//化繁为简，先死后活

		// int i = 1;
		// int endNum = 100;//结束的变量
		// int t = 3;
		// while(i <= endNum){
		// 	if (i % t == 0) {
		// 		System.out.println("i=" + i);
		// 	}
		// 	i++;//变量自增
		// }

		// 打印40 - 200之间所有的偶数[使用while]
		//化繁为简，先死后活（利于思考）
		//
		int j = 40;//变量初始化
		while(j <= 200){
			//判断
			if (j % 2 == 0) {
				System.out.println("j=" + j);
			}
			j++;//循环变量的迭代
		}
	}
}