# Cálculo del Período de Oscilación para Masa 9m

---

## **1. Introducción**

La tarea asignada para la Semana 5 a la *Persona 2* consiste en calcular el **período de oscilación** de un sistema masa–resorte cuando la masa se incrementa a **9m**, donde *m* es la masa base utilizada anteriormente.

El cálculo debe incluir:

- Fórmula del período.
- Sustitución con datos obtenidos previamente.
- Propagación de error.
- Presentación del resultado final.

Los valores utilizados provienen del trabajo de la **Persona 1 (Semana 4)**.

---

## **2. Fundamento Teórico**

El sistema masa–resorte ideal sigue el comportamiento del **Movimiento Armónico Simple (MAS)**:

\[
x(t) = A \cos(\omega t + \varphi)
\]

La frecuencia angular está dada por:

\[
\omega = \sqrt{\frac{k}{m}}
\]

El período se define como:

\[
T = \frac{2\pi}{\omega} = 2\pi \sqrt{\frac{m}{k}}
\]

Este resultado indica:

- El período **crece** con la raíz de la masa.
- El período **disminuye** cuando la constante del resorte aumenta.

---

## **3. Datos Utilizados**

Según el informe de la Semana 4:

- **Constante elástica del resorte:**

\[
k = 24.68\ \text{N/m}
\]

- **Error experimental:**

\[
\Delta k = 0.20\ \text{N/m}
\]

La masa base experimental utilizada fue:

\[
m = 1\ \text{kg}
\]

Para este trabajo:

\[
m' = 9m = 9\ \text{kg}
\]

---

## **4. Cálculo del Período para Masa 9m**

Aplicamos:

\[
T = 2\pi \sqrt{\frac{m'}{k}}
\]

Sustituyendo valores:

\[
T = 2\pi \sqrt{\frac{9}{24.68}}
\]

\[
T = 2\pi \sqrt{0.3648}
\]

\[
T = 2\pi (0.60398)
\]

\[
T = 3.79\ \text{s}
\]

Este valor coincide con el utilizado posteriormente para las gráficas elaboradas por la Persona 3.

---

## **5. Propagación de Error**

Partimos de:

\[
T = 2\pi\sqrt{\frac{m'}{k}}
\]

El error depende sólo de **k**, pues m' es exacta.

\[
\Delta T = \left| \frac{\partial T}{\partial k} \right| \Delta k
\]

Calculamos la derivada:

\[
\frac{\partial T}{\partial k} = -\pi \sqrt{\frac{m'}{k^3}}
\]

Sustituyendo:

\[
\Delta T = \pi \sqrt{\frac{9}{(24.68)^3}} \cdot 0.20
\]

\[
\Delta T = \pi (0.02447)(0.20)
\]

\[
\Delta T = 0.0154\ \text{s}
\]

---

## **6. Resultado Final**

\[
\boxed{T = 3.79 \pm 0.02\ \text{s}}
\]

El resultado muestra una baja incertidumbre, lo que confirma que la medición de la constante elástica es consistente y fiable.

---

## **7. Conclusiones**

1. Se determinó exitosamente el período de oscilación para una masa de \(9m\), usando la constante elástica derivada la semana anterior.  
2. El resultado obtenido es coherente con el comportamiento teórico del MAS.  
3. La propagación de error demuestra que los resultados experimentales presentan una buena estabilidad.  
4. Este cálculo fue fundamental para continuar con la generación de gráficas realizada por la Persona 3.
