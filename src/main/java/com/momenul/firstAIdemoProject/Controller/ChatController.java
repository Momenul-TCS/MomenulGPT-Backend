package com.momenul.firstAIdemoProject.Controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://momenulgpt.netlify.app/")
@RestController
@RequestMapping("/momenul/v1")
public class ChatController {

    private ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam String q){

        String response = chatClient.prompt(q).call().content();

        return ResponseEntity.ok(response);

    }
}
