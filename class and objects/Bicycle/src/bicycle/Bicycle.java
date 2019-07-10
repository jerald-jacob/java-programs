/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicycle;

/**
 *
 * @author jerald
 */
public class Bicycle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
pulsar newobj=new pulsar();
    newobj.changegear(2);
    newobj.changeSpeed(50);
    newobj.upspeed(30);
    newobj.applybrike(55,2);
    newobj.status();
    }
    
}
interface BicycleMain{
    void changeSpeed(int newvalue);
    void changegear(int newvale);
    void upspeed(int increment);
    void applybrike(int decrement,int newgear);
}
class pulsar implements BicycleMain{
    int speed=50;
    int gear=1;

    @Override
    public void changeSpeed(int newvalue) {
        speed=speed+newvalue;
       
    }

    @Override
    public void changegear(int newvale) {
       gear=gear+newvale;
    }

    @Override
    public void upspeed(int increment) {
       speed=speed+increment; 
    }

    @Override
    public void applybrike(int decrement,int newgear) {
        speed=speed-decrement;
        gear=gear-newgear;
    }
    public void status(){
        System.out.println("speed "+speed);
        System.out.println("Gear "+gear);
    }
    
}