package com.shouyubang.web.controller.api;

import com.shouyubang.web.model.*;
import com.shouyubang.web.service.NewsService;
import com.shouyubang.web.service.PayService;
import com.shouyubang.web.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by SYL on 2017/9/29.
 */
@RestController
@RequestMapping("/api/news")
@ComponentScan("com.shouyubang.web.service")
public class NewsApiController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private PayService payService;
    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces="application/json")
    public News findById(@PathVariable int id) {
        return newsService.findById(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public Response newsList() {
        List<NewsList> NewsList = newsService.listNewsList();
        Response response = new Response(101, "SUCCESS");
        String jsonArray = JsonUtil.toJSon(NewsList);
        response.setData(jsonArray);
        return response;
    }
//@RequestMapping(value = "/call/comments/{id}", method = RequestMethod.GET, produces = "application/json")
//public Response getComments(@PathVariable String id) {
//    List<Comment> comments = callService.getCommentsByStaffId(id);
//    Response response = new Response(10, "SUCCESS");
//    String jsonArray = JsonUtil.toJSon(comments);
//    response.setData(jsonArray);
//    return response;
//}
//    @RequestMapping(value = "/profile/{id}", method= RequestMethod.GET, produces="application/json")
//    public Response getProfile(@PathVariable String id) { //id是用户标识
//        Response response = new Response(19, "SUCCESS");
//        UserProfile userProfile = userInfoService.getUserInfo(id);
//        if(null == userProfile) {
//            response.setCode(-1);
//            response.setMessage("该用户未填写资料");
//        }
//        String json = JsonUtil.toJSon(userProfile);
//        response.setData(json);
//        return response;
//    }




}
