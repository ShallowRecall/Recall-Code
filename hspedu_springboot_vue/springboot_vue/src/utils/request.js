// 引入axios
import axios from "axios";
// 通过axios创建对象-request对象，用于发送请求到后端
const request = axios.create(
    {
        timeout: 5000
    }
)

//request拦截器的处理
//1. 可以对请求做统一的处理
//2. 比如统一的加入token，Content-Type等
request.interceptors.request.use(config => {
    config.headers['Content-Type'] = 'application/json;charset=utf-8';
    return config
}, error => {
    return Promise.reject(error)
});


//response拦截器
//可以在调用接口响应后，统一处理返回结果
request.interceptors.response.use(
    response => {
        // 这里的response 就是后端返回的结果
        console.log("response-", response)
        // 这里将 response的data属性赋给了res
        // 那么我们在请求方法中，得到结果是 response.data
        let res = response.data
        // 如果返回的是文件,就返回
        if (response.config.responseType === 'blob') {
            return res
        }
        // 如果是string，就转成json对象
        if (typeof res === 'string') {
            // 如果res 不为null，就进行转换json对象
            res = res ? JSON.parse(res) : res
        }
        return res;
    },
    error => {
        console.log("err", error)
        return Promise.reject(error);
    }
)

//导出request对象，这样就可以在其它组件使用
export default request

