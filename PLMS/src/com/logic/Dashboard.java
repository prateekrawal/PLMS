package com.logic;

public class Dashboard {

	// if trigger pressed Trigger()
	public void start() {
		Trigger trigger = new Trigger();
		trigger.start();

		Market market = new Market();
		market.start();

		// array list not to be sent from here. it will come from dao class in body of
		// this func
	}
}