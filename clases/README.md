# 🧠 Programación Orientada a Objetos en Java
## Fundamentos: Clases, Objetos y Memoria

---

## 📌 ¿Qué es una clase en Java?

Una **clase** es una plantilla o molde que define cómo serán los objetos.

Describe:
- **Atributos (datos)**
- **Métodos (comportamientos)**

### Ejemplo:
```java
class Persona {
    String nombre;
    int edad;

    void saludar() {
        System.out.println("Hola, soy " + nombre);
    }
}
```

---

## 📌 ¿Qué es un objeto?

Un **objeto** es una instancia de una clase.

```java
Persona p1 = new Persona();
```

- `Persona` → clase
- `p1` → objeto

---

## ⚙️ ¿Qué pasa en memoria cuando creas un objeto?

Cuando ejecutas:

```java
Persona p1 = new Persona();
```

Java realiza varias cosas importantes:

---

### 1. Se declara una referencia

```java
Persona p1;
```

Aquí **NO se crea el objeto**, solo una variable que puede apuntar a uno.

---

### 2. Se crea el objeto en el Heap (memoria dinámica)

```java
new Persona();
```

- Se reserva espacio en memoria
- Se crean los atributos (`nombre`, `edad`)
- Se inicializan con valores por defecto:
  - `String` → null
  - `int` → 0

---

### 3. Se asigna la referencia

```java
p1 = new Persona();
```

- `p1` guarda la dirección del objeto en memoria

---

## 🧠 Visualización simple

```
Stack (pila)            Heap (memoria)
------------           ----------------------
p1  -----------→       Persona object
                      nombre = null
                      edad = 0
```

---

## 📌 Acceso a los datos

Cuando haces:

```java
p1.nombre = "Abel";
```

Java:
1. Usa `p1` para ubicar el objeto
2. Modifica el atributo dentro del objeto

---

## ⚠️ Concepto clave

Si haces esto:

```java
Persona p1 = null;
p1.saludar();
```

Obtendrás un error:

```
NullPointerException
```

Porque `p1` **no apunta a ningún objeto**.

---

## 🔥 Ejemplo completo

```java
class Persona {
    String nombre;
    int edad;

    void saludar() {
        System.out.println("Hola, soy " + nombre);
    }
}

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        p1.nombre = "Abel";
        p1.edad = 25;

        p1.saludar();
    }
}
```

---

## 🧩 Resumen

- Una **clase** es un molde
- Un **objeto** es una instancia real
- `new` crea el objeto en memoria (Heap)
- La variable guarda una **referencia**, no el objeto en sí

---

## 🚀 Próximos pasos

Para seguir aprendiendo POO en Java:

1. Constructores
2. Encapsulamiento (getters/setters)
3. Herencia
4. Polimorfismo

---

## ✍️ Ejercicio sugerido

Responde:

```java
Persona p1 = new Persona();
```

- ¿Dónde se almacena `p1`?
- ¿Dónde se crea el objeto?

---

**Respuesta esperada:**
- `p1` → Stack
- Objeto → Heap

---

Si quieres continuar, el siguiente paso es entender **constructores en profundidad y buenas prácticas en Java**.

