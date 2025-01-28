package Cuenta;

public class CuentaCorriente extends Cuenta {
    private float sobregiro;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.sobregiro = 0;
    }

    @Override
    public void retirar(float cantidad) {
        float resultado = saldo - cantidad;
        if (resultado < 0) {
            sobregiro -= resultado;
            saldo = 0;
        } else {
            super.retirar(cantidad);
        }
    }

    @Override
    public void consignar(float cantidad) {
    	float residuo = sobregiro - cantidad;
    	if (sobregiro > 0) {
    		if ( residuo > 0) {
    		sobregiro = 0;
    		saldo = residuo;
    		} else { 
    		sobregiro = -residuo;
    		saldo = 0;
    		}
    		} else {
    		super.consignar(cantidad); 
    		}
    }

    @Override
    public void extractoMensual() {
    	super.extractoMensual(); 
    	}
    
    	public void imprimir() {
    	System.out.println("Saldo = $ " + saldo);
    	System.out.println("Cargo mensual = $ " + comisionMensual);
    	System.out.println("Número de transacciones = " + (numeroConsignaciones + numeroRetiros));
    	System.out.println("Valor de sogregiro = $" + (numeroConsignaciones + numeroRetiros));
    	System.out.println();
    	}
}