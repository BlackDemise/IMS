package org.example.interviewmanagement.enums;

import lombok.Getter;

@Getter
public enum EPosition {
    BACKEND_DEVELOPER("Backend Developer"),
    BUSINESS_ANALYST("Business Analyst"),
    TESTER("Tester"),
    HR("HR"),
    PROJECT_MANAGER("Project manager"),
    NOT_AVAILABLE("Not available");
    private final String positionTitle;

    EPosition(String positionTitle) {
        this.positionTitle = positionTitle;
    }
}
