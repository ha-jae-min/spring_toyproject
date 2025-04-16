package org.hajam.board.mappers;

import org.hajam.board.domain.BoardAttachFileVO;
import org.hajam.board.domain.BoardVO;

public interface BoardMapper {

	void insert(BoardVO board);
	
	void insertAttachFile(BoardAttachFileVO attachFile);
}
