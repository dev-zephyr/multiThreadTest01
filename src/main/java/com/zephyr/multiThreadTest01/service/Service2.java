package com.zephyr.multiThreadTest01.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class Service2 {

    @Async("async2")
    public CompletableFuture<Boolean> run() {
        System.out.println("service2 : " + Thread.currentThread());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return CompletableFuture.completedFuture(true);

    }
}
