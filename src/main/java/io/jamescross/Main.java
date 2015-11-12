package io.jamescross;

import io.jamescross.model.Fact;
import io.jamescross.rest.bytes.ImageConsumer;
import io.jamescross.rest.json.FactConsumer;
import io.jamescross.rest.xml.CategoryConsumer;

/**
 * Created by jamescross91 on 12/11/2015.
 */

public class Main {
    public static void main(String args[]) {
        if(args.length != 1) {
            System.out.println("Expecting exactly 1 argument: file, categories or fact.  Defaulting to file.");
            fileOption();
        } else {
            switch(args[1]) {
                case "file": fileOption();
                    break;
                case "categories": categoryOption();
                    break;
                case "fact": factOption();
                    break;
                default: System.out.printf("Invalid argument: please use either file, categories, or fact.");
            }
        }
    }

    private static void fileOption() {
        System.out.println(new ImageConsumer().consumeResource("http://thecatapi.com/api/images/get"));
    }

    private static void categoryOption() {
        System.out.println(new CategoryConsumer().consumeResource("http://thecatapi.com/api/categories/list"));
    }

    private static void factOption() {
        Fact fact = new FactConsumer().consumeResource("http://catfacts-api.appspot.com/api/facts");
        System.out.println(fact.getFacts());
    }
}
