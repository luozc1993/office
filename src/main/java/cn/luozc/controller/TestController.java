package cn.luozc.controller;

import cn.luozc.common.ApplicationContextHelper;
import cn.luozc.common.JsonData;
import cn.luozc.dao.CountryMapper;
import cn.luozc.exception.ParamException;
import cn.luozc.exception.PermissionException;
import cn.luozc.param.TestVo;
import cn.luozc.util.BeanValidator;
import cn.luozc.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Resource
    CountryMapper countryMapper;

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData Hello(){
        log.info("as");
        System.out.println ("2ass");
        throw new PermissionException ("test");
        //return JsonData.success ("hello");
    }

}
