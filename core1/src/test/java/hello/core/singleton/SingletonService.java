package hello.core.singleton;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
public class SingletonService {

    // 1. 자기 자신을 내부에서 Private Static으로 선언.
    // 이때, 전역 선언이 되면서 두개 이상을 선언할 수 없게 된다.
    private static final SingletonService instance = new SingletonService();

    
    // 2. public으로 열어서 인스턴스가 필요해지면 static 메서드를 통해서만 조회
    public static SingletonService getInstance() {
        return instance;
    }
    
    // 3. 생성자를 private으로 만들어 new로 객체 생성을 못하도록 제어
    private SingletonService() {
        
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }    

}
