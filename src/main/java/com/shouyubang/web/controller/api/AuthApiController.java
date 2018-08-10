package com.shouyubang.web.controller.api;

import com.shouyubang.web.model.Response;
import com.shouyubang.web.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/auth")
@ComponentScan("com.shouyubang.web.service")
public class AuthApiController {

    @Autowired
    AuthService authService;

    @RequestMapping(value = "/getSignOnce", method = RequestMethod.GET)
    public Response getOnceSign(@RequestParam(value = "bucket") String bucket,
                                @RequestParam(value = "service") String service,
                                @RequestParam(value = "expired") String expired,
                                @RequestParam(value = "path") String fileId) {
        Response response = new Response(6, "SUCCESS");
        response.setData(authService.appSignOnce(fileId, bucket));
        return response;
    }

    @RequestMapping(value = "/getSign", method = RequestMethod.GET)
    public Response getSign(@RequestParam(value = "bucket") String bucket,
                          @RequestParam(value = "service") String service) {
        long expired = System.currentTimeMillis() / 1000 + 60;
        Response response = new Response(7, "SUCCESS");
        response.setData(authService.appSign(expired, bucket));
        return response;
    }
}
