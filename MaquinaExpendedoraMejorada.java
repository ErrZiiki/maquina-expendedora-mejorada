public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    
    private int numeroBilletesVendidos;
    
    private boolean maquinaConPremios;
    
    private int numeroMaximoBilletes;
    
    private int billetesImpresos;
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean maquinaPremios, int maximoBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        numeroBilletesVendidos = 0;
        maquinaConPremios = maquinaPremios;
        numeroMaximoBilletes = maximoBilletes;
        billetesImpresos = 0;
    }
    public MaquinaExpendedoraMejorada(boolean maquinaPremios, int maximoBilletes) {
        precioBillete = 5;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = "aqu�";
        estacionDestino = "all�";
        numeroBilletesVendidos = 0;
        maquinaConPremios = maquinaPremios;
        numeroMaximoBilletes = maximoBilletes;
        billetesImpresos = 0;
    }
    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (numeroMaximoBilletes > billetesImpresos){
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }
        }
        else{
            System.out.println("No quedan billetes por imprimir numero maximo alcanzado");
        }
    }
    public int vaciarDineroDeLaMaquina(){
        int balanceTotal = balanceClienteActual + totalDineroAcumulado;
        
        if (balanceClienteActual == 0){
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;
        }
        else{
            System.out.println("No se puede realizar la acci�n solicitada debido a que la operaci�n del ciente sigue  activa");
            balanceTotal = -1;
        }
        return balanceTotal;
    }
    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (numeroMaximoBilletes > billetesImpresos){
            if (cantidadDeDineroQueFalta <= 0) {
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();         
            
                numeroBilletesVendidos += 1;
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                billetesImpresos += 1;
                if (maquinaConPremios == true){
                    System.out.println("Enhorabuena has ganado un descuento de "+(precioBillete*0.25)+"� en el establecimiento de tu preferencia.");
                }
            }
            else {
                System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " euros mas!");

            }
        }
        else{
            System.out.println("No quedan billetes por imprimir numero maximo alcanzado");
        }
    }
    public int getNumeroBilletesVendidos(){
        return numeroBilletesVendidos;
    }
    public void imprimirNumeroBilletesVendidos(){
        System.out.println("N�mero de billetes impresos: "+numeroBilletesVendidos);
    }
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
}
