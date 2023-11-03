import Matrices._

val m1 = matrizAlAzar(2,2)
val m2 = matrizAlAzar(2,2)

val m1m2 = multMatriz(m1,m2)
val m1m2Par = multMatrizPar(m1,m2)
val m1m2Rec = multMatrizRec(m1,m2)
m1m2 == m1m2Par
m1m2 == m1m2Rec

val mid = m1.length/2
val m1_00 = subMatriz(m1,0,0,mid)
val m1_0mid = subMatriz(m1,0,mid,mid)
val m1_mid0 = subMatriz(m1,mid,0,mid)
val m1_midmid = subMatriz(m1,mid,mid,mid)

val m1C4 = (m1_00++m1_mid0).zip(m1_0mid++m1_midmid).map{case (row1,row2) => row1++row2}
m1C4==m1

val suma = sumMatriz(m1,m2)
m1 == sumMatriz(suma,negMatriz(m2))