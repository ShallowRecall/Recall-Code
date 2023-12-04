//导入
//解读
//1. 在es5中，我们通过 require 就包 对应.js中的
//数据/对象,引入
//2. 我们使用的时候，通过m.属性 就可以使用
//3. 如果我们导入时，不需要所有的，可以导入部分数据
const m = require("./function.js");

const {sub} = require("./function.js");

//使用
//说明：只要这里idea可以识别变量/函数/对象,说明OK
console.log(m.sub("100", "200"));
console.log(m.sum(10, 90));
console.log(m.myname);
console.log(m.PI);
console.log(sub(19,8));