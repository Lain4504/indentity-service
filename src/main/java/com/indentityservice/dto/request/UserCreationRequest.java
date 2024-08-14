package com.indentityservice.dto.request;

import com.indentityservice.exception.ErrorCode;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
//@Getter
//@Setter
//tu dong tao method getter, setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 3, message = "USERNAME_INVALID")
     String username;
    @Size(min = 8, message = "PASSWORD_INVALID")
     String password;
     String firstname;
     String lastname;
     LocalDate doB;
}
