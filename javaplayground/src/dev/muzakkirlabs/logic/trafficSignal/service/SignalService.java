package dev.muzakkirlabs.logic.trafficSignal.service;

import dev.muzakkirlabs.logic.trafficSignal.entity.Intersection;
import dev.muzakkirlabs.logic.trafficSignal.entity.TrafficSignal;
import dev.muzakkirlabs.logic.trafficSignal.enums.Direction;
import dev.muzakkirlabs.logic.trafficSignal.enums.SignalState;

public class SignalService {

	public void activateGreenSignal(Intersection intersection, Direction direction) {
		intersection.resetSignals();
		TrafficSignal signal = intersection.getSignal(direction);
		signal.setSignalState(SignalState.GREEN);
	}

	public void activateYellowSignal(Intersection intersection, Direction direction) {
		intersection.resetSignals();
		TrafficSignal signal = intersection.getSignal(direction);
		signal.setSignalState(SignalState.YELLOW);
	}

	public void activateRedSignal(Intersection intersection, Direction direction) {
		TrafficSignal signal = intersection.getSignal(direction);
		signal.setSignalState(SignalState.RED);
	}

	public void resetAllSignals(Intersection intersection) {
		intersection.resetSignals();
	}

	public TrafficSignal getSignal(Intersection intersection, Direction direction) {
		return intersection.getSignal(direction);
	}

	public boolean isGreen(Intersection intersection, Direction direction) {
		return getSignal(intersection, direction).isGreen();
	}

	public boolean isYellow(Intersection intersection, Direction direction) {
		return getSignal(intersection, direction).isYellow();
	}

	public boolean isRed(Intersection intersection, Direction direction) {
		return getSignal(intersection, direction).isRed();
	}

}