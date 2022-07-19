package com.example.workflow;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class BookFlightTicket implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		
		String money="0.0";
		String ticketType="economyClass";
		
		money = (String) execution.getVariable("budget");
		double budget=Double.parseDouble(money);
		
		if(budget<=100) {
			ticketType="economyClass";
		}
		else if(budget>100 && budget<500) {
			ticketType="businessClass";
		}else {
			ticketType="firstClass";
		}
		execution.setVariable(ticketType, ticketType);
	}
}
