// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.math.geometry.Translation2d;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveConstants {
        public static enum ModulePosition {
            BACK_LEFT, BACK_RIGHT, FRONT_LEFT, FRONT_RIGHT
        }

        public static final double kTrackWidthMeters = 0;
        public static final double kWheelBaseMeters = 0;
        
        public static final Map<ModulePosition, Translation2d> modulePositions = Map.of(
            ModulePosition.BACK_LEFT, new Translation2d(-kTrackWidthMeters/2, -kWheelBaseMeters/2),
            ModulePosition.BACK_RIGHT, new Translation2d(kTrackWidthMeters/2, -kWheelBaseMeters/2),
            ModulePosition.FRONT_LEFT, new Translation2d(-kTrackWidthMeters/2, kWheelBaseMeters/2),
            ModulePosition.FRONT_RIGHT, new Translation2d(kTrackWidthMeters/2, kWheelBaseMeters/2)
        );
    } 
}
