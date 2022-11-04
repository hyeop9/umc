package com.umc.api.Controller;

import com.umc.api.UserProvider;
import com.umc.api.model.GetUserRes;
import com.umc.api.model.PostUserReq;
import com.umc.api.model.PostUserRes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserProvider userProvider;

    @Autowired
    public UserController(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    @GetMapping("/users")
    public List<GetUserRes> getUser() {
        List<GetUserRes> userRes = userProvider.getUser();
        return userRes;
    }

    @ResponseBody
    @PostMapping("/users")
    public PostUserRes postUser(@RequestBody PostUserReq postUserReq) {
        PostUserRes postUserRes = userProvider.postUser(postUserReq);
        return postUserRes;
    }
}
