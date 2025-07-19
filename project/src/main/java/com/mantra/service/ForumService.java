package com.mantra.service;

import com.mantra.dto.forum.PostRequest;
import com.mantra.dto.forum.PostResponse;
import com.mantra.dto.forum.ReplyRequest;
import com.mantra.dto.forum.ReplyResponse;

import java.util.List;

public interface ForumService {
    List<PostResponse> getAllPosts();
    PostResponse createPost(PostRequest request, String username);
    ReplyResponse createReply(ReplyRequest request, String username);
}