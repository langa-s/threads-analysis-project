package com.example.thread_analysis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RestController
@CrossOrigin(origins = "*") 
public class SocialController {

    @Autowired
    private GraphService graphService;

    // This matches the "fetch" line in index.html

    @GetMapping("/api/path")
    public List<String> getPath(@RequestParam String start, @RequestParam String end) {
        return graphService.getPath(start, end);
    }
}

/*import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
public class SocialController {
    private final GraphService graphService;

    public SocialController(GraphService graphService) {
        this.graphService = graphService;
    }

    @GetMapping("/api/path")
    public List<String> findPath(@RequestParam String from, @RequestParam String to) {
        return graphService.getPath(from, to);
    }  
}
*/