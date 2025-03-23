//package com.Project.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class NotificationService {
//	
//	@Autowired
//	private SimpMessagingTemplate messagingTemplate;
//	public void sendLeaveNotification(String manager, String message) {
//	        messagingTemplate.convertAndSendToUser(manager, "/topic/leave-notifications", message);
//	}
//
//}
