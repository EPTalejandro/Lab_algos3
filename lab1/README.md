
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
| Subgrafo                |       O($$n^2$$)   | Verificar si el grafo contiene los n vértices indicados O(n), para cada vértice en la lista dada, a lo sumo n, se revisa si cada elemento de la mutableList, igual a lo sumo n, está en la lista dada, el tiempo es O($$n^2$$) |

### Implementacion

A continuacion se detalladaran las desciciones que fueron tomadas a la hora de implementar el codigo:

Como se tatraba de un grafo como lista de adyacencia se crea un MutableMap en el cual su clave sera el vertice de tipo T(osea el dado a la hora de crear el Grafo) y su valor sera una MutableList en la cual se guardaran los vertices adyacentes a este.

Funciones:

* Subgrafo: primero se comprueba si todos los vertices dados pertenecen al grafo original, en caso contrario no existe un subgrafo con esos vertices. Una vez comprobado que todos los vertices dados pertenecen e duplica el grafo original para no modificarlo, y al duplicado se le aplicara la funcion de eliminar vertice a todos los vertices que no fueron dados por el usurio, asi al final se tendria el subgrafo requerido.

* eliminarVertice: se elimina de vertices lados la entrada del vertice dado lo cual elimina todos los lados de este, y luego solo queda eliminar el vertice dado en los lados de los demas vertices.
