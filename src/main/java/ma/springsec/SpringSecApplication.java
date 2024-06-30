package ma.springsec;

import ma.springsec.entities.AppRole;
import ma.springsec.entities.AppUser;
import ma.springsec.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecApplication {
    @Autowired
    AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner init(){
        return args -> {
            accountService.addNewRole(new AppRole(null,"USER"));
            accountService.addNewRole(new AppRole(null,"ADMIN"));
            accountService.addNewRole(new AppRole(null,"CUSTUMER_MANAGER"));
            System.out.println("STArttt");
            accountService.addNewUser(new AppUser(null,"ismail","sorhrani","ismail_sorhrani","1234",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"simo","sorhrani","simo_sorhrani","1234",new ArrayList<>()));
            System.out.println("FIiin");
            accountService.addRoleToUsername("ismail_sorhrani","USER");
            accountService.addRoleToUsername("simo_sorhrani","ADMIN");
        };
    }
}
