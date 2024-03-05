package programacionweb.springback.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import programacionweb.springback.models.api.Message;

@RestController
@Slf4j
public class MainController {
    @GetMapping("/")
    public ResponseEntity<Message> hello(HttpServletRequest request) {
        log.info("request: " + request.getRequestURL());
        return new ResponseEntity<Message>(new Message("Welcome to the ProgWebP1!"), HttpStatus.OK);
    }
}
