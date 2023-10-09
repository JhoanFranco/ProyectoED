
package Business;
import Data.Product;
import Data.Beneficiary;
import Data.CompanyDonor;
import Data.Donnor;
import Data.Serializador;
import Estructure_LinkedList.Queue;
import Estructure_LinkedList.LinkedList;
import Estructure_DoubleLinkedList.DoubleLinkedList;
import Data.serialization;
import static IU.GUI.mostrarMenu;
import Logic.ConectionAPI;


public class Main <T>{
    private static Queue listForChooseProduct = new Queue(); // primero una cola para poner los beneficiarios por orden de llegada
    private static DoubleLinkedList<Product> listOfProducts = new DoubleLinkedList(); // segundo una lista donde se van a poner todos los productos
    private static LinkedList<Beneficiary> listOfBeneficiaries= new LinkedList();
    private static LinkedList<Donnor> listOfDonors = new LinkedList();
    private static LinkedList<CompanyDonor> listaEmpresas = new LinkedList();

    // lo de historial de acciones esta en la clase donador
    // luego cada donador tiene enlazado un producto
    
    
    
    public static void main(String[] args) {
        //Pruebas para ver que el codigo funcione bien 
        // prueba lista de objetos
        Product producto = new Product("FOOD", "Harina", 5,"sar@gmail");
        Product producto2 = new Product("FOOD", "Frijol", 5,"carlos@gmail");
        Product producto3 = new Product("Ropa", "camiseta", 1,"antonio@gmail");
        Product producto4 = new Product("FOOD", "ARROZ", 3,"antoniA@gmail");
        //listOfProducts.pushFront(producto);
        //listOfProducts.pushFront(producto2);
        //listOfProducts.pushFront(producto3);
        //listOfProducts.pushFront(producto4);
        //System.out.println("Lista de Productos:");
        //System.out.println(listOfProducts.toString());
        //listOfProducts.removeAt(2);
        //System.out.println(listOfProducts.toString());
        // Guardar la lista de productos en un archivo serializable
        //Serializador.serializarObjeto(listOfProducts, "productos.dat");
        //cola.enqueue(producto2);
        //Product product2 =cola.dequeue();
        //System.out.println(product2.toString());
        //System.out.println(cola.find(producto2));
        
        // Agregar empresas a la lista
        //CompanyDonor empresa1 = new CompanyDonor("Surtifruver","545645-6","calle 43","Kennedy","super","surti@gmail.com","12345");
        //listaEmpresas.pushBack(empresa1);
        // Guardar la lista de empresas en un archivo serializable
        //Serializador.serializarObjeto(listaEmpresas, "empresas.dat");
        //Agregar Beneficiarios a la lista
        //Beneficiary beneficiario=new Beneficiary("Felipe","Alvarez Ramirez","felalvarez@gmail.com","52483767","12345");
        //listOfBeneficiaries.pushBack(beneficiario);
        // Guardar la lista de beneficiarios en un archivo serializable
        //Serializador.serializarObjeto(listOfBeneficiaries, "beneficiarios.dat");
        
        //Agregar Donadores a la lista
        //Donnor donador=new Donnor("Alberto","Murillo Ramirez","murrami@gmail.com","52484567","12345","calle 45#13-45","Kennedy");
        //listOfDonors.pushBack(donador);
        // Guardar la lista de beneficiarios en un archivo serializable
        //Serializador.serializarObjeto(listOfDonors, "donadores.dat");
        mostrarMenu();
        
        /*
        // Pruebas de serializacion
        // se crea un objeto para utilizar los metodos
        serialization ser = new serialization();
        
        // creacion inicial de un archivos, en este caso el 1
        ser.deleteFile(ser.getNameArray(1));
        System.out.println("Serializacion = "+ ser.WriteSerializationInicialFile(1));
        
        // como agregar elementos a la lista
        // primero se pude sacar de la lista de los archivos que queremos,pero Hay que guardarlo en el programa, es decir las listas Main .
        // para que funcionen los demas metodos. Por ello muy raramente utilizar getObjectFromSerializationFile
        ser.SetListInProgramFromFile(1);
        Main.listOfProducts.pushBack(product2);
        ser.saveStatusListProgram(1);
        
        //Ahora poner lista en main = null; para ver si funciona el guardado
        Main.listOfProducts = null;
        System.out.println("listaMain es igual  a = "+Main.listOfProducts);
        // luego ahora si traer poner la lista y mostrarla, para ver si funciono el guardado
        ser.SetListInProgramFromFile(1);
        System.out.println("listaMain es igual a = "+ Main.listOfProducts.topFront().toString());
        // luego SI FUNCIONA
        ser.WriteSerializationInicial_AllFiles();// Va a decir que la 2 no se creo porque ya fue creada anteriormente para la prueba anterior
        //ser.deleteAllFiles();
        
        // conecccion API pruebas
        ConectionAPI conApi = new ConectionAPI();
        conApi.getDataUsers();
        */
    }
    
    // setter y getter de Main

    public static Queue getListForChooseProduct() {
        return listForChooseProduct;
    }

    public static void setListForChooseProduct(Queue listForChooseProduct) {
        Main.listForChooseProduct = listForChooseProduct;
    }

    public static DoubleLinkedList<Product> getListOfProducts() {
        return listOfProducts;
    }

    public static void setListOfProducts(DoubleLinkedList<Product> listOfProducts) {
        Main.listOfProducts = listOfProducts;
    }

    public static LinkedList<Beneficiary> getListOfBeneficiaries() {
        return listOfBeneficiaries;
    }

    public static void setListOfBeneficiaries(LinkedList<Beneficiary> listOfBeneficiaries) {
        Main.listOfBeneficiaries = listOfBeneficiaries;
    }

    public static LinkedList<Donnor> getListOfDonors() {
        return listOfDonors;
    }

    public static void setListOfDonors(LinkedList<Donnor> listOfDonors) {
        Main.listOfDonors = listOfDonors;
    }

    
    
}
