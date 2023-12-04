//定义对象，变量，常量，函数

//定义sum函数时，就直接导出
//说明：如果在定义，导出的数据，在导入时，要保持名字一致
export const sum = function (a, b) {
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
