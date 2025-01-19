package korweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    // 1. 메인페이지 반환
    @GetMapping("/") // localhost:8080
    public String index(){  return "korweb/index";    }

    // 2. 회원가입 반환
    @GetMapping("/member/login") // localhost:8080/login
    public String login(){  return "korweb/member/login";    }

    // 3. 로그인 반환
    @GetMapping("/member/signup") // localhost:8080/signup
    public String signup(){  return "korweb/member/signup";    }

}
