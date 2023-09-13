public class Stars {
	public static void main(String[] args) {
		// for (int i = 1;i <= 5 ;i++ ) {
		// 	for (int j =1;j <= i ;j++ ) {
		// 		System.out.print("*");
		// 	}
		// 	System.out.println();
		// }
		/*
		思路分析
		化繁为简
		1.先打印一个矩形
		*****
		*****
		*****
		*****
		*****
		2.打印半个金字塔
		*      //第一层 有 1个*
		**	   //第二层 有 2个*
		***	   //第三层 有 3个*
		****   //第四层 有 4个*
		*****  //第五层 有 5个*
	
		3.打印整个金字塔
			*		//第一层 有1个*	有四=(总层数-1)个空格
		   ***		//第二层 有3个*	有三=(总层数-2)个空格
		  *****     //第三层 有5个*	有二=(总层数-3)个空格
		 *******    //第四层 有7个*	有一=(总层数-4)个空格
		*********   //第五层 有9个*	有0=(总层数-5)个空格

		4.打印整个金字塔
			*		//第一层 有1个*	当前行的第一个位置是*，最后一个位置也是*
		   * *		//第二层 有2个*	当前行的第一个位置是*，最后一个位置也是*
		  *   *     //第三层 有2个*	当前行的第一个位置是*，最后一个位置也是*
		 *     *    //第四层 有2个*	当前行的第一个位置是*，最后一个位置也是*
		*********   //第五层 有9个*	全部输出*

		
		先死后活
		5 层数做成变量 int totalLevel = 5;
		
		*/

		for (int i = 1;i <=5 ;i++ ) {//i 表示层数
			//控制打印每层的*个数
			for(int j = 1;j <= i;j++){
				System.out.print("*");
			}
			//每打印完一层的*后，就换行 println本身
			System.out.println(" ");		
		}
		System.out.println("=================");
		for (int i=1;i <=5 ; i++ ) {
			//在输出*之前，还要输出  对应空格 
			for (int k = 1;k <= 5-i ;k++ ) {
				System.out.print(" ");
			}
			for (int j = 1;j <= 2*i-1 ; j++ ) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
		System.out.println("=================");
		int totalLevel = 10;//层数
		for (int i=1;i <=totalLevel ; i++ ) {
			for (int k = 1;k <= totalLevel-i ;k++ ) {
				System.out.print(" ");
			}
			for (int j = 1;j <= 2*i-1 ; j++ ) {
				//当前行的第一个位置是*，最后一个位置也是*，最后一层全部*
				if (j ==1 || j == 2*i-1 || i== totalLevel) {
					System.out.print("*");
				}else{//其他情况输出空格
					System.out.print(" ");
				}
			}
			System.out.println(" ");
		}
	}
}