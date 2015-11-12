package io.jamescross;

import io.jamescross.rest.bytes.ImageConsumer;

/**
 * Created by jamescross91 on 12/11/2015.
 */

public class Main {
    public static void main(String args[]) {
//        try {
//            Fact fact = new FactConsumer().consumeResource("http://catfacts-api.appspot.com/api/facts");
//            System.out.println(fact.getFacts());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (UnirestException e) {
//            e.printStackTrace();
//        }

        //new CategoryConsumer().consumeResource("http://thecatapi.com/api/categories/list");
        System.out.println(new ImageConsumer().consumeResource("http://thecatapi.com/api/images/get"));
    }
}
