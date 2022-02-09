package com.coderhouse.model.request;

import lombok.*;

import javax.validation.constraints.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "El campo type no puede vacio")
    @Pattern(regexp = "^(admin|editor|client)$", message = "Solo acepta: admin, editor, client")
    private String type;
    private String name;
}
