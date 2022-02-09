package IA;
public class ArbolBinarioBusqueda<T> {
    private Nodo<T> nombre;

    public ArbolBinarioBusqueda(){
        this.nombre = null;
    }

    public Nodo<T> getNombre() {
        return nombre;
    }
    
	private boolean Inserta(Nodo<T> Raiz, T Dato){
		String IdDato=Dato.toString();
		String IdRaiz=Raiz.nodo.toString();
		if(IdDato.compareToIgnoreCase(IdRaiz)==0)
			return false;
		if(IdDato.compareToIgnoreCase(IdRaiz)<0){
			if(Raiz.getIzquierdo()!=null)
				return Inserta(Raiz.getIzquierdo(),Dato);
			else{
				
				Raiz.setIzquierdo(new Nodo<T>(Dato));
				return true;
			}
		}
		else {
			if(Raiz.getDerecho()!=null)
				return Inserta(Raiz.getDerecho(),Dato);
			else{
				
				Raiz.setDerecho(new Nodo<T>(Dato));
				return true;
			}			
		}
	}

    public void setnombre(Nodo<T> nombre) {
        this.nombre = nombre;
    }
    
    public boolean vacio() {
    	return nombre == null;
    }

    public void buscarOrden(){
        buscarPreOrden(this.nombre);
    }

    private void buscarPreOrden(Nodo<T> a){
        if(!nombre.vacio()){
        	System.out.print(a.getNodo() + " ");
            buscarPreOrden(a.getIzquierdo());
            buscarPreOrden(a.getDerecho());
        }
    }


}