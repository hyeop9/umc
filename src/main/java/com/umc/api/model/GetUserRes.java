package com.umc.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class GetUserRes {
    private int userIdx;
    private String userName;
    private String ID;
    private String password;
    private String email;
}
