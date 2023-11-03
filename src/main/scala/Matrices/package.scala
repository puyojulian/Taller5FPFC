import common._
import scala.collection.parallel.immutable.ParVector
import scala.util.Random
package object Matrices {
  val random = new Random()
  type Matriz = Vector[Vector[Int]]

  def matrizAlAzar(long: Int, vals: Int): Matriz = {
    // Crea una matriz de enteros cuadrada de long x long,
    // con valores aleatorios entre 0 y vals.
    val v = Vector.fill(long, long){random.nextInt(vals)}
    v
  }

  def vectorAlAzar(long: Int, vals: Int): Vector[Int] = {
    //Crea un vector de enteros de longitud long,
    // con valores aleatorios entre 0 y vals
    val v = Vector.fill(long){random.nextInt(vals)}
    v
  }

  def transpuesta(m: Matriz): Matriz = {
    val l = m.length
    Vector.tabulate(l, l)((i, j) => m(j)(i))
  }

  def prodPunto(v1: Vector[Int], v2: Vector[Int]): Int = {
    (v1 zip v2).map({case (i, j) => (i*j)}).sum
  }

  def prodPuntoParD(v1: ParVector[Int], v2: ParVector[Int]): Int = {
    // A ser usada en el punto 1.5
    (v1 zip v2).map({case (i, j) => (i*j)}).sum
  }

  def multMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val m2T = transpuesta(m2)
    val l = m1.length
    val c = Vector.tabulate(l, l)((i, j) => prodPunto(m1(i),m2T(j)))
    c
  }

  def multMatrizPar(m1: Matriz, m2: Matriz): Matriz = {
    val (m2T:Matriz,l:Int) = parallel(transpuesta(m2),m1.length)
    val middle = l/2
    val (c1:Matriz, c2:Matriz) = {
      if (l % 2 == 0)
        parallel(
          Vector.tabulate(middle, l)((i, j) => prodPunto(m1(i), m2T(j))),
          Vector.tabulate(middle, l)((i, j) => prodPunto(m1(i + middle), m2T(j)))
        )
      else
        parallel(
          Vector.tabulate(middle + 1, l)((i, j) => prodPunto(m1(i), m2T(j))),
          Vector.tabulate(middle, l)((i, j) => prodPunto(m1(i + middle + 1), m2T(j)))
        )
    }
    val c = c1++c2
    c
  }

  def subMatriz(m: Matriz, i: Int, j: Int, l: Int): Matriz = {
    // Dada m, mat r i z cuadrada de NxN, 1<=i , j<=N, i+n<=N, j+n<=N,
    // devuelve la submatriz de nxn correspondiente a m[i..i+(n-1), j..j+(n-1)]
    val posI = i
    val posJ = j
    Vector.tabulate(l,l)((i,j) => m(i+posI)(j+posJ))
  }
}
