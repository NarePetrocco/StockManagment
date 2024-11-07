public class Funciones {

    public static void main(String[] args) {
        String arturoInformation = buildPersonInformation("Arturo", 30);
        String juanInformation = buildPersonInformation("Juan", 20);

        System.out.println(arturoInformation);
        System.out.println(juanInformation);

    }
    public static String buildPersonInformation(String myName, int personAge) {
        return ("Hola estoy imprimiedo la funcion y me llamo: " +myName+ " y tengo "+personAge+ " años");
    }

}
