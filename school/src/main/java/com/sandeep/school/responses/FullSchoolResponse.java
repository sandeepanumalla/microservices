package com.sandeep.school.responses;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FullSchoolResponse {

    private Integer id;
    private String name;
    private String email;
    private List<Student> studentList;
}
