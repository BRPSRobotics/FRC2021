package org_new.frcteam5162.subsystems.color_wheel;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frcteam5162.config.RobotConfig;

public class ColorWheelArmSubsystem extends Subsystem {
    private static ColorWheelArmSubsystem instance;
    private static Servo servColorWheelArm = new Servo(RobotConfig.COLOR_WHEEL_ARM_PWM_ID);
    private static double dblExtPerc = 0.75;
    private static double dblRetPerc = 0.25;

    public ColorWheelArmSubsystem() {

    }

    public static ColorWheelArmSubsystem getInstance() {
        if (instance == null)
        {
            instance = new ColorWheelArmSubsystem();
        }

        return instance;
    }

    public static void ExtendColorWheelArm()
    {
        //Extend arm servo
        servColorWheelArm.set(dblExtPerc);
    }

    public static void RetractColorWheelArm()
    {
        //Retract arm servo
        servColorWheelArm.set(dblRetPerc);
    }

    @Override
    public void periodic() {

    }

    @Override
    protected void initDefaultCommand() {
        //setDefaultCommand(new ColorWheelCommand());
    }
}