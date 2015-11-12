import io.jamescross.Endpoints;
import io.jamescross.rest.xml.CategoryConsumer;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by jamescross91 on 12/11/2015.
 */

public class CategoryConsumerTest {
    @Test
    public void testConsumeFactsValid() {
        List<String> categories = new CategoryConsumer().consumeResource(Endpoints.CATEGORY_RESOURCE_PATH);
        assertTrue(categories.size() > 0);
        categories.stream().forEach(categoryString -> assertTrue(categoryString.length() > 1));
    }

    @Test
    public void testConsumeFactsInvalid() {
        List<String> categories = new CategoryConsumer().consumeResource("http://www.jamescross.io");
        TestCase.assertEquals(0, categories.size());
    }
}
