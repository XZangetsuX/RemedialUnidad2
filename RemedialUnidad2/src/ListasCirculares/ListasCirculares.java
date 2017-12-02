package ListasCirculares;



import nodo.nodo;

public class ListasCirculares<T> {
	private nodo<T> sentinel = null;
	private nodo<T> actual = null;

	public ListasCirculares() {
		sentinel = new nodo<T>();
		actual = new nodo<T>();
		sentinel.setIndex(-1);
		actual.setIndex(-1);
	}

	public ListasCirculares(T value) {
		this();
		sentinel.setNext(new nodo<T>(value));
		actual = sentinel.getNext();
		sentinel.getNext().setNext(actual);
	}
//----------------------------------------------------------------------
	public void List() {
		nodo<T> tmp = sentinel.getNext();
		if (!isEmpty()) {
			while (!tmp.getNext().equals(sentinel.getNext())) {
				System.out.println(tmp.getValue());
				tmp = tmp.getNext();
			}
			System.out.println(tmp.getValue());
		}
	}
//----------------------------------------------------------------------
	public void ListEx(int value) {
		nodo<T> tmp = sentinel.getNext();

		if (!isEmpty()) {
			while (!tmp.getNext().equals(sentinel.getNext())) {

				int resultado = (int) Math.pow((int) tmp.getValue(), value);

				System.out.println(resultado);
				tmp = tmp.getNext();
			}
			int resultado = (int) Math.pow((int) tmp.getValue(), value);
			System.out.println(resultado);
		}
	}
//----------------------------------------------------------------------
	public void addFirst(T value) {
		nodo<T> nuevo = new nodo<T>(value);
		nodo<T> last = getLast();
		if (isEmpty()) {
			sentinel.setNext(nuevo);
			nuevo.setNext(nuevo);
		} else {
			nuevo.setNext(sentinel.getNext());
			sentinel.setNext(nuevo);
			last.setNext(nuevo);
		}
	}
//----------------------------------------------------------------------
	public nodo<T> getLast() {
		nodo<T> tmp = sentinel.getNext();
		if (!isEmpty()) {
			while (!sentinel.getNext().equals(tmp.getNext()))
				tmp = tmp.getNext();
			return tmp;
		}
		return null;
	}

	public boolean isEmpty() {
		return (sentinel.getNext() == null) ? true : false;

	}

}
//----------------------------------------------------------------------