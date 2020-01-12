package com.lightbend.helloworld;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import java.util.concurrent.CompletableFuture;

public class HelloWorldServiceImpl implements HelloWorldService {
    public ServiceCall<NotUsed, String> helloWorld() {
        return NotUsed -> CompletableFuture.completedFuture("Hello Lagom World!");
    }
}
