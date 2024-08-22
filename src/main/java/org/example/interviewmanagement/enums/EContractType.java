package org.example.interviewmanagement.enums;

import lombok.Getter;

@Getter
public enum EContractType {
    TRIAL_TWO_MONTHS("Trial 2 months"),
    TRAINEE_THREE_MONTHS("Trainee 3 months"),
    ONE_YEAR("1 year"),
    THREE_YEARS("3 years"),
    UNLIMITED("Unlimited");
    private final String contractTypeTitle;

    EContractType(String contractTypeTitle) {
        this.contractTypeTitle = contractTypeTitle;
    }
}
