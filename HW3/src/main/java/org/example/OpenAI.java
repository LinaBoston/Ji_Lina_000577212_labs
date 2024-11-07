package org.example;

import io.github.stefanbratanov.jvm.openai.*;

import java.util.ArrayList;
import java.util.List;

public class OpenAI {


    public static String CallOpenAI(List<String> previousMessages, String userMessageString) {

        //var key = System.getenv("OPENAI_API_KEY");
        var key = "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";
        io.github.stefanbratanov.jvm.openai.OpenAI openAI = io.github.stefanbratanov.jvm.openai.OpenAI.newBuilder(key).build();
        ChatClient chatClient = openAI.chatClient();
        var builder = CreateChatCompletionRequest.newBuilder();
        var model = builder.model("gpt-4o");

        var userMessage = ChatMessage.userMessage(userMessageString);

        //var requestBuilder = model.message(userMessage);

        List<ChatMessage> messages = new ArrayList();
        for (var previousMessage : previousMessages) {
            messages.add(ChatMessage.userMessage(previousMessage));
        }
        messages.add(userMessage);


        var requestBuilder = model.messages(messages);

        CreateChatCompletionRequest createChatCompletionRequest = requestBuilder.build();

        ChatCompletion chatCompletion = chatClient.createChatCompletion(createChatCompletionRequest);
        var choices = chatCompletion.choices();

        return choices.get(0).message().content();
    }
}