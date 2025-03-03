
package Estructure_DoubleLinkedList;

import Data.Product;
import static IU.GUI.menuProductos;
import static IU.GUI.readOptionString;
import java.io.Serializable;


public class DoubleLinkedList <T> implements EstructureDoubleLinkedList<T> ,Serializable{
    // esta estrcutura esta hecha para soportar objetos
    private Node head;
    private Node tail; 
    private int counter;
    
    public DoubleLinkedList(){
        counter = 0;
        head = new Node(null);
        tail = new Node(null);
    }
    
    // add to front
    public void pushFront(T value){
        // si la cabeza es nula
        Node nodeNew = new Node(value);
        if(head.getNext()== null){
            head.setNext(nodeNew);
            tail.setNext(nodeNew);
        }else{
            // ponerle el prev
            head.getNext().setPrev(nodeNew);
            nodeNew.setNext(head.getNext());
            head.setNext(nodeNew);
        }
        counter++;
    }
    
    // Devuelve el item del frente
    public T topFront(){
        if(empty()){
            throw new RuntimeException("empty list, null head");
        }else{
            return(T) (head.getNext().getData());
        }

    }
    
    // remove front item 
    public void popFront(){
        if(empty()){
            throw new RuntimeException("empty list, null head");
        }
        // ponemos la cabeza en el nuevo 
        Node nodePop = head.getNext();
        head.setNext(nodePop.getNext());
        // si head es null solo hay un elemento
        if(head.getNext() == null){
           tail.setNext(null);
        }else{
            nodePop.getNext().setPrev(null);
        }
        counter--;
    }
     
    // add to back
    public void pushBack(T value){
        // crear el nodo nuevo
        Node nodeNew = new Node(value);
        // si tail es igual a null no hay valores 
        if(tail.getNext()== null){
            head.setNext(nodeNew);
            tail.setNext(nodeNew);
        }else{
            tail.getNext().setNext(nodeNew);
            nodeNew.setPrev(tail.getNext());
            tail.setNext(nodeNew);
        }
        counter++;
    }
    
    // return back item 
    public T topBack(){
        if(empty()){
            throw new RuntimeException("empty list, null tail");
        }else{
            return(T) (tail.getNext().getData());
        }
    }
    
    // remove back item 
    public void popBack(){
        //Node nodePop = null;
        if(empty()){
            throw new RuntimeException("empty list, null head");
        }
        else if(head.getNext() == tail.getNext()){
            head.setNext(null);
            head.setNext(null);
        }
        // es o(n) no sabemos cual es el anterior al tail 
        else{
            tail.setNext(tail.getNext().getPrev());
            tail.getNext().setNext(null);
        }
        counter--;
    }
    
    // ojo con este probar
    public void addAfter(Node node,T key){
        Node nodeNew = new Node(key);
        nodeNew.setNext(node.getNext());
        nodeNew.setPrev(node);
        node.setNext(nodeNew);
        if(nodeNew.getNext() != null){
            nodeNew.getNext().setPrev(nodeNew);
        }
        else if(tail.getNext() == node){
            tail.setNext(nodeNew);
        }
        counter++;
    }
    
    public void addBefore(Node node, T key){
        Node nodeNew = new Node(key);
        nodeNew.setNext(node);
        nodeNew.setPrev(node.getPrev());
        node.setPrev(nodeNew);
        if(nodeNew.getPrev() != null){
            nodeNew.getPrev().setNext(nodeNew);
        }
        else if(head.getNext() == node){
            head.setNext(nodeNew);
        }
    }
    
    public boolean empty(){
        return(head.getNext()== null);
    }
    
    public boolean find(T key){
        boolean found = false;
        if(empty()){
            return(found);
            //throw new RuntimeException("empty list, null head");
        }else{
            if(tail == head && head.getNext().getData() == key){
                found = true;
            }
            else{
                Node current = head;
                Node prev = new Node();
                prev.setNext(null);

                while(current.getNext() != null){
                    current = current.getNext();
                    T i = (T) current.getData();
                    //System.out.println("El comparable es asi:"+i.compareTo(key));
                    if(i == key){
                        return(true);
                    }
                }
            }
            if(tail.getNext().getData() == key){
                    found = true; 
            }
        }
            return(found);
    }
          
    public void delete(T key) {
        if (empty()) {
            throw new RuntimeException("Lista vacía, no se puede eliminar.");
        } else {
            Node current = head.getNext();
            Node prev = null;

            while (current != null) {
                T value = (T) current.getData();
                if (value.equals(key)) {
                    if (current == head.getNext()) {
                        // Si el nodo a eliminar es el primero
                        head.setNext(current.getNext());
                        if (current.getNext() != null) {
                            current.getNext().setPrev(null);
                        }
                    } else if (current == tail.getNext()) {
                        // Si el nodo a eliminar es el último
                        tail.setNext(prev);
                        if (prev != null) {
                            prev.setNext(null);
                        }
                    } else {
                        // Si el nodo a eliminar está en medio de la lista
                        prev.setNext(current.getNext());
                        current.getNext().setPrev(prev);
                    }
                    counter--;
                    return; // El nodo se ha eliminado, sal del método.
                }
                prev = current;
                current = current.getNext();
            }
        }
    }
    
        
    public Node getNodeForKeyWhioutCheck(T key){
        if(empty()){
            return(null);
        }
        else if(tail == head && head.getNext().getData() == key){
            return(head.getNext());
        }else{
            Node current = head;
            Node prev = new Node();
            prev.setNext(null);
            while(current.getNext() != null){
                current = current.getNext();
                T i = (T) current.getData();
                if(i == key){
                    return(current);
                }
            }
            if(tail.getNext().getData() == key){
                return(tail.getNext()); 
            }
        }
        return(null);
    }
    
    
    public Node getNodeForakey(T key){
        if(find(key)){
            return(getNodeForKeyWhioutCheck(key));
        }else{
            return(null);
        }
    }
    
