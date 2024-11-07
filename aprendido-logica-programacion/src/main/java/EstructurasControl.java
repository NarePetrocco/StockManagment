public class EstructurasControl {

    public static void main(String[] args) {

      String productType =  "PSICOLOGIA";

      switch (productType) {
        case "SALUD":
            System.out.println ("El impuesto es del 5%");
            break;
        case "BELLEZA":
            System.out.println ("El impuesto es del 10%");
            break;
        case "ALCOHOL":
            System.out.println ("El impuesto es del 20%");

        default:
            System.out.println ("El producto no ha sido reconocido");
            }

    }
}