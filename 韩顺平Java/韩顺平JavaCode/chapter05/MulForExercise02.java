//1）统计3个班成绩情况，每个班有5名同学，
//求出各个班的平均分和所有班级的平均分[学生的成绩从键盘输入]。
//2）统计三个班及格人数，每个班有 5 名同学。
// import java.util.Scanner;
// public class MulForExercise02 {
// 	public static void main(String[] args) {
// 		Scanner myScanner = new Scanner(System.in);
// 		double score = 0;
// 		double scoreAll = 0;
// 		int count = 0;
// 		for (int i= 1;i <= 3 ; i++ ) {
// 			double scoreSum = 0;
// 			for(int j = 1;j <= 5; j++){
// 				System.out.println("请输入第"+i+"个班的第"+j+"个学生的成绩：");
// 				score = myScanner.nextDouble();
// 				if (score >= 60){
// 					count++;
// 				}
// 				System.out.println("第"+i+"个班的第"+j+"个学生的成绩："+score);
// 				scoreSum+=score;
// 			}
// 			System.out.println("第"+ i +"个班的总分为："+scoreSum+" 平均分："+(scoreSum / 5));
// 			scoreAll +=scoreSum;
// 		}
// 		System.out.println("三个班的总分："+ scoreAll+" 平均分："+(scoreAll / 15));
// 		System.out.println("三个班及格的人数："+count);

// 	}
// 

public class MulForExercise02 {
	public static void main(String[] args) {
		//打印出九九乘法表
		for (int i = 1;i <= 9 ; i++ ) {
			for (int j = 1; j <= i ; j++ ) {
				System.out.print(j+" * "+i+" = "+(i*j)+"\t");
			}
			System.out.println();
		}
	}
}