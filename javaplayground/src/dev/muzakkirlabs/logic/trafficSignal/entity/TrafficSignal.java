package dev.muzakkirlabs.logic.trafficSignal.entity;

import dev.muzakkirlabs.logic.trafficSignal.enums.Direction;
import dev.muzakkirlabs.logic.trafficSignal.enums.SignalState;

public class TrafficSignal {
	
	private Direction direction;
    private SignalState signalState;

    public TrafficSignal(Direction direction) {
        this.direction = direction;
        this.signalState = SignalState.RED;
    }

    public Direction getDirection() {
        return direction;
    }

    public SignalState getSignalState() {
        return signalState;
    }

    public void setSignalState(SignalState signalState) {
        this.signalState = signalState;
    }

    public void turnGreen() {
        signalState = SignalState.GREEN;
    }

    public void turnYellow() {
        signalState = SignalState.YELLOW;
    }

    public void turnRed() {
        signalState = SignalState.RED;
    }
    
    public boolean isGreen() {
        return signalState == SignalState.GREEN;
    }

    public boolean isYellow() {
        return signalState == SignalState.YELLOW;
    }

    public boolean isRed() {
        return signalState == SignalState.RED;
    }

    @Override
    public String toString() {
        return String.format("%-5s : %s", direction, signalState);
    }

}