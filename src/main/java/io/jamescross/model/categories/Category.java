package io.jamescross.model.categories;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jamescross91 on 12/11/2015.
 */

@XmlRootElement(name = "category")
public class Category {
    @XmlElement
    private int id;
    @XmlElement
    private String name;

    public String getName() {
        return name;
    }
}
