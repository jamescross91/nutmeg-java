import io.jamescross.Endpoints;
import io.jamescross.model.Fact;
import io.jamescross.rest.json.FactConsumer;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by jamescross91 on 12/11/2015.
 */

public class FactConsumerTest {
    @Test
    public void testConsumeFactsValid() {
        Fact fact = new FactConsumer().consumeResource(Endpoints.FACT_RESOURCE_PATH);
        assertEquals("true", fact.getSuccess());
        assertTrue(fact.getFacts().size() > 0);
        fact.getFacts().stream().forEach(factString -> assertTrue(factString.length() > 1));
    }

    @Test
    public void testConsumeFactsInvalid() {
        Fact fact = new FactConsumer().consumeResource("http://www.google.co.uk");
        assertNull(fact.getSuccess());
        assertNull(fact.getFacts());
    }
}
