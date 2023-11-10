import Benchmark._
import Matrices._

// Comparación entre los algoritmos secuenciales con sus paralelos respectivos.
//for {
//  i <- 1 to 10
//  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
//  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
//} yield (compararAlgoritmos(multMatriz, multMatrizPar)(m1,m2),
//  math.pow(2, i).toInt)

//for {
//  i <- 1 to 10
//  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
//  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
//} yield (compararAlgoritmos(multMatrizRec,multMatrizRecPar)(m1,m2),
//  math.pow(2, i).toInt)
//
//for {
//  i <- 1 to 10
//  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
//  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
//} yield (compararAlgoritmos(multMatrizRec,multMatrizRecPar)(m1,m2),
//  math.pow(2, i).toInt)
//
//for {
//  i <- 1 to 10
//  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
//  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
//} yield (compararAlgoritmos(multMatrizRec,multMatrizRecPar)(m1,m2),
//  math.pow(2, i).toInt)

//for {
//  i <- 1 to 10
//  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
//  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
//} yield (compararAlgoritmos(multStrassen,multStrassenPar)(m1,m2),
//  math.pow(2, i).toInt)

//// Comparación entre los algoritmos secuenciales.
//for {
//  i <- 1 to 10
//  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
//  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
//} yield (compararAlgoritmos(multMatriz,multMatrizRec)(m1,m2),
//  math.pow(2, i).toInt)
//
//for {
//  i <- 1 to 10
//  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
//  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
//} yield (compararAlgoritmos(multMatrizRec,multStrassen)(m1,m2),
//  math.pow(2, i).toInt)
//
//for {
//  i <- 1 to 10
//  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
//  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
//} yield (compararAlgoritmos(multMatriz,multStrassen)(m1,m2),
//  math.pow(2, i).toInt)

//// Comparación entre algoritmos paralelos.
//for {
//  i <- 1 to 10
//  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
//  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
//} yield (compararAlgoritmos(multMatrizPar,multMatrizRecPar)(m1,m2),
//  math.pow(2, i).toInt)
//
//for {
//  i <- 1 to 10
//  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
//  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
//} yield (compararAlgoritmos(multMatrizRecPar,multStrassenPar)(m1,m2),
//  math.pow(2, i).toInt)
//
//for {
//  i <- 1 to 10
//  m1 = matrizAlAzar(math.pow(2, i).toInt, 2)
//  m2 = matrizAlAzar(math.pow(2, i).toInt, 2)
//} yield (compararAlgoritmos(multMatrizPar,multStrassenPar)(m1,m2),
//  math.pow(2, i).toInt)

