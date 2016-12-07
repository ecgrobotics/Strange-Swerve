package org.usfirst.frc.team1533.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * Wrapper for the 6127V1A360L.5FS absolute angle encoder.
 */
public class AbsoluteEncoder extends AnalogInput {
    double angleOffset;
    boolean flipped = false;

    /**
     * @param channel analog channel of the encoder
     * @param angleOffset offset acquired by the getCalibration method
     */
    public AbsoluteEncoder(int channel, double angleOffset) {
        this(channel, angleOffset, false);
    }

    /**
     * @param channel analog channel of the encoder
     * @param angleOffset offset acquired by the getCalibration method
     * @param flipped boolean indicating the encoder's angle needs to be
     *        reversed
     */
    public AbsoluteEncoder(int channel, double angleOffset, boolean flipped) {
        super(channel);
        this.angleOffset = Math.toRadians(angleOffset);
        this.flipped = flipped;
    }

    /**
     * Get the current angle of the encoder in radians between 0 and 2pi.
     * 
     * @return current angle in radians
     */
    public double getAngle() {
        double angle = (getVoltage() - 0.2) * (2 * Math.PI) / 4.6;
        if (flipped)
            angle *= -1;
        return wrapAngle(angle - angleOffset);
    }

    /**
     * Convert an angle to its equivalent between 0 and 2pi
     * 
     * @param angle angle in radians
     * @return equivalent angle between 0 and 2pi
     */
    private double wrapAngle(double angle) {
        angle %= (2 * Math.PI);
        if (angle < 0)
            angle += 2 * Math.PI;
        return angle;
    }

    /**
     * When the encoder is pointing at the desired angle, call this method to
     * get the angleOffset such that the current angle will be zero.
     * 
     * @return
     */
    public double getCalibration() {
        return wrapAngle(getAngle() + angleOffset);
    }

    /**
     * Angle returned to a PID controller.
     */
    public double pidGet() {
        return getAngle();
    }

}
