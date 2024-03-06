package com.hspedu.furn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hspedu.furn.bean.Furn;
import com.hspedu.furn.bean.Msg;
import com.hspedu.furn.service.FurnService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Controller
public class FurnController {

    //注入配置FurnService
    @Resource
    private FurnService furnService;

    /**
     * 1、响应客户端的添加请求
     * 2、@RequestBody：使用 SpringMVC 的 @RequestBody 将客户端提交的 json，封装成JavaBean对象
     * 3、@ResponseBody：服务器返回的数据格式是按照 json 来返回的(底层是按照http协议进行协商)
     *
     * @param furn
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public Msg save(@RequestBody Furn furn, Errors errors) {

        Map<String, Object> map = new HashMap<>();

        List<FieldError> fieldErrors = errors.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        if (map.isEmpty()) {// 说明后端校验通过，因为没有发现校验错误
            furnService.save(furn);
            //返回成功
            return Msg.success();
        } else {
            //校验失败，把校验错误信息封装到Mag对象，并返回
            return Msg.fail().add("errorMsg", map);
        }
    }

    @RequestMapping("/furns")
    @ResponseBody
    public Msg listFurns() {
        List<Furn> furnList = furnService.findAll();
        // 把家居信息，封装到msg对象
        return Msg.success().add("furnList", furnList);
    }

    @PutMapping("update")
    @ResponseBody
    public Msg update(@RequestBody Furn furn) {
        furnService.update(furn);
        return Msg.success();
    }

    @DeleteMapping("/del/{id}")
    @ResponseBody
    public Msg del(@PathVariable Integer id) {
        furnService.del(id);
        return Msg.success();
    }

    //提供接口，根据id返回对应的furn对象-封装Msg
    @GetMapping("/find/{id}")
    @ResponseBody
    public Msg findById(@PathVariable Integer id) {
        Furn furn = furnService.findById(id);
        return Msg.success().add("furn", furn);
    }

    /**
     * 分页请求接口
     *
     * @param pageNum：要显示第几页：默认为1
     * @param pageSize：每页要显示几条记录：默认为5
     * @return
     */
    @ResponseBody
    @RequestMapping("/furnsByPage")
    public Msg listFurnNyPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "5") Integer pageSize) {

        // 设置分页参数
        //1. 调用findAll是完成查询，底层会进行物理分页，而不是逻辑分页
        //2. 会根据分页参数来计算 limit ?,?，在发出SQL语句是，会带limit
        PageHelper.startPage(pageNum, pageSize);
        List<Furn> furnList = furnService.findAll();

        //将分页查询的结果，封装到PageInfo
        //PageInfo 对象包含了分页的各个信息，比如当前页面pageNum，共有多少记录
        //...

        PageInfo pageInfo = new PageInfo(furnList, pageSize);
        //将pageInfo封装到Msg对象，返回
        return Msg.success().add("pageInfo", pageInfo);
    }

    /**
     * 根据家具名进行分页查询-条件
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("/furnsByConditionPage")
    public Msg listFurnNyConditionPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                       @RequestParam(defaultValue = "5") Integer pageSize,
                                       @RequestParam(defaultValue = "") String search) {

        PageHelper.startPage(pageNum, pageSize);
        List<Furn> furnList = furnService.findByCondition(search);

        PageInfo pageInfo = new PageInfo(furnList, pageSize);
        //将pageInfo封装到Msg对象，返回
        return Msg.success().add("pageInfo", pageInfo);
    }


}
