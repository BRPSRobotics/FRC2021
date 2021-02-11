package org.frcteam5162.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.frcteam5162.config.RobotConfig;

public class LiftSubsystem extends Subsystem {
    private static LiftSubsystem instance;
    private static double dblOnPower = 0.25;
    private static TalonSRX mtrLift = new TalonSRX(RobotConfig.LIFT_CAN_ID);

    public LiftSubsystem() {
        mtrLift.set(ControlMode.PercentOutput, 0);
        mtrLift.setNeutralMode(NeutralMode.Brake);
    }

    public static LiftSubsystem getInstance() {
        if (instance == null)
        {
            instance = new LiftSubsystem();
        }

        return instance;
    }

    public static void LiftOn()
    {
        // Set Lift motor to on (dblOnPower).
        mtrLift.set(ControlMode.PercentOutput, dblOnPower);
    }
    public static void LiftOff()
    {
        // Set Lift motor to off (0).
        mtrLift.set(ControlMode.PercentOutput, 0);
    }

    @Override
    public void periodic() {

    }

    @Override
    protected void initDefaultCommand() {
        //setDefaultCommand(new LiftCommand());
    }
}