
//定义对象时，直接导出
export let cat = {
    name:"小花猫",
    age:100,
    cay(){
        console.log("小花猫喵喵叫...")
    }
}

// let cat = {
//     name:"小花猫",
//     age:100,
//     cay(){
//         console.log("小花猫喵喵叫...")
//     }
// }


export let dog = {
    name:"小花狗",
    age:2,
    hi(){
        console.log("小花狗说 hi...")
    }
}

// //使用批量导出
// export {cat,dog}
