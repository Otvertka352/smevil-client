package ru.otvertka352.smevilclient.impl.service.impl;

import org.springframework.stereotype.Service;
import ru.otvertka352.smevilclient.impl.service.UploadFileService;
import ru.otvertka352.smevilclient.impl.service.strategy.UploadFileStrategy;

import java.util.Map;

@Service
public class UploadFileServiceImpl implements UploadFileService {

    private final Map<String, UploadFileStrategy> uploadFileStrategies;

    public UploadFileServiceImpl(Map<String, UploadFileStrategy> uploadFileStrategies) {
        this.uploadFileStrategies = uploadFileStrategies;
    }

    @Override
    public void uploadFile(byte[] file, String fileType) {
        final UploadFileStrategy uploadFileStrategy = uploadFileStrategies.get(fileType);
        uploadFileStrategy.upload(file);
    }
}
