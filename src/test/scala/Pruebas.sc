import Matrices._

val m1 = matrizAlAzar(12,2)
val m2 = matrizAlAzar(12,2)

val m1m2 = multMatriz(m1,m2)
val m1m2Par = multMatrizPar(m1,m2)
m1m2 == m1m2Par