package com.configLoader;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/config")
public class ConfigController {

    private final ConfigLoader configLoader;

    public ConfigController(ConfigLoader configLoader) {
        this.configLoader = configLoader;
    }

    @PostMapping
    public ResponseEntity<?> put(@RequestParam String key, @RequestParam String value) {
        configLoader.put(key, value);
        return ResponseEntity.ok("Saved");
    }

    @GetMapping("/{key}")
    public ResponseEntity<String> get(@PathVariable String key) {
        return ResponseEntity.ok(configLoader.get(key));
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> getAll() {
        return ResponseEntity.ok(configLoader.getAll());
    }
}
