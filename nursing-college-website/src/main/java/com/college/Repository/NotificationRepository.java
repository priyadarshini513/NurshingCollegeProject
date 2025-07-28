package com.college.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.Entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
	 List<Notification> findTop5ByOrderByCreatedAtDesc();
}
