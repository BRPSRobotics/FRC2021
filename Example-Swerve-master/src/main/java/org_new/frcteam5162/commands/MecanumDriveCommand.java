package org_new.frcteam5162.commands;

import com.swervedrivespecialties.exampleswerve.Robot;

import org.frcteam5162.subsystems.MecanumDriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class MecanumDriveCommand extends Command {

    public MecanumDriveCommand() {
        requires(MecanumDriveSubsystem.getInstance());
    }

    @Override
    public void execute() {

        double x = Robot.getOi().getPrimaryX();
        double y = Robot.getOi().getPrimaryY();
        double rotation = Robot.getOi().getSecondaryX();

        MecanumDriveSubsystem.getInstance().drive(x, y, rotation);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
