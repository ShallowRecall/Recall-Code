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


//es6的导出模块/数据
/**
 * 解读
 * 1. export 就是导出模块/数据
 * 2. 可以全部导出，也可以部分导出
 */
export {
    sum,
    sub,
    name,
    monster,
}