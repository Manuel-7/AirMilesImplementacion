package aed.tp2;

class Usuario {
    private int ID;
    private int Totales;
    private int Disponibles;
    private int Acumuladas;
    private int Canjeadas;
    private array historialTransferidas;
    private int ultimoUsuarioTransferido;
    private booles esTransferidorExlusivo;
    private array historialRecibidas;
    private int ultimoUsuarioRecibido;
    private boolean esReceptorExlusivo;
    /* guardar la informacion completa de enviadas y recibidas/ de si es trasnferidos y receptor exlusivao
    Entonces cuando estamos recorriendo el ABB para 'paresTransferidoresExlusivos' y vemos que efectivamente es trasnfereridor exclusivo. 
    si es menor a su pareja lo ponemos en la lista
    Si es mayor a su pareja no hacemos nada porque ya lo pusimos
    Se recorre el ABB via iterador desde el menor hasta el mayor*/
}
