package aed.tp2;

class Usuario implements Comparable<Usuario> {
    private int ID;
    private int Totales;
    private int Disponibles;
    private int Canjeadas;
    private int ultimoUsuarioTransferido;
    private boolean esTransferidorExlusivo;
    private int ultimoUsuarioRecibido;
    private boolean esReceptorExlusivo; 
    /* guardar la informacion completa de enviadas y recibidas/ de si es trasnferidos y receptor exlusivao
    Entonces cuando estamos recorriendo el ABB para 'paresTransferidoresExlusivos' y vemos que efectivamente es trasnfereridor exclusivo. 
    si es menor a su pareja lo ponemos en la lista
    Si es mayor a su pareja no hacemos nada porque ya lo pusimos
    Se recorre el ABB via iterador desde el menor hasta el mayor*/


    /*--------------------------------------------------------------------------------------------------------- */
    /* Creadores */
    /*--------------------------------------------------------------------------------------------------------- */
    public Usuario(int id){
        ID = id;
        Totales = 0;
        Disponibles = 0;      
        Canjeadas = 0;
        ultimoUsuarioTransferido = id; /*pongo placeholder el id del propio porque intentando poner null me tira error */
        esTransferidorExlusivo = false;
        ultimoUsuarioRecibido = id;
        esReceptorExlusivo = false;
    }

    public Usuario(int id, boolean referido){
        ID = id;
        Totales = 500;
        Disponibles = 500;      
        Canjeadas = 0;
        ultimoUsuarioTransferido = id; /*pongo placeholder el id del propio porque intentando poner null me tira error */
        esTransferidorExlusivo = false;
        ultimoUsuarioRecibido = id;
        esReceptorExlusivo = false;
    }

    /*--------------------------------------------------------------------------------------------------------- */
    /* Averiguar Atributos */
    /*--------------------------------------------------------------------------------------------------------- */

    public int ID(){
        return this.ID;
    }
    
    public int totales(){
        return this.Totales;
    }

    public int disponibles(){
        return this.Disponibles;    
    }

    public int canjeadas(){
        return this.Canjeadas;
    }

    public boolean esTransferidorExlusivo(){
        return this.esTransferidorExlusivo;
    }

    public int aQuienTransfiere(){
        return this.ultimoUsuarioTransferido;
    }

    public boolean esReceptorExlusivo(){
        return this.esReceptorExlusivo;
    }

    public int deQuienRecibe(){
        return this.ultimoUsuarioRecibido;
    }

    /*--------------------------------------------------------------------------------------------------------- */
    /*Realizar Acciones */
    /*--------------------------------------------------------------------------------------------------------- */

    public void acumularMillas(int millas){
        Totales = this.Totales + millas;
        Disponibles = this.Disponibles + millas;
    }

    public void canjearMillas(int millas){
        /*Hay que agregar que tire error si se quieren canjear mas millas de las que se tiene? 
        Porque es un requiere pero me hace ruido no ponerlo */
        Disponibles = this.Disponibles - millas;
        Canjeadas = this.Canjeadas + millas;
    }    

    public void transferencia(boolean recibe,int id, int millas){
        /*quizas cada if podria separarse en funciones aparte
        es decir definir las funciones transferir() y recibir()
        Para hablarlo */
        if(recibe){
            acumularMillas(millas);            
            if(this.ultimoUsuarioRecibido == this.ID){
                ultimoUsuarioRecibido = id;
                esReceptorExlusivo = true;
            }
            else if(this.ultimoUsuarioRecibido != id){
                esReceptorExlusivo = false;
            }
        }
        else{
            canjearMillas(millas);
            Totales = this.Totales - millas;
            if(this.ultimoUsuarioTransferido == this.ID){
                ultimoUsuarioTransferido = id;
                esTransferidorExlusivo = true;
            }
            else if(this.ultimoUsuarioTransferido != id){
                esTransferidorExlusivo = false;
            }}
    }

    /*--------------------------------------------------------------------------------------------------------- */
    /*Chequeo pareja Transferidores Exclusivos */
    /*--------------------------------------------------------------------------------------------------------- */

    public boolean estaEnParejaTransferidoresExclusivos(){
        return (esTransferidorExlusivo() && esReceptorExlusivo()) && (aQuienTransfiere() == deQuienRecibe());
    }

    public int parejaTransferidoraExclusiva(){
        if(estaEnParejaTransferidoresExclusivos()){
            return aQuienTransfiere();
        }
        else{
            throw new UnsupportedOperationException("No tiene pareja exclusiva");
            /*Aca quizas deberiamos poner para que tire un erro */
        }
        
    }

    @Override 
    public int compareTo(Usuario usuario){
        return this.ID - usuario.ID;
    }


}
