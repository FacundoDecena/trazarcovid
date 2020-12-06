package ar.com.degedev.trazar_covid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TrazarCovidApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrazarCovidApplication.class, args);
    }

}
