package com.example.demo.Controller;

import com.example.demo.core.dtos.CharacterOfNumber;
import com.example.demo.core.dtos.SourceAndResulDTO;
import com.example.demo.service.ParityAndSimplicityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lab")
public class ParityAndSimplicityController {
    private final ParityAndSimplicityService service;
    private final Logger logger = LoggerFactory.getLogger(ParityAndSimplicityController.class);
    public ParityAndSimplicityController(ParityAndSimplicityService service) {
        this.service = service;
    }
    @GetMapping("/task")
    public CharacterOfNumber task(@RequestParam int param1) {
        logger.info("Enter in method task");
        return service.countResult(param1);
    }
    @GetMapping("/count")
    public ResponseEntity<Long> showCount(){
        return ResponseEntity.status(200).body(service.getCount());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SourceAndResulDTO>> getAll(){
        return ResponseEntity.status(200).body(service.getAll());
    }

    @PostMapping("/saveAll")
    public ResponseEntity<?> saveAll(@RequestBody List<Integer> list){
        return ResponseEntity.status(201).body(service.saveAll(list));
    }
}
