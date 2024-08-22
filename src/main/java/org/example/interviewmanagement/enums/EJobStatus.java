package org.example.interviewmanagement.enums;

import lombok.Getter;

@Getter
public enum EJobStatus {
    DRAFT("Draft"),
    OPEN("Open"),
    CLOSED("Closed");
    private final String jobStatusTitle;

    EJobStatus(String jobStatusTitle) {
        this.jobStatusTitle = jobStatusTitle;
    }
}
