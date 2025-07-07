package com.lfelipe.alura.music.network.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroqResponse {
    @JsonAlias("choices")
    private List<Choices> choices;

    public String getContent() {
        if (choices != null && !choices.isEmpty()) {
            return choices.get(0).getMessage().getContent();
        }
        return null;
    }

    public List<Choices> getChoices() {
        return choices;
    }

    public void setChoices(List<Choices> choices) {
        this.choices = choices;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Choices {
        private Message message;

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Message {
        @JsonAlias("content")
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}