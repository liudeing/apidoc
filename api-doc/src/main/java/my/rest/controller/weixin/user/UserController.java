package my.rest.controller.weixin.user;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ldp on 2017/6/13.
 */
@Controller
@RequestMapping("/api/user")
public class UserController {

    @ResponseBody
    @RequestMapping("/hello")
    @ApiOperation(value="测试接口", notes="测试接口详细描述")
    public String sayHello(){
        return "hello";
    }
}
