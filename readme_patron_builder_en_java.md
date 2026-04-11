# Patrón Builder en Java

## Concepto

El patrón **Builder** es un patrón de diseño creacional que se utiliza para **construir objetos complejos paso a paso**.

Su objetivo principal es separar:

- el proceso de construcción
- de la representación final del objeto

Esto permite crear objetos de forma más clara, flexible y mantenible, especialmente cuando tienen muchos atributos o múltiples combinaciones posibles.

---

## ¿Por qué se utiliza?

Se utiliza cuando crear un objeto con un constructor tradicional se vuelve difícil de leer o mantener.

Esto suele pasar cuando:

- la clase tiene muchos atributos
- algunos atributos son opcionales
- existen muchas combinaciones de construcción
- no quieres tener múltiples constructores sobrecargados

### Beneficios principales

- **Mejora la legibilidad del código**
- **Evita constructores demasiado largos**
- **Permite construir objetos paso a paso**
- **Reduce errores al pasar parámetros en orden incorrecto**
- **Facilita crear objetos inmutables**

---

## Problema que resuelve

Imagina una clase `Computadora` con muchos atributos:

- procesador
- memoria RAM
- almacenamiento
- tarjeta gráfica
- sistema operativo
- teclado retroiluminado
- Bluetooth
- WiFi

Una solución tradicional podría ser:

```java
Computadora pc = new Computadora(
    "Intel i7",
    16,
    512,
    "NVIDIA RTX 4060",
    "Windows 11",
    true,
    true,
    true
);
```

Aunque funciona, este enfoque tiene problemas:

- cuesta leer qué representa cada valor
- es fácil equivocarse en el orden
- empeora cuando crecen los atributos
- obliga a usar constructores grandes o muchas sobrecargas

Con **Builder**, la construcción se vuelve más expresiva.

---

## Estructura del patrón

### Participantes

- **Product**: objeto final que se quiere construir
- **Builder**: clase encargada de construir el objeto paso a paso
- **Client**: código que usa el builder

---

## Diagrama de referencia

```text
+------------------------------+
|         Computadora          |
|------------------------------|
| - procesador                 |
| - ram                        |
| - almacenamiento             |
| - tarjetaGrafica             |
| - sistemaOperativo           |
| - tecladoRetroiluminado      |
| - bluetooth                  |
| - wifi                       |
+------------------------------+
              ^
              |
+-------------------------------------------+
|          ComputadoraBuilder               |
|-------------------------------------------|
| - procesador                              |
| - ram                                     |
| - almacenamiento                          |
| - tarjetaGrafica                          |
| - sistemaOperativo                        |
| - tecladoRetroiluminado                   |
| - bluetooth                               |
| - wifi                                    |
|-------------------------------------------|
| + procesador(valor)                       |
| + ram(valor)                              |
| + almacenamiento(valor)                   |
| + tarjetaGrafica(valor)                   |
| + sistemaOperativo(valor)                 |
| + tecladoRetroiluminado(valor)            |
| + bluetooth(valor)                        |
| + wifi(valor)                             |
| + build()                                 |
+-------------------------------------------+
```

---

## Ejemplo en Java

### Caso: construcción de una computadora personalizada

---

### 1. Clase producto

```java
public class Computadora {

    private final String procesador;
    private final int ram;
    private final int almacenamiento;
    private final String tarjetaGrafica;
    private final String sistemaOperativo;
    private final boolean tecladoRetroiluminado;
    private final boolean bluetooth;
    private final boolean wifi;

    private Computadora(ComputadoraBuilder builder) {
        this.procesador = builder.procesador;
        this.ram = builder.ram;
        this.almacenamiento = builder.almacenamiento;
        this.tarjetaGrafica = builder.tarjetaGrafica;
        this.sistemaOperativo = builder.sistemaOperativo;
        this.tecladoRetroiluminado = builder.tecladoRetroiluminado;
        this.bluetooth = builder.bluetooth;
        this.wifi = builder.wifi;
    }

    @Override
    public String toString() {
        return "Computadora{" +
                "procesador='" + procesador + '\'' +
                ", ram=" + ram +
                ", almacenamiento=" + almacenamiento +
                ", tarjetaGrafica='" + tarjetaGrafica + '\'' +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                ", tecladoRetroiluminado=" + tecladoRetroiluminado +
                ", bluetooth=" + bluetooth +
                ", wifi=" + wifi +
                '}';
    }

    public static class ComputadoraBuilder {
        private String procesador;
        private int ram;
        private int almacenamiento;
        private String tarjetaGrafica;
        private String sistemaOperativo;
        private boolean tecladoRetroiluminado;
        private boolean bluetooth;
        private boolean wifi;

        public ComputadoraBuilder procesador(String procesador) {
            this.procesador = procesador;
            return this;
        }

        public ComputadoraBuilder ram(int ram) {
            this.ram = ram;
            return this;
        }

        public ComputadoraBuilder almacenamiento(int almacenamiento) {
            this.almacenamiento = almacenamiento;
            return this;
        }

        public ComputadoraBuilder tarjetaGrafica(String tarjetaGrafica) {
            this.tarjetaGrafica = tarjetaGrafica;
            return this;
        }

        public ComputadoraBuilder sistemaOperativo(String sistemaOperativo) {
            this.sistemaOperativo = sistemaOperativo;
            return this;
        }

        public ComputadoraBuilder tecladoRetroiluminado(boolean tecladoRetroiluminado) {
            this.tecladoRetroiluminado = tecladoRetroiluminado;
            return this;
        }

        public ComputadoraBuilder bluetooth(boolean bluetooth) {
            this.bluetooth = bluetooth;
            return this;
        }

        public ComputadoraBuilder wifi(boolean wifi) {
            this.wifi = wifi;
            return this;
        }

        public Computadora build() {
            if (procesador == null || procesador.isBlank()) {
                throw new IllegalStateException("El procesador es obligatorio");
            }
            if (ram <= 0) {
                throw new IllegalStateException("La RAM debe ser mayor que 0");
            }
            if (almacenamiento <= 0) {
                throw new IllegalStateException("El almacenamiento debe ser mayor que 0");
            }
            return new Computadora(this);
        }
    }
}
```

