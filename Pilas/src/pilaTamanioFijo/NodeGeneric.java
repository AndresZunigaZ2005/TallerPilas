package pilaTamanioFijo;

public class NodeGeneric<T> {

	T data;
	NodeGeneric <T> next;
	
    NodeGeneric(T d) {
        data = d;
        next = null;
    }
    

    public T getData() {
        return data;
    }

    public void setData(T dato) {
        this.data = dato;
    }


	public NodeGeneric<T> getNext() {
		return next;
	}


	public void setNext(NodeGeneric<T> next) {
		this.next = next;
	}

}
