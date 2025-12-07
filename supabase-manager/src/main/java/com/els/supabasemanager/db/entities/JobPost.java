package com.els.supabasemanager.db.entities;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "job_offer")
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "description")
    private String description;

    @Column(name = "salary")
    private String salary;

    @Column(name = "company")
    private String company;

    @Column(name = "spanish_level")
    private String spanishLevel;

    @Column(name = "english_level")
    private String englishLevel;

    @Column(name = "tags")
    private String tags;
    @Column(name = "work_style")
    private String workStyle;

    @NotNull
    @Column(name = "posted_by")
    private String postedBy;

    @Column(name = "link")
    private String link;

    @NotNull
    @Column(name = "created_at", insertable = false, updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "location")
    private String location;

    @Column(name = "responsibilities")
    private String responsibilities;

    @Column(name = "requirements")
    private String requirements;

    @Column(name = "nice_to_have")
    private String niceToHave;

    @Column(name = "response_way")
    private String responseWay;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @NotNull
    @Column(name = "visa_status")
    private String visaStatus;

    @NotNull
    @Column(name = "response_wanted_type")
    private String responseWantedType;

    @Column(name = "deprecated")
    private boolean deprecated;

    public JobPost() {
    }

}
