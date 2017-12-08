package com.github.gvolpe.tagless

import cats.effect.IO

object demo extends App {

  import interpreter._

  val ioa = program.mergeFiles[IO]
  ioa.unsafeRunSync

}
