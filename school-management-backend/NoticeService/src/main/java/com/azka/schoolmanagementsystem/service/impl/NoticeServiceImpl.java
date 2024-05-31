package com.azka.schoolmanagementsystem.service.impl;

import com.azka.schoolmanagementsystem.entity.NoticeEntity;
import com.azka.schoolmanagementsystem.repository.NoticeRepository;
import com.azka.schoolmanagementsystem.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public NoticeEntity createNotice(NoticeEntity noticeEntity) {
        return noticeRepository.save(noticeEntity);
    }

    @Override
    public List<NoticeEntity> getAllNotices() {
        return noticeRepository.findAll();
    }

    @Override
    public NoticeEntity getNoticeById(Long id) {
        return noticeRepository.findById(id).orElse(null);
    }

    @Override
    public NoticeEntity updateNotice(Long id, NoticeEntity updatedNotice) {
        NoticeEntity existingNotice = noticeRepository.findById(id).orElse(null);
        if (existingNotice != null) {
            existingNotice.setNoticeTitle(updatedNotice.getNoticeTitle());
            existingNotice.setNoticeDescription(updatedNotice.getNoticeDescription());
            existingNotice.setNoticeFor(updatedNotice.getNoticeFor());
            return noticeRepository.save(existingNotice);
        }
        return null;
    }

    @Override
    public void deleteNotice(Long id) {
        NoticeEntity notice = noticeRepository.findById(id).orElse(null);
        if (notice != null) {
            noticeRepository.delete(notice);
        }
    }
}