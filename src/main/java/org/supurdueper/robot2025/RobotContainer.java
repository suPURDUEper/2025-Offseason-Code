// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.supurdueper.robot2025;

import lombok.Getter;
import org.supurdueper.robot2025.state.Driver;
import org.supurdueper.robot2025.subsystems.drive.Drivetrain;
import org.supurdueper.robot2025.subsystems.drive.generated.TunerConstants;

public class RobotContainer {

    @Getter
    private static Drivetrain drivetrain;

    @Getter
    private static Driver driver;

    public RobotContainer() {
        driver = new Driver();
        drivetrain = TunerConstants.createDrivetrain();
        configureBindings();
    }

    void configureBindings() {}
}
