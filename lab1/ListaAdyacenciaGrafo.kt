class ListaAdyacenciaGrafo<T>(): Grafo<T>{

    private val vertices = mutableMapOf(T, MutableList<T>)

    override fun tamano():Int = vertices.size

    override fun contiene(v:T):Boolean = v in vertices

    override fun agregarVertice(v:T): Boolean {
        if(v in vertices) return false
        vertices.add(v,mutableListOf<T>())
        return true
    }

    override fun conectar(desde:T,hasta:T): Boolean {
        if (desde in vertices && hasta in vertices){
            vertices[desde].add(hasta)
            return true
        }
        return false
    }

    override fun obtenerArcosSalida(v:T): MutableList<T>{
        if( v in vertices){
            return vertices[v]
        }
        return mutableListOf<T>()
    }

    override fun eliminarVertice(v:T): Boolean {
        if(v in vertices){
            vertices.remove(v)
            for (lista in vertices.values){
                if ( v in lista) {
                    lista.remove(v)
                }
            }
            return true
        }
        return false
    }

    override fun obtenerArcosEntrada(v:T){
        if(v in vertices){
            var arcosEntrada: MutableList<T> = mutableListOf<T>()
            for (vertice, arcos in vertices){
                if (v in arcos){
                    arcosEntrada.add(vertice)
                }
            }
        }
        return false
    }

    // el parametro de entrada se llama vers debido a que el nombre vertices ya esta ocupado
    override fun subgrafo(vers: List<T>): ListaAdyacenciaGrafo<T>{
        for(v in vers){
            if(!(v in vers)) return false
        }
        var subgrafo: ListaAdyacenciaGrafo<T> = ListaAdyacenciaGrafo<T>()
        subgrafo.vertices = this.vertices
        val verticesEliminar: List<T> = this.vertices.filter {!(it in vers)}
        for (vertice in verticesEliminar){
            subgrafo.eliminarVertice(vertice)
        }
        return subgrafo
    }
}