public class Return01 {
	public static void main(String[] args) {
		for (int i = 1;i < 5;i++ ) {
			
			if (i == 3) {
				System.out.println("Hello World!"+i);
				//break;
				//continue;
				return;//当return用在方法时，表示跳出方法，如果在main,表示退出程序
			}
			System.out.println("梦开始的地方");
		}
		System.out.println("go on..");
	}
}