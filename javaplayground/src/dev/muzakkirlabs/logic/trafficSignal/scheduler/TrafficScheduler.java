package dev.muzakkirlabs.logic.trafficSignal.scheduler;

import dev.muzakkirlabs.logic.trafficSignal.enums.Direction;

public interface TrafficScheduler {
	
	Direction getNextDirection();

}