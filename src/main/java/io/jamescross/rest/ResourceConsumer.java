package io.jamescross.rest;

/**
 * Created by jamescross91 on 12/11/2015.
 */

public interface ResourceConsumer {
    <T> T consumeResource(String resourcePath);
}