//// Caso de prueba: Matrices de tamaño 2x2
//val m1 = matrizAlAzar(2, 2)
//val m2 = matrizAlAzar(2, 2)
//val m1m2 = multMatriz(m1,m2)
//val m1m2Par = multMatrizPar(m1,m2)
//val m1m2Rec = multMatrizRec(m1,m2)
//val m1m2RecPar = multMatrizRecPar(m1,m2)
//val m1m2Strassen = multStrassen(m1,m2)
//val m1m2StrassenPar = multStrassenPar(m1,m2)
//// Se verifica que todas las funciones den lo mismo.
//m1m2 == m1m2Par
//m1m2 == m1m2Rec
//m1m2 == m1m2RecPar
//m1m2 == m1m2Strassen
//m1m2 == m1m2StrassenPar
//// Se verifica que la suma y resta sean coherentes.
//val suma = sumMatriz(m1,m2)
//m1 == restaMatriz(suma,m2)
//
//// Caso de prueba: Matrices de tamaño 8x8
//val m1 = matrizAlAzar(8, 2)
//val m2 = matrizAlAzar(8, 2)
//val m1m2 = multMatriz(m1,m2)
//val m1m2Par = multMatrizPar(m1,m2)
//val m1m2Rec = multMatrizRec(m1,m2)
//val m1m2RecPar = multMatrizRecPar(m1,m2)
//val m1m2Strassen = multStrassen(m1,m2)
//val m1m2StrassenPar = multStrassenPar(m1,m2)
//// Se verifica que todas las funciones den lo mismo.
//m1m2 == m1m2Par
//m1m2 == m1m2Rec
//m1m2 == m1m2RecPar
//m1m2 == m1m2Strassen
//m1m2 == m1m2StrassenPar
//// Se verifica que la suma y resta sean coherentes.
//val suma = sumMatriz(m1,m2)
//m1 == restaMatriz(suma,m2)
//
//// Caso de prueba: Matrices de tamaño 64x64
//val m1 = matrizAlAzar(64, 2)
//val m2 = matrizAlAzar(64, 2)
//val m1m2 = multMatriz(m1,m2)
//val m1m2Par = multMatrizPar(m1,m2)
//val m1m2Rec = multMatrizRec(m1,m2)
//val m1m2RecPar = multMatrizRecPar(m1,m2)
//val m1m2Strassen = multStrassen(m1,m2)
//val m1m2StrassenPar = multStrassenPar(m1,m2)
//// Se verifica que todas las funciones den lo mismo.
//m1m2 == m1m2Par
//m1m2 == m1m2Rec
//m1m2 == m1m2RecPar
//m1m2 == m1m2Strassen
//m1m2 == m1m2StrassenPar
//// Se verifica que la suma y resta sean coherentes.
//val suma = sumMatriz(m1,m2)
//m1 == restaMatriz(suma,m2)
//
//// Caso de prueba: Matrices de tamaño 256x256
//val m1 = matrizAlAzar(256, 2)
//val m2 = matrizAlAzar(256, 2)
//val m1m2 = multMatriz(m1,m2)
//val m1m2Par = multMatrizPar(m1,m2)
//val m1m2Rec = multMatrizRec(m1,m2)
//val m1m2RecPar = multMatrizRecPar(m1,m2)
//val m1m2Strassen = multStrassen(m1,m2)
//val m1m2StrassenPar = multStrassenPar(m1,m2)
//// Se verifica que todas las funciones den lo mismo.
//m1m2 == m1m2Par
//m1m2 == m1m2Rec
//m1m2 == m1m2RecPar
//m1m2 == m1m2Strassen
//m1m2 == m1m2StrassenPar
//// Se verifica que la suma y resta sean coherentes.
//val suma = sumMatriz(m1,m2)
//m1 == restaMatriz(suma,m2)
//
//// Caso de prueba: Matrices de tamaño 512x512
//val m1 = matrizAlAzar(512, 2)
//val m2 = matrizAlAzar(512, 2)
//val m1m2 = multMatriz(m1,m2)
//val m1m2Par = multMatrizPar(m1,m2)
//val m1m2Rec = multMatrizRec(m1,m2)
//val m1m2RecPar = multMatrizRecPar(m1,m2)
//val m1m2Strassen = multStrassen(m1,m2)
//val m1m2StrassenPar = multStrassenPar(m1,m2)
//// Se verifica que todas las funciones den lo mismo.
//m1m2 == m1m2Par
//m1m2 == m1m2Rec
//m1m2 == m1m2RecPar
//m1m2 == m1m2Strassen
//m1m2 == m1m2StrassenPar
//// Se verifica que la suma y resta sean coherentes.
//val suma = sumMatriz(m1,m2)
//m1 == restaMatriz(suma,m2)

//// Punto 1.5, Implementando el producto punto usando paralelismo de datos.
//compararProdPunto(2)
//compararProdPunto(16)
//compararProdPunto(32)
//compararProdPunto(128)
//compararProdPunto(256)
//compararProdPunto(1024)
//compararProdPunto(2048)
//compararProdPunto(4096)
//compararProdPunto(8192)
//compararProdPunto(16384)
//compararProdPunto(32768)
//compararProdPunto(65536)
//compararProdPunto(131072)


//RESULTADOS REGISTRADOS OBTENIDOS Y SUS RESULTADOS COMPARATIVOS.

// compararAlgoritmos(multMatriz,multMatrizPar)(m1,m2)

val e0: IndexedSeq[((Double, Double, Double), Int)] =
  Vector(((0.0441,0.3516,0.12542662116040953),2),
    ((0.0257,0.0805,0.31925465838509315),4),
    ((0.0756,0.1344,0.5625),8),
    ((0.2811,0.9764,0.28789430561245394),16),
    ((1.4152,0.3435,4.119941775836972),32),
    ((5.3717,2.3536,2.282333446634942),64),
    ((37.2918,23.6129,1.5792977567346662),128),
    ((304.4371,171.1787,1.7784753593759037),256),
    ((2477.7999,1332.743,1.8591730738784598),512),
    ((21777.5295,10471.875,2.079620841539839),1024))

val e1: IndexedSeq[((Double, Double, Double), Int)] =
  Vector(((0.0311,0.0647,0.4806800618238022),2),
    ((0.0467,0.0615,0.7593495934959349),4),
    ((0.0524,0.2145,0.2442890442890443),8),
    ((0.1988,0.2128,0.9342105263157895),16),
    ((0.7727,0.5216,1.4814033742331292),32),
    ((5.9568,3.2552,1.8299336446301304),64),
    ((48.0621,28.9965,1.6575138378769851),128),
    ((373.5702,192.3139,1.9425023360245932),256),
    ((2595.4997,1328.963,1.953026306977696),512),
    ((22615.1483,10499.465,2.153933395653969),1024))

