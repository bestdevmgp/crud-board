package kr.hs.dgsw.summer.web.controller;

import kr.hs.dgsw.summer.web.domain.Post;
import kr.hs.dgsw.summer.web.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService boardService;

    @GetMapping("/api/board/read")
    public Post getPost(
            @RequestParam("id") int id) {

        return boardService.read(id);
    }

    @GetMapping("/api/board/read/{id}")
    public Post getPost1(
            @PathVariable int id) {
        return boardService.read(id);
    }
}
