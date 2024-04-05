package de.doubleslash.techdays.helm.simplespringapp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SimpleSpringAppController {

    @GetMapping("/hello")
    public ResponseEntity<String> getTest() {
        return ResponseEntity.ok("Hello World!");
    }
}
