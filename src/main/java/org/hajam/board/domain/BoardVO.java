package org.hajam.board.domain;

import java.time.LocalDateTime;
import java.util.List;

// lombok 없이
public class BoardVO {

	private Integer boardId;
    private String title;
    private String content;
    private Boolean delFlag;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<BoardAttachFileVO> attachFiles;

    public List<BoardAttachFileVO> getAttachFiles() {
        return attachFiles;
    }

    public void setAttachFiles(List<BoardAttachFileVO> attachFiles) {
        this.attachFiles = attachFiles;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "BoardVO{" +
                "boardId=" + boardId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", delFlag=" + delFlag +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
