# Patrón Factory en Java

## Concepto

El patrón **Factory** es un patrón de diseño creacional que se utiliza para **centralizar y abstraer la creación de objetos**.

En lugar de instanciar clases directamente con `new` en muchas partes del sistema, se delega esa responsabilidad a una clase o método especializado llamado **fábrica**.

---

## ¿Por qué se utiliza?

Se utiliza cuando la lógica de creación de objetos:

- puede variar
- depende de una condición
- puede crecer con el tiempo
- no debería estar dispersa por todo el código

### Beneficios principales

- **Reduce el acoplamiento**
- **Centraliza la creación de objetos**
- **Facilita mantenimiento y extensión**
- **Oculta detalles de implementación**
- **Permite programar contra interfaces o clases abstractas**

---

## Problema que resuelve

Imagina una aplicación que genera distintos tipos de notificaciones:

- correo electrónico
- SMS
- notificación push

Una solución básica sería esta:

```java
if (tipo.equals("email")) {
    return new NotificacionEmail();
} else if (tipo.equals("sms")) {
    return new NotificacionSMS();
} else if (tipo.equals("push")) {
    return new NotificacionPush();
}
```

Si esta lógica aparece repetida en varias clases, el sistema se vuelve:

- difícil de mantener
- frágil ante cambios
- poco escalable

Con **Factory**, esa creación se concentra en un único lugar.

---

## Estructura del patrón

### Participantes

- **Producto**: interfaz o clase base común
- **Productos concretos**: implementaciones específicas
- **Factory**: clase que decide qué objeto crear

---

## Diagrama de referencia

```text
                  +----------------------+
                  |     Notificacion     |
                  |----------------------|
                  | + enviar(mensaje)    |
                  +----------+-----------+
                             ^
            -----------------|-----------------
            |                |                |
            |                |                |
+---------------------+ +------------------+ +----------------------+
| NotificacionEmail   | | NotificacionSMS  | | NotificacionPush     |
|---------------------| |------------------| |----------------------|
| + enviar(mensaje)   | | + enviar(mensaje)| | + enviar(mensaje)    |
+---------------------+ +------------------+ +----------------------+


                  +------------------------------+
                  |      NotificacionFactory     |
                  |------------------------------|
                  | + crearNotificacion(tipo)    |
                  +------------------------------+
```

---

## Ejemplo en Java

### Caso: sistema de notificaciones

---

### 1. Producto

```java
public interface Notificacion {
    void enviar(String mensaje);
}
```

---

### 2. Productos concretos

#### Notificación por email

```java
public class NotificacionEmail implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando EMAIL: " + mensaje);
    }
}
```

#### Notificación por SMS

```java
public class NotificacionSMS implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando SMS: " + mensaje);
    }
}
```

#### Notificación push

```java
public class NotificacionPush implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando PUSH: " + mensaje);
    }
}
```

---

### 3. Factory

```java
public class NotificacionFactory {

    public static Notificacion crearNotificacion(String tipo) {
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("El tipo de notificación no puede estar vacío");
        }

        switch (tipo.toLowerCase()) {
            case "email":
                return new NotificacionEmail();
            case "sms":
                return new NotificacionSMS();
            case "push":
                return new NotificacionPush();
            default:
                throw new IllegalArgumentException("Tipo de notificación no soportado: " + tipo);
        }
    }
}
```

---

### 4. Clase principal

```java
public class Main {
    public static void main(String[] args) {
        Notificacion n1 = NotificacionFactory.crearNotificacion("email");
        Notificacion n2 = NotificacionFactory.crearNotificacion("sms");
        Notificacion n3 = NotificacionFactory.crearNotificacion("push");

        n1.enviar("Bienvenido al sistema");
        n2.enviar("Tu código de verificación es 123456");
        n3.enviar("Tienes una nueva alerta");
    }
}
```

---

## Salida esperada

```text
Enviando EMAIL: Bienvenido al sistema
Enviando SMS: Tu código de verificación es 123456
Enviando PUSH: Tienes una nueva alerta
```

---

## ¿Qué ventajas aporta este diseño?

### Sin Factory

- La creación queda dispersa en varias clases
- Hay mucho uso de `new` por todo el sistema
- Cambiar la forma de construcción es más costoso
- Aumenta el acoplamiento con clases concretas

### Con Factory

- Toda la lógica de creación se centraliza
- El cliente trabaja con la abstracción (`Notificacion`)
- Es más fácil agregar nuevos tipos
- Se mejora la legibilidad y mantenibilidad

---

## Extensión del ejemplo

Si mañana agregas una nueva notificación por WhatsApp:

```java
public class NotificacionWhatsApp implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando WhatsApp: " + mensaje);
    }
}
```

Solo necesitas actualizar la fábrica:

```java
case "whatsapp":
    return new NotificacionWhatsApp();
```

Y el resto del código puede seguir igual.

---

## ¿Cuándo conviene usar Factory?

Conviene usarlo cuando:

- necesitas crear objetos según condiciones
- quieres ocultar la lógica de construcción
- trabajas con interfaces o clases abstractas
- quieres reducir dependencias directas con clases concretas
- prevés que aparecerán nuevos tipos de objetos

---

## ¿Cuándo no conviene usarlo?

No siempre hace falta. Puede ser innecesario cuando:

- solo existe una única clase concreta
- la creación es trivial
- no hay variación ni crecimiento esperado

En esos casos, usar directamente `new` puede ser suficiente.

---

## Relación con SOLID

El patrón Factory se relaciona especialmente con:

- **Open/Closed Principle**: facilita extender el sistema con nuevos productos
- **Dependency Inversion Principle**: el cliente puede depender de una abstracción y no de clases concretas

---

## Diferencia entre Factory y Strategy

Aunque a veces se combinan, no son lo mismo:

- **Factory** se enfoca en **crear objetos**
- **Strategy** se enfoca en **cambiar comportamientos**

Ejemplo mental:

- Factory: decide qué objeto instanciar
- Strategy: decide cómo se comporta ese objeto

---

## Resumen

El patrón **Factory** permite centralizar la creación de objetos y desacoplar al cliente de las clases concretas.

Es útil cuando quieres que el sistema sea:

- más flexible
- más mantenible
- más extensible

---

## Idea clave para recordar

> Factory = crear objetos sin depender directamente de su clase concreta

