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
    public void update(Post Post) {
        list.stream()
                .findFirst()
                .ifPresent(post -> {
                    post.setTitle(Post.getTitle());
                    post.setContent(Post.getContent());
                    post.setWriter(Post.getWriter());
                });
    }

    @Override
    public void delete(int id) {
        list.removeIf(post -> post.getId() == id);
    }
}
