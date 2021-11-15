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
    //Total billetes vendidos
    private int numeroBilletesVendidos;
    //Indica si la maquina tiene(1) o no(0) premio
    public boolean maquinaPremio;
    //Máx. billetes que puede vender
    public int billetesVender;
    

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean maquinaYPremio, int billetesAVender) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        numeroBilletesVendidos = 0;
        maquinaPremio = maquinaYPremio;
        billetesVender = billetesAVender;
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
        if (cantidadIntroducida <= 0) {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }
        else if (numeroBilletesVendidos == billetesVender ){
            System.out.println("Número máximo de billetes vendidos!!!");
        }
        else {
             balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }       
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual ;
        if(numeroBilletesVendidos == billetesVender){
             System.out.println("Número máximo de billetes vendidos!!!");
        }    
        else if (cantidadDeDineroQueFalta > 0 ) {
            System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " euros mas!");
        }
        else {
            System.out.println("##################");
            System.out.println("# Billete de tren:");
            System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
            System.out.println("# " + precioBillete + " euros.");
            System.out.println("##################");
           
            totalDineroAcumulado = totalDineroAcumulado + precioBillete;
            balanceClienteActual = balanceClienteActual - precioBillete;
            numeroBilletesVendidos = numeroBilletesVendidos +1;
            if (maquinaPremio == true ){
                if (numeroBilletesVendidos % 3 == 0){
                    System.out.println("Tiene un descuento del 10% del coste del billete para compras en El Corte Ingles");         
                    System.out.println(0.1*precioBillete);
                }
                
            }
        }
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
    
    public int vaciarDineroDeLaMaquina() {
        int dineroVaciado = totalDineroAcumulado;
        if (balanceClienteActual == 0) {
            totalDineroAcumulado = 0; 
        }
        else {
            System.out.println("OPERACIÓN EN CURSO!! Imposible vaciar la máquina en este momento.");
            dineroVaciado = -1;
        }
        return dineroVaciado;
    } 
    
    public int getNumeroBilletesVendidos() {
        return numeroBilletesVendidos;
    }
    
    public void imprimeNumeroBilletesVendidos(){
        System.out.println(numeroBilletesVendidos);
    }
    
}