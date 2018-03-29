import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BottlesTest {

    @Test
    public void testSong() throws IOException {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bottles.writeLyrics(
                new PrintStream(
                        byteArrayOutputStream));
        final String actual = new String(byteArrayOutputStream.toByteArray());
        final String expected = new String(Files.readAllBytes(Paths.get("src/main/resources/golden_master.txt")));

        Assert.assertEquals(expected, actual);
    }
}