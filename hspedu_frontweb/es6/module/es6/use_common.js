//导入
/**
 * 解读
 * 1. 我们可以{} 来接收导出的数据
 * 2. 可以全部接收，也可以选择的接收
 * 3. 细节：这时要求导入和导出的名称一致
 */
import {sub, sum, name} from "./common"
import {monster} from "./common";


//使用
console.log(sum(10,90));
console.log(name);
console.log(monster.hi())

