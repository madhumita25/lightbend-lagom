package com.lightbend.helloworld;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static com.lightbend.lagom.javadsl.testkit.ServiceTest.defaultSetup;
import static com.lightbend.lagom.javadsl.testkit.ServiceTest.withServer;
import static org.junit.Assert.assertEquals;

public class HelloWorldServiceImplTest {

    @Test
    public void helloWord_shouldReturnResult() throws InterruptedException, ExecutionException, TimeoutException {

        withServer(defaultSetup(), server -> {
            HelloWorldService hws = server.client(HelloWorldService.class);

            String result = hws.helloWorld().invoke().toCompletableFuture().get(5, TimeUnit.SECONDS);

            assertEquals("Hello Lagom World!", result);
        });
    }
}
