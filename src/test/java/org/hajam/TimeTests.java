package org.hajam;

import org.hajam.mappers.TimeMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TimeTests {

	private static final Logger log = LoggerFactory.getLogger(TimeTests.class);
	
	private final TimeMapper timeMapper;
	
	@Autowired
    public TimeTests(TimeMapper timeMapper) {
        this.timeMapper = timeMapper;
    }
	
	@Test
    public void testTime() {
        log.info("time: {}", timeMapper.getTime());
    }
	
	@Test
	public void testTime2() {
		log.info("time2: {}", timeMapper.getTime2());
	}
}
