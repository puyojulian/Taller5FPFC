import Benchmark._
import Matrices._

//// Comparación entre los algoritmos secuenciales con sus paralelos respectivos.
//for {
//  i <- 1 to 8
//  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
//  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
//} yield (compararAlgoritmos(multMatriz, multMatrizPar)(m1,m2),
//  math.pow(2, i).toInt)
//
//for {
//  i <- 1 to 8
//  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
//  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
//} yield (compararAlgoritmos(multMatrizRec,multMatrizRecPar)(m1,m2),
//  math.pow(2, i).toInt)
//
//for {
//  i <- 1 to 8
//  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
//  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
//} yield (compararAlgoritmos(multStrassen,multStrassenPar)(m1,m2),
//  math.pow(2, i).toInt)

// Comparación entre los algoritmos secuenciales.
for {
  i <- 1 to 8
  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
} yield (compararAlgoritmos(multMatriz,multMatrizRec)(m1,m2),
  math.pow(2, i).toInt)

for {
  i <- 1 to 8
  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
} yield (compararAlgoritmos(multMatrizRec,multStrassen)(m1,m2),
  math.pow(2, i).toInt)

for {
  i <- 1 to 8
  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
} yield (compararAlgoritmos(multMatriz,multStrassen)(m1,m2),
  math.pow(2, i).toInt)

// Comparación entre algoritmos paralelos.
for {
  i <- 1 to 8
  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
} yield (compararAlgoritmos(multMatrizPar,multMatrizRecPar)(m1,m2),
  math.pow(2, i).toInt)

for {
  i <- 1 to 8
  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
} yield (compararAlgoritmos(multMatrizRecPar,multStrassenPar)(m1,m2),
  math.pow(2, i).toInt)

for {
  i <- 1 to 8
  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
} yield (compararAlgoritmos(multMatrizPar,multStrassenPar)(m1,m2),
  math.pow(2, i).toInt)

// Caso de prueba: Matrices de tamaño 2x2
val m1 = matrizAlAzar(2, 2)
val m2 = matrizAlAzar(2, 2)
val m1m2 = multMatriz(m1,m2)
val m1m2Par = multMatrizPar(m1,m2)
val m1m2Rec = multMatrizRec(m1,m2)
val m1m2RecPar = multMatrizRecPar(m1,m2)
val m1m2Strassen = multStrassen(m1,m2)
val m1m2StrassenPrelim = multStrassenPrelim(m1,m2)
val m1m2StrassenPar = multStrassenPar(m1,m2)
val m1m2StrassenPrelimPar = multStrassenPrelimPar(m1,m2)
// Se verifica que todas las funciones den lo mismo.
m1m2 == m1m2Par
m1m2 == m1m2Rec
m1m2 == m1m2RecPar
m1m2 == m1m2Strassen
m1m2 == m1m2StrassenPar
m1m2 == m1m2StrassenPrelim
m1m2 == m1m2StrassenPrelimPar
// Se verifica que la suma y resta sean coherentes.
val suma = sumMatriz(m1,m2)
m1 == restaMatriz(suma,m2)

// Caso de prueba: Matrices de tamaño 8x8
val m1 = matrizAlAzar(8, 2)
val m2 = matrizAlAzar(8, 2)
val m1m2 = multMatriz(m1,m2)
val m1m2Par = multMatrizPar(m1,m2)
val m1m2Rec = multMatrizRec(m1,m2)
val m1m2RecPar = multMatrizRecPar(m1,m2)
val m1m2Strassen = multStrassen(m1,m2)
val m1m2StrassenPrelim = multStrassenPrelim(m1,m2)
val m1m2StrassenPar = multStrassenPar(m1,m2)
val m1m2StrassenPrelimPar = multStrassenPrelimPar(m1,m2)
// Se verifica que todas las funciones den lo mismo.
m1m2 == m1m2Par
m1m2 == m1m2Rec
m1m2 == m1m2RecPar
m1m2 == m1m2Strassen
m1m2 == m1m2StrassenPar
m1m2 == m1m2StrassenPrelim
m1m2 == m1m2StrassenPrelimPar
// Se verifica que la suma y resta sean coherentes.
val suma = sumMatriz(m1,m2)
m1 == restaMatriz(suma,m2)

// Caso de prueba: Matrices de tamaño 64x64
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
// Se verifica que todas las funciones den lo mismo.
m1m2 == m1m2Par
m1m2 == m1m2Rec
m1m2 == m1m2RecPar
m1m2 == m1m2Strassen
m1m2 == m1m2StrassenPar
m1m2 == m1m2StrassenPrelim
m1m2 == m1m2StrassenPrelimPar
// Se verifica que la suma y resta sean coherentes.
val suma = sumMatriz(m1,m2)
m1 == restaMatriz(suma,m2)

// Caso de prueba: Matrices de tamaño 256x256
val m1 = matrizAlAzar(256, 2)
val m2 = matrizAlAzar(256, 2)
val m1m2 = multMatriz(m1,m2)
val m1m2Par = multMatrizPar(m1,m2)
val m1m2Rec = multMatrizRec(m1,m2)
val m1m2RecPar = multMatrizRecPar(m1,m2)
val m1m2Strassen = multStrassen(m1,m2)
val m1m2StrassenPrelim = multStrassenPrelim(m1,m2)
val m1m2StrassenPar = multStrassenPar(m1,m2)
val m1m2StrassenPrelimPar = multStrassenPrelimPar(m1,m2)
// Se verifica que todas las funciones den lo mismo.
m1m2 == m1m2Par
m1m2 == m1m2Rec
m1m2 == m1m2RecPar
m1m2 == m1m2Strassen
m1m2 == m1m2StrassenPar
m1m2 == m1m2StrassenPrelim
m1m2 == m1m2StrassenPrelimPar
// Se verifica que la suma y resta sean coherentes.
val suma = sumMatriz(m1,m2)
m1 == restaMatriz(suma,m2)

// Caso de prueba: Matrices de tamaño 512x512
val m1 = matrizAlAzar(512, 2)
val m2 = matrizAlAzar(512, 2)
val m1m2 = multMatriz(m1,m2)
val m1m2Par = multMatrizPar(m1,m2)
val m1m2Rec = multMatrizRec(m1,m2)
val m1m2RecPar = multMatrizRecPar(m1,m2)
val m1m2Strassen = multStrassen(m1,m2)
val m1m2StrassenPrelim = multStrassenPrelim(m1,m2)
val m1m2StrassenPar = multStrassenPar(m1,m2)
val m1m2StrassenPrelimPar = multStrassenPrelimPar(m1,m2)
// Se verifica que todas las funciones den lo mismo.
m1m2 == m1m2Par
m1m2 == m1m2Rec
m1m2 == m1m2RecPar
m1m2 == m1m2Strassen
m1m2 == m1m2StrassenPar
m1m2 == m1m2StrassenPrelim
m1m2 == m1m2StrassenPrelimPar
// Se verifica que la suma y resta sean coherentes.
val suma = sumMatriz(m1,m2)
m1 == restaMatriz(suma,m2)