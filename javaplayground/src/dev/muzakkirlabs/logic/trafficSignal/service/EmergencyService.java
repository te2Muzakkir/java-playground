package dev.muzakkirlabs.logic.trafficSignal.service;

import java.util.LinkedList;
import java.util.Queue;

import dev.muzakkirlabs.logic.trafficSignal.entity.EmergencyRequest;
import dev.muzakkirlabs.logic.trafficSignal.enums.Direction;
import dev.muzakkirlabs.logic.trafficSignal.enums.EmergencyType;

public class EmergencyService {
	
	private final Queue<EmergencyRequest> emergencyQueue;

    public EmergencyService() {
        emergencyQueue = new LinkedList<>();
    }

    public void raiseEmergency(Direction direction, EmergencyType emergencyType) {
        EmergencyRequest emergencyRequest = new EmergencyRequest(direction, emergencyType);
        emergencyQueue.offer(emergencyRequest);
    }

    public EmergencyRequest getNextEmergency() {
        return emergencyQueue.peek();
    }

    public EmergencyRequest resolveEmergency() {
        return emergencyQueue.poll();
    }

    public boolean hasEmergency() {
        return !emergencyQueue.isEmpty();
    }

    public int getPendingEmergencyCount() {
        return emergencyQueue.size();
    }

    public void clearAllEmergencies() {
        emergencyQueue.clear();
    }

    public Queue<EmergencyRequest> getAllEmergencies() {
        return new LinkedList<>(emergencyQueue);
    }

}