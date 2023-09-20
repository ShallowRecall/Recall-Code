public class Homework03{
	public static void main(String[] args) {
		
		//测试
		Book book= new Book("笑傲江湖",300);
		book.info();
		book.updatrPrice();//更新价格
		book.info();
	}
}


/*
分析
1.类名 Book
2.属性 price，name
3.方法名 updatePrice
4.形参()
5.返回值 void
6.提供一个构造器
*/
class Book{
	String name;
	double price;

	public Book(String name,double price){
		this.name = name;
		this.price = price;
	}
	public void updatrPrice(){
		//方法中，没有 price局部变量，this.price 等价 price
		if (this.price > 150) {
			this.price = 150;
		}else if (this.price > 100) {
			this.price = 100;
		}
	}

	//显示书籍情况
	public void info(){
		System.out.println("书名=" + this.name + " 价格=" + this.price);
	}
}