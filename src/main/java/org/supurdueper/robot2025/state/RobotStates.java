package org.supurdueper.robot2025.state;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.button.RobotModeTriggers;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import lombok.Getter;
import lombok.Setter;
import org.supurdueper.robot2025.RobotContainer;

public final class RobotStates {

    public static final Trigger sim = new Trigger(RobotBase::isSimulation);
    public static final Trigger teleop = RobotModeTriggers.teleop();
    public static final Trigger auto = RobotModeTriggers.autonomous();
    public static final Trigger disabled = RobotModeTriggers.disabled();
    public static final Driver driver = RobotContainer.getDriver();

    // Autos
    @Getter
    @Setter
    private static boolean autol4 = false;

    @Getter
    @Setter
    private static boolean autoscore = false;

    @Getter
    @Setter
    private static boolean autointake = false;

    @Getter
    @Setter
    private static boolean autoAimLeft = false;

    @Getter
    @Setter
    private static boolean autoAimRight = false;

    @Getter
    @Setter
    private static boolean autol3 = false;

    @Getter
    @Setter
    private static boolean autol2 = false;

    @Getter
    @Setter
    private static boolean aimed = false;

    public static final Trigger auto_l4 = new Trigger(RobotStates::isAutol4).and(auto);
    public static final Trigger auto_l3 = new Trigger(RobotStates::isAutol3).and(auto);
    public static final Trigger auto_l2 = new Trigger(RobotStates::isAutol2).and(auto);
    public static final Trigger auto_score = new Trigger(RobotStates::isAutoscore).and(auto);
    public static final Trigger auto_intake = new Trigger(RobotStates::isAutointake).and(auto);
    public static final Trigger auto_aimLeft = new Trigger(RobotStates::isAutoAimLeft).and(auto);
    public static final Trigger auto_aimRight = new Trigger(RobotStates::isAutoAimRight).and(auto);

    // // Information
    public static final Trigger isAimed = new Trigger(() -> aimed);

    // Actions
    public static final Trigger actionScore = driver.rightBumper.and(teleop).or(auto_score);
    public static final Trigger actionIntake = driver.leftBumper.and(teleop).or(auto_intake);
    public static final Trigger actionUnjam = driver.start.and(teleop);
    public static final Trigger actionL1 = driver.A.and(teleop);
    public static final Trigger actionL2 = driver.B.and(teleop).or(auto_l2);
    public static final Trigger actionL3 = driver.X.and(teleop).or(auto_l3);
    public static final Trigger actionL4 = driver.Y.and(teleop).or(auto_l4);
    public static final Trigger actionReef = actionL2.or(actionL3).or(actionL4);
    public static final Trigger actionNet = driver.extraLeft.and(teleop);
    public static final Trigger actionProcessor = new Trigger((() -> false));
    public static final Trigger actionLeftAim = driver.leftTrigger.and(teleop).or(auto_aimLeft);
    public static final Trigger actionRightAim = driver.rightTrigger.and(teleop).or(auto_aimRight);
    public static final Trigger actionAim = actionLeftAim.or(actionRightAim);
    public static final Trigger actionHome = new Trigger(() -> false);
    public static final Trigger actionClimbPrep = driver.extraRight.and(teleop);
    public static final Trigger actionClimb = driver.downDpad.and(teleop);
    public static final Trigger rezeroFieldHeading = driver.select.and(teleop);
    public static final Trigger actionLollipop = driver.leftDpad.and(teleop);

    private RobotStates() {
        throw new IllegalStateException("Utility class");
    }
}
