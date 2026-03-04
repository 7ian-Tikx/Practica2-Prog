
---

# 📌 README – Pràctica 1 (Programació II)

## 👥 Team

* Student 1: Jinjie Chen
* Student 2: Tiantian Pan

---

# 📁 Final Project Structure

```Pian text
pra1/
├─ PanTiantianChenJinjie.iml
├─ README.md
├─ src/
│  └─ prog2/
│     ├─ model/
      |  (Interfaces - ya existen)
│     │  ├─ InAllotjament.java
│     │  ├─ InCamping.java
│     │  ├─ InClient.java
│     │  ├─ InLlistaReserves.java
│     │  ├─ InReserva.java
│     │  │
      |  (clases principales - to implement)
│     │  ├─ Camping.java -acabado
│     │  ├─ Client.java  -acabado
│     │  ├─ Reserva.java -acabado
│     │  ├─ LlistaReserves.java -acabado
         (Altjament classes)
│     │  ├─ Allotjament.java (abstract) -acabado
│     │  ├─ Parcela.java -acabado
│     │  ├─ Casa.java        (abstract)
│     │  ├─ Bungalow.java -acabado
│     │  ├─ BungalowPremium.java -acabado
│     │  ├─ Glamping.java -acabado
│     │  └─ MobilHome.java -acabado
│     │
│     └─ vista/
│        ├─ ExcepcioReserva.java
│        └─ GestorCamping.java -- Solo falta esta parte
│
└─ test/
   └─ prog2/
      └─ model/
         ├─ AllotjamentTest.java
         ├─ CampingTest.java
         ├─ ClientTest.java
         ├─ LlistaReservesTest.java
         ├─ ParcelaTest.java
         └─ ReservaTest.java
```

## La relacion entre la clase Allotjament
```Pain text
Allotjament (abstract)
│
├── Parcela
├── Casa (abstract)
│     ├── Bungalow
│     │     └── BungalowPremium
│     ├── Glamping
│     └── MobilHome
```

---

# Task Distribution

## Student 1 – Allotjament System

Responsible for the complete accommodation hierarchy:

* Allotjament (abstract)
* Parcela
* Casa (abstract)
* Bungalow
* BungalowPremium
* Glamping
* MobilHome

Responsibilities:

* Constructors
* Getters / Setters
* correcteFuncionament()
* toString()
* estada mínima logic
* Passing:

    * AllotjamentTest
    * ParcelaTest

---

## Student 2 – Management & Reservations

Responsible for core system logic:

* Client
* Reserva
* LlistaReserves
* Camping
* getTemporada() static method
* Exception handling

Responsibilities:

* Reservation validation
* Overlapping date detection
* Minimum stay validation
* Exception messages (must match tests exactly)
* Passing:

    * ClientTest
    * ReservaTest
    * LlistaReservesTest
    * CampingTest

---

# Recommended Implementation Order

To minimize compilation errors and dependency issues:

### Phase 1 – Basic Entities

1. Client
2. Allotjament
3. Parcela

### Phase 2 – Reservation Core

4. Reserva
5. LlistaReserves (without complex validation first)

### Phase 3 – Full Accommodation Hierarchy

6. Casa
7. Bungalow
8. BungalowPremium
9. Glamping
10. MobilHome

### Phase 4 – System Integration

11. Camping
12. Implement:

* afegirReserva
* calculAllotjamentsOperatius
* getAllotjamentEstadaMesCurta
* static getTemporada

### Phase 5 – Final Integration

13. Complete GestorCamping (main)
14. Run all tests
15. Fix failing edge cases

---

# 📌 Final Validation Checklist

* All JUnit tests pass
* No interface modified
* No test modified
* No hardcoded values to cheat tests
* Correct exception messages
* Project compiles without warnings

---

# 📎 Development Notes

* One public class per file
* File name must match class name
* Follow Java naming conventions
* Keep attributes private
* Use ArrayList and Iterators where required

---
