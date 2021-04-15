package org.frcteam5162.commands;

import edu.wpi.first.wpilibj.command.Command;

public class MecanumDriveCommand extends Command {

    public MecanumDriveCommand() {
        requires(MecanumDriveSubsystem.getInstance());
    }

    @Override
    protected void execute() {

        double x = Robot.getOi().getPrimaryX();
        double y = Robot.getOi().getPrimaryY();
        double rotation = Robot.getOi().getSecondaryX();

        MecanumDriveSubsystem.getInstance().drive(x, y, rotation);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
