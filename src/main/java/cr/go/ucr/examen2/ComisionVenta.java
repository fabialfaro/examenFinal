/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.go.ucr.examen2;

/**
 *
 * @author fabia
 */
import java.util.Arrays;
import java.util.List;

public class ComisionVenta {
    
    private static final ComisionVenta currentInstance=new  ComisionVenta();
    
    private ComisionVenta(){}
    
    public List<Rango> rangos= Arrays.asList(new Rango(0.0,1500.00,0.03),
            new Rango(1500.01,5000.00,0.07),
            new Rango(5000.01,15000.00,0.12),
            new Rango(15000.00,100000.00,0.15));
    
    public Double calcular(Double montoVentaMensual)
    {
        if(montoVentaMensual == null || montoVentaMensual < 0.0 ||  montoVentaMensual > 100000.00)
            return -1.0;
        for(Rango r:rangos)
        {
            if(r.getMenor() <= montoVentaMensual && montoVentaMensual <= r.getMayor())
                return montoVentaMensual * r.getValor();
        } return -1.0;
    }

    public static ComisionVenta getCurrentInstance() {
        return currentInstance;
    }
    
    
    //public static void main(String args[])
    //{
        //System.out.println(ComisionVenta.getCurrentInstance().calcular(-0.01));
    //}
}


