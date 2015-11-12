package io.jamescross.rest.xml;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.jamescross.model.categories.Categories;
import io.jamescross.model.categories.Category;
import io.jamescross.model.categories.Response;
import io.jamescross.rest.ResourceConsumer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


/**
 * Created by jamescross91 on 12/11/2015.
 */

public class CategoryConsumer implements ResourceConsumer {
    @Override
    public List<String> consumeResource(String resourcePath)  {
        List<String> categories = new ArrayList<>();
        try {
            Response response = getResponse(resourcePath);
            List<Category> categoryElements = response.getData().getCategories().getCategoryList();
            //Map each category into only its name - which is all we are interested in
            categories.addAll(categoryElements.stream().map(category -> category.getName()).collect(toList()));
        } catch (UnirestException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return categories;
    }

    private Response getResponse(String resourcePath) throws UnirestException, JAXBException {
        HttpResponse<String> stringHttpResponse = Unirest.get(resourcePath).asString();

        JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        return (Response) jaxbUnmarshaller.unmarshal(new StringReader(stringHttpResponse.getBody()));
    }
}
