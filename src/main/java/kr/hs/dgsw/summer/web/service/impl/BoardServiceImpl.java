package kr.hs.dgsw.summer.web.service.impl;

import kr.hs.dgsw.summer.web.domain.Post;
import kr.hs.dgsw.summer.web.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService {
    private final List<Post> list = new ArrayList<>();

    private int idPool = 0;

    @Override
    public void addPost(Post post) {
        post.setId(++idPool);

        list.addFirst(post);

        log.info("List {}", list);

    }

    @Override
    public List<Post> list() {
        return list;
    }

    @Override
    public Post read(int id) {
        for (Post post : list) {
            if (post.getId() == id) {
                return post;
            }
        }

        throw new RuntimeException("not found");
    }

    @Override
    public void update(Post updatedPost) {
        list.stream()
                .filter(post -> post.getId() == updatedPost.getId())
                .findFirst()
                .ifPresent(post -> {
                    post.setTitle(updatedPost.getTitle());
                    post.setContent(updatedPost.getContent());
                    post.setWriter(updatedPost.getWriter());
                });
    }

    @Override
    public void delete(int id) {
        list.removeIf(post -> post.getId() == id);
    }
}
