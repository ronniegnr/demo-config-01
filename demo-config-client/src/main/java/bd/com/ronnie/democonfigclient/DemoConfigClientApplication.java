package bd.com.ronnie.democonfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoConfigClientApplication.class, args);
	}
}

@RestController
class HelloController {

    class Greeting {
        private String greeting1;
        private String greeting2;
        public Greeting(String greeting1, String greeting2) {
            this.greeting1 = greeting1;
            this.greeting2 = greeting2;
        }

        public String getGreeting1() {
            return greeting1;
        }

        public void setGreeting1(String greeting1) {
            this.greeting1 = greeting1;
        }

        public String getGreeting2() {
            return greeting2;
        }

        public void setGreeting2(String greeting2) {
            this.greeting2 = greeting2;
        }
    }

    @Value("${greeting1}")
    private String greeting1;

    @Value("${greeting2}")
    private String greeting2;

    @GetMapping(name = "greeting")
    public ResponseEntity<Greeting> greeting() {
        Greeting greeting = new Greeting(greeting1, greeting2);
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

}