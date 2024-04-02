---
marp: true
header: <div class="encabezado"><img src='imagenes/franjaSuperior.png'  /><div class="titulo"><h1 class="texto"></h1></div></div>
footer: '![image](imagenes/franjaInferior.png)' 
_header: '' 
_footer: '' 
paginate: true
_paginate: false
_backgroundImage: url('imagenes/fondo.png')
style: |

  .encabezado {
    position: relative; left: 0; top:0;display: inline-block; text-align: center;
  }
  .titulo {
    position: absolute; top: 40%; left: 50%; transform: translate(0%, -50%); color: gray;
  }
  .columns {
    display: grid;
    grid-template-columns: repeat(2, minmax(0, 1fr));
    gap: 1rem;
  }
  .texto:after {
    content: 'Titulo';
  }
  
  h1 { color: black }
---

<div style="position: absolute; left: 30%; top:45%; width: 70%; text-align: left"><h1 style="color: gray">Programación Orientada a Objetos</h1></div>
<div style="position: absolute; left: 30%; top:55%; width: 70%; text-align: left"><h5 style="color: gray">Área de programación<br />
Programa de Ingeniería de Sistemas y Computación<br />
Facultad de Ingeniería
</h5></div>

<div style="position: absolute; left: 45%; top:20%; background-color: rgb(212, 231, 205); width: 550px">
<b>
Problema: <br />
El arquitecto de parques infantiles<br />
</b>
</div>


<div style="position: absolute; left: 93%; top:10px; ">

![width:80](imagenes/licencia.png)
</div>

---


<style scoped>
.texto:after {
    content: 'Problema:';
  }
</style>

<div style="font-size: 20pt">

Raúl, un arquitecto de la ciudad de Armenia, está diseñando un conjunto de parques infantiles en un proyecto para la Gobernación del Quindío. El proyecto involucra el diseño de al menos un parque por cada uno de los  municipios del departamento: Armenia, Calarcá, Montenegro, Quimbaya, La Tebaida, Circasia, Filandia, Génova, Salento, Pijao, Córdoba y Buenavista.

La idea del gobernador es que el proyecto promueva la recreación y el deporte, así como también las matemáticas. Por eso, ha encargado al arquitecto que los diseños incluyan diferentes zonas en forma de figuras geométricas (círculos, rectángulos, cuadrados y triángulos rectángulos). La superficie de cada zona (área) puede ser de uno de los siguientes materiales: arena, grama sintética, grama natural o asfalto. 

Cada material tiene un valor por metro cuadrado y cada municipio tiene un sobre costo asociado. 

---

<style scoped>
.texto:after {
    content: 'Problema:';
  }

  div { columns: 2 }
</style>

<div style="font-size: 12pt;">


| Material                                | Valor por metro cuadrado                                          |
|---------------------------------------|-----------------------------------------------------------|
| Arena | $10.0000  |
| Grama sintética | $35.0000  |
| Grama natural | $20.0000  |
| Asfalto | $40.0000  | 



| Municipio                                | Sobrecosto                                          |
|---------------------------------------|-----------------------------------------------------------|
| Armenia | $0  |
| Calarcá| $10.0000  |
| Montenegro | $20.0000  |
| Quimbaya | $30.0000  | 
| Tebaida | $15.0000  | 
| Circasia | $18.0000  | 
| Filandia | $22.0000  | 
| Génova | $70.0000  | 
| Salento | $50.0000  | 
| Pijao | $40.0000  | 
| Córdoba | $30.0000  | 
| Buenavista | $35.0000  | 

---

<style scoped>
.texto:after {
    content: 'Problema:';
  }
</style>

<div style="font-size: 20pt">


Raúl necesita de una aplicación que le permita consultar la información del proyecto:

- todos los parques diseñados (ordenados por valor total de forma ascendente)
- Un parque determinado (dado su nombre)
- Los parques de un municipio (por nombre del municipio)

