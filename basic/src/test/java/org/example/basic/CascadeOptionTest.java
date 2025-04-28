package org.example.basic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.example.basic.entity.Comment;

import org.example.basic.entity.Post;

import org.example.basic.respository.CommentRepository;
import org.example.basic.respository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class CascadeOptionTest {
    // 있다고 치고
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;

    @Test
    void comment에서_cascade_persist_적용시_post도_저장된다() {
        Post post = new Post();

        Comment comment = new Comment();
        comment.setContent("댓글");
        post.addComment(comment);

        /**
         * cascade = {CascadeType.PERSIST}를 사용하면
         * post를 저장할 때, comment도 같이 저장된다.
         */
        Post savedPost = postRepository.save(post);

        // 코맨트를 뒤는게 생성 <- post의 pk, id필요
        // commentRepository.save(comment);
    }

    @Test
    void comment에서_cascade_merge_적용시_post수정도_merge된다() {
    }

    @Test
    void comment에서_cascade_remove_적용시_post도_삭제된다() {
        // 그냥 삭제시 삭제 되지만, FK인 ID로 삭제시 삭제가 그냥안된다.
        // 그래서 orphanRemoval을 true로 설정해야 한다.

        // Post post1 = new Post();
        // post1.setId(2L);

        Post post = postRepository.findById(2L).get();

        postRepository.delete(post);
    }

}
