import edu.princeton.cs.stdlib.StdDraw;
import java.awt.*;
public class codigoFinalTaller1 {
    public static void main(String[] args) {
        //Definir La pantalla
        double min = -1.0;
        double max = 1.0;

        definirPantalla(min, max);
        //Generar Coordenadas De Lineas
        double[] coordenadas = generarCoordenadas(min, max);
        double X0 = coordenadas[0];
        double Y0 = coordenadas[1];
        double X1 = coordenadas[2];
        double Y1 = coordenadas[3];
        //Generar Colores
        Color[] colors = {Color.RED, Color.PINK,Color.BLUE,Color.DARK_GRAY, Color.YELLOW,Color.GREEN,Color.BLACK, Color.CYAN, Color.GRAY, Color.ORANGE, Color.MAGENTA};

        //Cambio De Fondo
        boolean FondoOscuro=false;
        long TiempoIncial= System.currentTimeMillis();

        //Generar Velocidad (Vel = Velocidad)
        double VelX0 = Math.random()/30;
        double VelY0 = Math.random()/30;
        double VelX1 = Math.random()/30;
        double VelY1 = Math.random()/30;
        while (true) {
            // Verificar si ha pasado 3 segundos
            if (System.currentTimeMillis() - TiempoIncial >= 5000) {
                TiempoIncial = System.currentTimeMillis();
                FondoOscuro = !FondoOscuro;
            }
            if (FondoOscuro) {
                StdDraw.clear(Color.BLACK);
            } else {
                StdDraw.clear(Color.WHITE);
            }

            if (Math.abs(X0 + VelX0) > 1) {
                VelX0 = -VelX0;
            }
            if (Math.abs(Y0 + VelY0) > 1) {
                VelY0 = -VelY0;
            }
            if (Math.abs(X1 + VelX1) > 1) {
                VelX1 = -VelX1;
            }
            if (Math.abs(Y1 + VelY1) > 1) {
                VelY1 = -VelY1;
            }
            X0 += VelX0;
            Y0 += VelY0;
            X1 += VelX1;
            Y1 += VelY1;

            ColorLineas(X0, Y0, X1, Y1, VelX0, VelY0, VelX1, VelY1, colors);
            StdDraw.show();
            StdDraw.clear();
        }
    }
    private static void ColorLineas (double X0, double Y0, double X1, double Y1, double VelX0, double VelY0, double VelX1, double VelY1, Color[] colores) {

        for (int i = 0; i < 6; i++) {
            if (Math.abs(X0 + VelX0) > 1) {
                VelX0 = -VelX0;
            }
            if (Math.abs(Y0 + VelY0) > 1) {
                VelY0 = -VelY0;
            }
            if (Math.abs(X1 + VelX1) > 1) {
                VelX1 = -VelX1;
            }
            if (Math.abs(Y1 + VelY1) > 1) {
                VelY1 = -VelY1;
            }
            X0 += VelX0;
            Y0 += VelY0;
            X1 += VelX1;
            Y1 += VelY1;
            StdDraw.setPenColor(colores[i]);
            StdDraw.line(X0, Y0, X1, Y1);
            StdDraw.pause(3);
        }
    }
    //Funcion Generar Coordenas
    public static double[] generarCoordenadas(double min, double max) {
        double[] coordenadas = new double[4];
        coordenadas[0] = min + (max - min) * Math.random();
        coordenadas[1] = min + (max - min) * Math.random();
        coordenadas[2] = min + (max - min) * Math.random();
        coordenadas[3] = min + (max - min) * Math.random();
        return coordenadas;
    }
    // Funcion Definir Pantalla
    public static void definirPantalla(double min, double max) {
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);
        StdDraw.enableDoubleBuffering();
    }
}