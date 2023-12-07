/*
Proyecto Final:

Wilson Andrés Mosquera Zapata <202182116>
Andrés Camilo Henao Hidalgo <202227887>
Juan José Bolaños Delgado <201942124>

07/12/2023

Archivo: package.scala (ArbolSufijos)

*/

package object ArbolSufijos {

  // Definiendo otra estructura para manipular Seq[Seq[Char]]
  abstract class Trie

  case class Nodo(car: Char, marcada: Boolean,
                  hijos: List[Trie]) extends Trie

  case class Hoja(car: Char, marcada: Boolean) extends Trie

  def raiz(t: Trie): Char = {
    t match {
      case Nodo(c, _, _) => c
      case Hoja(c, _) => c
    }
  }

  def cabezas(t: Trie): Seq[Char] = {
    t match {
      case Nodo(_, _, lt) => lt.map(t => raiz(t))
      case Hoja(c, _) => Seq[Char](c)
    }
  }


  def pertenece(subSecuencia: Seq[Char], trie: Trie): Boolean = {
    // Función auxiliar que verifica si una subsecuencia está presente en la lista de cabezas de un trie.
    def perteneceEnCabezas(subSecuencia: Seq[Char], listaCabezas: List[Trie]): Boolean = {
      subSecuencia match {
        case cabeza +: cola =>
          listaCabezas.exists { subArbol =>
            raiz(subArbol) == cabeza && (pertenece(cola, subArbol) || pertenece(subSecuencia, subArbol))
          }
        case _ => true // La subsecuencia está vacía, es válida.
      }
    }

    trie match {
      case Nodo(_, _, hijos) => perteneceEnCabezas(subSecuencia, hijos)
      case Hoja(_, _) => subSecuencia.isEmpty
    }
  }

  def contieneSubsecuencia(consulta: Seq[Char], trie: Trie): Boolean = {
    // Función auxiliar para buscar la subsecuencia en el trie
    def buscarRama(nodoActual: Trie, consultaRestante: Seq[Char]): Boolean = (nodoActual, consultaRestante) match {
      case (Nodo(_, _, hijos), cabeza :: cola) =>
        hijos.exists(hijo => raiz(hijo) == cabeza && buscarRama(hijo, cola))
      case (Hoja(_, _), _) =>
        consultaRestante.isEmpty
      case (_, _) =>
        false
    }

    buscarRama(trie, consulta)
  }

  def adicionar(secuencia: Seq[Char], trie: Trie): Trie = {
    def agregarRecursivo(nodo: Trie, restante: Seq[Char]): Trie = (nodo, restante) match {
      case (Nodo(valor, marcada, hijos), cabeza :: cola) =>
        val nuevosHijos = hijos.map { hijo =>
          if (raiz(hijo) == cabeza) agregarRecursivo(hijo, cola)
          else hijo
        }
        Nodo(valor, marcada, nuevosHijos :+ crearRama(cola))
      case (Hoja(_, _), _) =>
        crearRama(restante)
      case (_, _) =>
        nodo
    }

    def crearRama(s: Seq[Char]): Trie = s match {
      case cabeza :: cola => Nodo(cabeza, marcada = false, List(crearRama(cola)))
      case Nil => Hoja(' ', marcada = true)
    }

    agregarRecursivo(trie, secuencia)
  }


}