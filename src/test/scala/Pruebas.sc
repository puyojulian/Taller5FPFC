import Benchmark._
import Matrices._

//for {
//  i <- 1 to 8
//  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
//  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
//} yield (compararAlgoritmos(multMatriz, multMatrizPar)(m1,m2),
//  math.pow(2, i).toInt)

for {
  i <- 1 to 8
  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
} yield (compararAlgoritmos(multMatrizRec,multMatrizRecPar)(m1,m2),
  math.pow(2, i).toInt)

for {
  i <- 1 to 8
  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
} yield (compararAlgoritmos(multStrassen,multStrassenPar)(m1,m2),
  math.pow(2, i).toInt)

//for {
//  i <- 1 to 6
//  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
//  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
//} yield (compararAlgoritmos(multStrassenPrelim,multStrassen)(m1,m2),
//  math.pow(2, i).toInt)
//
//for {
//  i <- 1 to 6
//  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
//  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
//} yield (compararAlgoritmos(multStrassenPrelimPar,multStrassenPar)(m1,m2),
//  math.pow(2, i).toInt)

val m1 = matrizAlAzar(64, 2)
val m2 = matrizAlAzar(64, 2)

val m1m2 = multMatriz(m1,m2)
val m1m2Par = multMatrizPar(m1,m2)
val m1m2Rec = multMatrizRec(m1,m2)
val m1m2RecPar = multMatrizRecPar(m1,m2)
val m1m2Strassen = multStrassen(m1,m2)
val m1m2StrassenPrelim = multStrassenPrelim(m1,m2)
val m1m2StrassenPar = multStrassenPar(m1,m2)
val m1m2StrassenPrelimPar = multStrassenPrelimPar(m1,m2)
m1m2 == m1m2Par
m1m2 == m1m2Rec
m1m2 == m1m2RecPar
m1m2 == m1m2Strassen
m1m2 == m1m2StrassenPar
m1m2 == m1m2StrassenPrelim
m1m2 == m1m2StrassenPrelimPar

val suma = sumMatriz(m1,m2)
m1 == restaMatriz(suma,m2)