public class Heap<E extends Comparable<E>> {
	private E[] mainArray;
	private int ultimoInsertado;
	private int size;
	
	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public Heap(){
		this.mainArray = (E[]) new Comparable[1];
		this.ultimoInsertado=0;
		this.size=0;
	}
	
	
	public void insertar(E val){
		this.mainArray[ultimoInsertado++]=val;
		this.size++;
		this.checkInsertar();
		if (ultimoInsertado==this.mainArray.length){
			this.incrementarHeap();
		}
	}
	
	public E borrar(){
		E temp = this.mainArray[0];
		System.out.println("Borrando: "+temp);
		this.size--;
		this.ultimoInsertado--;
		this.swap(0, this.ultimoInsertado);
		this.mainArray[this.ultimoInsertado]=null;
		this.checkBorrar();
		return temp;
	}
	
	@SuppressWarnings("unchecked")
	private void incrementarHeap(){
		System.out.println("Incrementando Heap");
		E[] tempArray = this.mainArray;
		this.mainArray = (E[]) new Comparable[tempArray.length*2 + 1];
		for (int i = 0; i < tempArray.length; i++) {
			this.mainArray[i] = tempArray[i];
		}
	}
	
	private void checkInsertar(){
		int pos = this.ultimoInsertado-1;
		do{
			if (this.mainArray[(pos-1)/2].compareTo(this.mainArray[pos])<0){
				this.swap(((pos-1)/2),pos);
				pos = (pos-1)/2;		
			}
			else{
				break;
			}
		}
		while(pos<this.mainArray.length-1);
	}
	
	private void checkBorrar(){
		try{
			int pos = 0;
			do{
				if (this.mainArray[2*pos +1].compareTo(this.mainArray[2*pos + 2])>0){
					if (this.mainArray[pos].compareTo(this.mainArray[2*pos+1])<0){
						this.swap(pos, (2*pos+1));
						pos = 2*pos+1;
					}
				}
				else if((this.mainArray[2*pos +1].compareTo(this.mainArray[2*pos + 2])<0)){
					if (this.mainArray[pos].compareTo(this.mainArray[2*pos+2])<0){
						this.swap(pos, (2*pos+2));
						pos = 2*pos+2;
					}
				}
				else{
					break;
				}
			}
			while(pos<this.mainArray.length);
		}
		catch(NullPointerException e){
			System.out.println(e);
		}
		
	}
	
	private void swap(int pos1, int pos2){
		String s="Cambiando: ";
		E temp = this.mainArray[pos1];
		s+=temp;
		this.mainArray[pos1] = this.mainArray[pos2];
		s+=" por "+this.mainArray[pos2];
		this.mainArray[pos2] = temp;
		System.out.println(s);
	}
	
	public String toString(){
		String s = "";
		if(this.size!=0){
			s+="[ ";
			for (int i = 0; i < this.mainArray.length; i++) {
				s+=this.mainArray[i]+" ";
			}
			s+="]";
		}
		else{
			s+="Heap Vacío";
		}
		return s;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap<Integer> prueba = new Heap<>();
		System.out.println(prueba);
		prueba.insertar(2);
		System.out.println(prueba);
		prueba.insertar(3);
		System.out.println(prueba);
		prueba.insertar(4);
		System.out.println(prueba);
		prueba.insertar(5);
		System.out.println(prueba);
		prueba.borrar();
		System.out.println(prueba);
		prueba.borrar();
		System.out.println(prueba);
		prueba.insertar(50);
		System.out.println(prueba);
		prueba.insertar(200);
		System.out.println(prueba);
		prueba.borrar();
		System.out.println(prueba);
		prueba.insertar(500);
		System.out.println(prueba);
		prueba.borrar();
		System.out.println(prueba);
	}
}
