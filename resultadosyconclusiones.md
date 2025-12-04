# Informe Semana 6 - Proyecto Movimiento Armónico

## 1. Introducción
Este informe corresponde a la **Semana 6** del proyecto de Movimiento Armónico Simple (MAS). En esta sección se presentan los cálculos y la propagación de errores relacionados con el sistema masa-resorte utilizado para describir el MAS.

## 2. Fundamento Teórico
El sistema masa–resorte ideal sigue el comportamiento del Movimiento Armónico Simple (MAS):

$$
x(t) = A \cos(\omega t + \varphi)
$$

La frecuencia angular está dada por:

$$
\omega = \sqrt{\frac{k}{m}}
$$

El período se define como:

$$
T = \frac{2\pi}{\omega} = 2\pi \sqrt{\frac{m}{k}}
$$

Este resultado muestra que:
- El período crece con la raíz de la masa.
- El período disminuye cuando la constante del resorte aumenta.

## 3. Datos Utilizados

Según el informe de la Semana 4:

**Constante elástica del resorte:**

$$ k = 24.68 \ \text{N/m} $$

**Error experimental:**

$$ \Delta k = 0.20 \ \text{N/m} $$

**La masa base experimental utilizada fue:**

$$ m = 1 \ \text{kg} $$

**Para este trabajo:**

$$ m' = 9m = 9 \ \text{kg} $$


## 4. Cálculo del Período para Masa 9m
Aplicamos la siguiente fórmula para el cálculo del período del sistema:

$$
T = 2\pi \sqrt{\frac{m'}{k}}
$$

Sustituyendo los valores conocidos:

$$
T = 2\pi \sqrt{\frac{9}{24.68}} \approx 3.79\ \text{s}
$$

Este valor coincide con el utilizado posteriormente para las gráficas elaboradas por la Persona 3.

## 5. Propagación de Error
La propagación de error en el cálculo del período depende del error en la medición de la constante elástica, \(k\). La fórmula para calcular el error es:

$$
\Delta T = \left| \frac{\partial T}{\partial k} \right| \Delta k
$$

Calculamos la derivada:

$$
\frac{\partial T}{\partial k} = -\pi \sqrt{\frac{m'}{k^3}}
$$

Sustituyendo los valores:

$$
\Delta T = \pi \sqrt{\frac{9}{(24.68)^3}} \cdot 0.20 \approx 0.0154\ \text{s}
$$

## 6. Resultado Final

$$
T = 3.79 \pm 0.02\ \text{s}
$$

Este resultado muestra una baja incertidumbre, lo que indica que la medición de la constante elástica es consistente y fiable.

## 7. Conclusiones

1. **Validación teórica:** Los datos experimentales confirman el comportamiento oscilatorio característico del MAS, mostrando curvas sinusoidales en la gráfica de posición vs tiempo.
2. La propagación de error muestra una baja incertidumbre, lo que refuerza la validez de las mediciones y cálculos realizados.
