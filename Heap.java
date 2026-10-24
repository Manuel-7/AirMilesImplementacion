package aed.tp2;

class Heap {
    private Vector _data;
    private int _tamaño;

    public Heap() {
        _data = new Vector();
        _tamaño = 0;
    }

    public int tamaño() {
        return _tamaño;
    }

    public Usuario máximo () {
        if(_tamaño == 0) {throw new UnsupportedOperationException("Vacío");}
        return _data.obtener(0);
    }

    public void agregar(Usuario u) {
        _tamaño += 1;
        _data.agregarAtras(u);
        int posActual = _data.longitud() - 1;
        while (_data.obtener(posActual).disponibles() > _data.obtener((posActual - 1)/ 2).disponibles()) { // Mientras tenga más millas disponibles que su padre
            _data.modificarPosicion(posActual, _data.obtener((posActual - 1)/ 2));
            _data.modificarPosicion((posActual - 1)/2, u);
            posActual = (posActual - 1)/2;
        }
    }

    public Usuario sacarMáximo() {
        if(_tamaño == 0) {throw new UnsupportedOperationException("Vacío");}
        _tamaño -= 1;
        Usuario res = _data.obtener(0);
        Usuario último = _data.obtener(_data.longitud() - 1);
        _data.modificarPosicion(0, último);
        _data.eliminar(_data.longitud() - 1);
        int posActual = 0;
        boolean hayUnHijoMayorQueElPadre = true;
        while (_data.longitud() > 2*posActual + 2 && hayUnHijoMayorQueElPadre) { // Mientras tenga 2 hijos y no sean ambos menores que él
            int posHijoIzq = 2*posActual + 1;
            int posHijoDer = 2*posActual + 2;
            int posHijoMayor = posHijoDer;
            if (_data.obtener(posHijoIzq).disponibles() > _data.obtener(posHijoDer).disponibles()) {
                posHijoMayor = posHijoIzq;
            }
            if (_data.obtener(posHijoMayor).disponibles() > último.disponibles()) {
                _data.modificarPosicion(posActual, _data.obtener(posHijoMayor));
                _data.modificarPosicion(posHijoMayor, último);
                posActual = posHijoMayor;
            }
            else {hayUnHijoMayorQueElPadre = false;}
        }
        if (_data.longitud() > 2*posActual + 1) {
            int posHijo = 2*posActual +1;
            if (_data.obtener(posHijo).disponibles() > _data.obtener(posActual).disponibles()) {
                _data.modificarPosicion(posActual, _data.obtener(posHijo));
                _data.modificarPosicion(posHijo, último);
                posActual = posHijo;
            }
        }
        return res;
    }
}
