package dev.muzakkirlabs.logic.trafficSignal.service;

import dev.muzakkirlabs.logic.trafficSignal.entity.Intersection;
import dev.muzakkirlabs.logic.trafficSignal.entity.TrafficSignal;

public class DisplayService {
	
	public void displayIntersection(Intersection intersection) {
        printHeader(intersection);
        for (TrafficSignal signal : intersection.getTrafficSignals()) {
            printSignal(signal);
        }
        printFooter();
    }

    public void displayPhase(String phase) {
        System.out.println();
        System.out.println("Current Phase : " + phase);
        System.out.println();
    }

    public void displayActiveSignal(TrafficSignal signal) {
        System.out.println("----------------------------------------");
        System.out.println("Active Direction : " + signal.getDirection());
        System.out.println("Current State    : " + signal.getSignalState());
        System.out.println("----------------------------------------");
    }

    public void displaySimulationStarted() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("     TRAFFIC SIGNAL SIMULATION STARTED");
        System.out.println("========================================");
        System.out.println();
    }

    public void displaySimulationStopped() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("     TRAFFIC SIGNAL SIMULATION STOPPED");
        System.out.println("========================================");
    }

    private void printHeader(Intersection intersection) {
        System.out.println();
        System.out.println("========================================");
        System.out.println("Intersection : " + intersection.getName());
        System.out.println("========================================");
    }

    private void printSignal(TrafficSignal signal) {
        System.out.printf("%-10s : %-10s%n", signal.getDirection(), signal.getSignalState());
    }

    private void printFooter() {
        System.out.println("========================================");
        System.out.println();
    }

}