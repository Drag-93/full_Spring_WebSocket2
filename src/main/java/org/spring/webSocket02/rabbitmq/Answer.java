package org.spring.webSocket02.rabbitmq;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Answer {
    //응답
    private String answer;
    private String message;

}
