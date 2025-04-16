package org.hajam.board.domain;

public class BoardAttachFileVO {
	
    private Integer boardId;
    private String attachfileUrl;
    private Integer ord;

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getAttachfileUrl() {
        return attachfileUrl;
    }

    public void setAttachfileUrl(String attachfileUrl) {
        this.attachfileUrl = attachfileUrl;
    }

    public Integer getOrd() {
        return ord;
    }

    public void setOrd(Integer ord) {
        this.ord = ord;
    }

    @Override
    public String toString() {
        return "BoardAttachFileVO{" +
                "boardId=" + boardId +
                ", attachfileUrl='" + attachfileUrl + '\'' +
                ", ord=" + ord +
                '}';
    }
}
