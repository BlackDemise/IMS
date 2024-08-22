package org.example.interviewmanagement.enums;

import lombok.Getter;

@Getter
public enum ESkill {
    JAVA("Java"),
    NODEJS("Nodejs"),
    DOTNET(".net"),
    CPLUSPLUS("C++"),
    BUSINESS_ANALYSIS("Business analysis"),
    COMMUNICATION("Communication");
    private final String skillTitle;

    ESkill(String skillTitle) {
        this.skillTitle = skillTitle;
    }
}
