package ru.otvertka352.smevilclient.impl.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.otvertka352.smevilclient.api.controller.FileController;
import ru.otvertka352.smevilclient.impl.service.UploadFileService;

@RestController
@AllArgsConstructor
public class FileControllerImpl implements FileController {

    private final UploadFileService uploadFileService;

    @Override
    public String uploadFile(byte[] file, String fileType) {
        uploadFileService.uploadFile(file, fileType);

        return "";
    }
}
