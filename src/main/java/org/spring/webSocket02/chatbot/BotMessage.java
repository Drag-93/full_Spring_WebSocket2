package org.spring.webSocket02.chatbot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter       //bot 응답 메시지
public class BotMessage {
    private String message;
}
