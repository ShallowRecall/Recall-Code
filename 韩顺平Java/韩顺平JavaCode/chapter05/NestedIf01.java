import java.util.Scanner;

public class NestedIf01 {
	public static void main(String[] args) {

		Scanner myScanner = new Scanner(System.in);
		System.out.println("请输入旅游月份（1-12）");
		int season = myScanner.nextInt();
		
		if (season>=1 && season<=12) {
			System.out.println("请输入游客的年龄：");
			int age = myScanner.nextInt();
			if(season >=4 && season <= 10){
				if (age >=18 && age <= 60) {
					System.out.println(age+"为成人,旺季门票：60");
				}else if (age < 18) {
					System.out.println(age+"为儿童,旺季门票：半价");
				}else if(age > 60){
					System.out.println(age+"为老人,旺季门票：1/3");
				}
		    	}else{
			   		if(age >=18 && age <= 60){
						System.out.println(age+"为成人,淡季门票：40");
				}
					else{
						System.out.println("淡季门票：20");
				}
			}

		}else{
			System.out.println("输入的月份错误，请重新输入！");
		}
	}
}