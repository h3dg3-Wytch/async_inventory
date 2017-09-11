package inventorysystem;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;

public class FileReaderTest {

    private InventoryReader inventoryReader;
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp(){
        inventoryReader = new InventoryReader();
    }

    @Test
    public void TestThatItCanReadFile() throws IOException{

        File inputs = folder.newFile();
        FileUtils.write(inputs, "1,4,6", "utf-8");
        List<Integer> list = inventoryReader.readFile(inputs.toString());
        assertThat(list, contains(1, 4, 6));

    }

    @Test
    public void TestThatItCanReadFileWithSpacesInInputs() throws IOException{
        File inputs = folder.newFile();
        FileUtils.write(inputs, "1, 4, 6", "utf-8");
        List<Integer> list = inventoryReader.readFile(inputs.toString());
        assertThat(list, contains(1, 4, 6));
    }

    @Test
    public void TestThatItCanReadFileWithNewLine() throws IOException{
        File inputs = folder.newFile();
        FileUtils.write(inputs, "1, 4, 6\n", "utf-8");
        List<Integer> list = inventoryReader.readFile(inputs.toString());
        assertThat(list, contains(1, 4, 6));
    }

    @Test
    public void TestThatABadFileCannotBeLoaded() throws IOException{
        File inputs = folder.newFile();
        FileUtils.write(inputs, "time,4, 6\n", "utf-8");
        assertEquals(inventoryReader.readFile(inputs.toString()),null);
    }

    @Test
    public void TestThatItDoesntAcceptNegativeNumbers()throws IOException {
        File inputs = folder.newFile();
        FileUtils.write(inputs, "-1, 0, 1", "utf-8");
        List<Integer> list = inventoryReader.readFile(inputs.toString());
        assertThat(list, contains(1));
    }

}
