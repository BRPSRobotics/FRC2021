package org.frcteam5162.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import org.frcteam5162.config.RobotConfig;

public class FeederSubsystem extends Subsystem {
    private static FeederSubsystem instance;
    private static double dblOnPower = 0.25;
    private static TalonSRX mtrFeeder = new TalonSRX(RobotConfig.FEEDER_CAN_ID);

    public FeederSubsystem() {
        mtrFeeder.set(ControlMode.PercentOutput, 0);
        mtrFeeder.setNeutralMode(NeutralMode.Brake);
    }

    public static FeederSubsystem getInstance() {
        if (instance == null)
        {
            instance = new FeederSubsystem();
        }

        return instance;
    }

    public static void FeederOn()
    {
        // Set feeder motor to on (dblOnPower).
        mtrFeeder.set(ControlMode.PercentOutput, dblOnPower);
    }
    public static void FeederOff()
    {
        // Set feeder motor to off (0).
        mtrFeeder.set(ControlMode.PercentOutput, 0);
    }

    @Override
    public void periodic() {

    }

    @Override
    protected void initDefaultCommand() {
        //setDefaultCommand(new FeederCommand());
    }
}