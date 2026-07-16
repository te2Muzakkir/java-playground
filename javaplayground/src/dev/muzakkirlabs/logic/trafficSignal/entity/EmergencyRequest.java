package dev.muzakkirlabs.logic.trafficSignal.entity;

import java.time.LocalDateTime;

import dev.muzakkirlabs.logic.trafficSignal.enums.Direction;
import dev.muzakkirlabs.logic.trafficSignal.enums.EmergencyType;

public class EmergencyRequest {
	
	private final Direction direction;
    private final EmergencyType type;
    private final LocalDateTime requestTime;

    public EmergencyRequest(Direction direction, EmergencyType type) {
        this.direction = direction;
        this.type = type;
        this.requestTime = LocalDateTime.now();
    }

    public Direction getDirection() {
        return direction;
    }

    public EmergencyType getType() {
        return type;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    @Override
    public String toString() {
        return "EmergencyRequest{" +
                "direction=" + direction +
                ", type=" + type +
                ", requestTime=" + requestTime +
                '}';
    }

}