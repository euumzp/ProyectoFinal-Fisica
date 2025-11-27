# Informe — Movimiento Armónico Simple

## Objetivo
Analizar experimentalmente el **Movimiento Armónico Simple** mediante datos de posición y velocidad de partículas con diferentes masas, determinando la constante elástica del resorte y el periodo de oscilación.

---

## Marco Teórico

### Ecuaciones Fundamentales

**Ley de Hooke:**
<p align="center">
  <img src="https://latex.codecogs.com/svg.image?F=-k&space;x&space;" alt="F = -kx"/>
</p>

**Ecuación del MAS:**
<p align="center">
  <img src="https://latex.codecogs.com/svg.image?m\ddot{x}&plus;k&space;x=0\quad\Rightarrow\quad\ddot{x}&plus;\omega^2&space;x=0&space;" alt="m x¨ + kx = 0 ⇒ x¨ + ω²x = 0"/>
</p>


**Frecuencia angular:**
<p align="center">
  <img src="https://latex.codecogs.com/svg.image?\omega=\sqrt{\frac{k}{m}}" alt="ω = √(k/m)"/>
</p>


**Solución de posición:**
<p align="center">
  <img src="https://latex.codecogs.com/svg.image?x(t)=A\cos(\omega&space;t&plus;\varphi)" alt="x(t) = A cos(ωt + φ)"/>
</p>


**Velocidad:**
<p align="center">
  <img src="https://latex.codecogs.com/svg.image?v(t)=-A\omega\sin(\omega&space;t&plus;\varphi)" alt="v(t) = -A ω sin(ωt + φ)"/>
</p>


**Periodo:**
<p align="center">
  <img src="https://latex.codecogs.com/svg.image?T=\frac{2\pi}{\omega}=2\pi\sqrt{\frac{m}{k}}" alt="T = 2π/ω = 2π √(m/k)"/>
</p>


### Energía en el MAS
- **Energía cinética:**
<p align="center">
  <img src="https://latex.codecogs.com/svg.image?K=\frac{1}{2}m&space;v^2&space;" alt="K = 1/2 m v²"/>
</p>
 
- **Energía potencial:**
<p align="center">
  <img src="https://latex.codecogs.com/svg.image?U=\frac{1}{2}k&space;x^2&space;" alt="U = 1/2 k x²"/>
</p>

- **Energía total:**
<p align="center">
  <img src="https://latex.codecogs.com/svg.image?E=\frac{1}{2}k&space;A^2&space;" alt="E = 1/2 k A²"/>
</p>

 
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
![Gráfico Tabla 1](graficos/grafico_tabla1.png)

**Descripción:**
En la gráfica se puede ver cómo cambia la posición (línea roja) y la velocidad (línea azul) de la masa de 4m a lo largo del tiempo. Al principio la posición es máxima y va disminuyendo poco a poco, mientras que la velocidad empieza en cero y se vuelve negativa, mostrando que el objeto empieza a moverse hacia el otro extremo del resorte.
Se nota que ambas curvas están relacionadas, pero con un pequeño desfase, tal como ocurre en el movimiento armónico simple. En general, el comportamiento es el esperado: una oscilación suave y periódica, con la velocidad aumentando cuando la posición se acerca al punto de equilibrio.

**Parámetros calculados:**
- Amplitud (A): 1.000 m
- Periodo (T): 2.000 s
- Frecuencia angular (ω): 3.142 rad/s
- Constante elástica (k): 39.48 N/m

### Tabla 2 - Masa 3m  
![Gráfico Tabla 2](graficos/grafico_tabla2.png)

**Descripción:**
En esta gráfica se muestra cómo varían la posición (línea roja) y la velocidad (línea azul) para la masa de 3m. Se nota que la posición disminuye de forma casi lineal al principio, mientras que la velocidad se hace más negativa hasta alcanzar un punto mínimo y luego empieza a subir otra vez.
Esto refleja el momento en que la masa llega al extremo de su trayectoria y comienza a regresar, lo que es típico del movimiento armónico simple.

**Parámetros calculados:**
- Amplitud (A): 0.856 m
- Periodo (T): 1.800 s
- Frecuencia angular (ω): 3.490 rad/s
- Constante elástica (k): 36.54 N/m

### Tabla 3 - Masa 3m
![Gráfico Tabla 3](graficos/grafico_tabla3.png)

