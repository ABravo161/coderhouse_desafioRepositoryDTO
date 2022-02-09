package com.coderhouse.model;

import com.coderhouse.builder.UserBuilder;
import com.coderhouse.model.database.document.UserDocument;
import com.coderhouse.model.request.UserRequest;
import lombok.Data;

@Data
public class UserFactory {

    public UserDocument createUser(UserRequest request) {
        switch (request.getType()) {
            case "editor":
                return UserBuilder.requestToDocEditor(request);
            case "client":
                return UserBuilder.requestToDocClient(request);
            case "admin":
                return UserBuilder.requestToDocAdmin(request);
            default:
                return null;
        }
    }

}
