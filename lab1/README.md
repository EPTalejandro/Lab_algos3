
# Proyecto 1

### Alejandro Villamizar 2210439

### Carlos Bisogno 2210041

Para ejecutar el programa se debe usar el comando make para la compilación de los archivos, una vez hecho eso se usa ./runMain.sh para que el archivo de prueba corra. Los resultados, de acuerdo a lo escrito en el main, se imprimirán en la consola.

|        Operación        |    Complejidad     |          Justificación                                                                                                                                                                                                         |
|:-----------------------:|:------------------:|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Agregar vertice         |       O(1)         | Verificar si contiene el vértice O(1),  por el mutableMap, que usa hasheo, agregar un nuevo elemento es O(1)                                                                                                                   |
| Conectar                |       O(1)         | Verificar si contiene los vértices O(1), por el mutableMap, que usa hasheo, acceder al vértice es O(1) y agregar un elemento a una lista es O(1)                                                                               |
| Contiene                |       O(1)         | Por el uso de mutableMap la verificación para ver si un elemento se encuentra contenido es O(1)                                                                                                                                |
| Obtener arcos salida    |       O(n)         | Verificar si contiene el vértice O(1), por el mutableMap, que usa hasheo, acceder al vértice es O(1), y copiar los vertices a una lista nueva es O(n)                                                                          |
| Obtener arcos entrada   |       O($$n^2$$)   | Verificar si contiene el vértice O(1), se recorren los n elementos, para todos se verifica su lista asociada, a lo sumo n elementos, esto es O($$n^2$$)                                                                        |
| Eliminar vertice        |       O($$n^2$$)   | Debe recorrer los "n" vértices y para cada uno verificar si en la lista, de a lo sumo n elementos, se encuentra el vértice eliminado                                                                                           |
| Tamaño                  |       O(1)         | Por el uso de mutableMap, existe un contador interno de elementos, acceder al valor es O(1)                                                                                                                                    |
| Subgrafo                |       O($$n^3$$)   | Verificar si el grafo contiene los n vértices indicados O(n), para cada vértice en la lista dada, a lo sumo n, se revisa si cada elemento de la mutableList, igual a lo sumo n, está en la lista dada, el tiempo es O($$n^3$$) |

### Implementacion

A continuacion se detalladaran las desciciones que fueron tomadas a la hora de implementar el codigo:

Como se tatraba de un grafo como lista de adyacencia se crea un MutableMap en el cual su clave sera el vertice de tipo T(osea el dado a la hora de crear el Grafo) y su valor sera una MutableList en la cual se guardaran los vertices adyacentes a este.

Funciones:

* tamaño: aprovecha el atributo .size de mutableMapOf para obtener cuantos vértices se encuentran en el grafo.

* contiene: verifica que el vértice dado pertenece al grafo, si es así devuelve true, en caso contrario devuelve false.

* agregarVertice: dado un vértice verifica si ya está en el grafo, de ser así devuelve false, en caso contrario lo agrega al grafo y devuelve true.

* conectar: dados dos vértices se verifica que ambos pertenezcan al grafo, de no ser así devuelve false. Si ambos pertenecen se crear un arcos del primer al segundo vértice.

* obtenerArcosSalida: dado un vértice verifica si pertenece al grafo, de no ser así devuelve una lista vacía, sino devuelve una lista con los arcos de salida del vértice.

* obtenerArcosEntrada: dado un vértice verifica si pertenece al grafo, de no ser así devuelve una lista vacía. Si pertenece, entonces para cada vértice verifica si existe un arco hacia el vértice dado, y si lo hay agrega el vértice a una lista que se retornará al final de la función.

* subgrafo: la primera acción es comprobar si todos los vertices dados pertenecen al grafo original, en caso contrario no existe un subgrafo con esos vertices. Una vez comprobado lo anterior se crea un nuevo grafo para no modificar el original, para cada vértice dado se obtiene su lista de arcos, se filtra para conversar sólo los vértices que pertenecerán al subgrafo, luego se guarda el vértice junto con su lista de arcos en el nuevo grafo. El método retorna un grafo.

* eliminarVertice: dado un vértice se verifica si pertenece al grafo, de no ser así devuelve false. Si pertenece se elimina de verticesLados lo cual elimina todos sus arcos de salida, luego elimina el vértice dado en los arcos de los demás vértices.
