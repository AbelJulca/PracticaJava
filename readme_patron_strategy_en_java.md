# Patrón Strategy en Java

## Concepto

El patrón **Strategy** es un patrón de diseño de comportamiento que permite **definir una familia de algoritmos, encapsular cada uno por separado e intercambiarlos dinámicamente**.

En otras palabras, sirve para que un objeto pueda cambiar su forma de comportarse sin necesidad de modificar su clase principal.

---

## ¿Por qué se utiliza?

Se utiliza cuando un sistema necesita ejecutar una misma operación de distintas maneras.

### Beneficios principales

- **Evita grandes bloques de `if` o `switch`**
- **Facilita agregar nuevos comportamientos** sin romper código existente
- **Cumple con el principio Open/Closed de SOLID**
- **Reduce acoplamiento** entre la lógica principal y los algoritmos concretos
- **Mejora la mantenibilidad y escalabilidad** del código

---

## Problema que resuelve

Imagina una aplicación que debe ordenar una lista de datos de varias formas:

- ascendente
- descendente
- por longitud del texto

Una solución poco escalable sería hacer esto:

```java
if (tipo.equals("asc")) {
    // ordenar ascendente
} else if (tipo.equals("desc")) {
    // ordenar descendente
} else if (tipo.equals("longitud")) {
    // ordenar por longitud
}
```

Este enfoque se vuelve difícil de mantener cuando aparecen nuevos criterios.

Con **Strategy**, cada forma de ordenar se encapsula en una clase distinta.

---

## Estructura del patrón

### Participantes

- **Strategy**: interfaz común para todos los algoritmos
- **ConcreteStrategy**: implementaciones concretas del algoritmo
- **Context**: clase que usa una estrategia

---

## Diagrama de referencia

```text
                 +----------------------+
                 |   EstrategiaOrden    |
                 |----------------------|
                 | + ordenar(lista)     |
                 +----------+-----------+
                            ^
            ----------------|----------------
            |               |               |
            |               |               |
+-------------------+ +-------------------+ +---------------------------+
| OrdenAscendente   | | OrdenDescendente  | | OrdenPorLongitud          |
|-------------------| |-------------------| |---------------------------|
| + ordenar(lista)  | | + ordenar(lista)  | | + ordenar(lista)          |
+-------------------+ +-------------------+ +---------------------------+


                 +----------------------+
                 |   OrganizadorTexto   |
                 |----------------------|
                 | - estrategia         |
                 | + setEstrategia()    |
                 | + organizar()        |
                 +----------------------+
```

---

## Ejemplo en Java

### Caso: organizar palabras con distintos criterios

---

### 1. Interfaz Strategy

```java
import java.util.List;

public interface EstrategiaOrden {
    void ordenar(List<String> elementos);
}
```

---

### 2. Estrategias concretas

#### Orden ascendente

```java
import java.util.Collections;
import java.util.List;

public class OrdenAscendente implements EstrategiaOrden {
    @Override
    public void ordenar(List<String> elementos) {
        Collections.sort(elementos);
    }
}
```

#### Orden descendente

```java
import java.util.Collections;
import java.util.List;

public class OrdenDescendente implements EstrategiaOrden {
    @Override
    public void ordenar(List<String> elementos) {
        Collections.sort(elementos, Collections.reverseOrder());
    }
}
```

#### Orden por longitud

```java
import java.util.List;

public class OrdenPorLongitud implements EstrategiaOrden {
    @Override
    public void ordenar(List<String> elementos) {
        elementos.sort((a, b) -> Integer.compare(a.length(), b.length()));
    }
}
```

---

### 3. Contexto

```java
import java.util.List;

public class OrganizadorTexto {

    private EstrategiaOrden estrategia;

    public OrganizadorTexto(EstrategiaOrden estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(EstrategiaOrden estrategia) {
        this.estrategia = estrategia;
    }

    public void organizar(List<String> elementos) {
        estrategia.ordenar(elementos);
    }
}
```

---

### 4. Clase principal

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> palabras = new ArrayList<>(Arrays.asList(
            "pera", "manzana", "kiwi", "sandia", "uva"
        ));

        OrganizadorTexto organizador = new OrganizadorTexto(new OrdenAscendente());

        organizador.organizar(palabras);
        System.out.println("Ascendente: " + palabras);

        palabras = new ArrayList<>(Arrays.asList("pera", "manzana", "kiwi", "sandia", "uva"));
        organizador.setEstrategia(new OrdenDescendente());
        organizador.organizar(palabras);
        System.out.println("Descendente: " + palabras);

        palabras = new ArrayList<>(Arrays.asList("pera", "manzana", "kiwi", "sandia", "uva"));
        organizador.setEstrategia(new OrdenPorLongitud());
        organizador.organizar(palabras);
        System.out.println("Por longitud: " + palabras);
    }
}
```

---

## Salida esperada

```text
Ascendente: [kiwi, manzana, pera, sandia, uva]
Descendente: [uva, sandia, pera, manzana, kiwi]
Por longitud: [uva, pera, kiwi, sandia, manzana]
```

---

## ¿Qué ventajas aporta este diseño?

### Sin Strategy

- La clase principal tendría muchos `if/else`
- Cada nueva forma de ordenar obliga a modificar código existente
- Mayor acoplamiento

### Con Strategy

- Cada algoritmo está separado
- Puedes cambiar el comportamiento en tiempo de ejecución
- El contexto no conoce detalles del algoritmo
- Es fácil agregar una nueva estrategia

Por ejemplo, si mañana necesitas ordenar por última letra, puedes crear:

```java
public class OrdenPorUltimaLetra implements EstrategiaOrden {
    @Override
    public void ordenar(List<String> elementos) {
        elementos.sort((a, b) -> Character.compare(
            a.charAt(a.length() - 1),
            b.charAt(b.length() - 1)
        ));
    }
}
```

Sin modificar `OrganizadorTexto`.

---

## ¿Cuándo conviene usar Strategy?

Conviene usarlo cuando:

- tienes varias formas de realizar una tarea
- quieres evitar condicionales extensos
- necesitas intercambiar algoritmos dinámicamente
- quieres que el código sea más extensible y mantenible

---

## ¿Cuándo no conviene usarlo?

No siempre hace falta. Puede ser excesivo cuando:

- solo existe una única forma de hacer la operación
- las variantes son mínimas y no crecerán
- el problema es demasiado pequeño

---

## Relación con SOLID

El patrón Strategy se relaciona especialmente con:

- **Open/Closed Principle**: puedes agregar nuevas estrategias sin modificar el contexto
- **Dependency Inversion Principle**: el contexto depende de una abstracción (`EstrategiaOrden`) y no de clases concretas

---

## Resumen

El patrón **Strategy** permite encapsular algoritmos intercambiables detrás de una misma interfaz.

Es útil cuando una operación puede realizarse de múltiples maneras y quieres que el sistema sea:

- flexible
- extensible
- fácil de mantener

---

## Idea clave para recordar

> Strategy = cambiar el comportamiento sin cambiar la clase principal

