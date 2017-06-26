package my.rest.api.controller.weixin.user;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ldp on 2017/6/13.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @ResponseBody
    @RequestMapping("/hello")
    @ApiOperation(value="测试接口", notes="测试接口详细描述")
    public String sayHello(){
        return "hello";
    }
}
