package com.coderhouse.model.database.document;

import com.coderhouse.model.database.document.concrete.UserAdmin;
import com.coderhouse.model.database.document.concrete.UserClient;
import com.coderhouse.model.database.document.concrete.UserEditor;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = UserAdmin.class, name = "userAdmin"),
        @JsonSubTypes.Type(value = UserEditor.class, name = "userEditor"),
        @JsonSubTypes.Type(value = UserClient.class, name = "userClient")
})
@Document("users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public abstract class UserDocument {

    @Id
    private String id;
    private String type;
    private String name;
    private LocalDateTime createDate;

}
