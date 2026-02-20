 import java.io.File 
 
fun armar(linea:String,grafo:ListaAdyacenciaGrafo<String>){
    val nombres = linea.split(" ")
    grafo.agregarVertice(nombres[0])
    grafo.agregarVertice(nombres[1])
    grafo.conectar(nombres[0],nombres[1])
}

fun gradosSeparacion(desde:String,hasta:String,grafo:ListaAdyacenciaGrafo<String>):Int{

    if(desde == hasta){
        return 0
    }

    var total:Int = 0
    val alcanzables: MutableSet<String> = mutableSetOf<String>()
    val vertices = ArrayDeque<String>()
    val revisados = mutableSetOf<String>()

    vertices.addLast(desde)
    var ultimo: String = desde 
    var actual:String = desde
    var termino: Boolean = false

    while (!(termino)){
        grafo.obtenerArcosSalida(actual).forEach{elemento:String -> alcanzables.add(elemento); if(!(elemento in revisados)){vertices.addLast(elemento)}}
        revisados.add(actual)
        if (hasta in alcanzables){
            return total+1
        }
        if(actual == ultimo){
            ultimo = vertices.last()
            total++
        }
        vertices.removeFirst()
        if(!(vertices.isEmpty())){
            actual = vertices.first()
        }
        else{
            termino = true
        }
    }
    return -1
}

fun main(args:Array<String>){

    val archivo = File("input.txt")

    val grafo = ListaAdyacenciaGrafo<String>()

    archivo.forEachLine {linea: String -> armar(linea,grafo)}

    if(grafo.contiene(args[0]) && grafo.contiene(args[1])){
        println (gradosSeparacion(args[0],args[1],grafo))
    }
    else{
        println(-1)
    }

}