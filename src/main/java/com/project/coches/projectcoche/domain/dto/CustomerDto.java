package com.project.coches.projectcoche.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    private String cardId;
    private String fullName;
    private  String email;
    private  Integer numberCellphone;
    private Integer active;
    private String password;

    @Override
    public String toString() {
        return "CustomerDto{" +
                "cardId='" + cardId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", numberCellphone=" + numberCellphone +
                ", active=" + active +
                ", password='" + password + '\'' +
                '}';
    }
}
