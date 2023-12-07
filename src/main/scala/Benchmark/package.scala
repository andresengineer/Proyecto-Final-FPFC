/*
Proyecto Final:

Wilson Andrés Mosquera Zapata <202182116>
Andrés Camilo Henao Hidalgo <202227887>
Juan José Bolaños Delgado <201942124>

07/12/2023

Archivo: package.scala (Benchmark)

*/

import scala.collection.parallel.CollectionConverters._
import org.scalameter._
import Oraculo._
package object Benchmark {
  type AlgoritmoReconstCadenasC = (Int, Oraculo) => Seq[Char]

  def compararAlgoritmos(a1: AlgoritmoReconstCadenasC, a2: AlgoritmoReconstCadenasC)
                        (n: Int, o: Oraculo): (Double, Double, Double) = {
    val timeA1 = config(
      KeyValue(Key.exec.minWarmupRuns -> 20),
      KeyValue(Key.exec.maxWarmupRuns -> 60),
      KeyValue(Key.verbose -> false)
    ) withWarmer (new Warmer.Default) measure (a1(n, o))

    val timeA2 = config(
      KeyValue(Key.exec.minWarmupRuns -> 20),
      KeyValue(Key.exec.maxWarmupRuns -> 60),
      KeyValue(Key.verbose -> false)
    ) withWarmer (new Warmer.Default) measure (a2(n, o))

    val speedUp = timeA1.value / timeA2.value
    (timeA1.value, timeA2.value, speedUp)
  }
}

