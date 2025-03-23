package com.Project.entities;

import javax.validation.constraints.Size;
import jakarta.persistence.Column;

public class MqttPublishModel {
	 	@Column(nullable=false)
	    @Size(min = 1,max = 255)
	    private String topic;

	 	@Column(nullable=false)
	    @Size(min = 1,max = 255)
	    private String message;

	 	@Column(nullable=false)
	    private Boolean retained;

	 	@Column(nullable=false)
	    private Integer qos;


	    public String getTopic() {
	        return topic;
	    }

	    public void setTopic(String topic) {
	        this.topic = topic;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public Boolean getRetained() {
	        return retained;
	    }

	    public void setRetained(Boolean retained) {
	        this.retained = retained;
	    }

	    public Integer getQos() {
	        return qos;
	    }

	    public void setQos(Integer qos) {
	        this.qos = qos;
	    }


}