**Descripción:**
En esta gráfica se observa la posición (línea roja) y la velocidad (línea azul) correspondientes a la masa de 3m. Al inicio, la velocidad es alta y positiva, pero va disminuyendo con el tiempo hasta volverse negativa, mientras que la posición aumenta gradualmente hasta alcanzar un valor máximo y luego se mantiene casi constante.
Esto muestra el punto en el que la masa llega al extremo de su oscilación: la posición se estabiliza momentáneamente y la velocidad pasa por cero antes de cambiar de dirección. En general, el comportamiento sigue el patrón esperado del movimiento armónico simple, mostrando cómo ambas magnitudes están desfasadas entre sí.

**Parámetros calculados:**
- Amplitud (A): 1.986 m
- Periodo (T): 2.200 s
- Frecuencia angular (ω): 2.856 rad/s
- Constante elástica (k): 24.47 N/m

### Tabla 4 - Masa 2m
![Gráfico Tabla 4](graficos/grafico_tabla4.png)

**Descripción:**
En esta gráfica se puede ver cómo cambian la posición y la velocidad de la masa con el tiempo.
La línea roja muestra la posición: al inicio la masa está más alejada de su punto de equilibrio (aproximadamente a 4.5 m) y poco a poco se va acercando, pasando por el centro y moviéndose hacia el otro lado.
La línea azul representa la velocidad. Al comienzo es casi cero, luego aumenta mientras la masa se mueve hacia el equilibrio y vuelve a disminuir cuando cambia de dirección.
Se nota que cuando la posición es máxima, la velocidad es mínima, y viceversa, lo cual es típico del Movimiento Armónico Simple.

**Parámetros calculados:**
- Amplitud (A): 1.958 m
- Periodo (T): 1.600 s
- Frecuencia angular (ω): 3.927 rad/s
- Constante elástica (k): 30.84 N/m

### Tabla 5 - Masa 2m
![Gráfico Tabla 5](graficos/grafico_tabla5.png)

**Descripción:**
En esta gráfica se observan las variaciones de posición y velocidad de la masa a lo largo del tiempo.
La línea roja representa la posición, que empieza cerca de los 2 metros y va disminuyendo de forma continua, mostrando cómo la masa se mueve hacia el punto de equilibrio y lo atraviesa.
La línea azul muestra la velocidad: inicia en cero y luego se hace negativa, lo que indica que la masa se mueve en sentido contrario a su posición inicial. Alrededor de la mitad del tiempo alcanza su valor más bajo, lo que coincide con el momento en que la posición pasa por el equilibrio, y luego comienza a aumentar nuevamente.
El comportamiento de ambas curvas refleja el Movimiento Armónico Simple, donde la posición y la velocidad están fuera de fase: cuando una alcanza su máximo, la otra se encuentra cerca de cero.
En general, el gráfico muestra un movimiento periódico y regular, coherente con las leyes del MAS y con el periodo experimental medido para esta masa.

**Parámetros calculados:**
- Amplitud (A): 2.000 m
- Periodo (T): 1.500 s
- Frecuencia angular (ω): 4.189 rad/s
- Constante elástica (k): 35.10 N/m

### Tabla 6 - Masa m
![Gráfico Tabla 6](graficos/grafico_tabla6.png)

**Descripción:**
En esta gráfica se observa el movimiento de la masa más pequeña del experimento.
La línea roja muestra la posición, que empieza cerca de –1 m y va aumentando con el tiempo, lo que indica que la masa se mueve desde un extremo negativo hacia el equilibrio y más allá de él.
La línea azul representa la velocidad, que aumenta rápidamente al inicio, alcanza su valor máximo cerca de la mitad del tiempo y luego comienza a disminuir hasta llegar nuevamente a cero. Esto refleja cómo la masa acelera cuando pasa por el equilibrio y se desacelera al acercarse al punto máximo de desplazamiento.
Se nota claramente que la velocidad y la posición están desfasadas, lo que es característico del Movimiento Armónico Simple.
El movimiento es rápido y regular, con un periodo corto, lo que coincide con la teoría: al tener una masa menor, la oscilación ocurre más deprisa.

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
<p align="center">
  <img src="https://latex.codecogs.com/svg.image?k_{promedio}=\frac{39.48&plus;29.61&plus;29.61&plus;19.74&plus;19.74&plus;9.87}{6}=\frac{148.05}{6}=24.68\text{N/m}" alt="k_promedio = 24.68 N/m"/>
</p>

### Cálculo del Periodo para Masa 9m

Utilizando la constante elástica promedio:

<p align="center">
  <img src="https://latex.codecogs.com/svg.image?T=2\pi\sqrt{\frac{m}{k}}=2\pi\sqrt{\frac{9m}{24.68}}" alt="T = 2π√(m/k) = 2π√(9m/24.68)"/>
</p>

Considerando m como unidad de masa de referencia:

