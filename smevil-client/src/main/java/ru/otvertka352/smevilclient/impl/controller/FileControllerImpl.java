package ru.otvertka352.smevilclient.impl.controller;

import lombok.AllArgsConstructor;
import ru.otvertka352.smevilclient.api.controller.FileController;
import ru.otvertka352.smevilclient.impl.service.UploadFileService;

import java.util.Base64;


@AllArgsConstructor
public class FileControllerImpl implements FileController {

    private final UploadFileService uploadFileService;

    @Override
    public String uploadFile(Base64 file, String fileType) {
        uploadFileService.uploadFile(file, fileType);

        return "";
    }
}
