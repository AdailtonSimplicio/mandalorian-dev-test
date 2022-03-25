package org.acme.redis.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class TaskModel {
    //Pojos
    public String key;
    @Size(min = 10)
    @Pattern(regexp = "^[a-zA-Z ][a-zA-Z0-9 ]+$")
    public String value;

    //Construtor
    public TaskModel(String key, @Size(min = 10) @Pattern(regexp = "^[a-zA-Z ][a-zA-Z0-9 ]+$") String value) {
        this.key = key;
        this.value = value;
    }
    //Construtor Vazio
    public TaskModel(){
    }
    //Gets e Sets
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
