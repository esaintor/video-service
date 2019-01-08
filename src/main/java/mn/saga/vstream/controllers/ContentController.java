package mn.saga.vstream.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("content")
public class ContentController {

    @GetMapping("hello")
    public String hello() {
        return "Hello World";
    }
}
