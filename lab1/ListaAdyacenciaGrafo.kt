class ListaAdyacenciaGrafo<T>(): Grafo<T>{

    private val verticesLados = mutableMapOf<T, MutableList<T>>()

    override fun tamano():Int = verticesLados.size

    override fun contiene(v:T):Boolean = v in verticesLados

    override fun agregarVertice(v:T): Boolean {
        if(v in verticesLados) return false
        verticesLados.put(v,mutableListOf<T>())
        return true
    }

    override fun conectar(desde:T,hasta:T): Boolean {
        if (desde in verticesLados && hasta in verticesLados){
            verticesLados[desde]!!.add(hasta)
            return true
        }
        return false
    }

    override fun obtenerArcosSalida(v:T): List<T>{
        if(v in verticesLados){
            return verticesLados[v]!!.toList()
        }
        return listOf<T>()
    }

    override fun eliminarVertice(v:T): Boolean {
        if(v in verticesLados){
            verticesLados.remove(v)
            for (lista in verticesLados.values){
                if ( v in lista) {
                    lista.remove(v)
                }
            }
            return true
        }
        return false
    }

    override fun obtenerArcosEntrada(v:T): List<T>{
        if(v in verticesLados){
            var arcosEntrada: MutableList<T> = mutableListOf<T>()
            for ((vertice, arcos) in verticesLados){
                if (v in arcos){
                    arcosEntrada.add(vertice)
                }
            }
            return arcosEntrada
        }
        return listOf<T>()
    }

    // el parametro de entrada se llama vertices debido a que el nombre verticesLados ya esta ocupado
    override fun subgrafo(vertices: Collection<T>): ListaAdyacenciaGrafo<T>{
        for(v in vertices){
            if(!(v in vertices)) return ListaAdyacenciaGrafo<T>()
        }
        var subgrafo: ListaAdyacenciaGrafo<T> = ListaAdyacenciaGrafo<T>()
        for((v,k) in this.verticesLados){
            subgrafo.verticesLados.put(v,k)
        }
        val verticesLadosEliminar: List<T> = this.verticesLados.keys.filter {!(it in vertices)}
        for (vertice in verticesLadosEliminar){
            subgrafo.eliminarVertice(vertice)
        }
        return subgrafo
    }
}