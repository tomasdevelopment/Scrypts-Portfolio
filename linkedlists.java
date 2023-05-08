
import java.util.Arrays;

public class linkedlists<E> implements VEDList<E> {

	private static class VEDNodo<E> {
		E val = null; // VAlor nodo
		VEDNodo<E> ant = null; // Nodo anterior
		VEDNodo<E> sig = null; // Nodo Siguiente

		VEDNodo(E pVal) { // Constructor clase nodo
			val = pVal;
		}
	}

	public static void main(String[] args) {
		linkedlists<String> myList = new linkedlists<>();
		// agregando con el metodo constructor//add with consultor method
		myList.add(0, "Apple");
		myList.add(1, "Banana");
		myList.add(2, "Cherry");
		// Consult method get
		String item = myList.get(1);
		System.out.println("Item at index 1: " + item);
		// modified method set
		String previousItem = myList.set(1, "Burberry"); // item 1 with burberry
		System.out.println("Previous item at index 1" + previousItem);
		System.out.println("Modified item: " + myList.get(1));
		// removal item check//revisar si se borro
		String removedItem = myList.remove(1);
		System.out.println("Removed item: " + removedItem);

		System.out.println("Size of the list before clearing: " + myList.size());
		// clear everything compeltely/borra todo
		myList.clear();
		System.out.println(Arrays.toString(myList.toArray()));
		int[] myArray = new int[] { 1, 2, 3 };
		System.out.println("Length of the array: " + myArray.length);

	}

	// encabezado es asignado al final para que no sea reasignado
	private final VEDNodo<E> header = new VEDNodo<E>(null);

	private int tamanho = 0;

	// constructor
	public linkedlists() {
		header.sig = header;
		header.ant = header;

	}

	// metodo insercion
	public void add(int index, E element) {
		// crear un nuevo nodo cuyo valor sea element
		VEDNodo<E> nuevo = new VEDNodo<E>(element);
		// obtener el nodo que guarda el elemento qu eesta en la posicion index
		VEDNodo<E> b = getNodeAt(index);
		// obtener el anteiror del nodo b
		VEDNodo<E> a = b.ant;
		// reencaedenar los nodos de la lista
		nuevo.ant = a;
		nuevo.sig = b;
		a.sig = nuevo;
		b.ant = nuevo;
		// incrementar el tama;o en una unidad
		tamanho++;
	}

	// destructor
	public void clear() {
		// El header siguiente del encabezado ponerlo en el encabezad
		header.sig = header;
		header.ant = header;
		tamanho = 0;
	}

	public E get(int index) {
		VEDNodo<E> nodo = getNodeAt(index);
		// retornar valor almacenado en nodo
		return nodo.val;
	}

	// modificador
	// consulta metodo
	private VEDNodo<E> getNodeAt(int index) {
		VEDNodo<E> x = header;
		if (index < (tamanho / 2)) {
			for (int i = 0; i <= index; i++) {
				x = x.sig;
			}
		} else {
			for (int i = tamanho - 1; i >= index; i--) {
				x = x.ant;
			}
		}
		return x;
	}

	// operacion eliminacion
	public E remove(int index) {
		VEDNodo<E> b = getNodeAt(index);
		VEDNodo<E> a = b.ant;
		VEDNodo<E> c = b.sig;
		a.sig = c;
		c.ant = a;
		tamanho--;
		return b.val;
	}

	public E set(int index, E element) {
		// obtener el nodo que guarda elemento en index
		VEDNodo<E> nodo = getNodeAt(index);
		E anteriorValor = nodo.val;
		nodo.val = element;
		return anteriorValor;
	}

	public int size() {
		return tamanho;
	}

	// object to array
	public Object[] toArray() {
		Object[] arr = new Object[tamanho];
		VEDNodo<E> currentNode = header.sig;
		int index = 0;
		while (currentNode != header) {
			arr[index++] = currentNode.val;
			currentNode = currentNode.sig;
		}
		return arr;
	}
}
