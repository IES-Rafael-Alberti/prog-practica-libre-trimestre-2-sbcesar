[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/NBVXLiSy)
# Actividad: Desarrollo de Proyecto Software en Kotlin

**ID actividad:** 2324_PRO_u4u5u6_libre

**Agrupamiento de la actividad**: Individual 

---

### Descripción:

La actividad consiste en el desarrollo de un proyecto software en Kotlin, permitiendo al estudiante elegir la temática. Este proyecto debe demostrar la comprensión y aplicación de los conceptos de programación orientada a objetos (POO), incluyendo la definición y uso de clases, herencia, interfaces, genericos, principios SOLID y el uso de librerías externas.

**Objetivo:**

- Demostrar comprensión de los fundamentos de POO mediante la instanciación y uso de objetos.
- Aplicar conceptos avanzados de POO como herencia, clases abstractas, e interfaces.
- Crear y usar clases que hagan uso de genéricos. 
- Aplicar principios SOLID.
- Integrar y utilizar librerías de clases externas para extender la funcionalidad del proyecto.
- Documentar y presentar el código de manera clara y comprensible.

**Trabajo a realizar:**

1. **Selección de la Temática:** Elige un tema de tu interés que pueda ser abordado mediante una aplicación software. Esto podría ser desde una aplicación de gestión para una pequeña empresa, una herramienta para ayudar en la educación, hasta un juego simple. Define claramente el problema que tu aplicación pretende resolver.

2. **Planificación:** Documenta brevemente cómo tu aplicación solucionará el problema seleccionado, incluyendo las funcionalidades principales que desarrollarás.

3. **Desarrollo:**
   - **Instancia de Objetos:** Tu aplicación debe crear y utilizar objetos, demostrando tu comprensión de la instanciación y el uso de constructores, métodos, y propiedades.
   - **Métodos Estáticos:** Define y utiliza al menos un método estático, explicando por qué es necesario en tu aplicación.
   - **Uso de IDE:** Desarrolla tu proyecto utilizando un IDE, aprovechando sus herramientas para escribir, compilar, y probar tu código.
   - **Definición de Clases:** Crea clases personalizadas con sus respectivas propiedades, métodos, y constructores.
   - **Clases con genéricos:** Define y utiliza al menos una clase que haga uso de genéricos en tu aplicación.
   - **Herencia y Polimorfismo:** Implementa herencia y/o interfaces en tu proyecto para demostrar la reutilización de código y la flexibilidad de tu diseño.  **Usa los principios SOLID:** Ten presente durante el desarrollo los principios SOLID y úsalos durante el diseño para mejorar tu aplicación.
   - **Librerías de Clases:** Integra y utiliza una o más librerías externas que enriquezcan la funcionalidad de tu aplicación.
   - **Documentación:** Comenta tu código de manera efectiva, facilitando su comprensión y mantenimiento.

4. **Prueba y Depuración:** Realiza pruebas para asegurarte de que tu aplicación funciona como se espera y depura cualquier error encontrado.
5. **Contesta a las preguntas** ver el punto **Preguntas para la Evaluación**

### Recursos

- Apuntes dados en clase sobre programación orientada a objetos, Kotlin, uso de IDEs, y manejo de librerías.
- Recursos vistos en clase, incluyendo ejemplos de código, documentación de Kotlin, y guías de uso de librerías.

### Evaluación y calificación

**RA y CE evaluados**: Resultados de Aprendizaje 2, 4, 6, 7 y Criterios de Evaluación asociados.

**Conlleva presentación**: SI

**Rubrica**: Mas adelante se mostrará la rubrica.

### Entrega

> **La entrega tiene que cumplir las condiciones de entrega para poder ser calificada. En caso de no cumplirlas podría calificarse como no entregada.**
>
- **Conlleva la entrega de URL a repositorio:** El contenido se entregará en un repositorio GitHub. 
- **Respuestas a las preguntas:** Deben contestarse en este fichero, README.md


# Preguntas para la Evaluación

Este conjunto de preguntas está diseñado para ayudarte a reflexionar sobre cómo has aplicado los criterios de evaluación en tu proyecto. Al responderlas, **asegúrate de hacer referencia y enlazar al código relevante** en tu `README.md`, facilitando así la evaluación de tu trabajo.

#### **Criterio global 1: Instancia objetos y hacer uso de ellos**
- **(2.a, 2.b, 2.c, 2.d, 2.f, 2.h, 4.f, 4.a)**: Describe cómo has instanciado y utilizado objetos en tu proyecto. ¿Cómo has aplicado los constructores y pasado parámetros a los métodos? Proporciona ejemplos específicos de tu código.

He usado constructores para inicializar objetos en diferentes clases. Por ejemplo, en la clase Usuario, mediante el constructor primario he añadido propiedades y luego en el objeto GestionConsola las he instanciado correctamente.

En esta clase se puede ver que he aplicado los constructores correctamente para agregarle algunos atributos (propiedades) a la clase

      class Usuario(
         private var nombre: String,
         private var nick: String,
      )

En esta funcion instancio las propiedades de la clase Usuario

      fun crearUsuario(): Usuario {
        print("Nombre: ")
        val nombre = readln()
        print("Nick: ")
        val nick = readln()
      
        return Usuario(nombre, nick)
      }


#### **Criterio global 2: Crear y llamar métodos estáticos**
- **(4.i)**: ¿Has definido algún método/propiedad estático en tu proyecto? ¿Cuál era el objetivo y por qué consideraste que debía ser estático en lugar de un método/propiedad de instancia?

