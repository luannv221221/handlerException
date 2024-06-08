package com.ra.model.dto.request;

import com.ra.validation.UserUnique;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserRequestDTO {
    private Long id;
    @NotBlank
    @UserUnique
    private String userName;
    private String address;
    @NotBlank
    @Length(min = 3,max = 255)
    private String password;
}
