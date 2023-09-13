public class Object03{
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.age=10;
		p1.name = "小明";
		Person p2 = p1;//把p1 赋给了 p2,让p2指向p1
		System.out.println(p2.age);
	}
}
class Person{
	int age;
	String name;
}