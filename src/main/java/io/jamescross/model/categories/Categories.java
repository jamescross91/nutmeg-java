package io.jamescross.model.categories;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by jamescross91 on 12/11/2015.
 */

@XmlRootElement(name = "categories")
public class Categories {
    @XmlElement(name =  "category")
    private List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }
}
