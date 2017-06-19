package my.rest.controller.apiconfig;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    @ResponseBody
    List<Version> listVersions() {
        ApiConfiguration.Version[] values = ApiConfiguration.Version.values();
        List<Version> versions = new ArrayList<Version>();
        for (ApiConfiguration.Version v : values) {
            versions.add(new Version(v._name(), v._description()));
        }
        return versions;
    }
}
