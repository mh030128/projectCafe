package org.jin.projectCafe.controller.user;

import org.jin.projectCafe.domain.user.User;
import org.jin.projectCafe.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    // 회원가입 폼
    @GetMapping("/user/join")
    public String joinForm (User user, Model model) {
        return "user/join";
    }

    // 회원가입 처리
    @PostMapping("/user/join")
    public String joinSubmit (User user, Model model) {
        try {
            userService.registerUser(user); // DB에 저장
            return "redirect:/user/login";  // 회원가입 후 로그인 페이지 이동
        } catch (Exception e) {
            model.addAttribute("errorMessage", "회원가입 실패 : " + e.getMessage());
            return "user/join";
        }
    }
}
