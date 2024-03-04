const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true
})

module.exports = {
    devServer: {
        port: 10000, //启动端口
        // 如果我们请求的地址 /api/save => 代理到 /api/save
        proxy: {                  // 设置代理，必须填
            '/api': {              // 设置拦截器 拦截模式   斜杠+拦截器名字，名字可以自己定
                target: 'http://localhost:8080/ssm', //代理的目标地址，就是/api 代替 http://localhost:8080/ssm
                changeOrigin: true,    //是否设置同源，输入是的，浏览器就允许跨域
                pathRewrite: {      //路径重写
                    '/api': ''     //选择忽略拦截器里面的单词
                }
            }
        }
    }
}
