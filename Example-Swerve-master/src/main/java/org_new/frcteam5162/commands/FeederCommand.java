package org_new.frcteam5162.commands;

import com.swervedrivespecialties.exampleswerve.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.frcteam5162.subsystems.FeederSubsystem;

public class FeederCommand extends Command {
    public FeederCommand()
    {
        requires(FeederSubsystem.getInstance());
    }

    protected void initialize()
    {
        Robot.getSubFeeder().FeederOn(); // Motor power for ON is defined in FeederSubsystem.java
    }

    protected void execute()
    {
        
    }

    protected void end()
    {
        Robot.getSubFeeder().FeederOff();
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