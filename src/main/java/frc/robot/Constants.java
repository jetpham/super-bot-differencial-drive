// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;

public final class Constants {
    public static final class DriveConstants {
        public static final int[] BACK_LEFT_MODULE_MOTORS = { 0, 1 };
        public static final int[] BACK_RIGHT_MODULE_MOTORS = { 2, 3 };
        public static final int[] FRONT_LEFT_MODULE_MOTORS = { 4, 5 };
        public static final int[] FRONT_RIGHT_MODULE_MOTORS = { 6, 7 };

        public static enum ModulePosition {
            BACK_LEFT, BACK_RIGHT, FRONT_LEFT, FRONT_RIGHT
        }

        public static final double kTrackWidthMeters = 0;
        public static final double kWheelBaseMeters = 0;

        public static final Map<ModulePosition, Pose2d> modulePositions = Map.of(
                ModulePosition.BACK_LEFT, new Pose2d(-kTrackWidthMeters / 2, -kWheelBaseMeters / 2, new Rotation2d()),
                ModulePosition.BACK_RIGHT, new Pose2d(kTrackWidthMeters / 2, -kWheelBaseMeters / 2, new Rotation2d()),
                ModulePosition.FRONT_LEFT, new Pose2d(-kTrackWidthMeters / 2, kWheelBaseMeters / 2, new Rotation2d()),
                ModulePosition.FRONT_RIGHT, new Pose2d(kTrackWidthMeters / 2, kWheelBaseMeters / 2, new Rotation2d()));
    }
}
