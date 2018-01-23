package org.usfirst.frc.team5924.robot;

import edu.wpi.first.wpilibj.Solenoid;

public class MySolenoid {
    private Solenoid firstPort;
    private Solenoid secondPort;

    private boolean doublek = false;

    /*
     * For a one-solenoid system
     */
    public MySolenoid(int port) {
        firstPort = new Solenoid(8, port);
        doublek = false;
        System.out.println("MySolenoid enabled on port " + port);
    }

    /*
     * For a double solenoid system
     */
    public MySolenoid(int port1, int port2) {
        doublek = true;
        firstPort = new Solenoid(8, port1);
        secondPort = new Solenoid(8, port2);
        System.out.println("Double MySolenoid enabled on ports " + port1 + " and " + port2);
    }

    /*
     * Extends the solenoid
     */
    public void extend() {
        firstPort.set(true);

        if(doublek) {
            secondPort.set(false);
        }
    }

    /*
     * Retracts the solenoid
     */
    public void retract() {
        firstPort.set(false);

        if(doublek) {
            secondPort.set(true);
        }
    }

    /*
     * Gets the state of the first solenoid
     */
    public boolean get() {
        return this.firstPort.get();
    }

    /*
     * Gets the state of the other solenoid
     */
    public boolean getOther() {
        return this.secondPort.get();
    }
}
