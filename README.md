# parcialTopicos
Este proyecto forma parte del primer previo de la asignatura Tópicos. Su finalidad es calcular el tiempo de trabajo independiente para una materia universitaria, tomando como entrada ciertas variables como el nombre de la materia, horas teóricas, horas prácticas y el número de créditos.

## Descripción

La aplicación permite calcular el tiempo de trabajo independiente que un estudiante debe dedicar a una materia. Los usuarios ingresan el nombre de la materia, horas teóricas, horas prácticas y el número de créditos, y la aplicación calcula automáticamente el tiempo recomendado de trabajo independiente.

## Características

- Se debe ingresar el nombre de la materia.
- Se debe ingresar las horas teóricas y prácticas.
- Se debe ingresar de numero de creditos.

## Uso

- Ingrese el nombre de la materia.
- Especifique el número de horas teóricas y prácticas.
- Ingrese el número de créditos correspondientes.
- El resultado mostrará el cálculo estimado de horas de trabajo independiente.
- Para el calcular el valor del trabajo independiente se realiza el siguiente calculo :
  
 1 crédito = 48 horas,
 trabajo independiente del semestre = 16,


Horas por créditos = Número de creditos * 48

 
Horas presenciales = (horas teóricas + horas prácticas) * trabajo independiente del semestre

**Trabajo independiente**= (Horas por créditos - Horas presenciales ) / trabajo independiente del semestre

## Requisitos

- **SDK mínimo**: 24 (Android 7.0)
- **Versión de Android mínima**: 7.0

## Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/kevinrc06/parcialTopicos.git
2. Abre el proyecto en Android Studio.
3. Sincroniza con Gradle y asegúrate de que todas las dependencias estén instaladas correctamente.
4. Ejecuta el proyecto en un dispositivo o emulador con Android 7.0 o superior.

## Tecnologías Utilizadas

- **Lenguaje**: Kotlin
- **Interfaz de usuario**: XML


