package org.spring.webSocket02.rabbitmq;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Question {
    //질의 -> 클라이언트 요청
    private Long key;
    private String name;
    private String question;
    private String content;
}
