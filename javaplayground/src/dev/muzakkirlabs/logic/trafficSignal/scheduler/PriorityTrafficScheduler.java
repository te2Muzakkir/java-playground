package dev.muzakkirlabs.logic.trafficSignal.scheduler;

import dev.muzakkirlabs.logic.trafficSignal.entity.EmergencyRequest;
import dev.muzakkirlabs.logic.trafficSignal.enums.Direction;
import dev.muzakkirlabs.logic.trafficSignal.service.EmergencyService;

public class PriorityTrafficScheduler implements TrafficScheduler {

	private final RoundRobinScheduler roundRobinScheduler;
    private final EmergencyService emergencyService;

    public PriorityTrafficScheduler(RoundRobinScheduler roundRobinScheduler,
                                    EmergencyService emergencyService) {
        this.roundRobinScheduler = roundRobinScheduler;
        this.emergencyService = emergencyService;
    }

    @Override
    public Direction getNextDirection() {
        if (emergencyService.hasEmergency()) {
            EmergencyRequest emergencyRequest = emergencyService.resolveEmergency();
            System.out.println();
            System.out.println("======================================");
            System.out.println("EMERGENCY DETECTED");
            System.out.println("--------------------------------------");
            System.out.println("Type      : " + emergencyRequest.getType());
            System.out.println("Direction : " + emergencyRequest.getDirection());
            System.out.println("======================================");
            System.out.println();
            return emergencyRequest.getDirection();
        }
        return roundRobinScheduler.getNextDirection();
    }

}