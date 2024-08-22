package org.example.interviewmanagement.enums;

import lombok.Getter;

@Getter
public enum EBenefit {
    LUNCH("Lunch"),
    TWENTY_FIVE_DAY_LEAVE("25-day leave"),
    HEALTHCARE_INSURANCE("Healthcare insurance"),
    HYBRID_WORKING("Hybrid working"),
    TRAVEL("Travel");
    private final String benefitTitle;

    EBenefit(String benefitTitle) {
        this.benefitTitle = benefitTitle;
    }
}
