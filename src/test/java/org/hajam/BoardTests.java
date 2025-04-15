package org.hajam;

import org.hajam.board.domain.BoardVO;
import org.hajam.board.mappers.BoardMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardTests {

    private static final Logger log = LoggerFactory.getLogger(BoardTests.class);

    private final BoardMapper boardMapper;
    
    @Autowired
    public BoardTests(BoardMapper boardMapper) {
    	this.boardMapper = boardMapper;
    }

    @Test
    public void testInsertBoard() {
    	
        BoardVO vo = new BoardVO();
        
        vo.setTitle("테스트 제목");
        vo.setContent("테스트 내용");

        boardMapper.insert(vo);

        log.info("등록된 게시글 번호: {}", vo.getBoardId());
    }
}
