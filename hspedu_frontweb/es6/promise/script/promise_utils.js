/**
 * 这里我们将重复的代码，抽取出来，编写一个方法get
 *
 * @param url ajax请求的资源
 * @param data ajax请求携带的数据
 * @returns {Promise<unknown>}
 */
function get(url, data) {
    return new Promise((resolve, reject) => {
        $.ajax({
                url: url,
                data: data,
                success(resultData) {
                    resolve(resultData);
                },
                error(err) {
                    reject(err);
                }
            }
        )
    })
}