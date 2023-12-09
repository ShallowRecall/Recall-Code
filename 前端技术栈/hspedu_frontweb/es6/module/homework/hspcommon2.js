//默认导出
//写法有一些变化，当我们的两个对象，当做{} 的属性即可

export default {
    cat: {
        name: "小花猫",
        age: 100,
        cay() {
            console.log("小花猫喵喵叫...")
        }
    },
    dog: {
        name: "小花狗",
        age: 2,
        hi() {
            console.log("小花狗说 hi...")
        }
    }
}