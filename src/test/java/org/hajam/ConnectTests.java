package org.hajam;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension .class)
@ContextConfiguration ("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ConnectTests {
	
	private static final Logger log = LoggerFactory.getLogger(ConnectTests.class);
	
	@Autowired 
	private DataSource ds;
	
	@Test
	public void testConnect() throws SQLException {
		
	    // HikariCP로부터 받은 커넥션을 자동으로 close() 해주기 위해 try-with-resources 사용
	    try (Connection con = ds.getConnection()) {
	        log.info("Connection successful: {}", con);
	    }
	    
	    // 커넥션은 try 블록이 끝나면 자동으로 close()됨
	}

}
