package com.azka.schoolmanagementsystem.service;

import com.azka.schoolmanagementsystem.entity.NoticeEntity;

import java.util.List;

public interface NoticeService {
    NoticeEntity createNotice(NoticeEntity noticeEntity);

    List<NoticeEntity> getAllNotices();

    NoticeEntity getNoticeById(Long id);

    NoticeEntity updateNotice(Long id, NoticeEntity updatedNotice);

    void deleteNotice(Long id);
}