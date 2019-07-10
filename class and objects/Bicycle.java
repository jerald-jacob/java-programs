/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bicycle;

/**
 *
 * @author jerald
 */
public class Bicycle{
	public static void main(String[] args) {	
BicycleClass Bicycle1=new BicycleClass();
Bicycle1.ChangeGear(2);
Bicycle1.ChangeSpeed(20);
Bicycle1.ApplyBreak(30);
Bicycle1.CurrentStatus();

		}
}
	class BicycleClass{
		int gear=1;
		int speed=40;
	void ChangeGear(int NewGear){
	gear+=NewGear;
	}
	void ChangeSpeed(int NewSpeed){
	speed+=NewSpeed;
	}
	void ApplyBreak(int DesressSpeed){
	speed-=DesressSpeed;
	}
	void CurrentStatus(){
	System.out.println("Gear "+gear+" speed "+speed);
	}
}
	
