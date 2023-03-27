package org.example;

import java.util.HashMap;
import java.util.Map;
/*This is a class that represents the documents.
* @author Jitca Diana*/
public class Document {
    private String ID;

    private String name;

    private String path;
    private Map<String, String> tags = new HashMap<>();

    public Document(String name, String ID, String path){
        this.name = name;
        this.ID = ID;
        this.path = path;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Document{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", tags=" + tags +
                '}';
    }
}

