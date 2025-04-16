package org.hajam;

import java.util.List;

import org.hajam.board.domain.BoardAttachFileVO;
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
    public void testInsertBoardWithFiles() throws Exception {
        BoardVO board = new BoardVO();
        board.setTitle("파일 포함 게시글");
        board.setContent("첨부파일이 포함된 게시글입니다.");

        boardMapper.insert(board); // boardId가 자동 생성됨

        List<String> savedUrls = List.of("2025/04/16/abcd.jpg", "2025/04/16/efgh.png"); // FileUtil 결과라고 가정

        for (int i = 0; i < savedUrls.size(); i++) {
            BoardAttachFileVO fileVO = new BoardAttachFileVO();
            fileVO.setBoardId(board.getBoardId());
            fileVO.setAttachfileUrl(savedUrls.get(i));
            fileVO.setOrd(i);

            boardMapper.insertAttachFile(fileVO);
        }

        log.info("게시글 ID: {}", board.getBoardId());
    }

}
