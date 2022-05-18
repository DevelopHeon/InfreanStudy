package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }
    
    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString(); // 전세계에서 유일한 아이디가 생성된다. 절대로 겹치지 않음
        System.out.println("[" + uuid + "] request scope bean create : " + this);
    }

    @PreDestroy // request 스코프는 소멸이 된다.
    public void close(){
        System.out.println("[" + uuid + "] request scope bean close : " + this);
    }
}
