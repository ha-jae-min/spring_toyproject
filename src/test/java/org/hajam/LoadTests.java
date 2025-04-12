package org.hajam;

import org.hajam.service.HelloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class LoadTests {
    
	// lombok 없이 직접 로거 인스턴스 생성
    private static final Logger log = LoggerFactory.getLogger(LoadTests.class);
    
    private final HelloService helloService;
    
    @Autowired
    public LoadTests(HelloService helloService) {
        this.helloService = helloService;
    }
    
    @Test
    public void test() {
        log.info("HelloService instance: {}", helloService);
    }
}
