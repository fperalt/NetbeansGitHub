/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.empleadogit;
import java.io.IOException;

enum TipoEmpleado {
    vendedor, encargado
};
class BRException extends Exception {

    public BRException(String msj) {
        super(msj);
    }
}

/**
 *
 * @author franp
 * @version v1
 */
public class EmpleadoBR {
   //private String nombre;
   //otros atributos
    float calculaSalarioBruto(TipoEmpleado tipo, float ventasMes, float horasExtra) 
            throws BRException {
        int salarioBase;
        if ((tipo == null || ventasMes < 0) || horasExtra < 0) {
            throw new BRException("Datos de nómina erróneos");
        }
        if (tipo == TipoEmpleado.vendedor) {
            salarioBase = 1000;
        } else {
            salarioBase = 1500;
        }
        if (ventasMes >= 1000 && ventasMes < 1500) {
            salarioBase += 100;
        }
        if (ventasMes >= 1500) {
            salarioBase += 200;
        }
        salarioBase += horasExtra * 20;
        return salarioBase;
    }

    public float calculaSalarioNeto(float salarioBruto) throws BRException 
    {
        float retencion = 0.0f;

        if (salarioBruto < 0) {
            throw new BRException("El salario bruto debe ser positivo");
        }
        if (salarioBruto >= 1000 && salarioBruto < 1500) {
            retencion = 0.16f;
        }
        if (salarioBruto >=1500) {
            retencion = 0.18f;
        }

        return salarioBruto * (1 - retencion);
    }

}