val e2: IndexedSeq[((Double, Double, Double), Int)] =
  Vector(((0.0775,0.1005,0.7711442786069651),2),
    ((0.0306,0.0617,0.4959481361426256),4),
    ((0.0484,0.0817,0.5924112607099143),8),
    ((0.2144,0.2782,0.7706685837526959),16),
    ((0.8613,0.497,1.7329979879275652),32),
    ((6.1123,3.3649,1.816487859966121),64),
    ((45.9702,29.1136,1.5789940096724553),128),
    ((367.4754,201.4365,1.8242741509110811),256),
    ((2580.1542,1256.9938,2.0526387640098145),512),
    ((21421.1105,10346.4481,2.070383023522826),1024))

val e3: IndexedSeq[((Double, Double, Double), Int)] =
  Vector(((0.0429,0.0791,0.5423514538558786),2),
    ((0.0091,0.0528,0.17234848484848486),4),
    ((0.0368,0.0632,0.5822784810126581),8),
    ((0.1836,0.295501,0.6213176943563643),16),
    ((1.2346,3.8231,0.3229316523240302),32),
    ((6.8564,3.1974,2.1443672984299744),64),
    ((47.8947,26.067501,1.8373337743422355),128),
    ((370.4129,208.524001,1.7763561902881384),256),
    ((2549.8832,1336.9112,1.9072943662974775),512),
    ((21130.973,10308.4556,2.04986797440346),1024))

val e4: IndexedSeq[((Double, Double, Double), Int)] =
  Vector(((0.0731,0.0833,0.8775510204081632),2),
    ((0.0279,0.1128,0.2473404255319149),4),
    ((0.094,0.1795,0.5236768802228412),8),
    ((0.3293,1.0097,0.32613647618104386),16),
    ((0.6992,0.696,1.0045977011494254),32),
    ((4.7594,2.4459,1.9458685964266733),64),
    ((38.5799,20.3091,1.8996361237080914),128),
    ((309.153,171.1996,1.8058044528141421),256),
    ((2309.3187,1150.889,2.0065520654033535),512),
    ((19648.9822,10074.0517,1.9504547708445847),1024))

// compararAlgoritmos(multMatrizRec,multMatrizRecPar)(m1,m2)

val r0: IndexedSeq[((Double, Double, Double), Int)] =
  Vector(((0.0125,0.0267,0.4681647940074906),2),
    ((0.0237,0.0626,0.37859424920127793),4),
    ((0.1948,0.1595,1.2213166144200627),8),
    ((0.8592,0.4467,1.9234385493619879),16),
    ((6.4095,2.3477,2.730118839715466),32),
    ((64.4153,18.1502,3.54901323401395),64),
    ((431.1129,142.2999,3.0296078915023834),128),
    ((3465.6238,1147.1905,3.020966264975172),256),
    ((27688.8092,9288.119,2.981099746891701),512),
    ((221544.3495,74209.6425,2.9853849450898515),1024))

val r1: IndexedSeq[((Double, Double, Double), Int)] =
  Vector(((0.0028,0.003,0.9333333333333333),2),
    ((0.0137,0.0471,0.2908704883227176),4),
    ((0.1037,0.0982,1.0560081466395113),8),
    ((0.8597,0.4245,2.025206124852768),16),
    ((6.7789,2.5174,2.6928179868117903),32),
    ((54.2703,17.9106,3.0300659944390476),64),
    ((431.4056,145.192,2.9712766543611218),128),
    ((3466.4742,1158.7546,2.991551619298858),256),
    ((27730.1588,9362.5781,2.9618080088432053),512),
    ((221762.0941,74422.2789,2.9797810195785335),1024))

// con umbral = 4:

//...

// compararAlgoritmos(multStrassen,multStrassenPar)(m1,m2)

val s0: IndexedSeq[((Double, Double, Double), Int)] =
  Vector(((0.0074,0.0062,1.1935483870967742),2),
    ((0.0497,0.0978,0.5081799591002045),4),
    ((0.4916,0.2135,2.302576112412178),8),
    ((1.5815,0.6785,2.3308769344141487),16),
    ((7.4228,3.7767,1.965419546164641),32),
    ((43.0942,16.0412,2.686469840161584),64),
    ((310.8794,104.7491,2.9678479337769965),128),
    ((2180.7757,721.7616,3.0214626269948415),256),
    ((15267.659,5081.7448,3.0044127757064856),512),
    ((107643.8453,35968.0719,2.9927610687410797),1024))

val s1: IndexedSeq[((Double, Double, Double), Int)] =
  Vector(((0.0031,0.0019,1.631578947368421),2),
    ((0.0157,0.0555,0.2828828828828829),4),
    ((0.1135,0.1508,0.7526525198938993),8),
    ((0.8633,0.5423,1.5919232896920523),16),
    ((32.1531,2.3563,13.645588422526844),32),
    ((45.5246,15.4341,2.949611574371035),64),
    ((309.4869,105.5268,2.932780108939151),128),
    ((2171.0991,733.3728,2.960430356838977),256),
    ((15310.5616,4964.9316,3.0837406904054836),512),
    ((107246.9233,35804.7617,2.9953257111050675),1024))

