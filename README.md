# Proyecto-Final-FPFC


## ReconstCadenas

## Contenido del Archivo

El archivo `package.scala` en este directorio incluye las siguientes funciones:

### `reconstruirCadenaIngenuo(n: Int, o: Oraculo): Seq[Char]`

Implementa una solución ingenua para reconstruir una cadena de longitud `n` utilizando un oráculo. Genera todas las posibles secuencias de longitud `n` y encuentra la primera subsecuencia que es parte de la cadena buscada según el oráculo.

### `reconstruirCadenaMejorado(n: Int, o: Oraculo): Seq[Char]`

Implementa una solución mejorada para reconstruir una cadena de longitud `n` utilizando un oráculo. Usa la propiedad de que si `s = s1 ++ s2`, entonces `s1` y `s2` también son subsecuencias de `s`. Genera subcadenas de longitud creciente, filtrando y verificando con el oráculo hasta encontrar la solución.

### `reconstruirCadenaTurbo(n: Int, o: Oraculo): Seq[Char]`

Implementa una solución turbo para reconstruir una cadena de longitud `n` utilizando un oráculo. Aprovecha la propiedad de concatenación de subcadenas y utiliza un enfoque más eficiente generando subcadenas a partir de un conjunto inicial.

### `reconstruirCadenaTurboMejorada(n: Int, o: Oraculo): Seq[Char]`

Implementa una solución turbo mejorada para reconstruir una cadena de longitud `n` utilizando un oráculo. Además de la propiedad de concatenación, incorpora un filtro para optimizar la generación y verificación de subcadenas.

## Uso del Archivo

Estas funciones ofrecen diferentes estrategias para la reconstrucción de cadenas, adaptándose a diversos contextos y mejorando el rendimiento en comparación con enfoques más simples.



## ArbolSufijos

Este directorio contiene el archivo `package.scala`, el cual implementa diferentees funciones para la reconstrucción de cadenas utilizando 

## Contenido del Archivo

El archivo incluye las siguientes funciones:

1. **`reconstruirCadenaIngenuo(n: Int, o: Oraculo): Seq[Char]`**
   - Implementa una solución ingenua para reconstruir una cadena de longitud `n` utilizando un oráculo.

2. **`reconstruirCadenaMejorado(n: Int, o: Oraculo): Seq[Char]`**
   - Implementa una solución mejorada para reconstruir una cadena de longitud `n` utilizando un oráculo.

3. **`reconstruirCadenaTurbo(n: Int, o: Oraculo): Seq[Char]`**
   - Implementa una solución turbo para reconstruir una cadena de longitud `n` utilizando un oráculo.

4. **`reconstruirCadenaTurboMejorada(n: Int, o: Oraculo): Seq[Char]`**
   - Implementa una solución turbo mejorada para reconstruir una cadena de longitud `n` utilizando un oráculo.

## Uso del Archivo

Estas funciones ofrecen diferentes enfoques para la reconstrucción de cadenas, permitiendo adaptarse a diversas restricciones y mejorar el rendimiento en comparación con enfoques más simples.

## Integrantes del Proyecto


## ArbolSufijos Package

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


# ReconstCadenasPar

Este paquete contiene las implementaciones de `ReconstCadenas`, pero usando paralelismo. Esto, a fin de comparar al final ambas versiones de las funciones, y ver en qué caso qué versión sería más optima a cual.

## Integrantes del Proyecto

- Wilson Andrés Mosquera Zapata (202182116)
- Andrés Camilo Henao Hidalgo (202227887)
- Juan José Bolaños Delgado (201942124)
