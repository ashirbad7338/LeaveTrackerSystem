package com.Project.service;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MqttService implements MqttCallback {

    private MqttClient client = null;
    private String mqttUserName = "";  // Empty username for anonymous access
    private String mqttPassword = "";  // Empty password for anonymous access
    private String mqttIpAddress = "localhost";  // Default IP address of MQTT broker
    private boolean mqttHaveCredential = false;  // No credentials needed for anonymous access
    private String mqttPort = "1883";  // Default MQTT port
//    private String mqttTopic = "topic/rest/project/";
    private String mqttTopic = "";
    Logger LOG = LoggerFactory.getLogger(getClass());

    @Override
    public void connectionLost(Throwable cause) {
        LOG.error("Connection lost: {}", cause.getMessage(), cause);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        try {
            LOG.info("Message delivery complete.");
        } catch (Exception e) {
            LOG.error("Error during delivery completion: {}", e.getMessage(), e);
        }
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        try {
            LOG.info("Message arrived on topic '{}': {}", topic, new String(message.getPayload()));
        } catch (Exception e) {
            LOG.error("Error while processing incoming message: {}", e.getMessage(), e);
        }
    }

    public void publish(String topicSuffix, String content) throws MqttException {
    	try (MqttClient client = new MqttClient("tcp://127.0.0.1:1883", MqttClient.generateClientId())) {
			MqttMessage message = new MqttMessage();
			message.setPayload(content.getBytes());
			message.setQos(2);  // QoS level 2 ensures message delivery exactly once

			try {
			    String topic = mqttTopic + topicSuffix;
			    client.publish(topic, message);  // Publish the message to the topic
			    LOG.info("Message published to topic '{}': {}", topic, content);
			} catch ( MqttException e) {
			    LOG.error("Error while publishing message: {}", e.getMessage(), e);
			} catch (Exception e) {
			    LOG.error("Unexpected error while publishing: {}", e.getMessage(), e);
			}
		}
    }

    public void startMqtt() {
        // Initialize MQTT client only if it's not initialized already
        if (client != null && client.isConnected()) {
            LOG.info("MQTT Client is already connected.");
            return;  // Prevent creating another connection if already connected
        }

        MemoryPersistence persistence = new MemoryPersistence();

        try {
            // Initialize MQTT client with connection parameters
//            client = new MqttClient("tcp://" + mqttIpAddress + ":" + mqttPort, MqttClient.generateClientId(), persistence);
            client = new MqttClient("tcp://127.0.0.1:1883", MqttClient.generateClientId(), persistence);

        } catch (MqttException e) {
            LOG.error("Error initializing MQTT client: {}", e.getMessage(), e);
            return;
        }

        MqttConnectOptions connectOptions = new MqttConnectOptions();
        connectOptions.setCleanSession(true);  // Ensures no state is retained across client connections
        connectOptions.setMaxInflight(3000);  // Limits the number of unacknowledged messages
        connectOptions.setAutomaticReconnect(true);  // Automatically reconnect on failure

        // No credentials required for anonymous access
        if (mqttHaveCredential) {
            connectOptions.setUserName(mqttUserName);  // Set username if credentials are provided
            connectOptions.setPassword(mqttPassword.toCharArray());  // Set password if credentials are provided
        }

        client.setCallback(this);  // Set callback to this class to handle messages and connection events

        try {
            // Connect to the broker
            IMqttToken mqttConnectionToken = client.connectWithResult(connectOptions);
            LOG.info("Connection status: {}", mqttConnectionToken.isComplete());

            // Subscribe to all topics (can be adjusted as needed)
            client.subscribe("#");
        } catch (MqttException e) {
            LOG.error("Error connecting to MQTT broker: {}", e.getMessage(), e);
        }
    }
}