// con umbral = 4:

val s2: IndexedSeq[((Double, Double, Double), Int)] =
  Vector(((0.0132,0.0192,0.6875000000000001),2),
    ((0.0455,0.0711,0.639943741209564),4),
    ((0.2121,0.1659,1.278481012658228),8),
    ((1.0221,0.4563,2.239973701512163),16),
    ((7.4084,2.4072,3.077600531738119),32),
    ((44.5917,14.9022,2.9922897290332973),64),
    ((312.1107,103.7498,3.0083017027502708),128),
    ((2188.5974,727.9144,3.0066686412578183),256),
    ((15365.3213,5027.4427,3.056289691775105),512),
    ((107400.5579,35167.8846,3.0539385328851996),1024))

val s3: IndexedSeq[((Double, Double, Double), Int)] =
  Vector(((0.0025,0.0025,1.0),2),
    ((0.0165,0.0161,1.0248447204968945),4),
    ((0.1202,0.12,1.0016666666666667),8),
    ((0.8457,0.3752,2.253997867803838),16),
    ((6.4712,2.5333,2.554454663877156),32),
    ((43.775,15.1152,2.896091351751879),64),
    ((307.6558,104.3044,2.94959560670499),128),
    ((2129.528,714.8112,2.979147500766636),256),
    ((15431.3588,5037.549,3.0632672357132407),512),
    ((108309.4602,35638.6469,3.039101358250501),1024))

val s4: IndexedSeq[((Double, Double, Double), Int)] =
  Vector(((0.0026,0.0021,1.2380952380952381),2),
    ((0.0165,0.0151,1.0927152317880795),4),
    ((0.1178,0.0861,1.3681765389082463),8),
    ((0.8503,0.4506,1.887039502885042),16),
    ((6.5147,2.3431,2.780376424395032),32),
    ((41.5459,16.15,2.5725015479876165),64),
    ((307.2176,102.9226,2.984938196275648),128),
    ((2463.258,723.8962,3.40277791208187),256),
    ((15378.5597,5023.819,3.0611293320877997),512),
    ((108069.4118,35076.7282,3.0809433303987572),1024))


// COMPARATIVA SECUENCIAL
// Estandar vs. Recursivo
(e0 zip r0).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v1,w1,v1/w1),w)}
(e1 zip r1).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v1,w1,v1/w1),w)}
//(e2 zip r2).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v1,w1,v1/w1),w)}
//(e3 zip r3).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v1,w1,v1/w1),w)}
//(e4 zip r4).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v1,w1,v1/w1),w)}

// Recursivo vs. Strassen
(r0 zip s0).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v1,w1,v1/w1),w)}
(r1 zip s1).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v1,w1,v1/w1),w)}
//(r2 zip s2).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v1,w1,v1/w1),w)}
//(r3 zip s3).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v1,w1,v1/w1),w)}
//(r4 zip s4).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v1,w1,v1/w1),w)}

// Estandar vs. Strassen
(e0 zip s0).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v1,w1,v1/w1),w)}
(e1 zip s1).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v1,w1,v1/w1),w)}
(e2 zip s2).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v1,w1,v1/w1),w)}
(e3 zip s3).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v1,w1,v1/w1),w)}
(e4 zip s4).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v1,w1,v1/w1),w)}



// COMPARATIVA PARALELO
// Estandar vs. Recursivo
(e0 zip r0).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v2,w2,v2/w2),w)}
(e1 zip r1).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v2,w2,v2/w2),w)}
//(e2 zip r2).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v2,w2,v2/w2),w)}
//(e3 zip r3).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v2,w2,v2/w2),w)}
//(e4 zip r4).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v2,w2,v2/w2),w)}

// Recursivo vs. Strassen
(r0 zip s0).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v2,w2,v2/w2),w)}
(r1 zip s1).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v2,w2,v2/w2),w)}
//(r2 zip s2).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v2,w2,v2/w2),w)}
//(r3 zip s3).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v2,w2,v2/w2),w)}
//(r4 zip s4).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v2,w2,v2/w2),w)}

// Estandar vs. Strassen
(e0 zip s0).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v2,w2,v2/w2),w)}
(e1 zip s1).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v2,w2,v2/w2),w)}
(e2 zip s2).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v2,w2,v2/w2),w)}
(e3 zip s3).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v2,w2,v2/w2),w)}
(e4 zip s4).map{case (((v1,v2,v3),v),((w1,w2,w3),w)) => ((v2,w2,v2/w2),w)}