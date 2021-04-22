package org_new.frcteam5162.commands.color_wheel;

import edu.wpi.first.wpilibj.command.Command;

import com.swervedrivespecialties.exampleswerve.Robot;

import org.frcteam5162.subsystems.color_wheel.ColorWheelArmSubsystem;

public class ColorWheelArmCommand extends Command {
    public ColorWheelArmCommand() {
        requires(ColorWheelArmSubsystem.getInstance());
    }

    protected void initialize() {
        Robot.getSubColorWheelArm().ExtendColorWheelArm();
    }
    
    protected void execute() {
        
    }

    protected void end()
    {
        Robot.getSubColorWheelArm().RetractColorWheelArm();
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