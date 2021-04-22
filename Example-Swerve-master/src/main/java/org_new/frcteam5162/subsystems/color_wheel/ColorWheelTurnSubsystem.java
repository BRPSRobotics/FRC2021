package org_new.frcteam5162.subsystems.color_wheel;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frcteam5162.config.RobotConfig;

public class ColorWheelTurnSubsystem extends Subsystem {
    private static ColorWheelTurnSubsystem instance;
    private static Servo servColorWheelTurn = new Servo(RobotConfig.COLOR_WHEEL_TURN_PWM_ID);
    private static double dblTurnPerc = 0;

    public ColorWheelTurnSubsystem() {

    }

    public static ColorWheelTurnSubsystem getInstance() {
        if (instance == null)
        {
            instance = new ColorWheelTurnSubsystem();
        }

        return instance;
    }

    public static void TurnColorWheel()
    {
        //Turn color wheel
        servColorWheelTurn.set(dblTurnPerc);
    }

    public static void StopColorWheel()
    {
        //Stop color wheel
        servColorWheelTurn.set(0.5);
    }
    @Override
    public void periodic() {

    }

    @Override
    protected void initDefaultCommand() {
        //setDefaultCommand(new ColorWheelCommand());
    }
}