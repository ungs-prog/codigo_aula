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

La fecha de entrega de este TP es el **17 de noviembre de 2016**. Se puede realizar de manera individual, o en grupos de a lo sumo dos personas.

El TP consta de dos ejercicios que se entregarán de manera conjunta en un único ZIP con el código Java. Se deben seguir las instrucciones especificadas al final de esta consigna.

El código de apoyo para los ejercicios se puede descargar aquí:

<https://github.com/ungs-prog2/codigo_aula/archive/tp2_2016_2.zip>

\setcounter{tocdepth}{2}  <!-- toc-depth in header not used if toc: false -->
\tableofcontents

\newpage


Generics
========

Consigna
--------

Se pide implementar **la interfaz Deque<E> de Java** usando nodos doblemente enlazados. Dicha interfaz representa una cola doblemente terminada.

Lineamientos de la entrega:

  - La única estructura auxiliar que se permite es _Nodo_.

  - El método `removeLast()` debe tener complejidad computacional $\mathcal{O}(1)$.

  - El nombre de la clase debe ser _DequeEnlazada_ y debe implementar correctamente la interfaz [_Deque_ de Java.][javadoc]

  - Los siguientes métodos no forman parte del trabajo práctico, esto es, no se deben implementar; para cumplir la interfaz, simplemente devolverán _null_ (o _false_, según corresponda):

      + `iterator()`
      + `descendingIterator()`
      + `toArray()`
      + `removeAll()`
      + `retainAll()`

El resto de la sección describe en mayor detalle la tarea a realizar.

[javadoc]: https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html


Cola doblemente terminada
-------------------------

Una [cola doblemente terminada][wp] es una estructura de datos normalmente enlazada con primitivas de inserción y borrado para cada extremo (cabeza y cola).

[wp]: https://es.wikipedia.org/wiki/Cola_doblemente_terminada

Las primitivas resultantes son:

|          | Inserción         | Examen       | Borrado           |
|----------+-------------------+--------------+-------------------|
| _Cabeza_ | `insertarPrimero` | `verPrimero` | `eliminarPrimero` |
| _Cola_   | `insertarUltimo`  | `verUltimo`  | `eliminarUltimo`  |

De estas seis primitivas, las primeras cinco son $\mathcal{O}(1)$ de manera trivial al combinar una estructura enlazada simple con una referencia al último elemento. Por el contrario, para implementar `eliminarUltimo()` en tiempo constante es imprescindible usar nodos doblemente enlazados.

En los nodos doblemente enlazados cada nodo mantiene dos referencias: una a su nodo siguiente y una segunda a su nodo anterior. Para mantener esta invariante, todas las primitivas de la estructura deberán actualizar ambas referencias cuando corresponda.


La interfaz _Deque_ de Java
---------------------------

Por los siguientes motivos, la interfaz _Deque_ de Java incluye más primitivas de las que se listaron arriba:

  1. Las primitivas de examen y borrado ofrecen dos variantes según su comportamiento cuando la cola está vacía:

     - `removeFirst()` y `getFirst()` lanzan _NoSuchElementException_.
     - `pollFirst()` y `peekFirst()`, por el contrario, simplemente devuelven _null_.

  2. Debido a interfaces como _Stack_ y _Queue_, anteriores a Java 1.5, _Deque_ ofrece más de un nombre para algunos de sus métodos, así:

     | Alias       | Canónico        |
     |-------------+-----------------|
     | `push()`    | `addFirst()`    |
     | `add()`     | `offerLast()`   |
     | `offer()`   | `offerLast()`   |
     | `pop()`     | `removeFirst()` |
     | `remove()`  | `removeFirst()` |
     | `poll()`    | `pollFirst()`   |
     | `peek()`    | `peekFirst()`   |
     | `element()` | `getFirst()`    |

  3. _Deque_, además, hereda de _Collection_, lo cual añade (entre otros métodos):

     - `clear()`
     - `addAll()`
     - `contains()`
     - `containsAll()`

  4. _Deque_ viola (o extiende) la interfaz estándar de cola doblemente terminada ofreciendo borrado de nodos intermedios:

     - `removeFirstOccurrence()`
     - `removeLastOccurrence()`


Materiales y ayuda para la implementación
-----------------------------------------

Para aliviar la cantidad de “trabajo burocrático” que conlleva implementar la interfaz _Deque_ al completo, se incluye en el código de apoyo una clase abstracta _DequeBase_.

Esta clase marca como _abstract_ las diez o doce primitivas principales de la clase a implementar por el alumno, e incluye definiciones para las demás.[^1]

[^1]: El uso de esta clase base, aunque recomendado, es enteramente opcional; verdaderamente, los lineamientos de la entrega al principio de la consigna son suficientes para implementar el ejercicio.

De usarse esta clase base, la declaración final de _DequeEnlazada_ quedaría:

    public class DequeEnlazada<T>
                    extends DequeBase<T> implements Deque<T> { ... }

