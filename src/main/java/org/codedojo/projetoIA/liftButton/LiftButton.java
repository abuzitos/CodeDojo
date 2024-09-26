package org.codedojo.projetoIA.liftButton;

/**
 * Define a LiftButton class.
 * Add a boolean field lightOn to track the state of the light.
 * Add a boolean field doorsOpen to track the state of the lift doors.
 * Implement a method pressButton():
 *      - If doorsOpen is true, do nothing.
 *      - If lightOn is false, set lightOn to true.
 * Implement a method liftArrives():
 *      - Set doorsOpen to true.
 *      - Set lightOn to false.
 * Implement a method doorsClose():
 *      - Set doorsOpen to false.
 */
public class LiftButton {
    private boolean lightOn;
    private boolean doorsOpen;

    public LiftButton() {
        this.lightOn = false;
        this.doorsOpen = false;
    }

    public void pressButton() {
        if (!doorsOpen && !lightOn) {
            lightOn = true;
        }
    }

    public void liftArrives() {
        doorsOpen = true;
        lightOn = false;
    }

    public void doorsClose() {
        doorsOpen = false;
    }

    public boolean isLightOn() {
        return lightOn;
    }

    public boolean areDoorsOpen() {
        return doorsOpen;
    }
}