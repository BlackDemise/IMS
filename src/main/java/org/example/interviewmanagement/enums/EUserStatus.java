package org.example.interviewmanagement.enums;

import lombok.Getter;

@Getter
public enum EUserStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive");
    private final String userStatusTitle;

    EUserStatus(String userStatusTitle) {
        this.userStatusTitle = userStatusTitle;
    }
}
