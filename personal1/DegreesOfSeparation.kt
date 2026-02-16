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

    var total:Int = 1
    val alcanzables: MutableSet<String> = mutableSetOf<String>()
    val vertices = ArrayDeque<String>()
    val revisados = mutableSetOf<String>()

    grafo.obtenerArcosSalida(desde).forEach{elemento:String -> alcanzables.add(elemento); vertices.addLast(elemento)}

    var ultimo = vertices.last()
    var actual = vertices.first()
    revisados.add(actual)

    if (hasta in alcanzables) return 1

    while (!(vertices.isEmpty())){
        grafo.obtenerArcosSalida(actual).forEach{elemento:String -> alcanzables.add(elemento); if(!(elemento in revisados)){vertices.addLast(elemento)}}
        revisados.add(actual)
        if(actual == ultimo){
            ultimo = vertices.last()
            total++
        }
        if (hasta in alcanzables){
            if(actual!=ultimo) return total+1
            else return total
        }
        vertices.removeFirst()
        actual = vertices.first()
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