    public boolean updateNode(T keySearch,T valueUpdate ){
        boolean found = false;
        if(empty()){
            return(found);
            //throw new RuntimeException("empty list, null head");
        }else{
            if(tail == head && head.getNext().getData() == keySearch){
                found = true;
            }
            else{
                Node current = head;
                Node prev = new Node();
                prev.setNext(null);

                while(current.getNext() != null){
                    current = current.getNext();
                    T i = (T) current.getData();
                    //System.out.println("El comparable es asi:"+i.compareTo(key));
                    if(i == keySearch){
                        current.setData(valueUpdate);
                        return(true);
                    }
                }
            }
            if(tail.getNext().getData() == keySearch){
                    tail.getNext().setData(valueUpdate);
                    found = true; 
            }
        }
            return(found);
    }
    
    public int getCounter(){
        return(counter);
    }
    
    public void setCounter(int counter){
        this.counter = counter;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
    public void removeAt(int position) {
        if (position < 0 || position >= counter) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }

        Node current = head.getNext();
        int currentPosition = 0;

        // Si la posición es 0, eliminar el primer nodo
        if (position == 0) {
            popFront();
            return;
        }

        // Recorrer la lista hasta la posición deseada
        while (current != null && currentPosition < position - 1) {
            current = current.getNext();
            currentPosition++;
        }

        // Verificar si se encontró el nodo anterior al que se desea eliminar
        if (current != null) {
            Node nodeToRemove = current.getNext();
            current.setNext(nodeToRemove.getNext());

            // Si se elimina el último nodo, actualizar la cola
            if (nodeToRemove.getNext() == null) {
                tail.setNext(current);
            }

            // Eliminar las referencias del nodo a eliminar
            nodeToRemove.setNext(null);
            nodeToRemove.setPrev(null);

            counter--;
        }
    }
    public void removeByProductName(String productName) {
        Node current = head.getNext();

        while (current != null) {
            Object data = current.getData();
            if (data instanceof Product) {
                Product product = (Product) data;
                if (product.getNameProduct().equalsIgnoreCase(productName)) {
                    // Encontramos el producto por nombre, eliminémoslo
                    if (current.getPrev() != null) {
                        current.getPrev().setNext(current.getNext());
                    } else {
                        // Si es el primer elemento, actualizamos la cabeza
                        head.setNext(current.getNext());
                    }
                    if (current.getNext() != null) {
                        current.getNext().setPrev(current.getPrev());
                    } else {
                        // Si es el último elemento, actualizamos la cola
                        tail.setNext(current.getPrev());
                    }
                    // Eliminamos las referencias del nodo
                    current.setNext(null);
                    current.setPrev(null);
                    counter--;
                    return; // Terminamos después de eliminar el nodo
                }
            }
            current = current.getNext();
        }
    }
    public void removeProductByQuantity(String productName) {
        while (true) {
            boolean productFound = false; // Variable para verificar si se encontró el producto
            Node current = head.getNext();

            while (current != null) {
                Object data = current.getData();
                if (data instanceof Product) {
                    Product product = (Product) data;
                    if (product.getNameProduct().equalsIgnoreCase(productName)) {
                        productFound = true; // Se encontró el producto
                        if (product.getQuantity() == 1) {
                            removeByProductName(productName);
                            return; // Salir del método después de eliminar el nodo
                        } else if (product.getQuantity() > 1) {
                            decreaseProductQuantity(productName);
                            return; // Salir del método después de disminuir la cantidad
                        }
                    }
                }
                current = current.getNext();
            }

            // Si el producto no se encontró en la lista, mostrar un mensaje y pedir al usuario que ingrese el nombre nuevamente
            if (!productFound) {
                System.out.println("El producto no existe en la lista. Por favor, ingrese el nombre del producto nuevamente:");
                productName=readOptionString("Ingresa el nombre del producto que deseas");
            }
        }
    }
    public void decreaseProductQuantity(String productName) {
        Node current = head.getNext();

        while (current != null) {
            Object data = current.getData();
            if (data instanceof Product) {
                Product product = (Product) data;
                if (product.getNameProduct().equalsIgnoreCase(productName)) {
                    if (product.getQuantity() > 1) {
                        product.setQuantity(product.getQuantity() - 1);
                    }
                    return;
                }
            }
            current = current.getNext();
        }
    }
    public int getIndexByName(String productName) {
        Node current = head.getNext();
        int index = 0;

        while (current != null) {
            Object data = current.getData();
            if (data instanceof Product) {
                Product product = (Product) data;
                if (product.getNameProduct().equalsIgnoreCase(productName)) {
                    return index;
                }
            }
            current = current.getNext();
            index++;
        }

        return -1; // Retorna -1 si no se encuentra el nombre en la lista
    }

    @Override
    public String toString() {
    if (empty()) {
        return "DoubleLinkedList is empty";
    }

    StringBuilder stringBuilder = new StringBuilder();
    Node current = head.getNext();
    int index = 0;
    while (current != null) {
        Object data = current.getData();
        if (data instanceof Product) {
            stringBuilder.append(data.toString());
            stringBuilder.append("\n"); // Agregar una nueva línea después de cada producto
        } else {
            stringBuilder.append(data.toString()); // Puedes ajustar esto si no es Product
        }
        current = current.getNext();
        index++;
    }

    return "DoubleLinkedList{\n" + stringBuilder.toString() + '}';
}

}
