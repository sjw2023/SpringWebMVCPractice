package com.example.springwebmvcintro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;


//이벤트 목록을 보여주는 컨트롤러
@Controller //MVC패턴에서 컨트롤러 역할을 하게 하는 어노테이션
public class EventController {

    //  웹 브라우져에서 /events로 httpMethod.GET 요청이 들어올때
    //  Model : 자바에 있는 맵 콜렉션, 여기에 우리가 화면에 전달할 모델을 담으면 됨 
    //  이 컨트롤러는 이벤트 목록을 보여줄것이므로 모델에 이벤트 목록을 담으면됨.
    //  현재 이벤트에 대한 도메인이 없기 때문에 모델에 해당하는 이벤트를 먼저 만들것임.
    //  아래 메소드는 요청을 처리하는 핸들러 라고 부른다.

    //  아래 어노테이션을 간략하게 줄일수도 있다.
    //  @RequestMapping(value="/events", method=HttpMethod.GET)
    //  @GetMapping 구현에 @RequestMapping이 붙어 있음. 4.3부터 제공됨
    @GetMapping("/events")
    public String events(Model model) {
        //  모델(이벤트)생성후에 여기에 직접 모델을 생성해서 사용해도 되지만
        //  스프링 핵심기술인 서비스 클래스를 이용하여 제공할수도 있다.

        //model.addAllAttributes(attributeValues)
        return "events";
    }
    
    
}
