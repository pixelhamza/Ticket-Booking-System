package com.ticketbooking.bridge;

/**
 * ============================================================================
 * DESIGN PATTERN: BRIDGE (Concrete Implementor: SmsSender)
 * ============================================================================
 * Handles transmission of short messages over cellular SMS gateways.
 */
public class SmsSender implements NotificationSender {

    @Override
    public void sendMessage(String message) {
        System.out.println("SMS: " + message);
    }
}