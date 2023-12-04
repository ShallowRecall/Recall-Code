//定义对象，变量，常量，函数
const sum = function (a, b) {
    return parseInt(a) + parseInt(b);
}

const sub = function (a, b) {
    return parseInt(a) - parseInt(b);
}

let name = "韩顺平教育";

const PI = 3.14;

const monster = {
    name: "牛魔王",
    age: 500,
    hi() {
        console.log("hi 你好 牛魔王");
    }
}

//导出
/*
解读
1. module.exports 导出模块
2. 把你需要导出的数据，写入到 {}中即可
3. 可以全部导出，也可以部分导出
4. 理解：相当于把我们导出的数据，当做一个对象
5. 如果属性名和函数/变量/对象..名字相同，可以简写
6. 简写 module.exports ={} 成 exports={}

 */
exports = {
    sum,
    sub,
    name,
    PI
}

// module.exports = {
//     sum,
//     sub,
//     name,
//     PI
// }

// module.exports = {
//     sum: sum,
//     sub: sub,
//     myname: name,
//     PI:PI
// }


