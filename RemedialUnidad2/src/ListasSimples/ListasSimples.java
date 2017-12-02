package ListasSimples;

import java.util.Iterator;

import nodo.nodo;

public class ListasSimples<T extends Comparable<T>> implements Iterable<T> {
	private nodo<T> sentinel = null;

	public ListasSimples() {

		sentinel = new nodo<T>();
		sentinel.setIndex(-1);
	}

	public ListasSimples(T value) {
		this();// llama el contructor de arriba
		nodo<T> tmp = new nodo(value);
		tmp.setIndex(0);
		sentinel.setNext(tmp);

	}

	// ----------------------------------------------------------------------
	public void add(T value) {
		add(value, sentinel);
	}

	public void add(T value, nodo<T> list) {
		if (list.getNext() == null) {
			list.setNext(new nodo<T>(value));

			return;

		}
		add(value, list.getNext());
	}

	// ----------------------------------------------------------------------
	public boolean addASC(T value) {
		if (sentinel.getNext() == null) {
			sentinel.setNext(new nodo<T>(value));
		} else {
			return addASC(value, sentinel);
		}
		return false;
	}

	private boolean addASC(T value, nodo<T> inicio) {
		nodo<T> nodo = sentinel;
		if (sentinel.getNext() != null) {
			if (inicio.getNext().getValue().compareTo(value) >= 0 && inicio.getNext().getNext() == null) {
				inicio.getNext().setNext(new nodo<T>(value));
				return true;
			} else if (inicio.getNext().getValue().compareTo(value) < 0 && inicio.getNext().getNext() == null) {
				nodo<T> tmp = inicio.getNext();
				sentinel.setNext(new nodo<T>(value));
				sentinel.getNext().setNext(tmp);
			} else if (inicio.getNext().getValue().compareTo(value) >= 0
					&& inicio.getNext().getNext().getValue().compareTo(value) < 0) {
				nodo<T> tmp = inicio.getNext().getNext();
				inicio.getNext().setNext(new nodo<T>(value));
				inicio.getNext().getNext().setNext(tmp);
				return true;
			} else if (inicio.getNext().getValue().compareTo(value) < 0 && inicio.getNext().getNext() != null) {
				nodo<T> tmp = inicio.getNext();
				sentinel.setNext(new nodo<T>(value));
				sentinel.getNext().setNext(tmp);
			} else {
				return addASC(value, inicio.getNext());
			}
		} else {
			return false;
		}
		return false;
	}

	// ----------------------------------------------------------------------
	public boolean addDSC(T value) {
		if (sentinel.getNext() == null) {
			sentinel.setNext(new nodo<T>(value));
		} else {
			return addDSC(value, sentinel);
		}
		return false;
	}

	private boolean addDSC(T value, nodo<T> inicio) {
		nodo<T> nodo = sentinel;
		if (sentinel.getNext() != null) {
			if (inicio.getNext().getValue().compareTo(value) < 0 && inicio.getNext().getNext() == null) {
				inicio.getNext().setNext(new nodo<T>(value));
				return true;
			} else if (inicio.getNext().getValue().compareTo(value) >= 0 && inicio.getNext().getNext() == null) {
				nodo<T> tmp = inicio.getNext();
				sentinel.setNext(new nodo<T>(value));
				sentinel.getNext().setNext(tmp);
			} else if (inicio.getNext().getValue().compareTo(value) >= 0 && inicio.getNext().getNext() != null) {
				nodo<T> tmp = inicio.getNext();
				sentinel.setNext(new nodo<T>(value));
				sentinel.getNext().setNext(tmp);
				return true;
			} else if (inicio.getNext().getValue().compareTo(value) < 0
					&& inicio.getNext().getNext().getValue().compareTo(value) >= 0) {
				nodo<T> tmp = inicio.getNext().getNext();
				inicio.getNext().setNext(new nodo<T>(value));
				inicio.getNext().getNext().setNext(tmp);
			} else {
				return addDSC(value, inicio.getNext());
			}
		} else {
			return false;
		}
		return false;
	}

	// ----------------------------------------------------------------------
	public int size() {
		nodo<T> tmp = sentinel;
		int i = 0;
		while (tmp.getNext() != null) {
			i++; // Metodo que devuelve el numero de nodos en la lista
			tmp = tmp.getNext();
		}
		return i;
	}

	// ----------------------------------------------------------------------
	private nodo<T> forIndex(long index, nodo<T> inicio) {
		// System.out.println(inicio.getValue()+", "+inicio.getIndex());

		if (inicio.getNext() == null) {
			System.out.println("x");
			// Metodo que returna el nodo del valor
			// System.out.println("inicio: "+inicio.getIndex());
			return null; // a buscar.
		} else if (inicio.getNext().getIndex() == (index)) {
			// System.out.println("inicio: "+inicio.getIndex());
			return inicio.getNext();
		}
		return forIndex(index, inicio.getNext());
	}

	// ----------------------------------------------------------------------
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				nodo<T> sig = sentinel;
				sentinel = sentinel.getNext();
				return (sentinel != null) ? true : false;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				return sentinel.getValue();
			}
		};

	}

	// ----------------------------------------------------------------------
	public void list(Iterator it) {

		while (it.hasNext()) {
			System.out.println(it.next());// Metodo que imprime la lista del primero al ultimo
		}
	}

}
