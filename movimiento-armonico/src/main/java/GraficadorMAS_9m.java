import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraficadorMAS_9m {
    
    public static void main(String[] args) {
        System.out.println("=== GRÁFICAS MOVIMIENTO ARMÓNICO - MASA 9m ===");
        System.out.println("Basado en resultados del informe Semana 4");
        
        double periodo = 3.79;
        double amplitud = 2.0;
        double k_promedio = 24.68;
        
        System.out.println("Parámetros utilizados:");
        System.out.printf(" - Periodo (T): %.2f s\n", periodo);
        System.out.printf(" - Constante elástica (k): %.2f N/m\n", k_promedio);
        System.out.printf(" - Amplitud (A): %.2f m\n", amplitud);
        System.out.printf(" - Masa: 9m\n");
        
        generarGraficas(periodo, amplitud);
        
        System.out.println("\nCódigo ejecutado exitosamente");
        System.out.println("Gráficas generadas:");
        System.out.println("   - posicion_masa9m.png");
        System.out.println("   - velocidad_masa9m.png");
        System.out.println("   - aceleracion_masa9m.png");
        System.out.println("   - movimiento_completo_masa9m.png");
    }
    
    public static void generarGraficas(double periodo, double amplitud) {
        // Configuración
        double omega = 2 * Math.PI / periodo;
        double tiempoTotal = 2 * periodo;
        int puntos = 400;
        
        List<Double> tiempos = new ArrayList<>();
        List<Double> posiciones = new ArrayList<>();
        List<Double> velocidades = new ArrayList<>();
        List<Double> aceleraciones = new ArrayList<>();
        
        for (int i = 0; i < puntos; i++) {
            double t = i * tiempoTotal / puntos;
            double x = amplitud * Math.cos(omega * t);
            double v = -amplitud * omega * Math.sin(omega * t);
            double a = -amplitud * omega * omega * Math.cos(omega * t);
            
            tiempos.add(t);
            posiciones.add(x);
            velocidades.add(v);
            aceleraciones.add(a);
        }
        
        crearGraficaPosicion(tiempos, posiciones, periodo);
        crearGraficaVelocidad(tiempos, velocidades, periodo);
        crearGraficaAceleracion(tiempos, aceleraciones, periodo);
        crearGraficaCombinada(tiempos, posiciones, velocidades, aceleraciones, periodo);
    }
    
    private static void crearGraficaPosicion(List<Double> tiempos, List<Double> posiciones, double periodo) {
        XYChart chart = new XYChartBuilder()
                .width(1000)
                .height(600)
                .title("Movimiento Armónico Simple - POSICIÓN vs Tiempo (Masa 9m)")
                .xAxisTitle("Tiempo (s)")
                .yAxisTitle("Posición (m)")
                .build();

        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setMarkerSize(2);
        chart.addSeries("x(t) = A cos(ωt)", tiempos, posiciones);
        
        try {
            BitmapEncoder.saveBitmap(chart, "posicion_masa9m.png", BitmapFormat.PNG);
            System.out.println("Gráfica de posición generada: posicion_masa9m.png");
        } catch (IOException e) {
            System.err.println("Error guardando gráfica de posición: " + e.getMessage());
        }
    }
    
    private static void crearGraficaVelocidad(List<Double> tiempos, List<Double> velocidades, double periodo) {
        XYChart chart = new XYChartBuilder()
                .width(1000)
                .height(600)
                .title("Movimiento Armónico Simple - VELOCIDAD vs Tiempo (Masa 9m)")
                .xAxisTitle("Tiempo (s)")
                .yAxisTitle("Velocidad (m/s)")
                .build();

        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setMarkerSize(2);
        chart.addSeries("v(t) = -Aω sin(ωt)", tiempos, velocidades);
        
        try {
            BitmapEncoder.saveBitmap(chart, "velocidad_masa9m.png", BitmapFormat.PNG);
            System.out.println("Gráfica de velocidad generada: velocidad_masa9m.png");
        } catch (IOException e) {
            System.err.println("Error guardando gráfica de velocidad: " + e.getMessage());
        }
    }
    
    private static void crearGraficaAceleracion(List<Double> tiempos, List<Double> aceleraciones, double periodo) {
        XYChart chart = new XYChartBuilder()
                .width(1000)
                .height(600)
                .title("Movimiento Armónico Simple - ACELERACIÓN vs Tiempo (Masa 9m)")
                .xAxisTitle("Tiempo (s)")
                .yAxisTitle("Aceleración (m/s²)")
                .build();

        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setMarkerSize(2);
        chart.addSeries("a(t) = -Aω² cos(ωt)", tiempos, aceleraciones);
        
        try {
            BitmapEncoder.saveBitmap(chart, "aceleracion_masa9m.png", BitmapFormat.PNG);
            System.out.println("Gráfica de aceleración generada: aceleracion_masa9m.png");
        } catch (IOException e) {
            System.err.println("Error guardando gráfica de aceleración: " + e.getMessage());
        }
    }
    
    private static void crearGraficaCombinada(List<Double> tiempos, List<Double> posiciones, 
                                            List<Double> velocidades, List<Double> aceleraciones, double periodo) {
        XYChart chart = new XYChartBuilder()
                .width(1200)
                .height(800)
                .title("MOVIMIENTO ARMÓNICO SIMPLE COMPLETO - Masa 9m")
                .xAxisTitle("Tiempo (s)")
                .yAxisTitle("Magnitud")
                .build();

        chart.getStyler().setLegendPosition(Styler.LegendPosition.OutsideE);
        chart.getStyler().setMarkerSize(1);
        
        chart.addSeries("Posición x(t) [m]", tiempos, posiciones);
        chart.addSeries("Velocidad v(t) [m/s]", tiempos, velocidades);
        chart.addSeries("Aceleración a(t) [m/s²]", tiempos, aceleraciones);
        
        try {
            BitmapEncoder.saveBitmap(chart, "movimiento_completo_masa9m.png", BitmapFormat.PNG);
            System.out.println("Gráfica combinada generada: movimiento_completo_masa9m.png");
        } catch (IOException e) {
            System.err.println("Error guardando gráfica combinada: " + e.getMessage());
        }
    }
}
