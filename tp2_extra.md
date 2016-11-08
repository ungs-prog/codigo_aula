---
lang: es
fontsize: 11pt
title: Trabajo práctico n.º 2
author: Programación II
date: Segundo cuatrimestre 2016
linkcolor: black
urlcolor: blue
links-as-notes: true
geometry: top=2.5cm,bottom=2.5cm,left=4cm,right=4cm
mainfont: TeXGyrePagellaX
monofont: Consolas
monofontoptions: Scale=0.9
numbersections: true
toc-depth: 2
secnumdepth: 2
math: true
layout: default
---

Añadir JUnit a un proyecto en Eclipse
=====================================

Los casos de prueba proporcionados para la clase _Deque_ están en formato _JUnit_. JUnit es una herramienta estandar de Java para verificar de manera automática que una implementación se comporta de la manera esperada.

El archivo _TestDeque.java_ se puede ejecutar normalmente una vez se añade la biblioteca JUnit4 al proyecto de Eclipse.

La opción se encuentra en: `Project -> Build Path -> Add libraries -> JUnit -> Versión 4`.[^1]

[^1]: Todas las instalaciones de Eclipse incluyen la biblioteca. Lo único necesario, como se muestra en este paso, es habilitarla para cada proyecto que la necesite.


Introducción a diccionarios en Java
===================================

Un diccionario es un tipo abstracto de datos que permite asociar parejas de elementos, esto es: dado un elemento $a_1$, podemos asociarle un valor $b_1$. Después, podremos preguntarle a la estructura: ¿qué valor quedó asociado con $a_1$?---y obtener $b_1$ como respuesta.

Conceptualmente, se puede concebir el diccionario como un conjunto de tuplas $(a_i, b_i)$ con las siguientes restricciones:

  - no puede haber dos tuplas $t_i$ y $t_j$ tal que $a_i = a_j$.

  - a la hora de averiguar valores asociados, la pregunta se realiza por el _primer_ elemento de la tupla; no es posible realizarla por el segundo.

    Así, es posible preguntar cuál es el $b$ (segundo elemento de la tupla) asociado a un $a_i$, pero no al revés.

Clave y significado
-------------------

Usando la terminología propia de diccionarios, al primer elemento de la tupla se le denomina _clave_ y al segundo _valor_ o _significado_.

Por tanto, un diccionario genérico usa dos tipos paramétricos $K$ y $V$: uno para las claves, y otro para los significados (esto es: clave y significado pueden ser de tipos distintos).

Clases de Java
--------------

El diccionario genérico se representa en Java mediante la interfaz $Map<C, S>$ (clave, significado) o $Map<K, V>$ (_key_, _value_ en inglés). La biblioteca estándar del lenguaje incluye dos implementaciones: _HashMap_ y _TreeMap_.

Primitivas
----------

Así, las primitivas más importantes del TAD diccionario son:

  - `agregar(c, s)`: asociar a la clave $$c$$ el significado $$s$$

  - `obtener(c)`: obtener el valor asociado con una clave.

  - `pertenece(c)`: preguntar si existe una clave en el diccionario.

  - `borrar(c)`: eliminar una pareja del diccionario, buscando por su clave.

Los métodos de los diccionarios de Java se pueden consultar en la [documentación de Map][map]. En particular, las cuatro primitivas anteriores se traducen así:

  - `V put(K key, V value)` (devuelve el valor anteriormente asociado con $k$, o _null_ si no lo hubiere)

  - `V get(Key k)`

  - `boolean containskey(Key k)`

  - `V remove(Key k)`

[map]: https://docs.oracle.com/javase/7/docs/api/java/util/Map.html

Complejidad
-----------

El TAD diccionario puede estar implementado sobre cualquier estructura, pero por razones de eficiencia las más comunes son dos: un árbol binario de búsqueda, o una tabla hash.

Java proporciona un diccionario sobre ABB en la clase _TreeMap_. Las cuatro primitivas arriba mencionadas tienen complejidad O(log n). Java mantiene la invariante del ABB comparando los elementos entre sí al insertar.

La implementación de diccionario de Java sobre tabla hash se llama _HashMap_. En general, las primitivas de diccionario sobre tabla hash tienen complejidad O(1). Esto se consigue con el uso de una _función hash_ sobre K (no hace falta función hash para V).

Java proporciona una función hash para todos sus tipos primitivos. Por tanto, en caso de tener un diccionario _Map<String, Persona>_, no es necesario que el usuario proporcione ninguna función de hash. Lo mismo ocurriría con, por ejemplo, _Map<Integer, String>_.

Por el contrario, si K es un tipo proporcionado por el usuario, por ejemplo en _Map<Persona, Integer>_ el usuario _sí_ tendría que proporcionar una función hash para el tipo _Persona_.


Algunos comentarios sobre Deque
===============================

Comparación
-----------

En principio, el TAD "cola doblemente terminada" es genérico sobre un T arbitrario y no realiza operaciones sobre los elementos: simplemente los almacena.

La interfaz _Deque_ de Java, no obstante, añade algunos métodos sobre el TAD que sí "miran"los elementos, en particular para realizar comparaciones de igualdad.

Las cuatro primitivas de _Deque_ que realizan comparaciones de igualdad son:

  - `removeFirstOccurrence()`
  - `removeLastOccurrence()`
  - `contains()`
  - `containsAll()`

Estas comparaciones se deben realizar con el método _equals()_, que está presente en todos los objetos de Java. Su signatura es:

    public boolean equals(Object obj);

Esto es, recibe un objeto genérico.

Por esta razón, las cuatro primitivas que realizan comparaciones incluyen _Object_ en su firma:

  - `removeFirstOccurrence(Object obj)`
  - `removeLastOccurrence(Object obj)`
  - `contains(Object obj)`
  - `containsAll(Collection<?> col)`

Nota: _Collection<?>_ es, a efectos prácticos, equivalente a _Collection<Object>_. La iteración se realiza con una variable de tipo _Object_:

    for (Object elem : col) ...

Excepciones
-----------

Solo hay cuatro primitivas que lanzan excepciones, y solo la lanzan cuando el deque está vacío:

  - `getFirst()`
  - `getLast()`
  - `removeFirst()`
  - `removeLast()`
