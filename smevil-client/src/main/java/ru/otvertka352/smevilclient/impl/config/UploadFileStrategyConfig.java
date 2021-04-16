package ru.otvertka352.smevilclient.impl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otvertka352.smevilclient.impl.service.strategy.UploadFileStrategy;
import ru.otvertka352.smevilclient.impl.service.strategy.impl.UploadFileStrategyMOBImpl;
import ru.otvertka352.smevilclient.impl.service.strategy.impl.UploadFileStrategyRKDimpl;
import ru.otvertka352.smevilclient.impl.service.strategy.impl.UploadFileStrategyRPZimpl;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class UploadFileStrategyConfig {

    @Bean
    public Map<String, UploadFileStrategy> uploadFileStrategies(){

        Map<String, UploadFileStrategy> result = new HashMap<>();
        result.put("rpz", new UploadFileStrategyRPZimpl());
        result.put("rkd", new UploadFileStrategyRKDimpl());
        result.put("mob", new UploadFileStrategyMOBImpl());

        return result;
    }
}
