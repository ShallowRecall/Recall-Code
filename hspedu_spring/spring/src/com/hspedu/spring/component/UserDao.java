package com.hspedu.spring.component;

import org.springframework.stereotype.Repository;

/**
 * @author ZhouYu
 * @version 1.0
 * 使用 @Repository 标识该类是一个Repository是一个持久化层的类/对象
 * <p>
 * <p>
 * 解读：
 * 1. 标记注解后，类名默认首字母小写作为id的值(默认)
 * 2. value = "recallUserDao" 使用指定的 recallUserDao 作为UserDao对象的id
 */
@Repository//(value = "recallUserDao")
public class UserDao {
}
