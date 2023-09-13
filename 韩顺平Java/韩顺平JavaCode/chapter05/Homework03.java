public class Homework03{
	public static void main(String[] args) {
		int year =2023;
		//能被4整除但是不能被100整除
		//能被400整除
		if((year % 4 == 0 && year % 100 != 00) || year % 400 == 0){
			System.out.println(year+"是闰年！");
		}else{
			System.out.println(year+"不是闰年！");
		}
	}
}