---

### 2. Clase principal

```java
public class Main {
    public static void main(String[] args) {
        Computadora computadora = new Computadora.ComputadoraBuilder()
                .procesador("Intel Core i7")
                .ram(16)
                .almacenamiento(512)
                .tarjetaGrafica("NVIDIA RTX 4060")
                .sistemaOperativo("Windows 11")
                .tecladoRetroiluminado(true)
                .bluetooth(true)
                .wifi(true)
                .build();

        System.out.println(computadora);
    }
}
```

---

## Salida esperada

```text
Computadora{procesador='Intel Core i7', ram=16, almacenamiento=512, tarjetaGrafica='NVIDIA RTX 4060', sistemaOperativo='Windows 11', tecladoRetroiluminado=true, bluetooth=true, wifi=true}
```

---

## ¿Qué ventajas aporta este diseño?

### Sin Builder

- constructores largos y difíciles de leer
- riesgo de confundir parámetros
- demasiadas sobrecargas de constructor
- menor claridad al crear objetos complejos

### Con Builder

- la creación es más legible y expresiva
- los atributos opcionales se manejan mejor
- la validación puede centralizarse en `build()`
- el código es más fácil de mantener

---

## Ejemplo comparativo

### Sin Builder

```java
Computadora pc = new Computadora(
    "Intel Core i7", 16, 512, "NVIDIA RTX 4060", "Windows 11", true, true, true
);
```

### Con Builder

```java
Computadora pc = new Computadora.ComputadoraBuilder()
    .procesador("Intel Core i7")
    .ram(16)
    .almacenamiento(512)
    .tarjetaGrafica("NVIDIA RTX 4060")
    .sistemaOperativo("Windows 11")
    .tecladoRetroiluminado(true)
    .bluetooth(true)
    .wifi(true)
    .build();
```

La segunda versión es más clara, más segura y más profesional.

---

## ¿Cuándo conviene usar Builder?

Conviene usarlo cuando:

- una clase tiene muchos atributos
- varios atributos son opcionales
- quieres mejorar la legibilidad de construcción
- necesitas validaciones antes de crear el objeto
- quieres crear objetos inmutables

---

## ¿Cuándo no conviene usarlo?

Puede ser innecesario cuando:

- la clase tiene pocos atributos
- la construcción es simple
- no hay combinaciones complejas

Si una clase solo necesita dos o tres atributos obligatorios, un constructor común puede ser suficiente.

---

## Relación con SOLID y Clean Code

El patrón Builder ayuda a mejorar:

- **legibilidad**
- **mantenibilidad**
- **responsabilidad de construcción separada**

También favorece un estilo de código más limpio cuando se crean objetos grandes.

---

## Diferencia entre Builder y Factory

Aunque ambos son patrones creacionales, no resuelven exactamente lo mismo:

- **Factory** decide **qué objeto crear**
- **Builder** decide **cómo construir un objeto complejo paso a paso**

Ejemplo mental:

- Factory: elige el tipo de producto
- Builder: arma el producto con detalle

---

## Resumen

El patrón **Builder** permite construir objetos complejos de forma progresiva, clara y segura.

Es muy útil cuando necesitas evitar constructores largos y quieres que la creación del objeto sea más expresiva y mantenible.

---

## Idea clave para recordar

> Builder = construir objetos complejos paso a paso sin depender de constructores enormes

