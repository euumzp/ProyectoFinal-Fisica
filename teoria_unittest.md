# Teoría sobre Unit Testing

## ¿Qué es Unit Testing?
El unit testing (pruebas unitarias) consiste en probar las partes más pequeñas del código, llamadas unidades, para asegurar que cada una funciona correctamente. Generalmente se prueban funciones o métodos.

Por ejemplo, si tenemos una función que suma dos números, un test unitario puede verificar que la función devuelve el resultado correcto.

---

## ¿Por qué usar Unit Testing?
El unit testing se usa porque:
- Permite **detectar errores temprano**, antes de combinar el código con otras partes del proyecto.
- **Evita que nuevos cambios rompan cosas que antes funcionaban**.
- **Mejora la calidad** del software y da más confianza al desarrollador.
- Sirve como **documentación viva**, ya que muestra cómo debería comportarse cada función.

---

## ¿Cuándo usarlo?
Se recomienda usar unit testing:
- Al terminar de escribir una función o módulo importante.
- Antes de subir cambios grandes al repositorio.
- Antes de lanzar una nueva versión del programa.

En resumen: **mientras programas, no después.**

---

## ¿Cómo usarlo? (Ejemplo en Python)
En Python existe un módulo incorporado llamado `unittest`, que permite escribir y ejecutar tests fácilmente.

Ejemplo práctico 

### calculadora.py
```python
def sumar(a, b):
    return a + b
```
### test_calculadora.py
```python
import unittest
from calculadora import sumar

class TestCalculadora(unittest.TestCase):
    def test_sumar(self):
        self.assertEqual(sumar(2, 3), 5)
        self.assertEqual(sumar(-1, 1), 0)
        self.assertEqual(sumar(0, 0), 0)

if __name__ == "__main__":
    unittest.main()
```
### Para ejecutarlo en la terminal:
```bash
python -m unittest test_calculadora.py
```
## Beneficios del Unit Testing
- **Previene errores futuros:** si algo se rompe, el test te avisa inmediatamente.  
- **Acelera el desarrollo:** ahorras tiempo al no tener que probar manualmente todo.  
- **Facilita el trabajo en equipo:** todos pueden saber qué parte del código está fallando.  
- **Ayuda a mantener el código limpio:** escribir tests te obliga a hacer funciones más simples y claras.