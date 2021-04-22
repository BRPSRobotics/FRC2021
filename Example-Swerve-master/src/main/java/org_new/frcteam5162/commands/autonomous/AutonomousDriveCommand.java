package org_new.frcteam5162.commands.autonomous;

import com.swervedrivespecialties.exampleswerve.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.geometry.Translation2d;

public class AutonomousDriveCommand extends Command {
    private double forward;
    private double strafe;
    private double rotation;

    public AutonomousDriveCommand(double f, double s, double r) {
        requires(DrivetrainSubsystem.getInstance());
        forward = f;
        strafe = s;
        rotation = r;
    }

    @Override
    protected void execute() {

        // Square the forward stick
        forward = Math.copySign(Math.pow(forward, 2.0), forward);

        // Square the strafe stick
        strafe = Math.copySign(Math.pow(strafe, 2.0), strafe);

        // Square the rotation stick
        rotation = Math.copySign(Math.pow(rotation, 2.0), rotation);

        DrivetrainSubsystem.getInstance().drive(new Translation2d(forward, strafe), rotation, true);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