La información de cada parque debe ser: nombre del parque, descripción, zonas con nombre, material y una determinada forma.

Es importante calcular el valor de todo el proyecto.

La aplicación debe impedir usar medidas negativas para las zonas, así como tener nombre repetido en zonas en el mismo parque o entre parques.

---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué se solicita finalmente? (problema)';
  }
</style>

Sistema que permita :

- Adicionar parques al proyecto (sin repetir nombres)
- Adicionar zonas a un parque (sin repetir nombres de zonas en el parque)
- Listar todos los parques diseñados ordenados por valor total de forma ascendente.
- Obtener un parque dado su nombre
- Obtener los parques de un municipio (por nombre del municipio)
- Calcular el valor de todo el proyecto
- Impedir el uso de medidas negativas

---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué información es relevante dado el problema anterior?';
  }

</style>

<div style="font-size: 15pt;">

- **Parque**:
  - nombre: Texto

- **ZonaParque**:
  - nombre: Texto

- **Material**:
  - ARENA(10000.0)
  - GRAMA_SINTETICA(35000.0)
  - GRAMA_NATURAL(20000.0)
  - ASFALTO(40000.0)]

---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué información es relevante dado el problema anterior?';
  }
</style>

<div style="font-size: 15pt;">

- **Municipio**:
  - ARMENIA(0.0)
  - CALARCA(10000.0)
  - MONTENEGRO(20000.0)
  - QUIMBAYA(30000.0)
  - TEBAIDA(15000.0)
  - CIRCASIA(18000.0)
  - FILANDIA(22000.0)
  - GÉNOVA(70000.0)
  - SALENTO(50000.0)
  - PIJAO(40000.0)
  - CORDOBA(30000.0)
  - BUENAVISTA(35000.0)

---

<style scoped>
.texto:after {
    content: 'Abstracción: ¿Qué información es relevante dado el problema anterior?';
  }
</style>

<div style="font-size: 15pt;">

- **Circulo**:
  - radio: Real

- **Rectangulo**:
  - ancho: Real
  - alto: Real

- **TrianguloRectangulo**:
  - base: Real
  - altura: Real

---


<style scoped>
.texto:after {
    content: 'Abstracción: ¿Cómo se agrupa la información relevante?';
  }
</style>

<div style="position: absolute; left: 10%; top:15%; ">

![width:1050](diagrama-00.svg)
</div>

---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>

<div style="font-size: 19pt;">

- **ProyectoGobernacion**
  - Almacenar un parque
  - Recuperarla información de un parque dado el nombre
  - Obtener parques de los municipios
  - Obtener parques ordenados por valor ascendente
  - Calcular el valor de todo el proyecto

- **ParqueInfantil**
  - Obtener la información del parque (nombre y descripción)
  - Adicionar / Recuperar zona del parque
  - Calcular el valor del parque

---

<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>

- **ZonaParque**
  - Obtener la información de la zona (nombre y material)
  - Calcular el valor de la zona

- **FiguraGeométrica** (**Circulo**, **Rectangulo**, **Cuadradro** y **TruanguloRectangulo**)
  - Calcular área de la figura específica
  
---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>



<div style="position: absolute; left: 5%; top:20%; ">

![width:1200](diagrama-01.svg)
</div>


---

<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

- Almacenar datos de prueba
- Recuperar los datos de prueba
- Verificar que los datos almacenados coinciden con los datos recuperados


---

<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 12pt;">

Clase: **Circulo**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Área de un círculo de radio positivo | Se crea un círculo de radio 10 y se obtiene su área| Se obtiene un área de 314.159 |
| Área de un círculo de radio negativo | Se intenta crea un círculo de radio -10 y se obtiene su área| Error, no es posible crear un círculo de radio negativo |



