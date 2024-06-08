package com.ra.model.dto.respone;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
    private Long id;
    private String userName;
    private String address;
}
