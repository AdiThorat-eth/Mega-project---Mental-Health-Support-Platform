package com.mantra.service.impl;

import com.mantra.dto.forum.PostRequest;
import com.mantra.dto.forum.PostResponse;
import com.mantra.dto.forum.ReplyRequest;
import com.mantra.dto.forum.ReplyResponse;
import com.mantra.entity.Post;
import com.mantra.entity.Reply;
import com.mantra.entity.User;
import com.mantra.repository.PostRepository;
import com.mantra.repository.ReplyRepository;
import com.mantra.repository.UserRepository;
import com.mantra.service.ForumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ForumServiceImpl implements ForumService {
    private final PostRepository postRepository;
    private final ReplyRepository replyRepository;
    private final UserRepository userRepository;

    @Override
    public List<PostResponse> getAllPosts() {
        return postRepository.findAllWithReplies().stream()
                .map(this::convertToPostResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PostResponse createPost(PostRequest request, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = new Post();
        post.setUser(user);
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());

        Post savedPost = postRepository.save(post);
        return convertToPostResponse(savedPost);
    }

    @Override
    public ReplyResponse createReply(ReplyRequest request, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Reply reply = new Reply();
        reply.setUser(user);
        reply.setPost(post);
        reply.setContent(request.getContent());

        Reply savedReply = replyRepository.save(reply);
        return convertToReplyResponse(savedReply);
    }

    private PostResponse convertToPostResponse(Post post) {
        List<ReplyResponse> replies = post.getReplies() != null ? 
            post.getReplies().stream()
                .map(this::convertToReplyResponse)
                .collect(Collectors.toList()) : 
            List.of();

        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getUser().getUsername(),
                post.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                replies
        );
    }

    private ReplyResponse convertToReplyResponse(Reply reply) {
        return new ReplyResponse(
                reply.getId(),
                reply.getContent(),
                reply.getUser().getUsername(),
                reply.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        );
    }
}