Clase: **Rectangulo**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Área de un rectángulo de ancho y alto positivos | Se crea un rectángulo con ancho 10 y alto 20, luego se obtiene su área| Se obtiene un área de 200.0 |
| Área de un rectángulo de ancho negativo y alto positivo | Se intenta crea un rectángulo con ancho -10 y alto 20, luego se obtiene su área| Error, no se puede crear un rectángulo con un ancho negativo |
| Área de un rectángulo de ancho positivo y alto negativo | Se intenta crea un rectángulo con ancho 10 y alto -20, luego se obtiene su área| Error, no se puede crear un rectángulo con un alto negativo |


</div>


---

<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 12pt;">

Clase: **Cuadrado**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Área de un cuadrado de lado positivo | Se crea un cuadrado de lado 10, luego se obtiene su área| Se obtiene un área de 100.0 |
| Área de un cuadrado de lado negativo | Se intenta crea un cuadrado de lado -10, luego se obtiene su área| Error, no se puede crear un cuadrado con lado negativo |


Clase: **TrianguloRectangulo**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Área de un triángulo rectángulo de base y altura positivas | Se crea un triángulo rectángulo con base 10 y altura 20, luego se obtiene su área| Se obtiene un área de 100.0 |
| Área de un triángulo rectángulo de base negativo y altura positivo | Se intenta crea un triángulo rectángulo con base -10 y altura 20, luego se obtiene su área| Error, no se puede crear un triángulo rectángulo con una base  negativa |
| Área de un triángulo rectángulo de base positiva y altura negativa | Se intenta crea un triángulo rectángulo con base 10 y altura -20, luego se obtiene su área| Error, no se puede crear un triángulo rectángulo de altura negativa  negativa |

---

<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 12pt;">

Clase: **ZonaParque**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Valor de una zona circular en arena | Se crea una zona circular de radio 10 en material de area con nombre "Zona 1" y se obtiene su valor| Se obtiene un valor de 3141592.65 |
| Valor de una zona rectangular en grama sintética | Se crea una zona  rectangular con ancho 10 y alto 20 y de material de grama sintética con nombre "Zona 1", luego se obtiene su valor| Se obtiene un área de 7000000.0 |
| Valor de una zona cuadrada en grama natural | Se crea una zona cuadrada con lado de 10 y de material de grama natural con nombre "Zona 1", luego se obtiene su valor| Se obtiene un área de 2000000.0 |
| Valor de una zona en forma de triángulo rectángulo en asfalto | Se crea una zona en forma de triángulo rectángulo con base de 10 y altura 20, además en material de asfalto con nombre "Zona 1", luego se obtiene su valor| Se obtiene un área de 4000000.0 |

---

<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 12pt;">

Clase: **ParqueInfantil**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Parque infantil con nombre nulo | Se intenta crear un parque infantil con nombre nulo| Error, no se puede crear un parque infantil de nombre nulo |
| Parque infantil con nombre vacío | Se intenta crear un parque infantil con nombre vacío| Error, no se puede crear un parque infantil de nombre vacío |
| Parque infantil con descripción nula | Se intenta crear un parque infantil con descripción nula| Error, no se puede crear un parque infantil con  descripción nula |
| Parque infantil con descripción vacía | Se intenta crear un parque infantil con descripción vacía| Error, no se puede crear un parque infantil con descripción vacía |
| Valor de un parque infantil con datos válidos pero sin zonas | Se crea un parque infantil ( "Mi primer recuerdo", "Parque para los primero años de edad", Calarca ), luego se obtiene el valor del parque |  Se obtiene 10000.0  (sobrecosto)|

---

<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 12pt;">

