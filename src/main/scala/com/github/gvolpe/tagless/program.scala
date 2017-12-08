package com.github.gvolpe.tagless

import cats.Monad
import cats.implicits._
import com.github.gvolpe.tagless.algebra.{Action, Disk, Log}
import freestyle.tagless._

object program {

  def mergeFiles[F[_] : Monad](implicit A: Action[F], D: Disk[F], L: Log[F]): F[Unit] =
    for {
      _   <- L.info("Reading files: data/foo.txt and data/bar.txt")
      foo <- D.read("data/foo.txt")
      bar <- D.read("data/bar.txt")
      _   <- L.warning("Uppercasing file contents")
      enc <- A.uppercaseData(new String(foo ++ bar, "UTF-8"))
      _   <- L.info("Writing result to data/output.txt")
      _   <- D.write("data/output.txt", enc.getBytes("UTF-8"))
    } yield ()

}
