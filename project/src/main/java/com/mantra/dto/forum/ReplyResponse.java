package com.mantra.dto.forum;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReplyResponse {
    private Long id;
    private String content;
    private String author;
    private String createdAt;
}