package com.hspedu.web.viewresolver;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author ZhouYu
 * @version 1.0
 */

/**
 * 解读
 * 1. MyView继承了AbstractView，就可以作为一个视图使用
 * 2. @Component(value = "myView"),该视图会注入到容器中，名字/id是 myView
 */
@Component(value = "hspView")
public class MyView extends AbstractView {
    @Override
    protected void renderMergedOutputModel(Map<String, Object> map,
                                           HttpServletRequest httpServletRequest,
                                           HttpServletResponse httpServletResponse)
            throws Exception {

        //完成视图渲染
        //并且可以确定我们要跳转的页面 [请求转发] /WEB-INF/pages/my_view.jsp
        System.out.println("进入到自己的视图..");

        //解读
        //1. 下面就是进行请求转发到 /WEB-INF/pages/my_view.jsp
        //2. /WEB-INF/pages/my_view.jsp 会被springmvc解析
        //   /springmvc/WEB-INF/pages/my_view.jsp
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/my_view.jsp")
                .forward(httpServletRequest, httpServletResponse);

    }
}
