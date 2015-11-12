package io.jamescross.model.categories;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jamescross91 on 12/11/2015.
 */

@XmlRootElement(name = "response")
public class Response {
    @XmlElement(name = "data")
    private Data data;

    public Data getData() {
        return data;
    }
}
