package kr.hs.dgsw.summer.web.service;

import kr.hs.dgsw.summer.web.domain.Post;

import java.util.List;

public interface BoardService {

    void addPost(Post post);

    List<Post> list();

    Post read(int id);

    void update(Post post);

    void delete(int id);
}
