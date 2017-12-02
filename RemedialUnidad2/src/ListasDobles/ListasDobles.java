package ListasDobles;

import java.util.ListIterator;

import nodo.nodo;

public class ListasDobles<T> {
	private nodo<T> start = null, end = null;
	// private int size=0;

	public ListasDobles() { // Constructor de la clase padre
		start = new nodo();
		start.setIndex(-1); // Inisialisa los nodos de la lista start y end
		end = new nodo();
		end.setIndex(-1);
	}

	public ListasDobles(T value) { // Constructor de la clase hijo
		this(); // Asina los get y next de start y end para crear
				// la lista.
		end.setBack(new nodo<T>(value));
		start.setNext(end.getBack());
		start.getNext().setIndex(0);
	}

	// ----------------------------------------------------------------------
	public int size() {
		nodo<T> tmp = start;
		int i = 0;
		while (tmp.getNext() != null) {
			i++; // Metodo que devuelve el numero de nodos en la lista
			tmp = tmp.getNext();
		}
		return i;
	}

	// ----------------------------------------------------------------------
	public boolean addAfter(long index, T newvalue) {
		if (index > size() || index < 0)
			return false;
		index = index - 1;// Metodo que añade un nuevo nodo
		nodo<T> finder = Searchx(index); // despues del nodo con el valor espesificado
		nodo<T> nodo = new nodo<T>(newvalue);
		if (finder != null && finder.getNext() != null) {
			nodo.setNext(finder.getNext());
			finder.setNext(nodo);
			nodo.setBack(finder);
			nodo.getNext().setBack(nodo);
			// size++;
			Reindex();
			return true;
		} else {
			add(newvalue);
			return true;
		}
	}

	// ----------------------------------------------------------------------
	public long IndexOf(T value) { // Metodo que debuelve el indice del
		nodo<T> finder = Search(value);// nodo del valor espesificado
		long index = 0;
		if (finder != null) {

			index = finder.getIndex();
			return index;
		} else {
			return index;
		}
	}

	// ----------------------------------------------------------------------
	public nodo<T> Search(T value) {
		return Search(value, start, end);
	}

	private nodo<T> Search(T value, nodo<T> start, nodo<T> end) {
		if (start.getNext() == null || end.getBack() == null) {
			// Metodo que returna el nodo del valor
			return null; // a buscar.
		} else if (start.getNext().getValue().equals(value)) {
			return start.getNext();
		} else if (end.getBack().getValue().equals(value)) {
			return end.getBack();
		} else if (start.getNext().equals(end) || start.equals(end)) {
			return null;
		}
		return Search(value, start.getNext(), end.getBack());
	}

	// ----------------------------------------------------------------------
	public nodo<T> Searchx(long index) {
		return Searchx(index, start, end);
	}

	private nodo<T> Searchx(long index, nodo<T> start, nodo<T> end) {
		if (start.getNext() == null || end.getBack() == null) {
			// Metodo que returna el nodo del valor
			return null; // a buscar.
		} else if (start.getNext().getIndex() == (index)) {
			return start.getNext();
		} else if (end.getBack().getIndex() == (index)) {
			return end.getBack();
		} else if (start.getNext().equals(end) || start.equals(end)) {
			return null;
		}
		return Searchx(index, start.getNext(), end.getBack());
	}

	// ----------------------------------------------------------------------
	public void add(T value) {// Metodo que añade un nuevo nodo al final de la lista
		nodo<T> tmp = end.getBack();
		end.setBack(new nodo<T>(value));
		if (tmp == null) {
			// end.getBack().setIndex(0);
			start.setNext(end.getBack());
		} else {
			end.getBack().setBack(tmp);
			tmp.setNext(end.getBack());
		}
		Reindex();
	}

	// ----------------------------------------------------------------------
	public T forPosition(long index) {
		if (index > size() || index < 0)
			return null;
		index = index - 1;
		// System.out.println("Siguiente: "+start.getNext().getNext().getValue()+" index
		// : "+(start.getNext().getNext().getIndex()+1));
		return forPosition(index, start.getNext(), end.getBack());
	}

	private T forPosition(long index, nodo<T> inicio, nodo<T> fin) {
		// System.out.println(inicio.getValue()+", "+inicio.getIndex());

		if (inicio == null || fin == null) {
			System.out.println("x");
			// Metodo que returna el nodo del valor
			// System.out.println("inicio: "+inicio.getIndex());
			return null; // a buscar.
		} else if (inicio.getIndex() == (index)) {
			// System.out.println("inicio: "+inicio.getIndex());
			return inicio.getValue();
		} else if (fin.getIndex() == (index)) {
			// System.out.println("inicio: "+inicio.getIndex());
			return fin.getValue();
		} else if (inicio.equals(fin) || inicio.equals(fin)) {
			return null;
		}
		return forPosition(index, inicio.getNext(), fin.getBack());
	}

	// ----------------------------------------------------------------------
	public void Reindex() {
		nodo<T> tmp = start; // Metodo que reasigna el indie a los nodos
		int i = 0; // de la lista
		while (tmp.getNext() != null) {

			tmp = tmp.getNext();
			tmp.setIndex(i);
			i++;
		}
	}

	// ----------------------------------------------------------------------
	public void replace(T oldValue, T newValue) {

		nodo<T> tmp = Search(oldValue);
		tmp.setValue(newValue);

	}

	// ----------------------------------------------------------------------
	public long forValue(T value) {
		return forValue(value, start, end);
	}

	private long forValue(T value, nodo<T> inicio, nodo<T> fin) {
		if (inicio.getNext() == null || fin.getBack() == null) {
			System.out.println("x");
			return 0;
		} else if (inicio.getNext().getValue() == (value)) {
			return inicio.getNext().getIndex();
		} else if (fin.getBack().getValue() == (value)) {
			return fin.getBack().getIndex() + 1;
		} else if (inicio.equals(fin) || inicio.equals(fin)) {
			return 0;
		}
		return forValue(value, inicio.getNext(), fin.getBack());
	}

	// ----------------------------------------------------------------------
	public void list(ListIterator it) {

		while (it.hasNext()) {
			System.out.println(it.next());// Metodo que imprime la lista del primero al ultimo
		}
	}

	// ----------------------------------------------------------------------
	public ListIterator<T> listiterator() {
		return new ListIterator<T>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				nodo<T> sig = start;
				start = start.getNext();
				return (start != null) ? true : false;
			}

			@Override
			public boolean hasPrevious() {
				// TODO Auto-generated method stub
				// nodo<T> ant = end;
				end = end.getBack();
				return (end != null) ? true : false;

			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				return start.getValue();
			}

			@Override
			public int nextIndex() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public T previous() {
				// TODO Auto-generated method stub
				return end.getValue();

			}

			@Override
			public int previousIndex() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub

			}

			@Override
			public void set(T arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void add(T arg0) {
				// TODO Auto-generated method stub

			}
		};
	}
}
