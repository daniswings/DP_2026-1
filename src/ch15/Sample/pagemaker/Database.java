package ch15.Sample.pagemaker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Database {
    private Database() {
    }

    // 데이터베이스 이름에서 Properties를 얻는다 
    public static Properties getProperties(String dbname) throws IOException {
        String filename = dbname + ".txt";
        Properties prop = new Properties();
        // ㅍ,러퍼티 파일에서 모든 데이터(키와 값)을 읽는다
        prop.load(new FileReader(filename));
        return prop;
    }
}
