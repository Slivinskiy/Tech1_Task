package com.Tech1.test_task.request;

import com.Tech1.test_task.entity.Color;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class CreateArticleRequest {

    @JsonProperty
    private String text;

    @JsonProperty
    @Enumerated(EnumType.STRING)
    private Color color;

    @JsonProperty
    private long user_id;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
