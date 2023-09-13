
public class Homework05{
	public static void main(String[] args) {
		
		/*
		随机生成10个整数(1_100的范围)保存到数组，
		并倒序打印以及求平均值、求最大值和最大值的下标、
		并查找里面是否有 8
		*/

		int[] arr = new int[10];

		//(int)(Math.random()*100)+1 生成 随机数1-100

		for (int i = 0;i < arr.length ;i++ ) {
			arr[i] = (int)(Math.random()*100)+1;
		}

		System.out.println("====arr的元素情况====");
		for (int i = 1;i < arr.length ;i++ ) {
			System.out.print(arr[i]+"\t");
		}

		System.out.println("\n====arr的元素情况(倒序)====");
		for (int i =arr.length-1; i>=0 ;i-- ) {
			System.out.print(arr[i]+"\t");
		}

		//平均值、求最大值和最大值的下标

		System.out.println("==平均值、求最大值和最大值的下标==");

		double sum = arr[0];
		int max = arr[0];
		int maxIndex = 0;
		for (int i=1;i < arr.length ;i++ ) {
			if (arr[i]>max) {
				max = arr[i];
				maxIndex = i;
			}
			sum+=arr[i];
		}
		System.out.println("平均值="+(sum / arr.length)+
			" max="+max+" maxIndex="+maxIndex);


		//查找数组中是否有8->顺序查找
		int findNum = 9;
		int index = -1;//如果找到，就把下标记录到 index
		for (int i = 0;i < arr.length ;i++ ) {
			if (findNum == arr[i]) {
				System.out.println("找到数" + findNum + "下标=" + i);
				index = i;
				break;	
			} 
		}
		if(index == -1){
			System.out.println("没有找到"+findNum);
		}

		char[] arr1={'a','z','b','c'};
		char[] arr2=arr1;
		arr1[2] = '韩';
		for(int i=0;i<arr2.length;i++){
		  System.out.println(arr1[i]+","+arr2[i]);
		}
	}
}