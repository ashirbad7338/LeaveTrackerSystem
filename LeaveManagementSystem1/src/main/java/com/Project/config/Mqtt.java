//package com.Project.config;
//
//import org.eclipse.paho.client.mqttv3.IMqttClient;
//import org.eclipse.paho.client.mqttv3.MqttCallback;
//import org.eclipse.paho.client.mqttv3.MqttClient;
//import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
//import org.eclipse.paho.client.mqttv3.MqttException;
//import org.eclipse.paho.client.mqttv3.MqttMessage;
//
//public class Mqtt {
//	private static final String MQTT_PUBLISHER_ID = "spring-server";
//    private static final String MQTT_SERVER_ADDRES= "tcp://127.0.0.1:1883";
//    private static IMqttClient instance;
//    public static IMqttClient getInstance() {
//        try {
//            if (instance == null) {
//                instance = new MqttClient(MQTT_SERVER_ADDRES, MQTT_PUBLISHER_ID);
//            }
//
//            MqttConnectOptions options = new MqttConnectOptions();
//            options.setAutomaticReconnect(true);
//            options.setCleanSession(true);
//            options.setConnectionTimeout(10);
//
//            if (!instance.isConnected()) {
//                instance.connect(options);
//            }
//        } catch (MqttException e) {
//            e.printStackTrace();
//        }
//
//        return instance;
//    }
//    public static void publish(String topic, MqttMessage message) throws MqttException {
////         if(instance == null || !instance.isConnected()) {
////             throw new MqttException("MQTT client is not connected");
////         }
//         instance.publish(topic, message);
//     }
//
//    public static void subscribeWithResponse(String topic, MqttCallback callback) throws MqttException {
//        if (instance == null || !instance.isConnected()) {
//            throw new MqttException("MQTT client is not connected");
//        }
//        private Mqtt() {
//        // Private constructor to prevent instantiation
//    }
//   
//
//}
