package org.spring.webSocket02.rabbitmq;

import org.spring.webSocket02.chatbot.BotMessage;
import org.spring.webSocket02.entity.TestEntity;
import org.spring.webSocket02.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
public class Receiver {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private TestRepository testRepository;

    public void receiveMessage(Question question) throws Exception{
        Thread.sleep(100);
        LocalDateTime today = LocalDateTime.now();
        String formattedTime = today.format(DateTimeFormatter.ofPattern("a H:mm"));
        //요청 data를 전달만 ->
        String responseText=question.getContent()+"에 대한 답변내용 입니다.";
        String src="";
        String searchData = question.getContent().trim();
        String searchName = searchData.replace("조회이름:", "").trim();
        System.out.println(question.getContent()+"<< question");
        if (searchData.startsWith("조회이름:")) {
            //DB조회 O
            //1. 이름으로 조회 name
            Optional<TestEntity> optionalTestEntity = testRepository.findByName(searchName);
            if (optionalTestEntity.isEmpty()) {
                responseText = "등록된 회원이 아닙니다.";
            } else {
                responseText = "조회이름: " + optionalTestEntity.get().getName() + ", " + "고향: " + optionalTestEntity.get().getCity();
                //2. 이름+고향 출력 name, city
            }
        }
        src="<div class='msg bot flex'>"+
                "<div class='icon'>"+
                "<img src='/images/rabbitchat.png' th:alt=\"#{chat}\"/>"+
                "</div>"+
                "<div class='message'>"+
                "<div class='part'>"+
                "<p>"+responseText+"</p>"+
                "<img src='"+src+"' th:alt=\"#{src}\"/>"+
                "</div>"+
                "<div class='time'>"+
                formattedTime+
                "</div>"+
                "</div>"+
                "</div>";
        simpMessagingTemplate.convertAndSend("/topic/question",Answer.builder().message(src).build());

    }
}
