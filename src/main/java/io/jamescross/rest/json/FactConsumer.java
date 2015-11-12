package io.jamescross.rest.json;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.jamescross.model.Fact;
import io.jamescross.rest.ResourceConsumer;

import java.io.FileNotFoundException;

/**
 * Created by jamescross91 on 12/11/2015.
 */

public class FactConsumer implements ResourceConsumer {
    @Override
    public Fact consumeResource(String resourcePath) {

        Fact fact = new Fact();

        try {
            HttpResponse<JsonNode> jsonResponse = Unirest.get(resourcePath).asJson();
            fact = new Gson().fromJson(jsonResponse.getBody().getObject().toString(), Fact.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return fact;
    }
}
