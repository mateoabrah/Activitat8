```markdown
# Proyecto Cuenta Corriente con TDD

En este proyecto he implementado una **Cuenta Corriente** utilizando el enfoque de **Test-Driven Development (TDD)**.
Mi objetivo es demostrar cómo desarrollar software siguiendo la metodología TDD, es decir, escribiendo las pruebas unitarias
antes de implementar la lógica de las funcionalidades. La aplicación simula una cuenta bancaria con operaciones como **ingresar**,
**retirar** y **transferir** dinero, y todas las funcionalidades están acompañadas de pruebas que validan el comportamiento correcto del código.

## Descripción

El proyecto consiste en una clase `CuentaCorriente` que representa una cuenta bancaria con las siguientes funcionalidades:

- **Ingresar dinero** en la cuenta.
- **Retirar dinero** de la cuenta, siempre que haya saldo suficiente.
- **Transferir dinero** entre dos cuentas.

He seguido el proceso de **TDD** en el que primero escribí las pruebas unitarias para cada una de las funcionalidades y luego implementé
la lógica para hacer que las pruebas pasaran con éxito.

### Clases principales

- **CuentaCorriente.java**: Esta es la clase principal donde se encuentra la lógica de la cuenta bancaria. Contiene métodos para ingresar,
retirar y transferir dinero entre cuentas.
- **CuentaCorrienteTest.java**: En esta clase he escrito las pruebas unitarias usando **JUnit 5** para asegurarme de que las operaciones
de la cuenta funcionan correctamente.

## Requisitos

Para ejecutar este proyecto, necesitas tener instalados los siguientes requisitos:

- **Java 21** o superior.
- **JUnit 5** para ejecutar las pruebas unitarias.

## Instalación y Ejecución

### 1. Clonar el repositorio

Primero, clona el repositorio en tu máquina local con el siguiente comando:

git clone https://github.com/mateoabrah/Activitat8.git

```

### 2. Compilar el proyecto

Una vez que hayas clonado el repositorio, abre una terminal y navega hasta el directorio del proyecto. 
Luego, compila el código fuente con el siguiente comando:

```bash
javac -d out src/CuentaCorriente.java src/CuentaCorrienteTest.java
```

Este comando compila tanto la clase `CuentaCorriente` como las pruebas unitarias `CuentaCorrienteTest`.

### 3. Ejecutar las pruebas

Para ejecutar las pruebas unitarias, puedes usar el siguiente comando en la terminal (Linux/macOS)

```bash
java -cp out:libs/junit-jupiter-api.jar:libs/junit-jupiter-engine.jar org.junit.jupiter.api.TestCuentaCorriente
```
Para ejecutarlo en Windows:

```bash
java -cp out;libs/junit-jupiter-api.jar;libs/junit-jupiter-engine.jar org.junit.jupiter.api.TestCuentaCorriente
```


Recuerda asegurarte de tener los archivos JAR de **JUnit 5** en el directorio `libs`.

## Flujo de trabajo con GitHub Actions

He configurado **GitHub Actions** para automatizar la ejecución de las pruebas unitarias cada vez que realizo un 
**push** o **pull request** al repositorio. 
GitHub Actions ejecutará las pruebas en un entorno de **Ubuntu** con los requisitos necesarios para el proyecto.

### Flujo de trabajo configurado

- El flujo de trabajo de **GitHub Actions** está configurado en el archivo `.github/workflows/java.yml`.
- Cada vez que hago un **push** a la rama `master`, el flujo de trabajo se ejecuta automáticamente y las
pruebas se corren sin necesidad de intervención manual.

## Contribución

Si deseas contribuir a este proyecto, sigue estos pasos:

1. Haz un **fork** del repositorio.
2. Crea una nueva rama para tus cambios.
3. Realiza los cambios y luego crea un **pull request** para que lo revise y pueda fusionar tus mejoras.

## Licencia

Este proyecto está bajo la licencia **MIT**.

```
