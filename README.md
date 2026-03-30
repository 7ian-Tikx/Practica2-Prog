# 🏕️ Pràctica 2 — Càmping Green (Programació 2, UB)

## Objetivo
Desarrollar un sistema para modelar, consultar y actualizar la información del **Càmping Green**:
- Alojamientos (estado operativo + iluminación)
- Accesos (tipos, estado abierto/cerrado, accesibilidad)
- Tareas de mantenimiento (alta/completado + efectos automáticos)
- Cálculos globales y persistencia (`save/load`)
- Tests propios por clase (punto 5.9)

---

## 📌 Plan final del proyecto (equipo de 2)

## 1) Alcance funcional

### 1.1 Alojamientos
- Mantener jerarquía de P1 (`Parcela`, `Bungalow`, `BungalowPremium`, `Glamping`, `MobilHome`).
- Añadir atributos nuevos en `Allotjament`:
  - `estat` (Operatiu / No operatiu)
  - `iluminacio` (`100%`, `50%`, `0%`)
- Implementar:
  - `tancarAllotjament(TascaManteniment tasca)`
  - `obrirAllotjament()`

### 1.2 Accesos
- Implementar jerarquía completa de accesos:
  - `Acces` (abstracta)
  - `AccesAsfalt` (abstracta), `AccesTerra` (abstracta)
  - `CamiAsfaltat`, `CarreteraAsfaltada`, `CamiTerra`, `CarreteraTerra`
- Estado de acceso: abierto/cerrado.
- Relación acceso ↔ lista de alojamientos a los que da servicio.

### 1.3 Tareas de mantenimiento
- Tipos: `Reparacio`, `Neteja`, `RevisioTecnica`, `Desinfeccio`.
- Reglas:
  - Un alojamiento no puede tener más de una tarea activa.
  - Al añadir tarea:
    - Alojamiento pasa a no operativo.
    - Iluminación del alojamiento cambia según tipo.
    - Se cierran accesos del alojamiento, salvo que también sirvan a otro alojamiento operativo.
  - Al completar tarea:
    - Alojamiento vuelve a operativo.
    - Iluminación vuelve a `100%`.
    - Recalcular estado de accesos.

### 1.4 Funciones de `Camping`
- Listados:
  - `llistarAllotjaments(estat)`
  - `llistarAccessos(infoEstat)`
  - `llistarTasquesManteniment()`
- Gestión:
  - `afegirTascaManteniment(...)`
  - `completarTascaManteniment(num)`
- Cálculos:
  - `calculaAccessosNoAccessibles()`
  - `calculaMetresTerra()`
- Persistencia:
  - `save(camiDesti)`
  - `load(camiOrigen)`

---

## 2) Reparto de trabajo

## 👤 Miembro A (Alojamientos + Mantenimiento)
- `Allotjament` + subclases (`Parcela`, `Bungalow`, `BungalowPremium`, `Glamping`, `MobilHome`).
- `TascaManteniment`.
- `LlistaTasquesManteniment` (alta/completado/listado/búsqueda).
- Integración de reglas de iluminación en alojamientos.
- Tests de todas las clases anteriores.

## 👤 Miembro B (Accesos + Persistencia + Cálculos)
- Jerarquía de `Acces` y `LlistaAccessos`.
- Cálculo de accesibilidad y metros de tierra.
- `save/load` en `Camping`.
- Integración final de `Camping` + `VistaCamping`/menú.
- Tests de accesos, cálculos y persistencia.

---

## 3) Cronograma de entrega (propuesto)

### Fase 1 — Estructura (día 1)
- Crear/ajustar jerarquías de clases e interfaces.
- Compilación básica sin lógica completa.

### Fase 2 — Lógica de negocio (día 2)
- Reglas de tareas de mantenimiento.
- Reglas de cierre/apertura de accesos.
- Métodos de listados y búsquedas.

### Fase 3 — Integración (día 3)
- Conectar todo en `Camping`.
- Inicialización de datos (`inicialitzaDadesCamping`).
- Validar flujo completo de menú.

### Fase 4 — Persistencia + Tests (día 4)
- Implementar `save/load`.
- Completar tests propios por clase (punto 5.9).
- Corrección de edge cases y limpieza final.

---

## 4) Criterios de calidad
- No modificar contratos de interfaces salvo necesidad explícita del enunciado.
- Mantener encapsulación y coherencia de nombres.
- Gestión de errores con `ExcepcioCamping`.
- No dejar métodos vacíos ni retornos “placeholder”.
- Commits pequeños y descriptivos.

---

## 5) Plan de tests propios (punto 5.9)

### 5.1 Cobertura mínima por clase
Para **cada clase implementada por el equipo**:
1. Test de constructor
2. Test de getters/setters relevantes
3. Test de método de lógica principal
4. Test de caso excepcional (si aplica)

### 5.2 Tests clave de integración
1. Añadir tarea -> estado e iluminación de alojamiento correctos.
2. Añadir tarea duplicada en el mismo alojamiento -> excepción.
3. Cierre de accesos respetando accesos compartidos.
4. Completar tarea -> reapertura de alojamiento y recalculado de accesos.
5. `save/load` mantiene estado completo del camping.

---

## 6) Riesgos y mitigación
- **Riesgo:** conflictos de merge en `Camping.java`.
  - **Mitigación:** integrar por bloques y acordar firmas antes de codificar.
- **Riesgo:** interfaces incompletas / métodos sin implementar.
  - **Mitigación:** checklist de compilación diaria.
- **Riesgo:** tests no alineados con reglas del enunciado.
  - **Mitigación:** testear explícitamente casos frontera (accesos compartidos, tareas duplicadas, estados).

---

## 7) Checklist final antes de entregar
- [ ] Compila todo el proyecto sin errores.
- [ ] Flujos de mantenimiento funcionan de extremo a extremo.
- [ ] Cálculos (`metresTerra`, accesibilidad) correctos.
- [ ] Persistencia `save/load` validada con test.
- [ ] Tests propios por clase completados (5.9).
- [ ] README actualizado con plan y reparto final.

---

Proyecto: **Pràctica 2 — Programació 2 (UB, 2025–2026)**
