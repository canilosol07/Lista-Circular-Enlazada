public class MiListaCircular implements ListInterface {
    Node cabeza;

    @Override
    public boolean isEmpty() {
        if (this.cabeza == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getSize() {
        if (this.cabeza == null) {
            return 0;
        }
        int contador = 1;
        Node actual = this.cabeza.siguiente;
        while (actual != this.cabeza) {
            contador = contador + 1;
            actual = actual.siguiente;
        }
        return contador;
    }

    @Override
    public void clear() {
        this.cabeza = null;
    }

    @Override
    public Object getHead() {
        return this.cabeza.dato;
    }

    @Override
    public Object getTail() {
        Node actual = this.cabeza;
        while (actual.siguiente != this.cabeza) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    @Override
    public Object get(Node node) {
        if (this.cabeza == null) {
            return null;
        }
        Node actual = this.cabeza;
        do {
            if (actual == node) {
                return actual.dato;
            }
            actual = actual.siguiente;
        } while (actual != this.cabeza);
        return null;
    }

    @Override
    public Node search(Object object) {
        if (this.cabeza == null) {
            return null;
        }
        Node actual = this.cabeza;
        do {
            if (actual.dato == object) {
                return actual;
            }
            actual = actual.siguiente;
        } while (actual != this.cabeza);
        return null;
    }

    @Override
    public boolean add(Object object) {
        return insertTail(object);
    }

    @Override
    public boolean insert(Node node, Object object) {
        if (node == null || this.cabeza == null) {
            return false;
        }
        Node actual = this.cabeza;
        do {
            if (actual == node) {
                Node nuevoNodo = new Node(object);
                nuevoNodo.siguiente = actual.siguiente;
                actual.siguiente = nuevoNodo;
                return true;
            }
            actual = actual.siguiente;
        } while (actual != this.cabeza);
        return false;
    }

    @Override
    public boolean insert(Object objectRef, Object object) {
        if (this.cabeza == null) {
            return false;
        }
        Node actual = this.cabeza;
        do {
            if (actual.dato == objectRef) {
                Node nuevoNodo = new Node(object);
                nuevoNodo.siguiente = actual.siguiente;
                actual.siguiente = nuevoNodo;
                return true;
            }
            actual = actual.siguiente;
        } while (actual != this.cabeza);
        return false;
    }

    @Override
    public boolean insertHead(Object object) {
        Node nuevoNodo = new Node(object);
        if (this.cabeza == null) {
            nuevoNodo.siguiente = nuevoNodo;
            this.cabeza = nuevoNodo;
        } else {
            Node ultimo = this.cabeza;
            while (ultimo.siguiente != this.cabeza) {
                ultimo = ultimo.siguiente;
            }
            nuevoNodo.siguiente = this.cabeza;
            ultimo.siguiente = nuevoNodo;
            this.cabeza = nuevoNodo;
        }
        return true;
    }

    @Override
    public boolean insertTail(Object object) {
        Node nuevoNodo = new Node(object);
        if (this.cabeza == null) {
            nuevoNodo.siguiente = nuevoNodo;
            this.cabeza = nuevoNodo;
        } else {
            Node ultimo = this.cabeza;
            while (ultimo.siguiente != this.cabeza) {
                ultimo = ultimo.siguiente;
            }
            ultimo.siguiente = nuevoNodo;
            nuevoNodo.siguiente = this.cabeza;
        }
        return true;
    }

    @Override
    public boolean set(Node node, Object object) {
        node.dato = object;
        return true;
    }

    @Override
    public boolean remove(Node node) {
        if (node == null || this.cabeza == null) {
            return false;
        }

        if (node == this.cabeza) {
            if (this.cabeza.siguiente == this.cabeza) {
                this.cabeza = null;
                return true;
            }
            Node ultimo = this.cabeza;
            while (ultimo.siguiente != this.cabeza) {
                ultimo = ultimo.siguiente;
            }
            ultimo.siguiente = this.cabeza.siguiente;
            this.cabeza = this.cabeza.siguiente;
            return true;
        }

        Node actual = this.cabeza;
        do {
            if (actual.siguiente == node) {
                actual.siguiente = node.siguiente;
                return true;
            }
            actual = actual.siguiente;
        } while (actual != this.cabeza);

        return false;
    }

    @Override
    public boolean contains(Object object) {
        if (this.cabeza == null) {
            return false;
        }
        Node actual = this.cabeza;
        do {
            if (actual.dato == object) {
                return true;
            }
            actual = actual.siguiente;
        } while (actual != this.cabeza);
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arreglo = new Object[this.getSize()];
        if (this.cabeza == null) {
            return arreglo;
        }
        Node actual = this.cabeza;
        int i = 0;
        do {
            arreglo[i] = actual.dato;
            i = i + 1;
            actual = actual.siguiente;
        } while (actual != this.cabeza);
        return arreglo;
    }

    @Override
    public Object[] toArray(Object[] object) {
        int size = getSize();
        if (object.length < size) {
            object = new Object[size];
        }
        if (this.cabeza == null) {
            return object;
        }
        Node actual = this.cabeza;
        int i = 0;
        do {
            object[i] = actual.dato;
            i = i + 1;
            actual = actual.siguiente;
        } while (actual != this.cabeza);
        return object;
    }

    Node buscarNodo(Node nodo) {
        if (this.cabeza == null || nodo == null) {
            return null;
        }
        Node actual = this.cabeza;
        do {
            if (actual == nodo) {
                return actual;
            }
            actual = actual.siguiente;
        } while (actual != this.cabeza);
        return null;
    }

    @Override
    public MiListaCircular subList(Node from, Node to) {
        MiListaCircular subLista = new MiListaCircular();

        Node nodoInicio = buscarNodo(from);
        Node nodoFin = buscarNodo(to);
        if (nodoInicio == null || nodoFin == null) {
            return subLista;
        }
        Node actual = nodoInicio;
        boolean seguir = true;
        while (seguir) {
            subLista.insertTail(actual.dato);
            if (actual == nodoFin) {
                seguir = false;
            } else {
                actual = actual.siguiente;
            }
        }
        return subLista;
    }

    @Override
    public MiListaCircular sortList() {
        Object[] arreglo = this.toArray();
        int i = 0;
        while (i < arreglo.length - 1) {
            int j = 0;
            while (j < arreglo.length - 1 - i) {
                Comparable actual = (Comparable) arreglo[j];
                if (actual.compareTo(arreglo[j + 1]) > 0) {
                    Object temporal = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temporal;
                }
                j = j + 1;
            }
            i = i + 1;
        }

        MiListaCircular listaOrdenada = new MiListaCircular();
        int k = 0;
        while (k < arreglo.length) {
            listaOrdenada.insertTail(arreglo[k]);
            k = k + 1;
        }
        return listaOrdenada;
    }

    @Override
    public String toString() {
        if (this.cabeza == null) {
            return "MiListaCircular{vacia}";
        }
        String resultado = "MiListaCircular{";
        Node actual = this.cabeza;
        do {
            resultado = resultado + actual.dato;
            actual = actual.siguiente;
            if (actual != this.cabeza) {
                resultado = resultado + ", ";
            }
        } while (actual != this.cabeza);
        resultado = resultado + "}";
        return resultado;
    }
}