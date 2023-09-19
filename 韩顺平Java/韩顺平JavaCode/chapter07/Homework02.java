public class Homework02{
	public static void main(String[] args) {
		
		String[] strs = {"jack","tom","mary","milan"};
		A02 a02 = new A02();
		int index = a02.find("milan",strs);
		System.out.println("查找的index=" + index);
	}
}

//分析
//1.类名 A02
//2.方法名 find
//3.返回值 int
//4.形参 (String,String[])
class A02 {
	public int find(String findStr,String[] strs){
		//直接遍历字符串数组，如果找到，则返回索引
		for (int i = 0; i < strs.length ;i++ ) {
			if (findStr.equals(strs[i])) {
				return i;
			}
		}
		//如果没有返回-1
		return -1;
	}
}