**Otras indicaciones:**

  - se puede arrancar a partir de las clases _PilaInt_ y _ColaInt_ vistas en la cursada y/o en materias anteriores. El código de apoyo incluye sendas implementaciones como referencia.

  - también se incluye una clase _TestDeque_ con pruebas para la implementación a entregar. El código entregado _debe_ pasar estas pruebas para ser admisible. No obstante, durante la corrección se podrá aplicar un conjunto más extenso de pruebas.


Ejemplo de uso
--------------

Un ejemplo inicial del uso de _Deque_ sería:

```c

Deque<String> deque = new DequeEnlazada<>();

deque.addFirst("b");
deque.addFirst("a");
deque.addLast("c");

deque.size();        // 3
deque.isEmpty();     // false

deque.getFirst();    // "a"
deque.removeLast();  // "c"
deque.getLast();     // "b"
deque.size();        //  2


// Excepciones sobre un deque vacío:

Deque<String> vacío = new DequeEnlazada<>();

deque.isEmpty();    // true
vacío.peekFirst();  // devuelve null
vacío.getFirst();   // lanza NoSuchElementException
```

\newpage


Polimorfismo
============

Introducción
------------

Como parte de un proyecto de investigación, en la UNGS se está diseñando una nueva red social y nos han pedido un diseño de clases para representar las relaciones entre distintas personas.

En esta primera versión solo guardaremos el nombre de las personas de la red y sus relaciones, aunque quizá en el futuro se haga necesario almacenar más información.

Lo que sí quedó establecido es que se debe poder representar dos tipos distintos de red social:

  - en una _red simétrica_ se considera que las relaciones son recíprocas, esto es: si A aparece en la lista de relaciones de B, B también debe aparecer en la lista de A.

  - en una _red asimétrica_ no se exige que las relaciones sean recíprocas: A puede tener a B en su lista de relaciones sin que B necesariamente tenga a A en la suya.


Objetivos
---------

Las siguientes objetivos deben primar en la versión inicialmente entregada a los investigadores:

  - Minimizar la cantidad repetida de código.

  - Diseñar de manera que los futuros algoritmos puedan funcionar sobre cualquiera de los dos tipos de red.

  - Usar las estructuras de datos adecuadas para una implementación eficiente tanto en espacio como en tiempo.


Operaciones sobre una red social
--------------------------------

Las operaciones más importantes sobre la clase-TAD _RedSocial_ son dos:

  1. agregar una relación entre dos personas, A y B.[^3]

  2. obtener el conjunto de relaciones de una persona A.[^4]

[^3]: La API debe indicar si la operación se llevó a cabo o no, esto es: si efectivamente se añadió la relación porque no existía previamente o si, por el contrario, no se realizó acción alguna porque la relación ya existía.

[^4]: No se exige ningún orden específico; queda gobernado por la implementación.

Como primitivas de consulta auxiliares se debe poder obtener:

  3. el número personas en la red.

  4. el número total de relaciones en la red.

  5. el número de relaciones de una persona en concreto.

Al crear la red no se conoce cuántas personas formarán parte de ella. Tampoco hay una primitiva explícita para agregar personas: estas se incorporan a la red de manera gradual, según se crean relaciones que las involucran.[^5]

[^5]: Por esta razón, el único error posible resulta de consultar el número de relaciones de una persona que no está presente en la red; en ese caso, es suficiente con devolver cualquier valor negativo. En el caso de las relaciones de una persona que no está en la red, se _sugiere_ devolver el conjunto vacío.


Complejidad asintótica
----------------------

Se establece que el tiempo de ejecución de las siguientes cuatro primitivas debe estar en $\mathcal{O}(1)$:

  - `totalPersonas()`
  - `totalRelaciones()`
  - `numRelaciones(a)`
  - `agregarRelacion(a, b)`

También se establece un límite al uso de memoria: la complejidad espacial de la red, esto es, el espacio que ocupa el objeto en memoria, debe quedar en $\mathcal{O}(n \times m)$ —donde $n$ y $m$ son, respectivamente, el número de personas y el número total de relaciones en la red.

Finalmente, se desea que la lista de relaciones de una persona se pueda obtener con complejidad espacial $\mathcal{O}(1)$ y se pueda recorrer con complejidad temporal $\mathcal{O}(m_a)$, donde $m_a$ es el número de relaciones de esa persona.


Informe
-------

Para este segundo ejercicio (no así para el primero) se pide un informe de como mucho _una_ carilla con la siguiente información:

  - uno o dos párrafos sobre cómo se alcanzó un diseño polimórfico: si mediante interfaces o mediante herencia, y por qué de ese modo frente al otro.

  - uno o dos párrafos explicando cómo se evitó la repetición de código, y en qué casos no se pudo evitar (si hubo alguno).

  - uno o dos párrafos describiendo las dificultades encontradas en el uso de estructuras de datos, o cualquier otro aspecto de la implementación.


