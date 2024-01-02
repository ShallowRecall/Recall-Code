package com.hspedu.spring.component;

import com.hspedu.spring.annotation.Component;
import com.hspedu.spring.annotation.Scope;

/**
 * @author ZhouYu
 * @version 1.0
 * 说明MonsterService 是一个Service
 * 1. 如果指定了value，那么在注入spring容器时，以你指定的为准
 * 2. 如果没有指定value，则使用类名首字母小写名字
 */
@Component(value = "monsterService") //把MonsterService注入我们自己的spring容器中
@Scope(value = "prototype")
public class MonsterService {
}