Clase: **ParqueInfantil**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Valor de un parque infantil con datos válidos y una zona circular | Se crea un parque infantil ( "Mi primer recuerdo", "Parque para los primero años de edad", Calarca ), luego se le adiciona una zona circular de radio 10 en material de arena y de nombre "Zona de mascotas", luego se obtiene el valor del parque |  Se obtiene 3151592.65 |
| Valor de un parque infantil con datos válidos y cuatro zonas una por cada forma | Se crea un parque infantil ( "Mi primer recuerdo", "Parque para los primero años de edad", Calarca ), luego se le adiciona: una zona circular de radio 10 en material de area y de nombre "Zona de mascotas", una zona  rectangular con ancho 10 y alto 20 y de material de grama sintética, zona cuadrada con lado de 10 y de material de grama natural, zona en forma de triángulo rectángulo con base de 10 y altura 20, además en material de arena; finalmente se obtiene el valor del parque | Se obtiene 13151592.65 |
| Parque infantil con dos zonas con el mismo nombre | Se crea un parque infantil ( "Mi primer recuerdo", "Parque para los primero años de edad", Calarca ), luego se le adiciona una zona circular de radio 10 en material de area y de nombre "Zona de mascotas", luego intenta adicionar otra zona (independiente de la forma) con el mismo nombre | Error, no se pueden tener dos zonas con el mismo nombre  |


---

<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 12pt;">

Clase: **ProyectoGobernacion**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Valor de proyecto que no tiene parques | Se crea un proyecto de la gobernación sin parques, luego se solicita el valor del proyecto | Se obtiene 0.0|
| Se obtiene un parque por el nombre | Se adiciona al proyecto de la gobernación un parque infantil ( "Mi primer recuerdo", "Parque para los primero años de edad", Calarca ), luego solicita la información del parque  "Mi primer recuerdo" | Se obtiene toda la información del parque  ( "Mi primer recuerdo", "Parque para los primero años de edad", Calarca ) |
| Se intenta obtener un parque inexistente | se solicita la información del parque  "Mi recuerdo"  (sin que exista) | Error, no existe un parque con ese nombre |
| Parques con el  mismo nombre | Se adiciona al proyecto de la gobernación un parque infantil ( "Mi primer recuerdo", "Parque para los primero años de edad", Calarca ), luego intenta adicionar otro parque pero con el mismo nombre | Error, no se pueden adicionar dos parques con el mismo nombre |

---

<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

<div style="font-size: 12pt;">

Clase: **ProyectoGobernacion**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Un municipio sin parques| Se obtiene los parques del municipio de "GENOVA" (municipio sin parques en el sistema) | Se obtiene una lista vacía | 
| Un municipio que no existe | Se obtiene los parques del municipio de "SEVILLA" | Se obtiene una lista vacía |
| Parques de una municipio | Se crea un proyecto con los parques { "Pijao 1", "Cordoba 1", "Buenavista 1", "Pijao 2", "Cordoba 2", "Buenavista 2"}; luego se solicitan los parques de municipio "PIJAO"  | Se obtiene la lista { "Pijao 1", "Pijao 2"} |
| Orden por valor, Dos parques por los últimos tres municipios del Quindío | Se crea un proyecto con los parques { "Pijao 1", "Cordoba 1", "Buenavista 1", "Pijao 2", "Cordoba 2", "Buenavista 2"}; luego se le adiciona a cada uno una zona cuadrada de asfalto de lado 15; y finalmente se solicitan los parques ordenados por valor ascendente  | Se obtiene la lista { "Cordoba 1", "Cordoba 2", "Buenavista 1", "Buenavista 2", , "Pijao 1", "Pijao 2"} |

---

<style scoped>
.texto:after {
    content: 'Codificación: ';
  }
</style>

- **¿Cómo pruebo la solución?**

  - Almacenar datos de prueba de un estudiante. 
  - Recuperar datos de prueba de un estudiante. 
  - Verificar que los datos almacenados coinciden con los datos recuperados

- **Cómo escribo la solución en Java?**

  Ver la carpeta del *src* en el proyecto de **Visual Studio Code**



---

<!-- 
_header: ''
_footer: '' 
_paginate: false
_backgroundImage: url('imagenes/gracias.png')
-->
