package hello;

import java.util.concurrent.atomic.AtomicLong;

import hex.genmodel.easy.exception.PredictException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="sl") double sl,
                           @RequestParam(value="sw") double sw,
                           @RequestParam(value="pl") double pl,
                           @RequestParam(value="pw") double pw) throws IllegalAccessException, InstantiationException, ClassNotFoundException, PredictException {
        Greeting g = new Greeting(sl, sw, pl, pw);
        return g.predict();
    }
}