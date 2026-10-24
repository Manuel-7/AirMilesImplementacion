package aed.tp2;

public class Vector {
    private Usuario[] data;
    private int puntero;

    public  Vector(){
        data = new Usuario[1];
        puntero = 0;
    }   

    public int longitud(){
        return puntero;
    }
    
    public boolean vacia(){
        return puntero == 0;
    }

    public void agregarAdelante(Usuario usuario){
        /*Algo aca siento que esta mal porque en el apunte dice que deberia ser complejidad O(f(n)) pero esto es O(n) */
        if(puntero == data.length){
            redimencionar();
        }
        for(int i = puntero; i > 0; i--){
            data[i] = data[i-1];            
        }
        data[0] = usuario;
        puntero ++;
    }

    public void redimencionar(){
        Usuario[] nuevoVector = new Usuario[this.data.length * 2];
        for(int i=0 ; i<puntero ; i++){
            nuevoVector[i] = data[i];
        }
        this.data = nuevoVector;
    }

    public void agregarAtras(Usuario usuario){
        if(puntero == data.length){
            redimencionar();
        }
        data[puntero] = usuario;
        puntero ++;
    }

    public Usuario primero(){
        return data[0];
    }

    public Usuario ultimo(){
        return data[puntero-1];
    }

    public Usuario obtener(int i){
        return data[i];
    }

    public void eliminar(int i){
        if(i>=puntero){throw new UnsupportedOperationException("Indice inexistente");/*aca deberia tirar error */}
        while(i < puntero-1){
            data[i] = data[i+1];
            i++;
        }
        puntero --;
    }

    public void modificarPosicion(int pos, Usuario nuevo){
        data[pos] = nuevo;
    }
}
