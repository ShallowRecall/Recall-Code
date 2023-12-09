//定义对象，变量，常量，函数

//演示默认导出
//如果是默认导出，导入的时候，使用的语法
//可以这样理解，类似把 {} 当做一个对象导出


export default {
    sum(a, b) {
        return parseInt(a) + parseInt(b);
    },
    sub(a, b) {
        return parseInt(a) - parseInt(b);
    }
}