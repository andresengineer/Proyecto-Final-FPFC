/*
Proyecto Final:

Wilson Andrés Mosquera Zapata <202182116>
 <202124366>

28/11/2023

Archivo: package.scala (ReconstCadenasPar)

*/

import common._
import Oraculo._
import scala.collection.parallel.CollectionConverters._
import scala.collection.parallel.ParSeq
import ReconstCadenas._
import scala.util.DynamicVariable
import scala.collection.parallel.immutable.ParSet
import scala.collection.parallel.immutable.ParVector

package object ReconstCadenasPar {


  val alfabeto = Seq('a', 'c', 'g', 't')
  type Oraculo = Seq[Char] => Boolean

  // Función de reconstrucción de cadena ingenua paralela
  def reconstruirCadenaIngenuoPar(umbral: Int)(n: Int, o: Oraculo): Seq[Char] = {
    val secuencias = (1 to n).foldLeft(Set(Seq.empty[Char])) { (acc, _) =>
      acc.flatMap(seq => alfabeto.map(char => seq :+ char))
    }

    def buscarSubsecuenciaPar(secuencia: Seq[Char]): Boolean = {
      val subsecuencias = secuencia.sliding(n)
      subsecuencias.to(LazyList).par.exists(subseq => o(subseq))
    }

    if (n <= umbral) {
      // Si el tamaño del conjunto de secuencias es menor o igual al umbral, ejecutar de forma secuencial
      reconstruirCadenaIngenuo(n,o)
    } else {
      // Dividir el conjunto de secuencias en partes y buscar en paralelo
      val divisiones = secuencias.grouped(umbral).toVector
      val futures = divisiones.map { parte =>
        task {
          parte.to(LazyList).find(buscarSubsecuenciaPar).getOrElse(Seq.empty[Char])
        }
      }

      val resultados = futures.map(_.join())
      resultados.find(_.nonEmpty).getOrElse(Seq.empty[Char])
    }
  }

  // Función de reconstrucción de cadena mejorada paralela
  def reconstruirCadenaMejoradoPar(umbral: Int)(n: Int, o: Oraculo): Seq[Char] = {

    def buscarSubsecuenciaPar(secuencia: Seq[Char]): Boolean = {
      val subsecuencias = secuencia.sliding(n)
      subsecuencias.to(LazyList).par.exists(subseq => o(subseq))
    }

    if (n <= umbral) {
      // Si el tamaño del conjunto de secuencias es menor o igual al umbral, ejecutar de forma secuencial
      reconstruirCadenaMejorado(n, o)
    } else {
      // Inicializar el conjunto de subcadenas generadas de longitud 0
      var subcadenasGeneradas: ParVector[Seq[Char]] = ParVector(Seq.empty[Char])

      // Generar subcadenas de longitud k para cada k <= n
      for (k <- 1 to n) {
        // Generar nuevas subcadenas concatenando con el alfabeto
        val nuevasSubcadenas = subcadenasGeneradas.flatMap(seq => alfabeto.map(char => seq :+ char)).toVector.par

        // Filtrar las subcadenas usando el oráculo
        val subcadenasValidas = nuevasSubcadenas.filter(o)

        // Si hay subcadenas válidas de longitud N, retornar la primera encontrada
        if (subcadenasValidas.exists(_.length == n)) {
          return subcadenasValidas.find(_.length == n).get
        }

        // Actualizar el conjunto de subcadenas generadas
        subcadenasGeneradas = subcadenasValidas
      }

      // Devolver una cadena vacía si no se encuentra ninguna solución
      Seq.empty[Char]
    }
  }

  // Función de reconstrucción de cadena turbo paralela
  def reconstruirCadenaTurboPar(umbral: Int)(n: Int, o: Oraculo) : Seq [Char]= {

    if (n <= umbral) {
      // Si el tamaño del conjunto de secuencias es menor o igual al umbral, ejecutar de forma secuencial
      reconstruirCadenaTurbo(n, o)
    } else {
      def generarCadenaTurbo(currentLength: Int, subcadenasActuales: ParSet[Seq[Char]]): Seq[Char] = {
        val nuevasSubcadenas = subcadenasActuales.flatMap(subcadena1 => subcadenasActuales.map(subcadena2 => subcadena1 ++ subcadena2)).par
        val subcadenasFiltradas = nuevasSubcadenas.filter(o)

        // Obtener la primera subcadena válida de longitud N
        subcadenasFiltradas.find(_.length == n).getOrElse {
          // Si el tamaño actual supera N, devolver una cadena vacía
          if (currentLength > n) Seq.empty[Char]
          else generarCadenaTurbo(currentLength * 2, subcadenasFiltradas.par)
        }
      }

      // Inicializar el conjunto de subcadenas generadas de longitud 1 como ParSet
      val subcadenasIniciales: ParSet[Seq[Char]] = alfabeto.map(Seq(_)).toSet.par

      generarCadenaTurbo(2, subcadenasIniciales)
    }
  }


}
