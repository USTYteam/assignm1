package com.ru.usty.elevator;

public class Person implements Runnable {
	
	//private ElevatorScene scene;
	int sourceFloor,destinationFloor; 
	public Person(int sourceFloor, int destinationFloor) {
		//this.scene = scene;
		this.sourceFloor = sourceFloor;
		this.destinationFloor = destinationFloor; 
	}
	
	
	
	/*public Person(ElevatorScene scene) {
		
	}*/
	
	@Override
	public void run() {
		
		try {
				ElevatorScene.elevatorWaitMutex.acquire();
				
					ElevatorScene.semaphore1.acquire();//wait
					
				ElevatorScene.elevatorWaitMutex.release();

				// TODO Auto-generated method stub
		
	}catch (InterruptedException e) {
		
		e.printStackTrace();
		
	} 
		//Person is through barrier
		ElevatorScene.scene.decrementNumberOfPeopleWaitingAtFloor(sourceFloor);
		ElevatorScene.scene.incrementNumberOfPeopleWaitingAtFloor(sourceFloor);

		System.out.println("Person Thread released");

  }
}