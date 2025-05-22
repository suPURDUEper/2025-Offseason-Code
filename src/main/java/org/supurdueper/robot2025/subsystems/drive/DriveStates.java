package org.supurdueper.robot2025.subsystems.drive;

import static edu.wpi.first.units.Units.*;
import static org.supurdueper.robot2025.Constants.DriveConstants.*;
import static org.supurdueper.robot2025.state.RobotStates.*;

import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.swerve.SwerveRequest;
import edu.wpi.first.wpilibj2.command.Command;
import org.supurdueper.robot2025.Constants.DriveConstants.*;
import org.supurdueper.robot2025.RobotContainer;
import org.supurdueper.robot2025.state.Driver;
import org.supurdueper.robot2025.subsystems.drive.DriveSysId.SysIdSwerveTranslationCurrent;
import org.supurdueper.robot2025.subsystems.drive.generated.TunerConstants;

public class DriveStates {

    private Drivetrain drivetrain;
    private Driver driver;

    /* Setting up bindings for necessary control of the swerve drive platform */
    private double MaxSpeed = TunerConstants.kMaxSpeed.in(MetersPerSecond); // kSpeedAt12Volts desired top speed
    private double MaxAngularRate = RotationsPerSecond.of(1.5).in(RadiansPerSecond); // 3/4 of a rotation per second
    private final SwerveRequest.FieldCentric driveFieldCentric = new SwerveRequest.FieldCentric();
    private final SysIdSwerveTranslationCurrent driveCurrentTuning = new SysIdSwerveTranslationCurrent();

    public DriveStates(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        this.driver = RobotContainer.getDriver();
    }

    public void bindCommands() {
        drivetrain.setDefaultCommand(normalTeleopDrive());
    }

    private Command normalTeleopDrive() {
        return drivetrain.applyRequest(() -> driveFieldCentric
                .withVelocityX(driver.getDriveFwdPositive() * MaxSpeed)
                .withVelocityY(driver.getDriveLeftPositive() * MaxSpeed)
                .withRotationalRate(driver.getDriveCCWPositive() * MaxAngularRate)
                .withDriveRequestType(DriveRequestType.OpenLoopVoltage));
    }

    public Command setVelocityDrive(double velocity) {
        return drivetrain.applyRequest(
                () -> driveFieldCentric.withVelocityX(velocity).withDriveRequestType(DriveRequestType.Velocity));
    }

    private Command currentTuningDrive() {
        return drivetrain.applyRequest(() -> driveCurrentTuning.withCurrent(driver.getDriveFwdPositive() * 40));
    }
}
