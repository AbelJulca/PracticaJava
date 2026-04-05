# 🧠 Abstracción en Java

## 📌 ¿Qué es la abstracción?

La **abstracción** es uno de los pilares de la Programación Orientada a Objetos (POO).

> Consiste en mostrar solo lo esencial de un objeto y ocultar los detalles internos de implementación.

---

## 🧠 Idea clave

- Te enfocas en **qué hace** un objeto
- No en **cómo lo hace internamente**

### Ejemplo del mundo real

Un cajero automático:
- Sabes que puedes retirar dinero
- No sabes cómo procesa la transacción internamente

---

## 🧱 ¿Cómo se implementa en Java?

Se logra principalmente mediante:

1. **Clases abstractas**
2. **Interfaces**

---

## 🔷 Clases abstractas

### 📌 Características

- Se definen con la palabra clave `abstract`
- No se pueden instanciar
- Pueden tener:
  - Métodos abstractos (sin implementación)
  - Métodos concretos (con implementación)

---

### 🧪 Ejemplo

```java
abstract class Animal {

    abstract void hacerSonido();

    void dormir() {
        System.out.println("El animal duerme");
    }
}
```

---

### 🧪 Implementación

```java
class Perro extends Animal {

    @Override
    void hacerSonido() {
        System.out.println("Guau");
    }
}
```

---

## 🔶 Interfaces

### 📌 ¿Qué es una interface?

Es un **contrato** que define métodos que una clase debe implementar.

---

### 🧪 Ejemplo

```java
interface Vehiculo {
    void arrancar();
}
```

---

### 🧪 Implementación

```java
class Auto implements Vehiculo {

    @Override
    public void arrancar() {
        System.out.println("El auto arranca");
    }
}
```

---

## 🚀 Uso de abstracción

```java
Vehiculo v = new Auto();
v.arrancar();
```

👉 No importa cómo funciona internamente el auto.

---

## ⚖️ Diferencias clave

| Característica        | Clase Abstracta | Interface |
|----------------------|----------------|----------|
| Métodos con código   | Sí             | Sí (default/static) |
| Métodos abstractos   | Sí             | Sí |
| Herencia múltiple    | No             | Sí |
| Uso principal        | Base común     | Contrato |

---

## 🧠 Beneficios de la abstracción

- Reduce la complejidad
- Facilita el mantenimiento
- Permite cambios internos sin afectar el uso
- Mejora la escalabilidad

---

## ⚠️ Buenas prácticas

- Usa interfaces para definir comportamientos
- Usa clases abstractas cuando compartes lógica común
- Programa contra interfaces, no implementaciones

---

## 🧩 Ejemplo práctico

```java
interface Figura {
    double area();
}

class Circulo implements Figura {
    double radio;

    Circulo(double radio) {
        this.radio = radio;
    }

    public double area() {
        return Math.PI * radio * radio;
    }
}
```

---

## 🧠 Resumen

- La abstracción oculta detalles internos
- Permite enfocarse en el comportamiento
- Se implementa con clases abstractas e interfaces

---

## 🚀 Siguiente paso

- Polimorfismo avanzado
- Interfaces funcionales y lambdas
- Principios SOLID