En la clase Usuario, he establecido el ID como lateinit debido a que necesito inicializarla después, se inicializa dentro del metodo `generarIdRandom()`, que se llama en la inicializacion del objeto, permitiendo retrasar la inicializacion de esta variable hasta que sea necesario su uso.

Dicha variable esta en un objeto estatico (companion object) para conseguir que este asociada a la clase. Sirve para que todas las instancias de Usuario tengan la misma propiedad.

      companion object {
         lateinit var ID: String
      }

      init {
        ID = generarIdRandom()
      }


- **(2.e)**: ¿En qué parte del código se llama a un método estático o se utiliza la propiedad estática?

En la unica parte del codigo donde he tenido un uso real de esta ha sido en la funcion `mostrarperfil()` ya que se genera aleatoriamente y no tiene uso real. Si hubiese creado más clases hijas como pudieran ser desarrollador o jugador, gracias a la herencia compartirian esta misma propiedad sin necesidad de instanciarlas.

      fun mostrarPerfil() : String {
         return "\nID: $ID\nNombre: $nombre\nNick: $nick"
      }

#### **Criterio global 3: Uso de entornos**
- **(2.i)**: ¿Cómo utilizaste el IDE para el desarrollo de tu proyecto? Describe el proceso de creación, compilación, y prueba de tu programa.

A principio de todo tuve pensado crear un vampire survivor, pero lo vi muy complejo asi que cambie a la idea de crear un Steam, que es como un videoclub pero online y con más funcionalidades. Empecé en un documento de google muy informal en el cual fui planteando la estructura de clases, los metodos que usaria y un poco de la herencia. En el IDE ya fui creando todo lo que sería el esqueleto del proyecto y ya luego iria aplicando la herencia.

Si algo no funcionaba he ido creando varios puntos de ruptura y debugeando el codigo.

#### **Criterio global 4: Definir clases y su contenido**
- **(4.b, 4.c, 4.d, 4.g)**: Explica sobre un ejemplo de tu código, cómo definiste las clases en tu proyecto, es decir como identificaste las de propiedades, métodos y constructores y modificadores del control de acceso a métodos y propiedades, para representar al objeto del mundo real. ¿Cómo contribuyen estas clases a la solución del problema que tu aplicación aborda?

Usaré como ejemplo la clase Usuario, es obvio que lo primero que debe hacer un usuario es conectarse a dicho programa, por lo que se piden diversos datos como el nombre o su id de jugador y son registrados.

      class Usuario(
         private var nombre: String,
         private var nick: String,
      )

He supuesto que como una persona normal, el que tiene boca se equivoca y por lo cual le he agregado las funcionalidades para modificar satisfactoriamente sus datos.

      fun cambiarNombre(nuevoNombre: String) {
         nombre = nuevoNombre
      }

      fun cambiarNick(nuevoNick: String) {
         nick = nuevoNick
      }

Sobre el control de acceso, he hecho que las funciones y propiedades sean privadas para que no sean accesibles desde cualquier parte del código.

#### **Criterio global 5: Herencia y uso de clases abstractas e interfaces**
- **(4.h, 4.j, 7.a, 7.b, 7.c)**: Describe sobre tu código cómo has implementado la herencia o utilizado interfaces en tu proyecto. ¿Por qué elegiste este enfoque y cómo beneficia a la estructura de tu aplicación? ¿De qué manera has utilizado los principios SOLID para mejorar el diseño de tu proyecto? ¿Mostrando tu código, contesta a qué principios has utilizado y qué beneficio has obtenido?

Mi codigo no posee mucha herencia y ninguna interfad, no va mas alla de instanciar clases en otras, lo unico que he podido aislar es el codigo con la gestion de los datos de entrada y salida situados en el main y su encapsulamiento en el objeto GestionConsola

El unico principio SOLID que creo que he podido salvar es el de SRP porque cada clase tiene una unica responsabilidad.

#### **Criterio global 6: Diseño de jerarquía de clases**
- **(7.d, 7.e, 7.f, 7.g)**: Presenta la jerarquía de clases que diseñaste. ¿Cómo probaste y depuraste esta jerarquía para asegurar su correcto funcionamiento? ¿Qué tipo de herencia has utilizado: Especificación, Especialización, Extensión, Construcción?
No hay herencia alguna que haya podido implementar

#### **Criterio global 7: Librerías de clases**
- **(2.g, 4.k)**: Describe cualquier librería externa que hayas incorporado en tu proyecto. Explica cómo y por qué las elegiste, y cómo las incorporaste en tu proyecto. ¿Cómo extendió la funcionalidad de tu aplicación? Proporciona ejemplos específicos de su uso en tu proyecto.

He usado la libreria de mordant para dar estilo a la salida de información como puede ser el título del proyecto nada más iniciar este mismo. En el main se puede apreciar:

      val terminal = Terminal()
      terminal.println(TextColors.brightBlue(tituloApi))

#### **Criterio global 8: Documentado**
- **(7.h)**: Muestra ejemplos de cómo has documentado y comentado tu código. ¿Que herramientas has utilizado? ¿Cómo aseguras que tu documentación aporte valor para la comprensión, mantenimiento y depuración del código?

He usado KDoc para documentar el codigo cada vez que he terminado una funcion para cuando vuelva a verla no se me olvide que hacen. No me han hecho falta muchos comentarios, ya que mi codigo es simple y entendible.

#### **Criterio global 9: Genéricos**
- **(6.f)**: Muestra ejemplos de tu código sobre cómo has implementado una clase con genéricos. ¿Qué beneficio has obtenido?

No he implementado genericos

