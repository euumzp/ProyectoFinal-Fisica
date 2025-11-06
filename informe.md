# Informe — Movimiento Armónico Simple

---

## Objetivo

Explicar la teoría del **Movimiento Armónico Simple (MAS)** y presentar las ecuaciones y conceptos fundamentales que sustentan el fenómeno, dejando espacio para que el grupo inserte los gráficos y resultados experimentales.

---

## Introducción

El movimiento armónico simple es un movimiento oscilatorio alrededor de una posición de equilibrio donde la fuerza restauradora es proporcional al desplazamiento y está dirigida hacia el punto de equilibrio (ley de Hooke). Es un modelo básico para resortes, péndulos pequeños y muchas oscilaciones en física.

---

## Ecuaciones fundamentales

**Ley de Hooke (fuerza restauradora):**

$$ F = -k x $$

**Ecuación diferencial del MAS:**

$$ m \ddot{x}(t) = -k x(t) \quad \Longrightarrow \quad \ddot{x} + \omega^2 x = 0 $$

donde
$$ \omega = \sqrt{\frac{k}{m}} $$
es la frecuencia angular.

**Solución general (posición):**

$$ x(t) = A \cos(\omega t + \varphi) $$

* A: amplitud
* φ: fase inicial

**Velocidad y aceleración:**

$$ v(t) = \dot{x}(t) = -A \omega \sin(\omega t + \varphi) $$
$$ a(t) = \ddot{x}(t) = -A \omega^2 \cos(\omega t + \varphi) = -\omega^2 x(t) $$

**Periodo y frecuencia:**

$$ T = \frac{2\pi}{\omega} = 2\pi \sqrt{\frac{m}{k}}, \quad f = \frac{1}{T} $$

---

## Energía en el MAS

* Energía cinética: $$ K = \frac{1}{2} m v^2 $$
* Energía potencial elástica: $$ U = \frac{1}{2} k x^2 $$
* Energía total: $$ E = K + U = \frac{1}{2} m A^2 \omega^2 = \frac{1}{2} k A^2 = \text{constante} $$

---

## Relación entre posición y velocidad

* La posición y la velocidad están desfasadas π/2 (90°).
* Cuando la posición es máxima ($x = \pm A$), la velocidad es cero; cuando la posición pasa por el equilibrio ($x = 0$), la velocidad alcanza su valor máximo ($v_{\text{max}} = A \omega$).

---

## Conclusión teórica

La teoría del MAS permite comprender cómo se relacionan amplitud, masa, constante elástica y frecuencia angular. Estos conceptos sirven de base para interpretar los resultados experimentales que se presentarán en el informe junto con los gráficos y cálculos de la constante elástica y el periodo.
