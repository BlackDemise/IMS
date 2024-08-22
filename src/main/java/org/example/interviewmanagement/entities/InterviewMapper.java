package org.example.interviewmanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "InterviewMapper")
public class InterviewMapper {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "interviewId", foreignKey = @ForeignKey(name = "FK_INTERVIEW"))
    private Interview interview;


    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "interviewerID", foreignKey = @ForeignKey(name = "FK_INTERVIEWER_USER"))
    private User user;
}
