
package Data;

import java.io.Serializable;


public class Food extends Product implements Serializable{
    // la clase comida es la clase hija de producto
    
    public Food(String typeProduct,String nameProduct, int quantity,String emailDonor, int expirationDateYear, int expirationDateMonth, int expirationDateDay){
        // llamar al constructor de la superclase
        super(typeProduct, nameProduct,quantity, emailDonor);
        this.expirationDateYear = expirationDateYear ;
        this.expirationDateMonth =  expirationDateMonth;       
        this.expirationDateDay = expirationDateDay;
        
    }
    
    //  atributos 
    private int expirationDateYear;
    private int expirationDateMonth;
    private int expirationDateDay;
    
    
    public boolean IsFoodExpired(int currentDateYear, int currentDateMonth, int currentDateDay){
        int comparationYear= currentDateYear - expirationDateYear; 
        int comparationMonth= currentDateMonth - expirationDateMonth; 
        int comparationDay= currentDateDay - expirationDateDay; 
        // se mira si el año de comparacion es mayor a uno entoces verdad si no revisa el siguiente
        if(comparationYear >= 1){
            return(true);
        }else if(comparationMonth >= 1){
            return(true);
        }
        else if(comparationDay >= 0){ // aqui puede ser que este en el mismo dia por eso 0
            return(true);
        }else{
            return(false);
        }
        
    }
    
    // metodos setters y getters

    public int getExpirationDateYear() {
        return expirationDateYear;
    }

    public void setExpirationDateYear(int expirationDateYear) {
        this.expirationDateYear = expirationDateYear;
    }

    public int getExpirationDateMonth() {
        return expirationDateMonth;
    }

    public void setExpirationDateMonth(int expirationDateMonth) {
        this.expirationDateMonth = expirationDateMonth;
    }

    public int getExpirationDateDay() {
        return expirationDateDay;
    }

    public void setExpirationDateDay(int expirationDateDay) {
        this.expirationDateDay = expirationDateDay;
    }

    
    @Override
    public String toString() {
        return "Food{" + "expirationDateYear=" + expirationDateYear + ", expirationDateMonth=" + expirationDateMonth + ", expirationDateDay=" + expirationDateDay + '}';
    }
    
}
