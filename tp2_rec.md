---
lang: es
fontsize: 11pt
title: Recuperatorio trabajo práctico n.º 2
author: Programación II
date: Segundo cuatrimestre 2016
linkcolor: black
urlcolor: blue
links-as-notes: true
geometry: top=2.5cm,bottom=2.5cm,left=4cm,right=4cm
mainfont: TeX Gyre Pagella
monofont: Consolas
monofontoptions: Scale=0.9
numbersections: true
toc-depth: 2
secnumdepth: 2
math: true
layout: default
---

La fecha de entrega del recuperatorio es el **29 de noviembre de 2016**. Se debe incluir en la entrega la solución corregida a la [consigna inicial,][ini] más la solución a las dos ampliaciones que se proponen a continuación.

[ini]: https://github.com/ungs-prog2/codigo_aula/archive/tp2_2016_2.zip


Métodos adicionales para _DequeEnlazada_
========================================

Se pide implementar en la clase _DequeEnlazada_ los métodos estándar de Java _equals()_ y _toString()_.

Igualdad
--------

Para cualquier clase de Java, la signatura estándar del método _equals()_ es:

    public boolean equals(Object obj) { ... }

Es decir, siempre toma como parámetro una instancia genérica de _Object_.

Como recordatorio a lo visto en clase, los pasos a realizar son:

  1. Comprobar que _obj_ no sea `null`.

  2. Comprobar si _obj_ fuera en realidad una referencia a _this_.

  3. Comprobar, usando el operador `instanceof`, que _obj_ es una instancia de _DequeEnlazada_.

  4. Realizar sobre _obj_ una coerción al tipo `DequeEnlazada<?>`.

Una vez realizada la conversión de tipo, se procederá a la comparación de las estructuras, que deben tener exactamente los mismos elementos en el mismo orden.

La comparación elemento a elemento se debe delegar al completo en el método _equals()_ del tipo paramétrico $T$ de la cola. Para facilitar el manejo de _null_ se recomienda usar el método _[Objects.equals()][oq]_ de Java.

[oq]: https://docs.oracle.com/javase/7/docs/api/java/util/Objects.html

Conversión a cadena
-------------------

La firma del método _toString()_ es:

    public String toString() { ... }

Para _DequeEnlazada_ se pide devolver exactamente el siguiente formato:

    Deque{s₁ -> s₂ -> s₃}

O, si la cola está vacía o tiene un solo elemento:

    Deque{}
    Deque{s₁}

donde $s_1, s_2, \ldots, s_n$ corresponden a la representación como cadena de los $n$ elementos almacenados y ‘`->`’ es literalmente los dos caracteres ASCII _guión_ y _mayor que_.

Adicionalmente, para evitar malgastar memoria, se debe implementar haciendo uso de la utilidad [_StringBuilder_ de Java.][sb]

[sb]: https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html


Métodos adicionales para la red social
======================================

Se pide implementar un mismo método _toString()_ para las dos clases de red social, más la primitiva de red asimétrica que se describe a continuación.

Red inversa
-----------

A menudo en algoritmos de redes sociales (y grafos en general) se necesita obtener la inversa de una red asimétrica. Para este recuperatorio se pide implementar un método que realice precisamente esa tarea:

    public RedSocialAsim inversa() { ... }

El algoritmo para calcular la red inversa es muy sencillo:

    procedimiento "calcular red inversa":
        1. crear nueva red asimétrica
        2. para cada persona P de la red original:
           a. obtener la lista de relaciones de P
           b. para cada persona R de esa lista:
              => agregar a la nueva red la relación inversa R -> P

Lista de personas en la red
---------------------------

Una funcionalidad importante que no se incluyó en la versión inicial de la red, y que se necesita para el algoritmo de inversión, es poder acceder a la lista de personas que la componen. La solución más elegante es hacer que _RedSocial_ se pueda usar en un ciclo _foreach_ directamente:

    for (String p : original) {
        System.out.println("En la red está: " + p);
    }

De _iterador_ a _iterable_
--------------------------

En la consigna anterior se explicó en detalle el concepto de “objeto iterador” (interfaz _Iterator_ de Java). Ahora definimos un objeto _O_ como “iterable” cuando implementa la interfaz _Iterable_ de Java y, por tanto:

  1. incluye el método `iterator()` que define la interfaz, el cual devuelve un “objeto iterador” para la estructura.

  2. se puede usar el objeto _O_ en un ciclo _foreach_.

Así, si _RedSocial_ implementa esa interfaz:

```java
class RedSocial implements Iterable<String>
{
    @Override
    public Iterator<String> iterator() { ... }
}
```

será posible usarla dentro de un ciclo _foreach_.

Relaciones de una persona
-------------------------

En la consigna original la signatura del método _relaciones()_ era:

    public Iterator<String> relaciones(String p) { ... }

Esto permitía cumplir con los requisitos de complejidad y encapsulamiento exigidos, pero la iteración era tediosa porque se debía invocar de manera explícita los métodos de _Iterator_:

    Iterator<String> it = red.relaciones("Spinoza");
    while (it.hasNext())
        System.out.println("Spinoza influenció a: " + it.next());

Si, en cambio, modificamos la signatura para que devuelva un _iterable_:

    public Iterable<String> relaciones(String p) { ... }

sería posible escribir directamente:

    for (String f : red.relaciones("Spinoza"))
        System.out.println("Spinoza influenció a: " + f);

**Fe de erratas:** La versión inicial de la consigna mezclaba, inicialmente, el concepto de _iterador_ e _iterable_ en los ejemplos de código. Se corrigió y se aclara aquí.

Entrega
-------

En definitiva, para el recuperatorio de la parte 2 se pide:

1.  Implementar la interfaz `Iterable<String>` en el TAD red social.

2.  Cambiar la firma del método _relaciones()_ a:

        public Iterable<String> relaciones(String persona) { ... }

3.  Incluir una implementación de _toString()_ común para todas las redes sociales, y una primitiva `inversa()` para las redes asimétricas. Además:

    - al igual que en _DequeEnlazada_, `toString()` debe usar _StringBuilder_ para no realizar construcciones de cadenas innecesarias

    - tanto en `inversa()` como en `toString()` solamente se permite usar métodos públicos de la red.

Instrucciones para la entrega {-}
=============================

Las instrucciones de entrega son las mismas que en la consigna original. La copia en papel para la comisión 1 se debe dejar en el casillero de los profesores Simó o Bertaccini antes de las 20h del día de la entrega.
