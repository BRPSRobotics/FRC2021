package org_new.frcteam5162.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import org.frcteam5162.config.RobotConfig;

public class IntakeSubsystem extends Subsystem {
    private static IntakeSubsystem instance;
    private static double dblOnPower = 0.6;
    private static TalonSRX mtrIntake = new TalonSRX(RobotConfig.LOAD_CAN_ID);

    public IntakeSubsystem() {
        mtrIntake.set(ControlMode.PercentOutput, 0);
        mtrIntake.setNeutralMode(NeutralMode.Brake);
    }

    public static IntakeSubsystem getInstance() {
        if (instance == null)
        {
            instance = new IntakeSubsystem();
        }

        return instance;
    }

    public static void IntakeOn(boolean forward)
    {
        // Set Intake motor to on (dblOnPower).
        double power;

        if (forward)
        {
            power = dblOnPower;
        }
        else
        {
            power = -dblOnPower;
        }

        mtrIntake.set(ControlMode.PercentOutput, power);
    }
    public static void IntakeOff()
    {
        // Set Intake motor to off (0).
        mtrIntake.set(ControlMode.PercentOutput, 0);
    }

    @Override
    public void periodic() {

    }

    @Override
    protected void initDefaultCommand() {
        //setDefaultCommand(new IntakeCommand());
    }
}