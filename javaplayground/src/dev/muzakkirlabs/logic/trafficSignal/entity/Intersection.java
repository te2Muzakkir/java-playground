package dev.muzakkirlabs.logic.trafficSignal.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dev.muzakkirlabs.logic.trafficSignal.enums.Direction;
import dev.muzakkirlabs.logic.trafficSignal.enums.SignalState;

public class Intersection {
	
	private final String name;
    private final List<TrafficSignal> trafficSignals;
    
    public Intersection(String name) {
        this.name = name;
        this.trafficSignals = new ArrayList<>();
        initializeSignals();
    }

    private void initializeSignals() {
        for (Direction direction : Direction.values()) 
            trafficSignals.add(new TrafficSignal(direction));
    }

    public String getName() {
        return name;
    }

    public List<TrafficSignal> getTrafficSignals() {
        return Collections.unmodifiableList(trafficSignals);
    }

    public TrafficSignal getSignal(Direction direction) {
        for (TrafficSignal signal : trafficSignals) {
            if (signal.getDirection() == direction)
                return signal;
        }
        throw new IllegalArgumentException("No signal found for direction : " + direction);
    }

    public void resetSignals() {
    	trafficSignals.forEach(s -> s.setSignalState(SignalState.RED));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Intersection : ").append(name).append(System.lineSeparator());
        for (TrafficSignal signal : trafficSignals) 
            builder.append(signal).append(System.lineSeparator());
        return builder.toString();
    }

}