package com.azka.schoolmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notice")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "notice_title")
    private String noticeTitle;

    @Column(name = "notice_description")
    private String noticeDescription;

    @Column(name = "notice_for")
    private String noticeFor; // e.g., "all", "teacher", "student"
}