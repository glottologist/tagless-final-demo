import sbt._

object Dependencies {
  lazy val FreesVersion       = "0.4.6"
  lazy val CatsEffectVersion  = "0.5"

  lazy val freesCore	  = "io.frees"        %% "frees-core"     % FreesVersion
  lazy val freesTagless = "io.frees"        %% "frees-tagless"  % FreesVersion

  lazy val catsEffect   =  "org.typelevel"  %% "cats-effect"    % CatsEffectVersion
  
  lazy val scalaTest 	  = "org.scalatest"   %% "scalatest"      % "3.0.3"
}
