import Matrices._

val m1 = matrizAlAzar(12,2)
val m2 = matrizAlAzar(12,2)

val m1m2 = multMatriz(m1,m2)
val m1m2Par = multMatrizPar(m1,m2)
m1m2 == m1m2Par

val m1_00 = subMatriz(m1,0,0,6)
val m1_06 = subMatriz(m1,0,6,6)
val m1_60 = subMatriz(m1,6,0,6)
val m1_66 = subMatriz(m1,6,6,6)