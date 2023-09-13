
//演示for的使用细节
public class ForDetail {
	public static void main(String[] args) {
		
		//for(;循环判断条件;) 
		//中的初始化和变量迭代可以写到其它地方，但是两边的分号不能省略。

		//使用for循环控制
		// int i = 1;//循环变量初始化
		// for(; i <= 10; ){
		// 	System.out.println("Hello world!" + i);
		// 	i++;
		// }
		// System.out.println("i="+i);//ok


		// int j = 0;
		// //补充
		// for(;;){//表示无限循环，死循环+break
		// 	System.out.println("ok~"+(j++));
		// }

		int count = 3;
		for (int i = 0,j = 0; i < count ;i++,j += 2 ) {
			System.out.println("i=" + i + " j=" + j);
		}
	}
}