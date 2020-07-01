/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
   
  public static final class DriveMotorPorts {
    //drive motor PWM ports
    public static final int kDriveLeftMotor1 = 1;
    public static final int kDriveLeftMotor2 = 2;
    public static final int kDriveLeftMotor3 = 3;
    public static final int kDriveRightMotor1 = 4;
    public static final int kDriveRightMotor2 = 5;
    public static final int kDriveRightMotor3 = 6;  
  }

  public static final class IntakeMotorPorts {
    //intake motor PWM ports
    public static final int kIntakeMotor = 0;
  }

  public static final class FeederMotorPorts {
    //feeder mototr PWM ports
    public static final int kFeederLeftMotor = 7;
    public static final int kFeederRightMotor = 8;
  }

  public static final class EncoderPorts {
    //encoder DIO ports
    public static final int kDriveLeftEncoderA = 1;
    public static final int kDriveLeftEncoderB = 2;
    public static final int kDriveRightEncoderA = 3;
    public static final int kDriveRightEncoderB = 4;
    public static final int kShooterEncoderA = 5;
    public static final int kShooterEncoderB = 6;
  }

  public static final class SolenoidPorts {
    //soilenoid PCM channels
    public static final int kIntakeSolenoidForwardChannel = 0;
    public static final int kIntakeSolenoidReverseChannel = 1;
    public static final int kFeederStopperSolenoidForwardChannel = 2;
    public static final int kFeederStopperSolenoidReverseChannel = 3;
  }

  public static final class OIPorts {
    //controller ports (Driver Station)
    public static final int kStickPort = 0;
    public static final int kControllerPort = 1;
  }

  public static final class EncoderConstants {
    //encoder distance per pulse
    //DPR=distance per revolution, CPR=counts per revolution, DPP=distance per pulse, GR=gear ratio
    
    public static final class DriveEncoderConstants {
      public static final double kDriveEncoderDPR = 6 * Math.PI;
      public static final double kDriveEncoderCPR = 256;
      //public static final double kDriveGearBoxGR = ?;
      public static final double kDriveEncoderDPP = (kDriveEncoderDPR / kDriveEncoderCPR) /** kDriveGearBoxGR*/;
    }
    
    public static final class ShooterEncoderConstants {
      //TODO
      //public static final double kDriveEncoderDPR = ?;
      //public static final double kDriveEncoderCPR = ?;
      //public static final double kDriveGearBoxGR = ?;
      //public static final double kDriveEncoderDPP = (kDriveEncoderDPR / kDriveEncoderCPR) /** kDriveGearBoxGR*/;
    }
  }

  public static final class PIDConstants {
    //kP, kI, kD
    public static final class DriveSubsystem1 {
      public static final double kP = 0;
      public static final double kI = 0;
      public static final double kD = 0;
    }
    public static final class ShooterSubsystem {
      public static final double kP = 0;
      public static final double kI = 0;
      public static final double kD = 0;
    }
  }
}
