package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient{

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);

        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url) {this.url = url;}

    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    public void disconnect() {
        System.out.println("close: " + url);
    }



//    public void afterPropertiesSet() throws Exception {
//        // "implements InitializingBean"시 의존관계 주입이 끝나면 호출하는 콜백 함수
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메세지");
//    }
//
//    public void destroy() throws Exception {
//        // "Implements DisposableBean"시 빈이 종료되면 호출하는 콜백 함수
//        System.out.println("NetworkClient.destroy");
//        disconnect();
//    }


    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
