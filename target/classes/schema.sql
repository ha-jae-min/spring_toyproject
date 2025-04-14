-- 게시글 테이블
CREATE TABLE tbl_board (
    board_id       INT AUTO_INCREMENT PRIMARY KEY,
    title          VARCHAR(200) NOT NULL,
    content        TEXT NOT NULL,
    delFlag        BOOLEAN DEFAULT FALSE,
    created_at     DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at     DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 댓글 테이블
CREATE TABLE tbl_comment (
    comment_id     INT AUTO_INCREMENT PRIMARY KEY,
    board_id       INT NOT NULL,
    content        TEXT NOT NULL,
    delFlag        BOOLEAN DEFAULT FALSE,
    created_at     DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at     DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (board_id) REFERENCES tbl_board(board_id) ON DELETE CASCADE
);

-- 게시글 첨부파일 테이블
CREATE TABLE tbl_board_attachfile (
    board_id       INT NOT NULL,              
    attachfile_url VARCHAR(500),            
    ord            INT,                      
    FOREIGN KEY (board_id) REFERENCES tbl_board(board_id) ON DELETE CASCADE  -- 게시글 테이블의 board_id를 참조
);

-- 댓글 첨부파일 테이블
CREATE TABLE tbl_comment_attachfile (
    comment_id     INT NOT NULL,            
    attachfile_url VARCHAR(500),              
    ord            INT,                      
    FOREIGN KEY (comment_id) REFERENCES tbl_comment(comment_id) ON DELETE CASCADE  -- 댓글 테이블의 comment_id를 참조
);
