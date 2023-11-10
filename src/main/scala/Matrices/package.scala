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

  // Ejercicio 1.1.1
  def multMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val m2T = transpuesta(m2)
    val l = m1.length
    val c = Vector.tabulate(l, l)((i, j) => prodPunto(m1(i),m2T(j)))
    c
  }

  // Ejercicio 1.1.2
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

  // Ejercicio 1.2.1
  def subMatriz(m: Matriz, i: Int, j: Int, l: Int): Matriz = {
    // Dada m, matriz cuadrada de NxN, 1<=i , j<=N, i+n<=N, j+n<=N,
    // devuelve la submatriz de nxn correspondiente a m[i..i+(n-1), j..j+(n-1)]
    val posI = i
    val posJ = j
    Vector.tabulate(l,l)((i,j) => m(i+posI)(j+posJ))
  }

  // Ejercicio 1.2.2
  def sumMatriz(m1: Matriz, m2: Matriz): Matriz = {
    // recibe m1 y m2 matrices cuadradas de la misma dimension, potencia de 2
    // y de vuelve la matriz resultante de la suma de las 2 matrices
    val l = m1.length
    Vector.tabulate(l,l)((i,j) => m1(i)(j)+m2(i)(j))
  }

  // Ejercicio 1.2.3
  def multMatrizRec(m1: Matriz, m2: Matriz): Matriz = {
    // recibe m1 y m2 matrices cuadradas de la misma dimension, potencia de 2
    // y devuelve la multiplicacion de las 2 matrices
    val l = m1.length
    val mid = l/2

    if (l == 2 || l == 1) {
      multMatriz(m1,m2)
    }
    else {
      val c_00 = sumMatriz(
        multMatrizRec(
          subMatriz(m1, 0, 0, mid),
          subMatriz(m2, 0, 0, mid)),
        multMatrizRec(
          subMatriz(m1, 0, mid, mid),
          subMatriz(m2, mid, 0, mid))
      )
      val c_0mid = sumMatriz(
        multMatrizRec(
          subMatriz(m1, 0, 0, mid),
          subMatriz(m2, 0, mid, mid)),
        multMatrizRec(
          subMatriz(m1, 0, mid, mid),
          subMatriz(m2, mid, mid, mid))
      )
      val c_mid0 = sumMatriz(
        multMatrizRec(
          subMatriz(m1, mid, 0, mid),
          subMatriz(m2, 0, 0, mid)),
        multMatrizRec(
          subMatriz(m1, mid, mid, mid),
          subMatriz(m2, mid, 0, mid))
      )
      val c_midmid = sumMatriz(
        multMatrizRec(
          subMatriz(m1, mid, 0, mid),
          subMatriz(m2, 0, mid, mid)),
        multMatrizRec(
          subMatriz(m1, mid, mid, mid),
          subMatriz(m2, mid, mid, mid))
      )
      (c_00 ++ c_mid0).zip(c_0mid ++ c_midmid).map {case (row1, row2) => row1 ++ row2}
    }
  }

  // Ejercicio 1.2.4
  def multMatrizRecPar(m1: Matriz, m2: Matriz): Matriz = {
    // recibe m1 y m2 matrices cuadradas de la misma dimension, potencia de 2
    // y devuelve la multiplicacion de las 2 matrices
    val l = m1.length
    val mid = l / 2

    val umbral = 4
    val threshold = {
      if (l <= umbral)
        l
      else
        umbral
    }

    if (l == threshold) { // 'threshold' define si se usa el algoritmo secuencial o paralelo.
      multMatrizRec(m1, m2)
    }
    else {
      val (t1, t2) = (
        task(multMatrizRecPar(
          subMatriz(m1, 0, 0, mid),
          subMatriz(m2, 0, 0, mid))),
        task(multMatrizRecPar(
          subMatriz(m1, 0, mid, mid),
          subMatriz(m2, mid, 0, mid)))
      )
      val (t3, t4) = (
        task(multMatrizRecPar(
          subMatriz(m1, 0, 0, mid),
          subMatriz(m2, 0, mid, mid))),
        task(multMatrizRecPar(
          subMatriz(m1, 0, mid, mid),
          subMatriz(m2, mid, mid, mid)))
      )
      val (t5, t6) = (
        task(multMatrizRecPar(
          subMatriz(m1, mid, 0, mid),
          subMatriz(m2, 0, 0, mid))),
        task(multMatrizRecPar(
          subMatriz(m1, mid, mid, mid),
          subMatriz(m2, mid, 0, mid)))
      )
      val (t7, t8) = (
        task(multMatrizRecPar(
          subMatriz(m1, mid, 0, mid),
          subMatriz(m2, 0, mid, mid))),
        task(multMatrizRecPar(
          subMatriz(m1, mid, mid, mid),
          subMatriz(m2, mid, mid, mid)))
      )

      val (m1_00_m2_00, m1_0mid_m2_mid0) = (t1.join, t2.join)
      val (m1_00_m2_0mid, m1_0mid_m2_midmid) = (t3.join, t4.join)
      val (m1_mid0_m2_00, m1_midmid_m2_mid0) = (t5.join, t6.join)
      val (m1_mid0_m2_0mid, m1_midmid_m2_midmid) = (t7.join, t8.join)

      val c_00 = sumMatriz(m1_00_m2_00, m1_0mid_m2_mid0)
      val c_0mid = sumMatriz(m1_00_m2_0mid, m1_0mid_m2_midmid)
      val c_mid0 = sumMatriz(m1_mid0_m2_00, m1_midmid_m2_mid0)
      val c_midmid = sumMatriz(m1_mid0_m2_0mid, m1_midmid_m2_midmid)
      (c_00 ++ c_mid0).zip(c_0mid ++ c_midmid).map {case (row1, row2) => row1 ++ row2}
    }
  }

  // Ejercicio 1.3.1
  def restaMatriz(m1: Matriz, m2: Matriz): Matriz = {
    // recibe m1 y m2 matrices cuadradas de la misma dimension, potencia de 2
    // y devuelve la matriz resultante de la resta de las 2 matrices
    val l = m1.length
    Vector.tabulate(l,l)((i,j) => m1(i)(j)-m2(i)(j))
  }

  // Ejercicio 1.3.2
  def multStrassen(m1: Matriz, m2: Matriz): Matriz = {
    // recibe m1 y m2 matrices cuadradas de la misma dimension, potencia de 2
    // y devuelve la multiplicacion de las 2 matrices usando el algoritmo de Strassen
    val l = m1.length
    val mid = l / 2

    if (l == 2 || l == 1) {
      multMatriz(m1, m2)
    }
    else {
      val (s1, s2) = (
        restaMatriz(
          subMatriz(m2, 0, mid, mid),
          subMatriz(m2, mid, mid, mid)),
        sumMatriz(
          subMatriz(m1, 0, 0, mid),
          subMatriz(m1, 0, mid, mid))
      )
      val (s3, s4) = (
        sumMatriz(
          subMatriz(m1, mid, 0, mid),
          subMatriz(m1, mid, mid, mid)),
        restaMatriz(
          subMatriz(
            m2, mid, 0, mid),
          subMatriz(m2, 0, 0, mid))
      )
      val (s5, s6) = (
        sumMatriz(
          subMatriz(m1, 0, 0, mid),
          subMatriz(m1, mid, mid, mid)),
        sumMatriz(
          subMatriz(m2, 0, 0, mid),
          subMatriz(m2, mid, mid, mid))
      )
      val (s7, s8) = (
        restaMatriz(
          subMatriz(m1, 0, mid, mid),
          subMatriz(m1, mid, mid, mid)),
        sumMatriz(
          subMatriz(m2, mid, 0, mid),
          subMatriz(m2, mid, mid, mid))
      )
      val (s9, s10) = (
        restaMatriz(
          subMatriz(m1, 0, 0, mid),
          subMatriz(m1, mid, 0, mid)),
        sumMatriz(
          subMatriz(m2, 0, 0, mid),
          subMatriz(m2, 0, mid, mid))
      )

      val (p1, p2) = (
        multStrassen(subMatriz(m1, 0, 0, mid), s1),
        multStrassen(s2, subMatriz(m2, mid, mid, mid))
      )
      val (p3, p4) = (
        multStrassen(s3, subMatriz(m2, 0, 0, mid)),
        multStrassen(subMatriz(m1, mid, mid, mid), s4)
      )
      val (p5, p6) = (
        multStrassen(s5, s6),
        multStrassen(s7, s8)
      )
      val p7 = multStrassen(s9, s10)

      val c_00 = sumMatriz(restaMatriz(sumMatriz(p5, p4), p2), p6)
      val c_0mid = sumMatriz(p1, p2)
      val c_mid0 = sumMatriz(p3, p4)
      val c_midmid = restaMatriz(restaMatriz(sumMatriz(p5, p1), p3), p7)
      (c_00 ++ c_mid0).zip(c_0mid ++ c_midmid).map {case (row1, row2) => row1 ++ row2}
    }
  }

  // Ejercicio 1.3.3
  def multStrassenPar(m1: Matriz, m2: Matriz): Matriz = {
    // recibe m1 y m2 matrices cuadradas de la misma dimension, potencia de 2
    // y devuelve la multiplicacion de las 2 matrices usando el algoritmo de Strassen
    val l = m1.length
    val mid = l / 2

    val umbral = 4
    val threshold = {
      if (l <= umbral)
        l
      else
        umbral
    }

    if (l == threshold) {
      multStrassen(m1, m2)
    }
    else {
      val (t1, t2) = (
        task(restaMatriz(
          subMatriz(m2, 0, mid, mid),
          subMatriz(m2, mid, mid, mid))),
        task(sumMatriz(
          subMatriz(m1, 0, 0, mid),
          subMatriz(m1, 0, mid, mid)))
      )
      val (t3, t4) = (
        task(sumMatriz(
          subMatriz(m1, mid, 0, mid),
          subMatriz(m1, mid, mid, mid))),
        task(restaMatriz(
          subMatriz(m2, mid, 0, mid),
          subMatriz(m2, 0, 0, mid)))
      )
      val (t5, t6) = (
        task(sumMatriz(
          subMatriz(m1, 0, 0, mid),
          subMatriz(m1, mid, mid, mid))),
        task(sumMatriz(
          subMatriz(m2, 0, 0, mid),
          subMatriz(m2, mid, mid, mid)))
      )
      val (t7, t8) = (
        task(restaMatriz(
          subMatriz(m1, 0, mid, mid),
          subMatriz(m1, mid, mid, mid))),
        task(sumMatriz(
          subMatriz(m2, mid, 0, mid),
          subMatriz(m2, mid, mid, mid)))
      )
      val (t9, t10) = (
        task(restaMatriz(
          subMatriz(m1, 0, 0, mid),
          subMatriz(m1, mid, 0, mid))),
        task(sumMatriz(
          subMatriz(m2, 0, 0, mid),
          subMatriz(m2, 0, mid, mid)))
      )

      val (s1, s2) = (t1.join, t2.join)
      val (s3, s4) = (t3.join, t4.join)
      val (s5, s6) = (t5.join,t6.join)
      val (s7, s8) = (t7.join, t8.join)
      val (s9, s10) = (t9.join, t10.join)


      val (t11, t12) = (
        task(multStrassenPar(subMatriz(m1, 0, 0, mid), s1)),
        task(multStrassenPar(s2, subMatriz(m2, mid, mid, mid)))
      )
      val (t13, t14) = (
        task(multStrassenPar(s3, subMatriz(m2, 0, 0, mid))),
        task(multStrassenPar(subMatriz(m1, mid, mid, mid), s4))
      )
      val (t15, t16) = (
        task(multStrassenPar(s5, s6)),
        task(multStrassenPar(s7, s8))
      )
      val t17 = task(multStrassenPar(s9, s10))

      val (p1, p2) = (t11.join, t12.join)
      val (p3, p4) = (t13.join, t14.join)
      val (p5, p6) = (t15.join, t16.join)
      val p7 = t17.join

      val c_00 = sumMatriz(restaMatriz(sumMatriz(p5, p4), p2), p6)
      val c_0mid = sumMatriz(p1, p2)
      val c_mid0 = sumMatriz(p3, p4)
      val c_midmid = restaMatriz(restaMatriz(sumMatriz(p5, p1), p3), p7)
      (c_00 ++ c_mid0).zip(c_0mid ++ c_midmid).map {case (row1, row2) => row1 ++ row2}
    }
  }
}
