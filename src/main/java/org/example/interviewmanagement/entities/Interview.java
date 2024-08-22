package org.example.interviewmanagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Interviews")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interviewID;
    @Column
    private String interviewScheduleTitle;
    @Column
    private LocalDate interviewSchedule;
    @Column(name = "interview_schedule_from")
    private Time interviewScheduleFrom;

    @Column(name = "interview_schedule_to")
    private Time interviewScheduleTo;

    @Column(name = "interview_location")
    private String interviewLocation;

    @Column(name = "interview_meetingid")
    private String interviewMeetingId;

    @Column(name = "interview_note")
    private String interviewNote;

    @Column(name = "interview_result")
    private String interviewResult;

    //(user vs interview  ) many to many => ( interview Mapper)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "interview")
    @ToString.Exclude
    private List<InterviewMapper> interviewMappers;

    //Job vs Interview
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "interviews_job_id", foreignKey = @ForeignKey(name = "FK_INTERVIEW_JOB"))
    private Job job;


// interview vs candidate
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "interview_candidate_id", foreignKey = @ForeignKey(name = "FK_CANDIDATE_INTERVIEW"))
    private Candidate candidate;

// offer vs interview
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "interview")
    @ToString.Exclude
    private List<Offer> offers;

 // user vs interview
     @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
     @JoinColumn(name = "interview_recruiter_id", foreignKey = @ForeignKey(name = "FK_USER_INTERVIEW"))
     private User user;
}
