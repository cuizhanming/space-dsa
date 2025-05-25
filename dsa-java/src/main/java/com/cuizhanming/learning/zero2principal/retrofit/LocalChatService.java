package com.cuizhanming.learning.zero2principal.retrofit;

import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Arrays;

@Service
public class LocalChatService {
    private final Message systemMessage = new Message("system", "Act like a Principal Engineer specializing in Java. Only answer in complete sentences. Do not include a summary and do not include any follow up questions.");
    private final ChatService chatService;

    @Autowired
    public LocalChatService(ChatService chatService) {
        this.chatService = chatService;
    }

    public String getChatCompletion(String userQuery) {

        // Create
        Message userMessage = new Message("user", userQuery);

        // Create request
        ChatRequest chatRequest = new ChatRequest(
                "NousResearch/Hermes-2-Pro-Llama-3-8B-GGUF",
                Arrays.asList(systemMessage, userMessage),
                0.7,
                150,
                false
        );

        // Make the API call
        Call<ResponseBody> call = chatService.getChatCompletion(chatRequest);

        try {
            Response<ResponseBody> response = call.execute();
            if (response.isSuccessful()) {
                System.out.println(response.body());
                return response.body().string();
            } else {
                throw new RuntimeException("Request failed with status code: " + response.code());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error executing request", e);
        }
    }

    public String getChatCompletion() {
        return getChatCompletion("Briefly describe annotation processors in 100 words or less.");
    }
}
