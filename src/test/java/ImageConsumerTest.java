import io.jamescross.Endpoints;
import io.jamescross.rest.bytes.ImageConsumer;
import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by jamescross91 on 12/11/2015.
 */

public class ImageConsumerTest {
    @Test
    public void testConsumeFactsValid() {
        String filePath = new ImageConsumer().consumeResource(Endpoints.FILE_RESOURCE_PATH);
        assertTrue(filePath.length() > 0);
        File file = new File(filePath);
        assertTrue(file.exists());
        assertTrue(file.length() != 0);
    }
}
