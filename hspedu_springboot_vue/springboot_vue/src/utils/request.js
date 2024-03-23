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

//导出request对象，这样就可以在其它组件使用
export default request

