package practice.ch20;

import java.util.HashMap;
import java.util.Map;

public class BigCharFactory {
    // 이미 만든 BigChar 인스턴스를 관리 
    // key는 String, BigChar는 관리 대상
    private Map<String,BigChar> pool = new HashMap<>();
    // Singleton 패턴 
    private static BigCharFactory singleton = new BigCharFactory();

    // 생성자 
    private BigCharFactory() {
    }

    // 유일한 인스턴스를 얻는다
    public static BigCharFactory getInstance() {
        return singleton;
    }

    // BigChar 인스턴스 생성(공유)
    public synchronized BigChar getBigChar(char charname) { // "3"
        // 이미 만들어진 BigChar 인스턴스를 검색 (요청한 게 이미 존재하는지)
        BigChar bc = pool.get(String.valueOf(charname)); // "3"

        if (bc == null) { // 이미 만들어진 BigChar 인스턴스가 없다면
            // 여기서 BigChar 인스턴스를 생성 
            bc = new BigChar(charname);
            pool.put(String.valueOf(charname), bc); // pool에 추가
        }
        return bc;
    }
}
