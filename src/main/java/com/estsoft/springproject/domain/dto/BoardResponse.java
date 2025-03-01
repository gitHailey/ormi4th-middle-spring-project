package com.estsoft.springproject.domain.dto;

import com.estsoft.springproject.domain.entity.Board;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponse {
    private Long id;
    private String type;    // 일반글/공지글
    private String team;    // 응원 팀
    private String title;
    private String content;
    private Timestamp created_at;
    private Timestamp modified_at;
    private String nickname;    // 작성자
    private Long userId;

    public BoardResponse(Board board) {
        this.id = board.getId();
        this.type = board.getType();
        this.team = board.getTeam();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.created_at = board.getCreatedAt();
        this.modified_at = board.getModifiedAt();
        this.nickname = board.getUser().getNickname();
        this.userId = board.getUser().getId();
    }
}