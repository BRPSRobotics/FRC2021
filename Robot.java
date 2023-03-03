// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private Joystick drivestick; // creates a new joystick named "drivestick"
  private Joystick operation; // creates a new joystick named "operation"
  public static Drivetrain drivetrain; // gives us the ability to all public functions located in the Drivetrain Subsystem
  double deadzone = 0.25; // creates a varible for a deadzone to be used later in hand with the joysticks
  public static ArmControl arm;

  Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);

  public final DoubleSolenoid grabber = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1); //if plugged into ports 0 and 1



  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    drivetrain = new Drivetrain(); // initializes the drivetrain
    drivestick = new Joystick(0); // assigns which port is to be used for the joystick in the Driver Station
    operation = new Joystick(1);  // assigns which port is to be used for the joystick in the Driver Station

    drivestick.setXChannel(2); // sets X-axis using the axis from the Driverstation
    drivestick.setYChannel(1); // sets Y-axis using the axis from the Driverstation

    arm = new ArmControl();

    grabber.set(Value.kForward); //may be kReverse depending on desired staring position, when testing make sure everyone is clear of pneumatics

    pcmCompressor.enableDigital();

    operation.setYChannel(1);
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {

  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    double turnratedeadzone; // creates a variable to be used when the deadzone varible is applied to the drivetrain
    double throttledeadzone; // creates a variable to be used when the deadzone varible is applied to the drivetrain

    if(Math.abs(drivestick.getY())>deadzone){
      throttledeadzone = Math.pow(drivestick.getY(), 3);
      //assigns the deadzone to the joystick, and quadratically ramps up power for throttle
    } else {
      throttledeadzone = 0;
    }

    if(Math.abs(drivestick.getX())>deadzone){
      turnratedeadzone = Math.pow(drivestick.getX(), 3);
      //assigns the deadzone to the joystick, and quadratically ramps up power for turnrate
    } else{
      turnratedeadzone = 0;
    }

    drivetrain.arcadeDrive(turnratedeadzone, throttledeadzone);

    //arm tilt controls

    double operatordeadzone;

    if(Math.abs(operation.getY())>deadzone){
      operatordeadzone = Math.pow(-operation.getY(),3);
    } else {
      operatordeadzone = 0;
    }
    arm.armspeed(operatordeadzone);
    //grabber controls
    if  (operation.getRawButtonPressed(5)){
      grabber.set(Value.kReverse);
    } else if (operation.getRawButtonPressed(6)){
      grabber.set(Value.kForward);
    }

    //arm extend controls
    double elevdeadzone;
    if(Math.abs(operation.getZ())>deadzone){
      elevdeadzone = Math.pow(operation.getZ(),3);
    } else {
      elevdeadzone = 0;
    }
    arm.tiltspeed(elevdeadzone);
    

  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {

  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {

  }
}