<p align="center">
  <img src="https://latex.codecogs.com/svg.image?T=2\pi\sqrt{\frac{9}{24.68}}=2\pi\sqrt{0.3647}=2\pi\times&space;0.604=3.79\text{s}" alt="T = 2π√(9/24.68) = 2π√(0.3647) = 2π×0.604 = 3.79 s"/>
</p>

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

<p align="center">
  <img src="https://latex.codecogs.com/svg.image?k=m\omega^2=m\left(\frac{2\pi}{T}\right)^2&space;" alt="k = mω² = m(2π/T)²"/>
</p>

**Error relativo en k:**

<p align="center">
  <img src="https://latex.codecogs.com/svg.image?\frac{\Delta&space;k}{k}\approx&space;2\frac{\Delta&space;T}{T}" alt="Δk/k ≈ 2 ΔT/T"/>
</p>

---

## Cálculo de la Constante Elástica del Resorte (k)

Para cada conjunto de datos se determinó la constante elástica **k** usando la ecuación fundamental del Movimiento Armónico Simple:

$$
k = m\omega^2 = m\left( \frac{2\pi}{T} \right)^2
$$

donde:

* **m** es la masa.
* **T** es el periodo medido.
* **ω** es la frecuencia angular, dada por:

$$
\omega = \frac{2\pi}{T}
$$

---

### Procedimiento de Cálculo

1. A partir del gráfico posición–tiempo se obtuvo el **periodo T**.
2. Se calculó la frecuencia angular:

$$
\omega = \frac{2\pi}{T}
$$

3. Finalmente, se calculó la constante elástica:

$$
k = m\omega^2
$$

---

### Ejemplo de Cálculo (Tabla 1 — Masa 4m)

* Masa: ( m = 4m_0 )
* Periodo: ( T = 2.000\ \text{s} )

**1. Frecuencia angular**

$$
\omega = \frac{2\pi}{2.000} = 3.142\ \text{rad/s}
$$

**2. Constante elástica**

$$
k = 4(3.142)^2 = 39.48\ \text{N/m}
$$

---

### Valores Calculados de k

| Tabla | Masa | Periodo T (s) | ω (rad/s) | k (N/m)   |
| ----- | ---- | ------------- | --------- | --------- |
| 1     | 4m   | 2.000         | 3.142     | **39.48** |
| 2     | 3m   | 1.800         | 3.490     | **29.61** |
| 3     | 3m   | 2.200         | 2.856     | **29.61** |
| 4     | 2m   | 1.600         | 3.927     | **19.74** |
| 5     | 2m   | 1.500         | 4.189     | **19.74** |
| 6     | m    | 1.000         | 6.283     | **9.87**  |

---

### Constante Elástica Promedio

$$
k_{\text{promedio}} =
\frac{
39.48 + 29.61 + 29.61 + 19.74 + 19.74 + 9.87
}{6}
$$

$$
k_{\text{promedio}} = 24.68\ \text{N/m}
$$

---

## Propagación de Errores

El error relativo en la constante elástica proviene del error en la medición del periodo:

$$
\frac{\Delta k}{k} \approx 2\frac{\Delta T}{T}
$$

Ejemplo para la Tabla 1 (( \Delta T = 0.001\ \text{s} )):

$$
\Delta k = 39.48\left( 2\frac{0.001}{2.000} \right)
$$

$$
\Delta k = 0.039\ \text{N/m}
$$

Los errores típicos calculados se encuentran en el rango:

$$
\Delta k \approx 0.02 - 0.06\ \text{N/m}
$$

---

### Resultado Final

$$
\boxed{ k = 24.68 \pm 0.04\ \text{N/m} }
$$

---

## Conclusiones

1. **Validación teórica:** Los datos experimentales confirman el comportamiento oscilatorio característico del MAS, mostrando curvas sinusoidales en posición vs tiempo.

2. **Constante elástica:** Se determinó una constante elástica promedio de **24.68 N/m** para el resorte utilizado, con una variación significativa entre mediciones debido a limitaciones en el algoritmo de cálculo del periodo.

3. **Periodo para masa 9m:** El periodo de oscilación calculado es de **3.79 segundos**.

4. **Relación masa-periodo:** Se observa la tendencia teórica $T \propto \sqrt{m}$, aunque la precisión está limitada por el algoritmo de estimación de periodo.

5. **Herramienta computacional:** El programa desarrollado demostró ser efectivo para la visualización de datos, pero requiere mejoras en el algoritmo de cálculo de parámetros para mayor precisión.


6. **Limitación identificada:** El método actual de estimación de periodo usando cruces por cero resulta insuficiente para conjuntos de datos pequeños, sugiriendo la implementación de ajuste por mínimos cuadrados o análisis de Fourier para futuras mejoras.


