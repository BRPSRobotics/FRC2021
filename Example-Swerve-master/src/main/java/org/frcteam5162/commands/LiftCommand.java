package org.frcteam5162.commands;

import com.swervedrivespecialties.exampleswerve.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.frcteam5162.subsystems.LiftSubsystem;

public class LiftCommand extends Command {
    public LiftCommand()
    {
        requires(LiftSubsystem.getInstance());
    }

    protected void initialize()
    {
        Robot.getSubLift().LiftOn(); // Motor power for ON is defined in LiftSubsystem.java
    }

    protected void execute()
    {
        
    }

    protected void end()
    {
        Robot.getSubLift().LiftOff();
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