package entity;

import lombok.Data;

@Data
public class ResponseBodyUser {
    private String id;

    public ResponseBodyUser(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
