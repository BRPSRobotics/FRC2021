package org_new.frcteam5162.main;

import com.swervedrivespecialties.exampleswerve.subsystems.DrivetrainSubsystem;

import org.frcteam5162.subsystems.color_wheel.ColorWheelTurnSubsystem;
import org.frcteam5162.subsystems.color_wheel.ColorWheelArmSubsystem;
import org.frcteam5162.subsystems.FeederSubsystem;
import org.frcteam5162.subsystems.LaunchSubsystem;
import org.frcteam5162.subsystems.IntakeSubsystem;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
    private static OI oi;

    private static IntakeSubsystem subIntake;
    private static FeederSubsystem subFeeder;
    private static LaunchSubsystem subLaunch;
    private static ColorWheelArmSubsystem subColorWheelArm;
    private static ColorWheelTurnSubsystem subColorWheelTurn;

    private final Timer m_timer = new Timer();
    
    public static OI getOi() {
        return oi;
    }

    public static IntakeSubsystem getSubIntake() {
        return subIntake;
    }

    public static FeederSubsystem getSubFeeder() {
        return subFeeder;
    }

    public static LaunchSubsystem getSubLaunch() {
        return subLaunch;
    }

    public static ColorWheelArmSubsystem getSubColorWheelArm() {
        return subColorWheelArm;
    }

    public static ColorWheelTurnSubsystem getSubColorWheelTurn() {
        return subColorWheelTurn;
    }

    @Override
    public void robotInit() {
        oi = new OI();
        subLaunch = LaunchSubsystem.getInstance();
        subIntake = IntakeSubsystem.getInstance();
        subFeeder = FeederSubsystem.getInstance();
        DrivetrainSubsystem.getInstance();

        //autonomousCommandGroup = new SequentialCommandGroup(new FeederCommand(), new DriveCommand());
    }

    @Override
    public void robotPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Left Analog - X-Axis", oi.getSecondaryX());
        SmartDashboard.putNumber("Left Analog - Y-Axis", oi.getSecondaryY());
        SmartDashboard.putNumber("Right Analog - X-Axis", oi.getPrimaryX());
        SmartDashboard.putNumber("Right Analog - Y-Axis", oi.getPrimaryY());
    }

    @Override
    public void autonomousInit() {
        m_timer.reset();
        m_timer.start();

        //if (autonomousCommandGroup != null) autonomousCommandGroup.start();
    }
}
