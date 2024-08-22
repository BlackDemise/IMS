package org.example.interviewmanagement.enums;

import lombok.Getter;

@Getter
public enum EDepartment {
    IT("IT"),
    HR("HR"),
    FINANCE("Finance"),
    COMMUNICATION("Communication"),
    MARKETING("Marketing"),
    ACCOUNTING("Accounting");
    private final String departmentName;

    EDepartment(String departmentName) {
        this.departmentName = departmentName;
    }
}
