package org.frcteam5162.commands.color_wheel;

import edu.wpi.first.wpilibj.command.Command;

import com.swervedrivespecialties.exampleswerve.Robot;

import org.frcteam5162.subsystems.color_wheel.ColorWheelTurnSubsystem;

public class ColorWheelTurnCommand extends Command {
    public ColorWheelTurnCommand() {
        requires(ColorWheelTurnSubsystem.getInstance());
    }

    protected void initialize() {
        Robot.getSubColorWheelTurn().TurnColorWheel();
    }
    
    protected void execute() {
        
    }

    protected void end()
    {
        Robot.getSubColorWheelTurn().StopColorWheel();
    }

    protected void interrupted()
    {
        end();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}