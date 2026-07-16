package dev.muzakkirlabs.logic.trafficSignal;

import dev.muzakkirlabs.logic.trafficSignal.entity.Intersection;
import dev.muzakkirlabs.logic.trafficSignal.enums.Direction;
import dev.muzakkirlabs.logic.trafficSignal.scheduler.TrafficScheduler;
import dev.muzakkirlabs.logic.trafficSignal.service.DisplayService;
import dev.muzakkirlabs.logic.trafficSignal.service.SignalService;

public class TrafficController {
	
	private static final int GREEN_DURATION = 10;
    private static final int YELLOW_DURATION = 3;

    private final Intersection intersection;
    private final TrafficScheduler scheduler;
    private final SignalService signalService;
    private final DisplayService displayService;

    public TrafficController(Intersection intersection, TrafficScheduler scheduler) {
        this.intersection = intersection;
        this.scheduler = scheduler;
        this.signalService = new SignalService();
        this.displayService = new DisplayService();
    }

    public void startSimulation() {
        displayService.displaySimulationStarted();
        while (true) {
            Direction direction = scheduler.getNextDirection();
            runGreenPhase(direction);
            runYellowPhase(direction);
        }
    }

    private void runGreenPhase(Direction direction) {
        signalService.activateGreenSignal(intersection, direction);
        displayService.displayPhase("GREEN (" + GREEN_DURATION + " Seconds)");
        displayService.displayActiveSignal(
                signalService.getSignal(intersection, direction));
        displayService.displayIntersection(intersection);
        waitFor(GREEN_DURATION);
    }

    private void runYellowPhase(Direction direction) {
        signalService.activateYellowSignal(intersection, direction);
        displayService.displayPhase("YELLOW (" + YELLOW_DURATION + " Seconds)");
        displayService.displayActiveSignal(
                signalService.getSignal(intersection, direction));
        displayService.displayIntersection(intersection);
        waitFor(YELLOW_DURATION);
    }

    private void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
}