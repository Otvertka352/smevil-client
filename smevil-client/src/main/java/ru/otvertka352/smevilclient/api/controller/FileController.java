package ru.otvertka352.smevilclient.api.controller;

import org.springframework.web.bind.annotation.*;

public interface FileController {

    @PostMapping("/uploadFile")
    @ResponseBody String uploadFile(@RequestBody byte[] file, @RequestParam String fileType);

    @GetMapping("/")
    @ResponseBody String home();
}
