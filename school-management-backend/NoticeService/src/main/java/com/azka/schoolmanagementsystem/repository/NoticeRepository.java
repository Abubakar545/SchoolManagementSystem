package com.azka.schoolmanagementsystem.repository;


import com.azka.schoolmanagementsystem.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {
}