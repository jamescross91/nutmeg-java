package io.jamescross.model.categories;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jamescross91 on 12/11/2015.
 */

@XmlRootElement(name = "data")
public class Data {
    @XmlElement(name = "categories")
    private Categories categories;

    public Categories getCategories() {
        return categories;
    }
}
