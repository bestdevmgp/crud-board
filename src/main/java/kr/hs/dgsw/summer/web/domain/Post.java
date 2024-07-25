package kr.hs.dgsw.summer.web.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Post {
    private int id;

    private String title;

    private String content;

    private String writer;
}
