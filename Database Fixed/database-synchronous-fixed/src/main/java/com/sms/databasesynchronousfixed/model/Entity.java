package com.sms.databasesynchronousfixed.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;

@Document(collection = "time")
public class Entity {
    @MongoId
    private String id;
    private String content;

    public Entity() {
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(id, entity.id) && Objects.equals(content, entity.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Entity(String id, String content) {
        this.id = id;
        this.content = content;
    }
}
