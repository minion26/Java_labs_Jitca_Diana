package org.example;

import java.util.HashMap;
import java.util.Map;

public class Document {
    private String ID;

    private String name;
    private Map<String, String> tags = new HashMap<>();

    public Document(String name, String ID){
        this.name = name;
        this.ID = ID;

    }

    public Document(){

    }

    public void addTag(String key, String value){
        this.tags.put(key, value);
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Document{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", tags=" + tags +
                '}';
    }
}

