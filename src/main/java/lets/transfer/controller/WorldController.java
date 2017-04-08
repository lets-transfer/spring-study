package lets.transfer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WorldController {
    @RequestMapping("world")
    public String world(Model model) {
        return "helloWorld/world/world";
    }
}
