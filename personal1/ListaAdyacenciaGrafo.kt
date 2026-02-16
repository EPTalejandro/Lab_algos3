class ListaAdyacenciaGrafo<T>(): Grafo<T>{

    val verticesLados = mutableMapOf<T, MutableSet<T>>()

    override fun tamano():Int = this.verticesLados.size

    override fun contiene(v:T):Boolean = v in this.verticesLados

    override fun agregarVertice(v:T): Boolean {
        if(contiene(v)) return false
        verticesLados.put(v,mutableSetOf<T>())
        return true
    }

    override fun conectar(desde:T,hasta:T): Boolean {
        if (contiene(desde) && contiene(hasta)){
            verticesLados[desde]!!.add(hasta)
            verticesLados[hasta]!!.add(desde)
            return true
        }
        return false
    }

    override fun obtenerArcosSalida(v:T): List<T>{
        if(contiene(v)){
            return verticesLados[v]!!.toList()
        }
        return listOf<T>()
    }

    override fun eliminarVertice(v:T): Boolean {
        if(contiene(v)){
            verticesLados.remove(v)
            for (lista in verticesLados.values){
                if (v in lista) {
                    lista.remove(v)
                }
            }
            return true
        }
        return false
    }

    override fun obtenerArcosEntrada(v:T): List<T>{
        if(contiene(v)){
            var arcosEntrada: MutableSet<T> = mutableSetOf<T>()
            for ((vertice, arcos) in verticesLados){
                if (v in arcos){
                    arcosEntrada.add(vertice)
                }
            }
            return arcosEntrada.toList()
        }
        return listOf<T>()
    }
    
    override fun subgrafo(vertices: Collection<T>): ListaAdyacenciaGrafo<T>{
        for(v in vertices){
            if(!(contiene(v))) return ListaAdyacenciaGrafo<T>()
        }
        val subgrafo = ListaAdyacenciaGrafo<T>()
        for (v in vertices){
            val originales = this.verticesLados[v]
            val copiaFiltrada: MutableSet<T> = originales!!.filter { it in vertices }.toMutableSet()
            subgrafo.verticesLados.put(v, copiaFiltrada)
        }
        return subgrafo
    }
}