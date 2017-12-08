package com.github.gvolpe.tagless

import cats.Id
import com.github.gvolpe.tagless.algebra.{Action, Disk, Log}
import org.scalatest.FunSuite

class MergeFilesProgramSpec extends FunSuite {

  implicit val actionHandler = new Action.Handler[Id] {
    override def uppercaseData(key: String) = key.toUpperCase
    override def lowercaseData(key: String) = key.toLowerCase
  }

  implicit val diskHandler = new Disk.Handler[Id] {
    override def read(filename: String) = filename.getBytes
    override def write(filename: String, content: Array[Byte]) = ()
  }

  implicit val logHandler = new Log.Handler[Id] {
    override def info(msg: String) = println(s"[Info] $msg")
    override def warning(msg: String) = println(s"[Warning] $msg")
    override def error(msg: String, t: Option[Throwable]) = println(s"[Error] $msg. Cause: $t")
  }

  test("merge files") {
    program.mergeFiles[Id]
  }

}
