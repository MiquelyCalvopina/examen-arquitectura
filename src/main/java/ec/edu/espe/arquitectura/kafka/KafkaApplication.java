package ec.edu.espe.arquitectura.kafka;

import com.github.javafaker.Faker;
import ec.edu.espe.arquitectura.kafka.model.PagoPrestamo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
@Slf4j
public class KafkaApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }
    
    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, Object> kafkaTemplate) {
        return args -> {
            Faker faker = new Faker();
            PagoPrestamo pagoPrestamo = new PagoPrestamo();
            for (int i = 0; i < 10000; i++) {
                pagoPrestamo.
                pagoPrestamo.setPago();
                pagoPrestamo.setFecha(LocalDate.now());
                pagoPrestamo.setHora(LocalTime.now());
                pagoPrestamo.setNumeroCuota(faker.number().randomDigit());

                log.info("Persona: {}", pagoPrestamo);
                ListenableFuture<SendResult<String, Object>> send = kafkaTemplate.send("personas", pagoPrestamo);
                send.addCallback(new KafkaSendCallback<String, Object>() {
                    @Override
                    public void onSuccess(SendResult<String, Object> result) {
                        log.info("Mensaje enviado: {}",result.getRecordMetadata());
                    }
                    
                    @Override
                    public void onFailure(Throwable ex) {
                        log.error("Error al enviar el mensaje {}",ex);
                    }
                    
                    @Override
                    public void onFailure(KafkaProducerException ex) {
                         log.error("Error al enviar el mensaje {}",ex); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                });
            }
        };
    }
}
