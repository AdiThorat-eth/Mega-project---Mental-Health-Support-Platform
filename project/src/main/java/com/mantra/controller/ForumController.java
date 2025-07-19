package com.mantra.controller;

import com.mantra.dto.ApiResponse;
import com.mantra.dto.forum.PostRequest;
import com.mantra.dto.forum.PostResponse;
import com.mantra.dto.forum.ReplyRequest;
import com.mantra.dto.forum.ReplyResponse;
import com.mantra.service.ForumService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Community Forum", description = "Community forum for mental health discussions")
@SecurityRequirement(name = "bearerAuth")
public class ForumController {
    private final ForumService forumService;

    @GetMapping("/posts")
    @Operation(summary = "Get all forum posts")
    public ResponseEntity<ApiResponse<List<PostResponse>>> getAllPosts() {
        List<PostResponse> posts = forumService.getAllPosts();
        return ResponseEntity.ok(ApiResponse.success(posts));
    }

    @PostMapping("/posts")
    @Operation(summary = "Create a new forum post")
    public ResponseEntity<ApiResponse<PostResponse>> createPost(
            @Valid @RequestBody PostRequest request,
            Authentication authentication) {
        PostResponse response = forumService.createPost(request, authentication.getName());
        return ResponseEntity.ok(ApiResponse.success("Post created successfully", response));
    }

    @PostMapping("/replies")
    @Operation(summary = "Reply to a forum post")
    public ResponseEntity<ApiResponse<ReplyResponse>> createReply(
            @Valid @RequestBody ReplyRequest request,
            Authentication authentication) {
        ReplyResponse response = forumService.createReply(request, authentication.getName());
        return ResponseEntity.ok(ApiResponse.success("Reply created successfully", response));
    }
}