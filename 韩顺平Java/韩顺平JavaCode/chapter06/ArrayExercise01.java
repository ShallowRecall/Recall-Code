
public class ArrayExercise01{
	public static void main(String[] args) {
		
		/*
		创建一个 char 类型的 26 个元素的数组，分别 放置'A'-'Z'。
		使用 for 循环访问所有元素并打印出来。
		提示：char 类型 数据运算 'A'+2 -> 'C'

		思路分析
		1.定义一个 数组 char[] chars = new char[26]
		2.因为 'A' + 1 = 'B' 类推，所以可以用for来赋值
		3. 使用 for 循环访问所有元素
		*/
		char[] chars = new char[26];
		for (int i=0;i < chars.length ;i++ ) {//循环26次
			//chars 是 char[]
			//chars[i] = char
			chars[i] = (char)('A' + i);//'A' + i 是int，需要强制转换
		}

		//循环输出
		System.out.println("===chars数组===");
		for (int i = 0;i < chars.length ;i++ ) {
			System.out.print(chars[i] + " ");
		}
	}
}