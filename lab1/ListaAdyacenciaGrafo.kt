class ListaAdyacenciaGrafo<T>(): Grafo<T>{

    private val vertices = MutableMapOf(T,MutableList<T>)

    override fun tamano():Int = vertices.size

    override fun contiene(v:T):Boolean = v in vertices

    override fun agregarVertice(v:T): Boolean {
        if(v in vertices) return false
        vertices.add(v,MutableListOf<T>())
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
        return MutableListOf<T>()
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
            arcosEntrada: MutableList<T> = MutableListOf<T>()
            for (vertice,arcos in vertices){
                if (v in arcos){
                    arcosEntrada.add(vertice)
                }
            }
        }
        return false
    }
}