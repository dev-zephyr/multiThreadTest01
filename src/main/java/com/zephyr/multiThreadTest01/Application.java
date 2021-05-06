package com.zephyr.multiThreadTest01;

import com.zephyr.multiThreadTest01.service.Service1;
import com.zephyr.multiThreadTest01.service.Service2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements ApplicationRunner {

    @Autowired
    Service1 service1;

    @Autowired
    Service2 service2;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        go1();
    }


    public void go1() {
        service1.run();
    }


}
