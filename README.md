# Proyecto-Final-FPFC

## Descripción de ArbolSufijos Package

Este archivo, ubicado en `/src/main/scala/ArbolSufijos/` y llamado `package.scala`, forma parte de la implementación para la función de la solución turbo acelerada. Se centra en la implementación de un árbol de sufijos en Scala.

### Contenido del Archivo

El archivo define un paquete denominado `ArbolSufijos` que contiene varias estructuras y funciones relacionadas con la manipulación de árboles de sufijos. A continuación, se presenta un resumen de las principales componentes:

### Estructuras

1. **Trie:** Una estructura abstracta que representa un nodo en el árbol de sufijos. Puede ser un nodo interno (`Nodo`) con hijos o una hoja (`Hoja`) marcada.

2. **Nodo:** Representa un nodo interno en el árbol, con un carácter asociado, un marcador booleano y una lista de hijos.

3. **Hoja:** Representa una hoja en el árbol, con un carácter asociado y un marcador booleano.

### Funciones Principales

1. **`raiz`:** Devuelve el carácter asociado a la raíz de un nodo o hoja.

2. **`cabezas`:** Devuelve una secuencia de caracteres que son las cabezas de los hijos de un nodo, o un solo carácter si es una hoja.

3. **`pertenece`:** Verifica si una subsecuencia dada pertenece al árbol de sufijos.

4. **`contieneSubsecuencia`:** Comprueba si el árbol de sufijos contiene una subsecuencia específica.

5. **`adicionar`:** Agrega una secuencia al árbol de sufijos, manteniendo su estructura.

### Uso del package 

El archivo proporciona herramientas para trabajar con árboles de sufijos, permitiendo la verificación de subsecuencias y la adición de nuevas secuencias al árbol.

##      

## Integrantes del Proyecto

- Wilson Andrés Mosquera Zapata (202182116)
- Andrés Camilo Henao Hidalgo (202227887)
- Juan José Bolaños Delgado (201942124)
