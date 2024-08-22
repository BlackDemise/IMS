package org.example.interviewmanagement.enums;

import lombok.Getter;

@Getter
public enum EHighestLevel {
    HIGH_SCHOOL("High school"),
    BACHELOR_DEGREE("Bachelor's Degree"),
    MASTER_DEGREE_PHD("Master Degree, PhD");
    private final String highestLevelTitle;

    EHighestLevel(String highestLevelTitle) {
        this.highestLevelTitle = highestLevelTitle;
    }
}
