package io.jamescross;

import io.jamescross.model.Fact;
import io.jamescross.rest.bytes.ImageConsumer;
import io.jamescross.rest.json.FactConsumer;
import io.jamescross.rest.xml.CategoryConsumer;

import java.util.List;

import static io.jamescross.Endpoints.*;

/**
 * Created by jamescross91 on 12/11/2015.
 */

public class Main {

    public static void main(String args[]) {
        if(args.length != 1) {
            System.out.println("Expecting exactly 1 argument: file, categories or fact.  Defaulting to file.");
            fileOption();
        } else {
            switch(args[0]) {
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
        System.out.println(new ImageConsumer().consumeResource(FILE_RESOURCE_PATH));
    }

    private static void categoryOption() {
        List<String> categories = new CategoryConsumer().consumeResource(CATEGORY_RESOURCE_PATH);
        categories.stream().forEach(category -> System.out.println(category));
    }

    private static void factOption() {
        Fact fact = new FactConsumer().consumeResource(FACT_RESOURCE_PATH);
        fact.getFacts().stream().forEach(factString -> System.out.println(factString));
    }
}
