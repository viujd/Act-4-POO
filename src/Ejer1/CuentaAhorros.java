package Ejer1;
public class CuentaAhorros extends Cuenta {
    private boolean activa;

    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        if (saldo < 10000) 
        	activa = false;
        	else
        	activa = true;
    }

    @Override
    public void retirar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
        } else {
            System.out.println("La cuenta está inactiva. No se pueden realizar retiros.");
        }
    }

    @Override
    public void consignar(float cantidad) {
        if (activa)
        super.consignar(cantidad);
    }

    @Override
    public void extractoMensual() {
        if (numeroRetiros > 4) {
            comisionMensual += (numeroRetiros - 4) * 1000;
        }
        super.extractoMensual();
        if ( saldo < 10000 )
        	activa = false;
    }

    @Override
    public void imprimir() {
    	System.out.println("Saldo = $ " + saldo);
    	System.out.println("Comisión mensual = $ " + comisionMensual);
    	System.out.println("Número de transacciones = " + (numeroConsignaciones + numeroRetiros));
    	System.out.println();
    	}
}
