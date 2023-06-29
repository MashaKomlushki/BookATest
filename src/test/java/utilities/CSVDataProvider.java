package utilities;

import com.github.hemanthsridhar.CSVUtils;
import com.github.hemanthsridhar.lib.ExtUtils;
import org.testng.annotations.DataProvider;
import rs.booka.BaseTest;

public class CSVDataProvider extends BaseTest {
    @DataProvider(name = "dp1")
    public Object [][] CSVDataRead() throws Exception {
        String path = "D:\\MashaProject\\testData\\loginTestData.csv";
        ExtUtils ext = new CSVUtils(path, true);
        return ext.parseData();
    }
}
