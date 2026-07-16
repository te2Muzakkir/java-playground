package dev.muzakkirlabs.logic.atm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.muzakkirlabs.logic.entity.Customer;

public class AutomatedTellerMachine {

	public static void main(String[] args) {
		Customer customer = new Customer("Customer1", 5000.0);
		String message = withDrawAmount(customer, 1000);
		System.out.println(message);
	}
	
	public static String withDrawAmount(Customer customer, double amountToBeDeducted) {
		if(amountToBeDeducted <= 0)
			return "Invalid Amount Entered";
		if(customer.getBalance() < amountToBeDeducted)
			return "Insufficient balance";
		if(amountToBeDeducted%100 != 0)
			return "Enter ammount in multiples of 100, 200 and 500";
		currencyDenomination(amountToBeDeducted);
		customer.setBalance(customer.getBalance() - amountToBeDeducted);
		return String.format("Hello, %s! Amount has been deducted and you remaining balance is: %s ", customer.getName(), customer.getBalance());
	}
	
	public static void currencyDenomination(double amountToBeDeducted) {
		Map<String, Integer> denominationCountMap = new HashMap<>();
		List<Integer> denominationList = new ArrayList<>(List.of(500, 200, 100)); //DB call to get denominations
		denominationList.sort(Collections.reverseOrder());
		for(Integer denomination : denominationList) {
			if(amountToBeDeducted == 0)
				break;
			int count = (int) (amountToBeDeducted / denomination);
			amountToBeDeducted = amountToBeDeducted % denomination;
            if (count > 0) 
            	denominationCountMap.put(denomination.toString(), count);
		}
		System.out.println(denominationCountMap);
	}

}