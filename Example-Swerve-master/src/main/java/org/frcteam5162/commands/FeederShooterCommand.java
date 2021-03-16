package org.frcteam5162.commands;

import com.swervedrivespecialties.exampleswerve.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.frcteam5162.subsystems.FeederSubsystem;
import org.frcteam5162.subsystems.LaunchSubsystem;

public class FeederShooterCommand extends Command {
    public FeederShooterCommand()
    {
        requires(FeederSubsystem.getInstance());
        requires(LaunchSubsystem.getInstance());
    }

    protected void initialize()
    {
        Robot.getSubFeeder().FeederOn();
        Robot.getSubLaunch().LauncherOn();
        // Motor power for ON is defined in FeederSubsystem.java
    }

    protected void execute()
    {
        
    }

    protected void end()
    {
        Robot.getSubFeeder().FeederOff();
        Robot.getSubLaunch().LauncherOff();
    }

    protected void interrupted()
    {
        end();
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }
}