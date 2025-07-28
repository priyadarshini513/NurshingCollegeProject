package com.college.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.college.Entity.Notification;
import com.college.Repository.NotificationRepository;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
	@Autowired
    private NotificationRepository notificationRepository;

    @GetMapping
    public List<Notification> getLatestNotifications() {
        return notificationRepository.findTop5ByOrderByCreatedAtDesc();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNotification(@RequestParam String message) {
        Notification notif = new Notification();
        notif.setMessage(message);
        notificationRepository.save(notif);
        return ResponseEntity.ok("Saved");
    }

}
