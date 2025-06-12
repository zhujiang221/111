package myexample.controller;

import com.coze.openapi.client.chat.CreateChatReq;
import com.coze.openapi.client.chat.model.ChatEvent;
import com.coze.openapi.client.chat.model.ChatEventType;
import com.coze.openapi.client.connversations.message.model.Message;
import com.coze.openapi.service.auth.TokenAuth;
import com.coze.openapi.service.service.CozeAPI;
import myexample.beans.Resume;
import io.reactivex.Flowable;
import myexample.service.ResumeDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:8080")
public class MyResumeSkillController {
    @Autowired
    private ResumeDescriptionService mydescription;
    @RequestMapping("/skill")
    public String get_skill(String question1,String question2,String question3,int id){
        String token = "pat_D6FfIyCHNNBGimlxRHRSA5Ls7MXUWWu3DqNRVW9fnwkMua2LqEoLXvATAnbaGNCw";
        String botID = "7507450520324325411";
        String userID = "user7178521765";

        TokenAuth authCli = new TokenAuth(token);

        // Init the Coze client through the access_token.
        CozeAPI coze =
                new CozeAPI.Builder()
                        .baseURL("https://api.coze.cn/v3/chat/")
                        .auth(authCli)
                        .readTimeout(600000)
                        .connectTimeout(600000)
                        .build();


        /*
         * Step one, create chat
         * Call the coze.chat().stream() method to create a chat. The create method is a streaming
         * chat and will return a Flowable ChatEvent. Developers should iterate the iterator to get
         * chat event and handle them.
         * */
        CreateChatReq req =
                CreateChatReq.builder()
                        .botID(botID)
                        .userID(userID)
                        .readTimeout(600000)
                        .connectTimeout(600000)
                        .messages(Collections.singletonList(Message.buildUserQuestionText(question1)))
                        .build();

        Flowable<ChatEvent> resp = coze.chat().stream(req);
        StringBuilder sb=new StringBuilder();
        resp.blockingForEach(
                event -> {
                    if (ChatEventType.CONVERSATION_MESSAGE_DELTA.equals(event.getEvent())) {
                        System.out.print("2222222222222222222222222222");
                        sb.append(event.getMessage().getContent());
                        System.out.println(event.getMessage().getContent());
                    }
                    if (ChatEventType.CONVERSATION_CHAT_COMPLETED.equals(event.getEvent())) {
                        System.out.println("Token usage:" + event.getChat().getUsage().getTokenCount());
                    }
                });
        System.out.println("done");
        System.out.println("第一个项目的描述结束");
        System.out.println(sb.toString());
        CreateChatReq req1 =
                CreateChatReq.builder()
                        .botID(botID)
                        .userID(userID)
                        .readTimeout(600000)
                        .connectTimeout(600000)
                        .messages(Collections.singletonList(Message.buildUserQuestionText(question2)))
                        .build();

        Flowable<ChatEvent> resp1 = coze.chat().stream(req);
        StringBuilder sb1=new StringBuilder();
        resp.blockingForEach(
                event -> {
                    if (ChatEventType.CONVERSATION_MESSAGE_DELTA.equals(event.getEvent())) {
                        System.out.print("2222222222222222222222222222");
                        sb.append(event.getMessage().getContent());
                        System.out.println(event.getMessage().getContent());
                    }
                    if (ChatEventType.CONVERSATION_CHAT_COMPLETED.equals(event.getEvent())) {
                        System.out.println("Token usage:" + event.getChat().getUsage().getTokenCount());
                    }
                });
        System.out.println("done");
        System.out.println("第二个项目的描述结束");
        System.out.println(sb.toString());
        CreateChatReq req2 =
                CreateChatReq.builder()
                        .botID(botID)
                        .userID(userID)
                        .readTimeout(600000)
                        .connectTimeout(600000)
                        .messages(Collections.singletonList(Message.buildUserQuestionText(question3)))
                        .build();

        Flowable<ChatEvent> resp2 = coze.chat().stream(req);
        StringBuilder sb2=new StringBuilder();
        resp.blockingForEach(
                event -> {
                    if (ChatEventType.CONVERSATION_MESSAGE_DELTA.equals(event.getEvent())) {
                        System.out.print("2222222222222222222222222222");
                        sb.append(event.getMessage().getContent());
                        System.out.println(event.getMessage().getContent());
                    }
                    if (ChatEventType.CONVERSATION_CHAT_COMPLETED.equals(event.getEvent())) {
                        System.out.println("Token usage:" + event.getChat().getUsage().getTokenCount());
                    }
                });
        System.out.println("done");
        System.out.println("第三个项目的描述结束");
        System.out.println(sb.toString());
        coze.shutdownExecutor();
        String mystrs1=sb.toString();
        String mystrs2=sb.toString();
        String mystrs3=sb.toString();
        String[] mypros_one=mystrs1.split( "描述:");
        String[] mypros_two=mystrs2.split( "描述:");
        String[] mypros_three=mystrs3.split( "描述:");
        Resume resume=new Resume();
        resume.setProject_one(mypros_one[1]);
        resume.setProject_two(mypros_two[1]);
        resume.setProject_three(mypros_three[1]);
        mydescription.updateDescription(resume);
        return "-------------------\n"+mystrs1+"-----------------\n"+mystrs2 +"-------------\n"+mystrs3+"------------------";
    }
}
