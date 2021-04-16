package ru.otvertka352.smevilclient.impl.service;

import java.util.Base64;

public interface UploadFileService {

    void uploadFile(Base64 file, String fileType);

}
