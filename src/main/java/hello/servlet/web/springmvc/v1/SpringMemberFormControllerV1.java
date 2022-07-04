package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@Component
//@RequestMapping
// 두 개의 어노테이션을 클래스 레벨에 적으면(메소드에 적는게 아님) @Controller 와 같은 역할을 할 수 있다.
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
         return new ModelAndView("new-form");
    }
}
