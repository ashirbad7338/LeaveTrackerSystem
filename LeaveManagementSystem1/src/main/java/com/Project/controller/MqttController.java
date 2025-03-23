package com.Project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPubAck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Project.dto.MessageDTO;
import com.Project.entities.MqttPublishModel;
import com.Project.entities.MqttSubscribeModel;
import com.Project.service.MqttService;

@RestController
@RequestMapping(value="/api/mqtt")
public class MqttController {
//    @Autowired
//    private Mqtt mqtt;
//    
//    @PostMapping("publish")
//    public void publishMessage(@RequestBody @Valid MqttPublishModel messagePublishModel,
//                               BindingResult bindingResult) throws org.eclipse.paho.client.mqttv3.MqttException {
////        if (bindingResult.hasErrors()) {
////            throw new org.eclipse.paho.client.mqttv3.MqttException("Some parameters are invalid");
////        }
//
//        MqttMessage mqttMessage = new MqttMessage(messagePublishModel.getMessage().getBytes());
//        mqttMessage.setQos(messagePublishModel.getQos());
//        mqttMessage.setRetained(messagePublishModel.getRetained());
//
//        mqtt.publish(messagePublishModel.getTopic(), mqttMessage);
//    }
//
//    @GetMapping("subscribe")
//    public List<MqttSubscribeModel> subscribeChannel(@RequestParam(value = "topic") String topic,
//                                                     @RequestParam(value = "wait_millis") Integer waitMillis)
//            throws InterruptedException, org.eclipse.paho.client.mqttv3.MqttException {
//        List<MqttSubscribeModel> messages = new ArrayList<>();
//        CountDownLatch countDownLatch = new CountDownLatch(10);
//        mqtt.subscribeWithResponse(topic, (s, mqttMessage) -> {
//            MqttSubscribeModel mqttSubscribeModel = new MqttSubscribeModel();
//            mqttSubscribeModel.setId(mqttMessage.getId());
//            mqttSubscribeModel.setMessage(new String(mqttMessage.getPayload()));
//            mqttSubscribeModel.setQos(mqttMessage.getQos());
//            messages.add(mqttSubscribeModel);
//            countDownLatch.countDown();
//        });
//
//        countDownLatch.await(waitMillis, TimeUnit.MILLISECONDS);
//
//        return messages;
//    }

	@Autowired
	private MqttService mqttService;

	@PutMapping("/start")
	public String startMqtt() {
		return null;
	}

	@PostMapping("/publish")
	public String publish(@RequestBody MessageDTO messageDTO) {
		try {
			mqttService.publish(messageDTO.getTopic(), messageDTO.getMessage());
		} catch (MqttException e) {
			e.printStackTrace();
		}
		return "Success";
	}
}