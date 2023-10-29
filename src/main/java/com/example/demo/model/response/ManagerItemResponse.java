package com.example.demo.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerItemResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private Long seniorVpId;
    private Long teamId;
}
