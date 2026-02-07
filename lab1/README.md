
# Proyecto 1

Alejandro Villamizar 2210439

Carlos Bisogno 2210041

Parrafo

|        Operación        |    Complejidad     |          Justificación                                                                                                                                  |
|:-----------------------:|:------------------:|---------------------------------------------------------------------------------------------------------------------------------------------------------|
| Agregar vertice         |       O(1)         | Verificar si contiene el vértice O(1),  por le mutableMap, que usa hasheo, agregar un nuevo elemento es O(1)                                            |
| Conectar                |       O(1)         | Verificar si contiene los vértices O(1), por el mutableMap, que usa hasheo, acceder al vértice es O(1) y agregar un elemento a una lista es O(1)        |
| Contiene                |       O(1)         | Por el uso de mutableMap la verificación para ver si un elemento se encuentra contenido es O(1)                                                         |
| Obtener arcos salida    |       O(n)         | Verificar si contiene el vértice O(1), por el mutableMap, que usa hasheo, acceder al vértice es O(1), y copiar los vertices a una lista nueva es O(n)   |
| Obtener arcos entrada   |       O($$n^2$$)   | Verificar si contiene el vértice O(1), se recorren los n elementos, para todos se verifica su lista asociada, a lo sumo n elementos, esto es O($$n^2$$) |
| Eliminar vertice        |       O($$n^2$$)   | Debe recorrer los "n" vértices y para cada uno verificar si en la lista, de a lo sumo n elementos, se encuentra el vértice eliminado                    |
| Tamaño                  |       O(1)         | Por el uso de mutableMap, existe un contador interno de elementos, acceder al valor es O(1)                                                             |
| Subgrafo                |       O(n)         |                                                                                                                                                         |
