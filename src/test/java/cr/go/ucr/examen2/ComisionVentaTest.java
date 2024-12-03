/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cr.go.ucr.examen2;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author fabia
 */


class ComisionVentaTest {

    @Test
    void testCalcularComisionInvalida() {
        ComisionVenta comisionVenta = ComisionVenta.getCurrentInstance();
        assertEquals(-1.0, comisionVenta.calcular(-1.0), "Valores negativos deben devolver -1");
        assertEquals(-1.0, comisionVenta.calcular(100001.0), "Valores mayores a 100000 deben devolver -1");
    }

    @Test
    void testCalcularComisionRango1() {
        ComisionVenta comisionVenta = ComisionVenta.getCurrentInstance();
        assertEquals(0.0, comisionVenta.calcular(0.0), "El cálculo para 0 debe ser 0");
        assertEquals(45.0, comisionVenta.calcular(1500.0), "El cálculo para 1500 debe ser 3%");
    }

    @Test
    void testCalcularComisionRango2() {
        ComisionVenta comisionVenta = ComisionVenta.getCurrentInstance();
        assertEquals(105.0007, comisionVenta.calcular(1500.01), 0.0001, "El cálculo para 1500.01 debe ser 7%");
        assertEquals(350.0, comisionVenta.calcular(5000.0), 0.0001, "El cálculo para 5000 debe ser 7%");
    }


    @Test
    void testCalcularComisionRango3() {
        ComisionVenta comisionVenta = ComisionVenta.getCurrentInstance();
        assertEquals(600.0, comisionVenta.calcular(5000.01), 0.01, "El cálculo para 5000.01 debe ser 12%");
        assertEquals(1800.0, comisionVenta.calcular(15000.0), "El cálculo para 15000 debe ser 12%");
    }

    @Test
    void testCalcularComisionRango4() {
        ComisionVenta comisionVenta = ComisionVenta.getCurrentInstance();
        assertEquals(2250.0015, comisionVenta.calcular(15000.01), 0.0001, "El cálculo para 15000.01 debe ser 15%");
        assertEquals(15000.0, comisionVenta.calcular(100000.0), "El cálculo para 100000 debe ser 15%");
    }
}
