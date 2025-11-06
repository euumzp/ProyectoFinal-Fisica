# Informe — Movimiento Armónico Simple

## Objetivo
Analizar experimentalmente el **Movimiento Armónico Simple** mediante datos de posición y velocidad de partículas con diferentes masas, determinando la constante elástica del resorte y el periodo de oscilación.

---

## Marco Teórico

### Ecuaciones Fundamentales

**Ley de Hooke:**
$$ F = -k x $$

**Ecuación del MAS:**
$$ m \ddot{x} + k x = 0 \quad \Rightarrow \quad \ddot{x} + \omega^2 x = 0 $$

**Frecuencia angular:**
$$ \omega = \sqrt{\frac{k}{m}} $$

**Solución de posición:**
$$ x(t) = A \cos(\omega t + \varphi) $$

**Velocidad:**
$$ v(t) = -A \omega \sin(\omega t + \varphi) $$

**Periodo:**
$$ T = \frac{2\pi}{\omega} = 2\pi \sqrt{\frac{m}{k}} $$

### Energía en el MAS
- **Energía cinética:** $ K = \frac{1}{2} m v^2 $
- **Energía potencial:** $ U = \frac{1}{2} k x^2 $  
- **Energía total:** $ E = \frac{1}{2} k A^2 $ (constante)

---

## Metodología Experimental

### Datos Utilizados
Se analizaron 6 conjuntos de datos correspondientes a partículas con masas:
- **Tabla 1:** Masa 4m
- **Tabla 2:** Masa 3m  
- **Tabla 3:** Masa 3m
- **Tabla 4:** Masa 2m
- **Tabla 5:** Masa 2m
- **Tabla 6:** Masa m

### Implementación Computacional
Se desarrolló un programa en Java utilizando:
- **Maven** para gestión de dependencias
- **XChart** para visualización de gráficos
- **CSV** para manejo de datos experimentales

```java
// Código principal para análisis MAS
public class MASAnalizer {
    // Implementación de lectura de datos y graficación
}
```

---

## Resultados Experimentales

### Tabla 1 - Masa 4m
![Gráfica Posición vs Tiempo - Masa 4m](/graficos/tabla1_posicion.jpg)

**Parámetros calculados:**
- Amplitud (A): 1.000 m
- Periodo (T): 2.000 s
- Frecuencia angular (ω): 3.142 rad/s
- Constante elástica (k): 39.48 N/m

### Tabla 2 - Masa 3m  
![Gráfica Posición vs Tiempo - Masa 3m](/graficos/tabla2_posicion.jpg)

**Parámetros calculados:**
- Amplitud (A): 0.856 m
- Periodo (T): 1.800 s
- Frecuencia angular (ω): 3.490 rad/s
- Constante elástica (k): 36.54 N/m

### Tabla 3 - Masa 3m
![Gráfica Posición vs Tiempo - Masa 3m](/graficos/tabla3_posicion.jpg)

**Parámetros calculados:**
- Amplitud (A): 1.986 m
- Periodo (T): 2.200 s
- Frecuencia angular (ω): 2.856 rad/s
- Constante elástica (k): 24.47 N/m

### Tabla 4 - Masa 2m
![Gráfica Posición vs Tiempo - Masa 2m](/graficos/tabla4_posicion.jpg)

**Parámetros calculados:**
- Amplitud (A): 1.958 m
- Periodo (T): 1.600 s
- Frecuencia angular (ω): 3.927 rad/s
- Constante elástica (k): 30.84 N/m

### Tabla 5 - Masa 2m
![Gráfica Posición vs Tiempo - Masa 2m](/graficos/tabla5_posicion.jpg)

**Parámetros calculados:**
- Amplitud (A): 2.000 m
- Periodo (T): 1.500 s
- Frecuencia angular (ω): 4.189 rad/s
- Constante elástica (k): 35.10 N/m

### Tabla 6 - Masa m
![Gráfica Posición vs Tiempo - Masa m](/graficos/tabla6_posicion.jpg)

**Parámetros calculados:**
- Amplitud (A): 1.000 m
- Periodo (T): 1.000 s
- Frecuencia angular (ω): 6.283 rad/s
- Constante elástica (k): 39.48 N/m

---

## Análisis de Resultados

### Cálculo de la Constante Elástica (k)

**Valores obtenidos de k:**
- Tabla 1: 39.48 N/m
- Tabla 2: 29.61 N/m  
- Tabla 3: 29.61 N/m
- Tabla 4: 19.74 N/m
- Tabla 5: 19.74 N/m
- Tabla 6: 9.87 N/m

**Constante elástica promedio:**
$$ k_{promedio} = \frac{39.48 + 29.61 + 29.61 + 19.74 + 19.74 + 9.87}{6} = \frac{148.05}{6} = 24.68 \text{ N/m} $$

### Cálculo del Periodo para Masa 9m

Utilizando la constante elástica promedio:

$$ T = 2\pi \sqrt{\frac{m}{k}} = 2\pi \sqrt{\frac{9m}{24.68}} $$

Considerando m como unidad de masa de referencia:
$$ T = 2\pi \sqrt{\frac{9}{24.68}} = 2\pi \sqrt{0.3647} = 2\pi \times 0.604 = 3.79 \text{ segundos} $$

---

## Discusión de Errores

### Fuentes de Error
1. **Error en medición de tiempo:** ±0.001 s
2. **Error en medición de posición:** ±0.001 m  
3. **Error en medición de velocidad:** ±0.001 m/s
4. **Aproximaciones numéricas** en el cálculo del periodo
5. **Limitación de puntos** en los datos experimentales
6. **Algoritmo de estimación de periodo** - Uso de valor por defecto (T=2.000s) cuando no se detectan suficientes cruces por cero

### Propagación de Errores
El error en la constante elástica se propaga desde las mediciones de posición y tiempo a través de la relación:
$$ k = m \omega^2 = m \left(\frac{2\pi}{T}\right)^2 $$

**Error relativo en k:**
$$ \frac{\Delta k}{k} \approx 2\frac{\Delta T}{T} $$
Dado que T ≈ 2.000s para múltiples mediciones, el error sistemático afecta significativamente el cálculo de k.

---

## Conclusiones

1. **Validación teórica:** Los datos experimentales confirman el comportamiento oscilatorio característico del MAS, mostrando curvas sinusoidales en posición vs tiempo.

2. **Constante elástica:** Se determinó una constante elástica promedio de **24.68 N/m** para el resorte utilizado, con una variación significativa entre mediciones debido a limitaciones en el algoritmo de cálculo del periodo.

3. **Periodo para masa 9m:** El periodo de oscilación calculado es de **3.79 segundos**.

4. **Relación masa-periodo:** Se observa la tendencia teórica $T \propto \sqrt{m}$, aunque la precisión está limitada por el algoritmo de estimación de periodo.

5. **Herramienta computacional:** El programa desarrollado demostró ser efectivo para la visualización de datos, pero requiere mejoras en el algoritmo de cálculo de parámetros para mayor precisión.

6. **Limitación identificada:** El método actual de estimación de periodo usando cruces por cero resulta insuficiente para conjuntos de datos pequeños, sugiriendo la implementación de ajuste por mínimos cuadrados o análisis de Fourier para futuras mejoras.
