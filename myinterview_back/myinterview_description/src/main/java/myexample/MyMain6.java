package myexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyMain6 {
    public static void main(String[] args){
        SpringApplication.run(MyMain6.class,args);
    }
}
