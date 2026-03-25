[cite_start]Aquí tienes una propuesta de estructura para el archivo `README.md` de vuestro repositorio, organizada para que podáis visualizar el reparto de tareas y los objetivos técnicos de la **Práctica 2** del Càmping Green[cite: 1, 5].

---

# 🏕️ Càmping Green - Pràctica 2 (Programació 2)

[cite_start]Proyecto de gestión para el **Càmping Green** desarrollado para la Facultad de Matemáticas e Informática de la **UB (Curs 2025-2026)**[cite: 2, 5]. [cite_start]Esta segunda fase se centra en la implementación de herencia, polimorfismo, gestión de mantenimiento y persistencia de datos[cite: 71, 173].

## 📋 Objetivos del Proyecto
* [cite_start]Implementar una jerarquía de clases para **Accesos** y **Alojamientos**[cite: 173, 184].
* [cite_start]Gestionar **Tareas de Mantenimiento** que afecten al estado operativo y energético del camping[cite: 50, 56].
* [cite_start]Automatizar la iluminación para un consumo energético eficiente (Camping "Verde")[cite: 53, 56].
* [cite_start]Garantizar la **Persistencia de Datos** mediante la lectura y escritura de objetos en ficheros[cite: 87, 212].

---

## 🛠️ Organización del Trabajo

Para optimizar el desarrollo, el equipo se ha dividido las responsabilidades de la siguiente manera:

### 👤 Miembro A: Gestión de Alojamientos y Mantenimiento
* [cite_start]**Jerarquía de Alojamientos**: Actualización de la clase `Allotjament` y sus hijas (`Parcela`, `Bungalow`, `BungalowPremium`, `Glamping`, `MobilHome`) con nuevos atributos de estado y niveles de iluminación (100%, 50%, 0%)[cite: 27, 28, 185].
* [cite_start]**Lógica de Mantenimiento**: Implementación de `TascaManteniment` y su enumeración de tipos (Reparació, Neteja, Revisió Tècnica, Desinfecció)[cite: 51, 188, 191].
* [cite_start]**Interfaz de Usuario**: Ampliación de la `VistaCamping` con las 13 opciones del menú y gestión de `ExcepcioCamping`[cite: 72, 153, 234].

### 👤 Miembro B: Infraestructura y Persistencia
* [cite_start]**Jerarquía de Accesos**: Creación de las clases abstractas `Acces`, `AccesAsfalt` y `AccesTerra`, junto a sus implementaciones finales para caminos y carreteras[cite: 174, 177, 178].
* [cite_start]**Lógica de Accesibilidad**: Implementación de los métodos para calcular metros totales de tierra y filtrar accesos por capacidad de vehículos[cite: 84, 85, 179].
* [cite_start]**Persistencia**: Desarrollo de los métodos `guardar()` y `carregar()` en la clase `Camping` utilizando `Streams` de objetos[cite: 212, 221, 228].

---

## 🚀 Funcionalidades Principales

1.  [cite_start]**Gestión de Estados**: Los alojamientos pueden estar `Operatiu` o `No operatiu`[cite: 28]. [cite_start]Si un alojamiento tiene una tarea activa, deja de estar operativo[cite: 59].
2.  [cite_start]**Cierre Automático de Accesos**: Al añadir una tarea a un alojamiento, el sistema cierra los accesos que llevan a él, a menos que den servicio a otros alojamientos operativos[cite: 60, 62].
3.  [cite_start]**Ahorro Energético**: La iluminación de los alojamientos y accesos se ajusta automáticamente según las tareas de mantenimiento activas[cite: 54, 65].
4.  [cite_start]**Validaciones Robustas**: Uso de excepciones para evitar duplicidad de tareas en un mismo alojamiento o errores en la carga de ficheros[cite: 57, 233].

---

## 📂 Estructura del Código
[cite_start]El proyecto se organiza en dos paquetes principales[cite: 96]:
* [cite_start]`prog2.model`: Contiene la lógica de negocio, datos y entidades (Camping, Allotjaments, Accessos, Tasques)[cite: 97, 150].
* [cite_start]`prog2.vista`: Contiene la interacción con el usuario, menús y la clase principal `IniciadorCamping`[cite: 97, 129, 154].

## 🧪 Pruebas Unitarias
Se han incluido tests unitarios utilizando **JUnit 5** para validar:
* [cite_start]Constructores de todas las clases del modelo[cite: 247].
* [cite_start]Cálculo correcto de metros de longitud en accesos de tierra[cite: 85].
* [cite_start]Correcto funcionamiento de la disponibilidad en las reservas[cite: 208].

---
