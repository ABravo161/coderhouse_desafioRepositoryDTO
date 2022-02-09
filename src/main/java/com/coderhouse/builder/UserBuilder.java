package com.coderhouse.builder;

import com.coderhouse.model.database.document.UserDocument;
import com.coderhouse.model.database.document.concrete.UserAdmin;
import com.coderhouse.model.database.document.concrete.UserClient;
import com.coderhouse.model.database.document.concrete.UserEditor;
import com.coderhouse.model.request.UserRequest;
import com.coderhouse.model.response.UserResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserBuilder {

    public static UserEditor requestToDocEditor(UserRequest request) {
        return UserEditor.builder()
                .type(request.getType())
                .createDate(LocalDateTime.now())
                .name(request.getName())
                .build();
    }

    public static UserAdmin requestToDocAdmin(UserRequest request) {
        return UserAdmin.builder()
                .type(request.getType())
                .createDate(LocalDateTime.now())
                .name(request.getName())
                .build();
    }

    public static UserClient requestToDocClient(UserRequest request) {
        return UserClient.builder()
                .type(request.getType())
                .createDate(LocalDateTime.now())
                .name(request.getName())
                .build();
    }


    public static UserResponse docToResponseCreate(UserDocument doc) {
        return UserResponse.builder()
                .id(doc.getId())
                .createDate(doc.getCreateDate().toString())
                .build();
    }


    public static <T extends UserDocument> UserResponse docToResponse(T doc) {
            return UserResponse.builder()
                    .id(doc.getId())
                    .createDate(doc.getCreateDate().toString())
                    .name(doc.getName())
                    .type(doc.getType())
                    .build();
        }


    public static List<UserResponse>
    listDocToResponse(List<UserDocument> users) {

        var listResponse = new ArrayList<UserResponse>();
        users.forEach(item -> listResponse.add(docToResponse(item)));
        return listResponse;
    }

}
