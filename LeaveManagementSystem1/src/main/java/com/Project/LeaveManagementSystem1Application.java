package com.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Project.service.MqttService;

@SpringBootApplication
public class LeaveManagementSystem1Application {
	
	@Autowired
	private MqttService mqtt;

	public static void main(String[] args) {
		SpringApplication.run(LeaveManagementSystem1Application.class, args);
	}
	
	
	public void run(String...args) throws Exception{
		mqtt.startMqtt();
	}
	


}
