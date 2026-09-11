
void main() {
    MiListaCircular miLista = new MiListaCircular();

    // Datos de prueba
    miLista.add(10);
    miLista.add(20);
    miLista.add(30);
    miLista.add(40);

    //Modulo isEmpty
    System.out.println(miLista.isEmpty());

    //Modulo getSize
    System.out.println(miLista.getSize());

    //Modulo clear
    MiListaCircular listaTemporal = new MiListaCircular();
    listaTemporal.add(1);
    listaTemporal.clear();
    System.out.println(listaTemporal);

    //Modulo getHead
    System.out.println(miLista.getHead());

    //Modulo getTail
    System.out.println(miLista.getTail());

    //Modulo get
    Node nodoTreinta = miLista.search(30);
    System.out.println(miLista.get(nodoTreinta));

    //Modulo search
    System.out.println(miLista.search(20));

    //Modulo add
    miLista.add(60);
    System.out.println(miLista);

    //Modulo insert(Node node, Object object)
    Node nodoCuarenta = miLista.search(40);
    miLista.insert(nodoCuarenta, 45);
    System.out.println(miLista);

    //Modulo insert(Object objectRef, Object object)
    miLista.insert(30, 25);
    System.out.println(miLista);

    //Modulo insertHead
    miLista.insertHead(5);
    System.out.println(miLista);

    //Modulo insertTail
    miLista.insertTail(50);
    System.out.println(miLista);

    //Modulo set
    Node nodoVeinte = miLista.search(20);
    miLista.set(nodoVeinte, 22);
    System.out.println(miLista);

    //Modulo remove
    Node nodoVeinticinco = miLista.search(25);
    miLista.remove(nodoVeinticinco);
    System.out.println(miLista);

    //Modulo contains
    System.out.println(miLista.contains(30));

    //Modulo toArray()
    Object[] arreglo = miLista.toArray();
    int i = 0;
    while (i < arreglo.length) {
        System.out.println(arreglo[i]);
        i = i + 1;
    }

    //Modulo toArray(Object[] object)
    Object[] otroArreglo = new Object[miLista.getSize()];
    miLista.toArray(otroArreglo);
    int j = 0;
    while (j < otroArreglo.length) {
        System.out.println(otroArreglo[j]);
        j = j + 1;
    }

    //Modulo subList
    Node inicio = miLista.search(22);
    Node fin = miLista.search(40);
    MiListaCircular sub = miLista.subList(inicio, fin);
    System.out.println(sub);

    //Modulo sortList
    MiListaCircular otraLista = new MiListaCircular();
    otraLista.add(50);
    otraLista.add(10);
    otraLista.add(40);
    otraLista.add(20);
    otraLista.add(30);
    MiListaCircular ordenada = otraLista.sortList();
    System.out.println(ordenada);
}