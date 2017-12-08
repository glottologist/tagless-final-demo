package com.github.gvolpe.tagless

import java.nio.file.{Files, Paths}

import cats.effect.IO
import com.github.gvolpe.tagless.algebra.{Action, Disk, Log}

object interpreter {

  implicit val actionHandler = new Action.Handler[IO] {
    override def uppercaseData(key: String) = IO { key.toUpperCase }
    override def lowercaseData(key: String) = IO { key.toLowerCase }
  }

  implicit val diskHandler = new Disk.Handler[IO] {
    override def read(filename: String) = IO { Files.readAllBytes(Paths.get(filename)) }
    override def write(filename: String, content: Array[Byte]) =
      IO { Files.write(Paths.get(filename), content) }.map(_ => ())
  }

  implicit val logHandler = new Log.Handler[IO] {
    override def info(msg: String) = IO { println(s"[Info] $msg") }
    override def warning(msg: String) = IO { println(s"[Warning] $msg") }
    override def error(msg: String, t: Option[Throwable]) = IO { println(s"[Error] $msg. Cause: $t") }
  }

}
