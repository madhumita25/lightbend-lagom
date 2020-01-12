package com.lightbend.helloworld;

import com.lightbend.lagom.javadsl.client.integration.LagomClientFactory;

import java.net.URI;

public class Main {
    public static void main (String[] args) {
        try(LagomClientFactory lcf = LagomClientFactory.create("client", LagomClientFactory.class.getClassLoader())) {
            HelloWorldService hws = lcf.createClient(HelloWorldService.class, new URI("http://localhost:61610"));
            String result = hws.helloWorld().invoke().toCompletableFuture().get();
            // Instead of thenApply  - just get for test
            System.out.println(result);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
