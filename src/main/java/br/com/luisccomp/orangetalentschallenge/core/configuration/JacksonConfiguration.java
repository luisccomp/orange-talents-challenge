package br.com.luisccomp.orangetalentschallenge.core.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                // PROPRIEDADES NÃO MAPEADAS não quebram
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                // NÃO FALHA SE ALGUMA PROPRIEDADE ESTIVER VAZIA
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                // SERVE Para compatibilidade de arrays, quando tem um array com um item, caso não tenha, essa config
                // se perde.
                .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
                // Determina se datas devem ser mapeadas para timestamps em formato array numérico (true) ou se devem
                // ser convertidas para texto (false)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                // Serializa datas
                .registerModule(new JavaTimeModule());
    }

}
