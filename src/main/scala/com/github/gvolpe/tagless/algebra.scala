package com.github.gvolpe.tagless

import freestyle.tagless.tagless

object algebra {

  @tagless
  trait Action {
    def uppercaseData(key: String): FS[String]
    def lowercaseData(key: String): FS[String]
  }

  @tagless
  trait Disk {
    def read(filename: String): FS[Array[Byte]]
    def write(filename: String, content: Array[Byte]): FS[Unit]
  }

  @tagless
  trait Log {
    def info(msg: String): FS[Unit]
    def warning(msg: String): FS[Unit]
    def error(msg: String, throwable: Option[Throwable]): FS[Unit]
  }

}
