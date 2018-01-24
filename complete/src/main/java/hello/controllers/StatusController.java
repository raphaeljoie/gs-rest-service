package hello.controllers;

import java.util.concurrent.atomic.AtomicLong;

import hello.dynamic_models.Status;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class StatusController {

    private final AtomicLong counter = new AtomicLong();

    @SuppressWarnings("unused")
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public Status status(@RequestParam(value = "name", defaultValue = "World") String name,
                         HttpServletRequest request) {

        return new Status(counter.incrementAndGet(),
                request.getLocalAddr());
    }
}
