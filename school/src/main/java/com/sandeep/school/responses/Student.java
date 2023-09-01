package com.sandeep.school.responses;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private String email;
}
