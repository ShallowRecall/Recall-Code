package com.hspedu.web.datavalid;

import com.hspedu.web.datavalid.entity.Monster;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author ZhouYu
 * @version 1.0
 * MonsterHandler 处理器响应用户提交数据
 * @Scope(value = "prototype") 表示每次请求MonsterHandler会生成一个新的对象
 */
@Controller
@Scope(value = "prototype")
public class MonsterHandler {

    // 显示添加monster的界面

    /**
     * 显示添加monster的界面
     * 1. 这里Map<String, Object> map
     * 2. 当我们向map添加数据时，会默认存放到request域
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/addMonsterUI")
    public String addMonsterUI(Map<String, Object> map) {

        //再次说明，如果你跳转的页面使用了springmvc标签
        //就需要准备一个对象，放入到request域中，这个对象的属性名 monster，对应
        //springmvc表单标签的 modelAttribute="monster"
        map.put("monster", new Monster());
        return "datavalid/monster_addUI";
    }

    /**
     * 编写方法，处理添加妖怪
     * 1. springmvc可以将提交的数据，按照参数名和对象的属性名匹配
     * 2. 直接封装到对象中
     * String => Integer
     * @param monster
     * @return
     */
    @RequestMapping(value = "/save")
    public String save(Monster monster) {
        System.out.println("----monster----" + monster);
        return "datavalid/success";
    }

}
