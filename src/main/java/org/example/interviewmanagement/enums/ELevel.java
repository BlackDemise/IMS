package org.example.interviewmanagement.enums;

import lombok.Getter;

@Getter
public enum ELevel {
    FRESHER("Fresher"),
    JUNIOR("Junior"),
    SENIOR("Senior"),
    LEADER("Leader"),
    MANAGER("Manager"),
    VICE_HEAD("Vice Head");
    private final String levelTitle;

    ELevel(String levelTitle) {
        this.levelTitle = levelTitle;
    }
}
