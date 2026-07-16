package dev.muzakkirlabs.logic.trafficSignal.controller;

import dev.muzakkirlabs.logic.trafficSignal.TrafficController;
import dev.muzakkirlabs.logic.trafficSignal.entity.Intersection;
import dev.muzakkirlabs.logic.trafficSignal.enums.Direction;
import dev.muzakkirlabs.logic.trafficSignal.enums.EmergencyType;
import dev.muzakkirlabs.logic.trafficSignal.scheduler.PriorityTrafficScheduler;
import dev.muzakkirlabs.logic.trafficSignal.scheduler.RoundRobinScheduler;
import dev.muzakkirlabs.logic.trafficSignal.service.EmergencyService;

public class TrafficSignalApplication {
	
	public static void main(String[] args) {
		Intersection intersection = new Intersection("Main Junction");
        EmergencyService emergencyService = new EmergencyService();
        emergencyService.raiseEmergency(Direction.WEST, EmergencyType.AMBULANCE);
        emergencyService.raiseEmergency(Direction.SOUTH, EmergencyType.FIRE_TRUCK);
        RoundRobinScheduler roundRobinScheduler = new RoundRobinScheduler();
        PriorityTrafficScheduler scheduler = new PriorityTrafficScheduler(roundRobinScheduler, emergencyService);
        TrafficController controller = new TrafficController(intersection, scheduler);
        controller.startSimulation();
    }

}