//package com.Project.config;
//
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//
//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
//	@Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        // Enable a simple broker to carry the messages back to the client
//        config.enableSimpleBroker("/topic");
//        // Prefix for outgoing messages
//        config.setApplicationDestinationPrefixes("/app");
//    }
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        // Register the WebSocket endpoint to connect clients
//        registry.addEndpoint("/ws").withSockJS();
//    }
//}
