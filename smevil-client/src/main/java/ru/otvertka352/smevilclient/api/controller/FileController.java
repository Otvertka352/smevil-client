package ru.otvertka352.smevilclient.api.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
public interface FileController {

    @PostMapping("/uploadFile")
    @ResponseBody String uploadFile(@RequestBody Base64 file, @RequestParam String fileType);

}
