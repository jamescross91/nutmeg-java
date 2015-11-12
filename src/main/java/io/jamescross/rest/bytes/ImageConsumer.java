package io.jamescross.rest.bytes;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.jamescross.rest.ResourceConsumer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jamescross91 on 12/11/2015.
 */

public class ImageConsumer implements ResourceConsumer {
    @Override
    public String consumeResource(String resourcePath) {
        String tempPath = "";
        try {
            File temp = File.createTempFile("tempfile", ".jpg");
            tempPath = temp.toString();
            InputStream inputStream = Unirest.get(resourcePath).asBinary().getBody();
            FileOutputStream fileOutputStream = new FileOutputStream(temp);

            int read;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, read);
            }
        } catch (UnirestException | IOException e) {
            e.printStackTrace();
        }

        return tempPath;
    }
}
