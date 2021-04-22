package ru.otvertka352.smevilclient.impl.service.strategy.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.otvertka352.smevilclient.impl.handler.impl.XLSXReaderRPZ;
import ru.otvertka352.smevilclient.impl.service.strategy.UploadFileStrategy;

public class UploadFileStrategyRPZimpl implements UploadFileStrategy {

    @Override
    public void upload(byte[] file) {
        final XLSXReaderRPZ readerRPZ = new XLSXReaderRPZ();
        readerRPZ.read(file);
    }
}
