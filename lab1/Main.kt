fun main(){
    
    val grafo: Grafo<Int> = ListaAdyacenciaGrafo()

    grafo.agregarVertice(1)
    grafo.agregarVertice(2)
    grafo.agregarVertice(3)
    grafo.agregarVertice(4)
    grafo.agregarVertice(5) 

    println(grafo.tamano())
    println(grafo.contiene(2))

    grafo.conectar(1,2)
    grafo.conectar(1,3)
    grafo.conectar(1,4)
    grafo.conectar(1,5)
    grafo.conectar(2,2)
    grafo.conectar(2,3)
    grafo.conectar(3,4)
    grafo.conectar(5,3)

    println(grafo.obtenerArcosEntrada(4))
    println(grafo.obtenerArcosSalida(4))
    println(grafo.obtenerArcosSalida(2))
    println(grafo.obtenerArcosSalida(1))

    println(grafo.eliminarVertice(6))
    grafo.eliminarVertice(3)
    println(grafo.obtenerArcosSalida(2))
    println(grafo.obtenerArcosSalida(1))

    grafo.conectar(4,4)
    grafo.conectar(5,1)
    grafo.conectar(5,2)
    grafo.conectar(5,5)
    grafo.conectar(2,4)

    val grafo2 = grafo.subgrafo(listOf(5,1))
    println()
    println(grafo2.obtenerArcosSalida(5))
    println(grafo2.obtenerArcosSalida(1))

    println(grafo.tamano())
    println(grafo.obtenerArcosSalida(5))
}