package org.example.interviewmanagement.enums;

import lombok.Getter;

@Getter
public enum EInterviewStatus {
    NEW("New"),
    INVITED("Invited"),
    INTERVIEWED("Interviewed"),
    CANCELLED("Cancelled");
    private final String interviewStatusTitle;

    EInterviewStatus(String interviewStatusTitle) {
        this.interviewStatusTitle = interviewStatusTitle;
    }
}
