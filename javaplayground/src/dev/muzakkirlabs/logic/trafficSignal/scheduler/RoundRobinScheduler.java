package dev.muzakkirlabs.logic.trafficSignal.scheduler;

import java.util.ArrayDeque;
import java.util.Queue;

import dev.muzakkirlabs.logic.trafficSignal.enums.Direction;

public class RoundRobinScheduler implements TrafficScheduler {

	private final Queue<Direction> directionQueue = new ArrayDeque<>();

	public RoundRobinScheduler() {
		initialize();
	}

	private void initialize() {
		for (Direction direction : Direction.values()) {
			directionQueue.offer(direction);
		}
	}

	@Override
	public Direction getNextDirection() {
		if (directionQueue.isEmpty()) 
			throw new IllegalStateException("No directions available.");
		Direction nextDirection = directionQueue.poll();
		directionQueue.offer(nextDirection);
		return nextDirection;
	}

	public void reset() {
		directionQueue.clear();
		initialize();
	}

}