package com.zephyr.multiThreadTest01.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class Service1 {

    private final Service2 service2;

    @Async("async1")
    public void run() {

        CompletableFuture<Boolean>[] list = new CompletableFuture[5];

        System.out.println("service1 : " + Thread.currentThread());

        for(int i=0; i<5; i++) {

            list[i] = service2.run();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        CompletableFuture.allOf(list).join();   // async1의 스레드풀을 10으로 증가해도 하나스레드만 사용하고(async1의 run()이 한번만 호출되었으니까)
                                                // service2의 모든 메서드가 종료될때까지 기다린다.
        System.out.println("끄<읕");
    }
}