Guía de implementación
----------------------

Muchas de las primitivas se pueden implementar en $\mathcal{O}(1)$ simplemente usando de modo adecuado las implementaciones de diccionario y/o conjunto de Java: _HashMap_, _HashSet_, etc. No se pide, en ningún caso, que estas estructuras sean implementadas como parte del trabajo práctico. Lo mismo ocurre para la complejidad espacial de la red.

El caso más complejo es la obtención de las relaciones de una persona:

  - al pedirse complejidad espacial $\mathcal{O}(1)$, no se debe realizar una copia de esa lista o estructura.

  - al mismo tiempo, la interfaz no debe exponer ni la implementación particular de la estructura que almacena las relaciones, ni desde luego permitir su modificación desde fuera.

Por esto, se aconseja el uso de iteradores de manera que se pueda escribir:

    static void imprimirRelaciones(RedSocial red, String persona)
    {
        for (String r : red.relaciones(persona))
            System.out.println(r);
    }

donde la primitiva _relaciones()_ tendría la siguiente signatura:

    Iterator<String> relaciones(String persona)
    {
        // ...
    }

El uso de iteradores permite cumplir con los tres requisitos: complejidad espacial $\mathcal{O}(1)$, complejidad temporal $\mathcal{O}(m_a)$ y no exponer la estructura subyacente ni permitir su modificación.

Cabe notar que, por lo general, _no_ corresponde implementar un iterador propio para estructuras estándar del lenguaje. En particular, todas las colecciones de Java tienen un método _iterator()_ en el que se puede delegar la primitiva:

    Iterator<String> relaciones(String a)
    {
        // Obtener una referencia a la estructura de ‘a’ y devolver
        // su iterador:
        return estructura_A.iterator();
    }

Para devolver el conjunto vacío, se puede crear una estructura vacía y devolver su iterador, o usar el método de Java `Collections.emptyIterator()`.


Caso de prueba
--------------

Junto con la implementación de las clases necesarias, se pide un archivo de ejemplo donde:

  1. se cree una red de cada tipo

  2. se invoque a los distintos métodos de cada red, comprobando que el resultado sea correcto.

Como _mínimo_, en el caso de prueba se tiene que construir la red que se representa en la figura \ref{filo}.

![¿Quién influenció a quién? (7 nodos y 10 relaciones)](filo.pdf){#filo}

\newpage


Instrucciones para la entrega {-}
=============================

### Formato ###

La entrega se realiza por correo electrónico en un mensaje que debe contener dos archivos adjuntos:

  - primer adjunto: un archivo PDF con el informe (una carilla) del ejercicio 2.

  - segundo adjunto: un archivo ZIP con los archivos fuente del proyecto.[^6] En particular, se espera:

      - la solución al ejercicio 1 en un un archivo llamado
        _DequeEnlazada.java_. La definición de nodo puede incluirse en este
        archivo o, si se prefiere, en un archivo separado.

        Los archivos _DequeBase.java_ y _TestDeque.java_ **no** deben ser modificados y no forman parte de la entrega.

        Si, por iniciativa propia, el alumno añade sus propios casos de prueba, los puede entregar en un archivo _TestDequeAlumno.java_.

      -  los archivos de código para el ejercicio 2, que serán al menos tres: las implementaciones de red simétrica y asimétrica más sus casos de prueba. Obviamente, se permite incluir más clases y archivos de código según necesite el diseño propuesto.

[^6]: Al exportar desde Eclipse se debe seleccionar solamente el directorio ‘src’. No debe incluirse ningún archivo en formato JAR y, preferentemente, tampoco archivos _.class_ (bytecode de Java).

Las direcciones de entrega electrónica son:

  - Comisión 1: `entregas.prog2@gmail.com`
  - Comisión 2: `ungsmpprogramacion2@hotmail.com.ar`

El asunto debe incluir "TP2 2016/2", la comisión (COM1 o COM2), el número de grupo (p.ej. G3 o G17) y los apellidos de sus integrantes. Por ejemplo:

```

Asunto: TP2 2016/2 - COM1 - Bertaccini Simó G9
```

### Requisitos ###

Todo el código entregado debe compilar para considerarse una entrega válida.

Además, la implementación de _DequeEnlazada_ debe pasar los casos de prueba que se adjuntaron a la consigna (_TestDeque.java_).

### Copia en papel ###

Para la comisión 1, además, se debe entregar una copia impresa de código e informe. Se debe entregar en mano en el laboratorio el día de la entrega o, alternativamente, en el casillero de los profesores en el ICI hasta las 19h del mismo día.


### Consideración final ###

De haber múltiples entregas, se considera como definitiva la _última_ enviada. Caso de no ser la correcta, se debe enviar de nuevo la versión que sí lo es.
