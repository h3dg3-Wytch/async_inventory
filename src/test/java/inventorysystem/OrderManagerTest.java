package inventorysystem;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

public class OrderManagerTest {

    private Inventory inventory;
    private OrderManager orderManager;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        File file = folder.newFile("input.txt");
        FileUtils.write(file, "1,2,4", "utf-8");

        this.inventory = new Inventory();
        this.orderManager = new OrderManager(inventory, 2, file.toString());
    }

    @Test
    public void TestTheRetrieval() throws IOException{
        new Thread(orderManager).start();
    }
}
