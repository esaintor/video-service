package mn.saga.vstream.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("content")
public class ContentController {

    @GetMapping("hello")
    public String hello() {
        return "Hello World";
    }

    // home page content
    @GetMapping("home")
    public void home() {
        // list of all medias
        // trending, recommend, marvel, dc, recently added, favorite, continue to watch from profile list

    }


    // determine whether tv show or movies
    @GetMapping("type/{typeId}")
    public void type(@PathVariable Long typeId) {
        // list of medias according to type of {type}

    }

    // determine whether action or comedy etc
    @GetMapping("genre/{genreId}")
    public void genre(@PathVariable Long genreId) {
        // list of medias according to type of {type}

    }


}
