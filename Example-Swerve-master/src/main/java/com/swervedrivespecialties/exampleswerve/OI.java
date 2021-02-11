package com.swervedrivespecialties.exampleswerve;

import com.swervedrivespecialties.exampleswerve.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.InstantCommand;
import org.frcteam5162.commands.FeederCommand;
import org.frcteam5162.commands.LoadFillCommand;
import org.frcteam5162.commands.color_wheel.ColorWheelArmCommand;
import org.frcteam5162.commands.color_wheel.ColorWheelTurnCommand;
import org.frcteam5162.commands.LiftCommand;
import org.frcteam5162.commands.LaunchCommand;

public class OI {
    /*
       Add your joysticks and buttons here
     */

    private Joystick pivotJoystick = new Joystick(0);
    private Joystick primaryJoystick = new Joystick(1);

    /* 5162 */

    private JoystickButton loadfillButton = new JoystickButton(primaryJoystick, 1);
    private JoystickButton feederButton = new JoystickButton(primaryJoystick, 2);
    private JoystickButton launchButton = new JoystickButton(primaryJoystick, 3);
    private JoystickButton liftButton = new JoystickButton(primaryJoystick, 4);
    private JoystickButton colorWheelArmButton = new JoystickButton(primaryJoystick, 5);
    private JoystickButton colorWheelTurnButton = new JoystickButton(pivotJoystick, 6);

    /* ~5162 */

    public OI() {
        // Back button zeroes the drivetrain
        new JoystickButton(primaryJoystick, 7).whenPressed(
                new InstantCommand(() -> DrivetrainSubsystem.getInstance().resetGyroscope())
        );

        feederButton.whileHeld(new FeederCommand());
        launchButton.whileHeld(new LaunchCommand());
        liftButton.whileHeld(new LiftCommand());
        loadfillButton.whileHeld(new LoadFillCommand());
        colorWheelArmButton.whileHeld(new ColorWheelArmCommand());
        colorWheelTurnButton.whileHeld(new ColorWheelTurnCommand());
    }

    public Joystick getPrimaryJoystick() {
        return primaryJoystick;
    }

    public Joystick getPivotJoystick() {
        return pivotJoystick;
    }
}
