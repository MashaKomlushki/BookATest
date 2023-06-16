package utilities;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import rs.booka.BaseTest;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVReader extends BaseTest {

    private static String[] HEADERS = { "Username", "Password"};

    public static void getCSVData() throws IOException {
        String path = "D:\\MashaProject\\testData\\loginTestData.csv";

        Reader reader = Files.newBufferedReader(Paths.get(path));

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .setSkipHeaderRecord(true)
                .build();


        Iterable<CSVRecord> records = csvFormat.parse(reader);

        for (CSVRecord csvRecord : records) {
            String username = csvRecord.get("Username");
            String password = csvRecord.get("Password");

            System.out.println("Username is " + username);
            System.out.println("Password is " + password);

        }
    }


}
