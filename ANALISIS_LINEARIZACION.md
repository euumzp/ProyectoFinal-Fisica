# Justificación de la Linearización para Análisis de Movimiento Armónico Simple

## Contexto Físico
El Movimiento Armónico Simple (MAS) describe sistemas oscilatorios donde la fuerza restauradora es proporcional al desplazamiento. En nuestro experimento, estudiamos partículas con diferentes masas (2m, 3m, 4m) sometidas a este tipo de movimiento.

## Fundamentación Matemática

### Ecuaciones Fundamentales del MAS
Para un sistema MAS, tenemos:
- **Ecuación de posición**: \( x(t) = A \cos(\omega t + \phi) \)
- **Ecuación de velocidad**: \( v(t) = -A \omega \sin(\omega t + \phi) \)

### Derivación de la Relación Lineal
\[
v^2 = \omega^2 (A^2 - x^2)
\]

### Forma Lineal Final
\[
v^2 = (-\omega^2) \cdot x^2 + (\omega^2 A^2)
\]

### Parámetros Lineales
- **Variable independiente (X)**: \( x^2 \)
- **Variable dependiente (Y)**: \( v^2 \)
- **Pendiente (m)**: \( -\omega^2 \)
- **Intercepto (b)**: \( \omega^2 A^2 \)

## Procedimiento de Cálculo
A partir de la regresión lineal:
- **Frecuencia angular**: \( \omega = \sqrt{-m} \)
- **Amplitud**: \( A = \sqrt{-\frac{b}{m}} \)

## Aplicación a los Datos Experimentales
Para cada conjunto de datos (masas 2m, 3m, 4m) aplicaremos esta linearización para determinar \( \omega \) y \( A \).
