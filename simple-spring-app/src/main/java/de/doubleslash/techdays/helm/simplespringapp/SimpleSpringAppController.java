package de.doubleslash.techdays.helm.simplespringapp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SimpleSpringAppController {

    private final SimpleDataService simpleDataService;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<SimpleDataEntity> getById(@PathVariable long id) {
        return ResponseEntity.ok(simpleDataService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<SimpleDataEntity>> getAll() {
        final List<SimpleDataEntity> all = simpleDataService.findAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping("/add")
    public ResponseEntity<SimpleDataEntity> add(@RequestBody SimpleDataEntity simpleDataEntity) {
        final SimpleDataEntity dataEntity = simpleDataService.save(simpleDataEntity);
        return ResponseEntity.ok(dataEntity);
    }

}
