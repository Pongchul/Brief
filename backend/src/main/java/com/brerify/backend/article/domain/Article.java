package com.brerify.backend.article.domain;

import com.brerify.backend.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String source;

    @Lob
    private String content;

    private Long likes;

    // TODO 코멘트를 엔티티 하나 bookMarks로 만들어서 연관관계 매핑 필요
    private Long bookMarks;

    // TODO 코멘트를 엔티티 하나 entity로 만들어서 연관관계 매핑 필요
    private Long replies;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;


}
