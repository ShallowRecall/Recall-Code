public class TestPerson{
	public static void main(String[] args) {
		Person p1 = new Person("mary",20);
		Person p2 = new Person("smith",30);

		System.out.println("p1和p2的比较结果=" + p1.compareTo(p2));
	}
}

/*
定义 Person 类，里面有 name、age 属性，并提供 compareTo 比较方法，
用于判断是否和另一个人相等，提供测试类 TestPerson 用于测试, 
名字和年龄完全一样，就返回 true, 否则返回 false
*/
class Person{
	String name;
	int age;
	//构造器
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	//compareTo比较方法
	public boolean compareTo(Person p){
		// if (this.name.equals(p.name) && this.age == p.age) {
		// 	return true;
		// }else{
		// 	return false;
		// }
		return this.name.equals(p.name) && this.age == p.age;
	}
}