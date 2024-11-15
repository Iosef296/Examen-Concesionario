import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class ConcesionarioIosef {
    Scanner sc = new Scanner(System.in);
    String departamento;
    int opcion, i;
    ArrayList<String> compra = new ArrayList<>();
    String[] departamentos = {"Amazonas", "Áncash", "Apurímac", "Arequipa", "Ayacucho", "Cajamarca", "Callao", "Cusco", "Huancavelica", "Huánuco", "Ica", "Junín", "La Libertad", "Lambayeque", "Lima", "Loreto", "Madre de Dios", "Moquegua", "Pasco", "Piura", "Puno", "San Martín", "Tacna", "Tumbes", "Ucayali"};
    String[] sedes = {"Sede Arequipa", "Sede Chincha", "Sede Cusco", "Sede Ica", "Sede Juliaca", "Sede Piura", "Sede Puno", "Sede Trujillo"};
    //String[] marcas = {"Toyota", "Honda", "Ford", "Chevrolet", "Nissan", "Volkswagen", "BMW", "Mercedes-Benz", "Audi", "Kia", "Hyundai", "Mazda", "Subaru", "Tesla", "Ferrari", "Lamborghini", "Porsche", "Jaguar", "Land Rover", "Mitsubishi", "Volvo", "Peugeot", "Renault", "Fiat", "Suzuki"};
    String[] camionetas = {"Wrangler - Jeep (SUV)", "Cherokee - Jeep (SUV)" , "Altima - Nissan (SUV en algunos modelos)" , "Outlander - Mitsubishi (SUV)" , "Land Cruiser - Toyota (SUV)" , "Explorer - Ford (SUV)" , "X5 - BMW (SUV)" , "Soul - Kia (SUV compacto)" , "Siena - Toyota (SUV/Minivan)" , "Tucson - Hyundai (SUV)" , "Tundra - Toyota (Pick-up)" , "Wrangler Unlimited - Jeep (SUV)" , "Range Rover - Land Rover (SUV)" , "Pacifica - Chrysler (SUV/Minivan)" , "Mokka - Opel (SUV)" , "Q5 - Audi (SUV)"};
    String[] deportivo = {"Mustang - Ford (Deportivo)" , "Camaro - Chevrolet (Deportivo)" , "Model S - Tesla (Deportivo, aunque es eléctrico)" , "Vantage - Aston Martin (Deportivo)" , "Civic Type R - Honda (Deportivo compacto)" , "Cayenne - Porsche (Deportivo / SUV de alto rendimiento)" , "3 Series - BMW (Deportivo)" , "C-Class - Mercedes-Benz (Deportivo / Sedan deportivo)" , "Golf - Volkswagen (Deportivo en algunas versiones como el GTI)" , "A4 - Audi (Deportivo / Sedan)" , "Q7 - Audi (SUV deportivo)" , "E-Class - Mercedes-Benz (Deportivo / Sedan)" , "F-150 - Ford"};
    String[] seminuevos = {"Honda Civic (2017)" , "Toyota Corolla (2016)" , "Ford Mustang (2015)" , "Chevrolet Camaro (2016)" , "BMW 3 Series (2014)" , "Audi A4 (2017)" , "Hyundai Elantra (2016)" , "Mazda CX-5 (2015)" , "Jeep Grand Cherokee (2016)" , "Nissan Altima (2017)" , "Subaru Impreza (2015)" , "Volkswagen Golf (2017)" , "Kia Optima (2016)" , "Ford Explorer (2016)" , "Toyota Camry (2017)" , "Chevrolet Silverado 1500 (2014)" , "Ram 1500 (2015)" , "Honda Accord (2014)" , "Audi Q5 (2015)" + "Mazda 6 (2014)"};
    double[] precioscamionetas = {35000, 28000, 20000, 22000, 75000, 30000, 45000, 18000, 30000, 24000, 40000, 40000, 80000, 35000, 20000, 40000};
    double[] preciosdeportivos = {70000, 70000, 10000, 150000, 45000, 100000, 60000, 80000, 45000, 60000, 75000, 90000, 60000};
    double[] preciosseminuevos = {12000, 10000, 18000, 20000, 15000, 20000, 10000, 14000, 22000, 12000, 12000, 16000, 12000, 20000, 18000, 22000, 18000, 12000, 20000, 12000};
    //Map<String, String[]> provinciasPeru = new HashMap<>();
    Map<String, String> departamentoSede = new HashMap<>();
    Map<String, String> carrosMarcas = new HashMap<>();
    public ConcesionarioIosef() {
        /*provinciasPeru.put("Amazonas", new String[]{"Bagua", "Bongará", "Chachapoyas", "Condorcanqui", "Luya", "Rodríguez de Mendoza", "Utcubamba"});
        provinciasPeru.put("Áncash", new String[]{"Aija", "Antonio Raymondi", "Asunción", "Bolognesi", "Carhuaz", "Carlos Fermín Fitzcarrald",
                "Casma", "Corongo", "Huaraz", "Huari", "Huarmey", "Huaylas", "Mariscal Luzuriaga", "Ocros",
                "Pallasca", "Pomabamba", "Recuay", "Santa", "Sihuas", "Yungay"});
        provinciasPeru.put("Apurímac", new String[]{"Abancay", "Andahuaylas", "Antabamba", "Aymaraes", "Cotabambas", "Chincheros", "Grau"});
        provinciasPeru.put("Arequipa", new String[]{"Arequipa", "Camaná", "Caravelí", "Castilla", "Caylloma", "Condesuyos", "Islay", "La Unión"});
        provinciasPeru.put("Ayacucho", new String[]{"Cangallo", "Huamanga", "Huanca Sancos", "Huanta", "La Mar", "Lucanas", "Parinacochas",
                "Páucar del Sara Sara", "Sucre", "Víctor Fajardo", "Vilcas Huamán"});
        provinciasPeru.put("Cajamarca", new String[]{"Cajabamba", "Cajamarca", "Celendín", "Chota", "Contumazá", "Cutervo", "Hualgayoc", "Jaén",
                "San Ignacio", "San Marcos", "San Miguel", "San Pablo", "Santa Cruz"});
        provinciasPeru.put("Callao", new String[]{"Prov. Constitucional del Callao"});
        provinciasPeru.put("Cusco", new String[]{"Acomayo", "Anta", "Calca", "Canas", "Canchis", "Chumbivilcas", "Cusco", "Espinar", "La Convención",
                "Paruro", "Paucartambo", "Quispicanchi", "Urubamba"});
        provinciasPeru.put("Huancavelica", new String[]{"Acobamba", "Angaraes", "Castrovirreyna", "Churcampa", "Huancavelica", "Huaytará", "Tayacaja"});
        provinciasPeru.put("Huánuco", new String[]{"Ambo", "Dos de Mayo", "Huacaybamba", "Huamalíes", "Huánuco", "Lauricocha", "Leoncio Prado",
                "Marañón", "Pachitea", "Puerto Inca", "Yarowilca"});
        provinciasPeru.put("Ica", new String[]{"Chincha", "Ica", "Nazca", "Palpa", "Pisco"});
        provinciasPeru.put("Junín", new String[]{"Chanchamayo", "Chupaca", "Concepción", "Huancayo", "Jauja", "Junín", "Satipo", "Tarma", "Yauli"});
        provinciasPeru.put("La Libertad", new String[]{"Ascope", "Bolívar", "Chepén", "Gran Chimú", "Julcán", "Otuzco", "Pacasmayo", "Pataz",
                "Sánchez Carrión", "Santiago de Chuco", "Trujillo", "Virú"});
        provinciasPeru.put("Lambayeque", new String[]{"Chiclayo", "Ferreñafe", "Lambayeque"});
        provinciasPeru.put("Lima", new String[]{"Barranca", "Cajatambo", "Canta", "Cañete", "Huaral", "Huarochirí", "Huaura", "Lima",
                "Oyón", "Yauyos"});
        provinciasPeru.put("Loreto", new String[]{"Alto Amazonas", "Datem del Marañón", "Loreto", "Mariscal Ramón Castilla", "Maynas",
                "Putumayo", "Requena", "Ucayali"});
        provinciasPeru.put("Madre de Dios", new String[]{"Manu", "Tahuamanu", "Tambopata"});
        provinciasPeru.put("Moquegua", new String[]{"General Sánchez Cerro", "Ilo", "Mariscal Nieto"});
        provinciasPeru.put("Pasco", new String[]{"Daniel Alcides Carrión", "Oxapampa", "Pasco"});
        provinciasPeru.put("Piura", new String[]{"Ayabaca", "Huancabamba", "Morropón", "Paita", "Piura", "Sechura", "Sullana", "Talara"});
        provinciasPeru.put("Puno", new String[]{"Azángaro", "Carabaya", "Chucuito", "El Collao", "Huancané", "Lampa", "Melgar", "Moho",
                "Puno", "San Antonio de Putina", "San Román", "Sandia", "Yunguyo"});
        provinciasPeru.put("San Martín", new String[]{"Bellavista", "El Dorado", "Huallaga", "Lamas", "Mariscal Cáceres", "Moyobamba", "Picota",
                "Rioja", "San Martín", "Tocache"});
        provinciasPeru.put("Tacna", new String[]{"Candarave", "Jorge Basadre", "Tacna", "Tarata"});
        provinciasPeru.put("Tumbes", new String[]{"Contralmirante Villar", "Tumbes", "Zarumilla"});
        provinciasPeru.put("Ucayali", new String[]{"Atalaya", "Coronel Portillo", "Padre Abad", "Purús"});
        */
        //SEDES
        departamentoSede.put("Amazonas", "Sede Trujillo");
        departamentoSede.put("Áncash", "Sede Trujillo");
        departamentoSede.put("Apurímac", "Sede Cusco");
        departamentoSede.put("Arequipa", "Sede Arequipa");
        departamentoSede.put("Ayacucho", "Sede Cusco");
        departamentoSede.put("Cajamarca", "Sede Trujillo");
        departamentoSede.put("Callao", "Sede Ica");
        departamentoSede.put("Cusco", "Sede Cusco");
        departamentoSede.put("Huancavelica", "Sede Ica");
        departamentoSede.put("Huánuco", "Sede Trujillo");
        departamentoSede.put("Ica", "Sede Ica");
        departamentoSede.put("Junín", "Sede Ica");
        departamentoSede.put("La Libertad", "Sede Trujillo");
        departamentoSede.put("Lambayeque", "Sede Piura");
        departamentoSede.put("Lima", "Sede Ica");
        departamentoSede.put("Loreto", "Sede Trujillo");
        departamentoSede.put("Madre de Dios", "Sede Cusco");
        departamentoSede.put("Moquegua", "Sede Arequipa");
        departamentoSede.put("Pasco", "Sede Ica");
        departamentoSede.put("Piura", "Sede Piura");
        departamentoSede.put("Puno", "Sede Puno");
        departamentoSede.put("San Martín", "Sede Trujillo");
        departamentoSede.put("Tacna", "Sede Arequipa");
        departamentoSede.put("Tumbes", "Sede Piura");
        departamentoSede.put("Ucayali", "Sede Trujillo");
        //CARROS
        carrosMarcas.put("Civic", "Honda");
        carrosMarcas.put("Accord", "Honda");
        carrosMarcas.put("Civic Type R", "Honda");
        carrosMarcas.put("Corolla", "Toyota");
        carrosMarcas.put("Land Cruiser", "Toyota");
        carrosMarcas.put("Avalon", "Toyota");
        carrosMarcas.put("Tundra", "Toyota");
        carrosMarcas.put("Camry", "Toyota");
        carrosMarcas.put("Siena", "Toyota");
        carrosMarcas.put("Mustang", "Ford");
        carrosMarcas.put("F-150", "Ford");
        carrosMarcas.put("Explorer", "Ford");
        carrosMarcas.put("Wrangler", "Jeep");
        carrosMarcas.put("Altima", "Nissan");
        carrosMarcas.put("Sentra", "Nissan");
        carrosMarcas.put("A4", "Audi");
        carrosMarcas.put("3 Series", "BMW");
        carrosMarcas.put("C-Class", "Mercedes-Benz");
        carrosMarcas.put("Golf", "Volkswagen");
        carrosMarcas.put("CX-5", "Mazda");
        carrosMarcas.put("Outlander", "Mitsubishi");
        carrosMarcas.put("Impreza", "Subaru");
        carrosMarcas.put("Pajero", "Mitsubishi");
        carrosMarcas.put("Challenger", "Dodge");
        carrosMarcas.put("Vantage", "Aston Martin");
        carrosMarcas.put("Qashqai", "Nissan");
        carrosMarcas.put("Rio", "Kia");
        carrosMarcas.put("Sonata", "Hyundai");
        carrosMarcas.put("Discovery", "Land Rover");
        carrosMarcas.put("X5", "BMW");
        carrosMarcas.put("Q7", "Audi");
        carrosMarcas.put("E-Class", "Mercedes-Benz");
        carrosMarcas.put("Soul", "Kia");
        carrosMarcas.put("Elantra", "Hyundai");
        carrosMarcas.put("S-Class", "Mercedes-Benz");
        carrosMarcas.put("Cherokee", "Jeep");
        carrosMarcas.put("Forte", "Kia");
        carrosMarcas.put("Wrangler Unlimited", "Jeep");
        carrosMarcas.put("Tucson", "Hyundai");
        carrosMarcas.put("Mokka", "Opel");
        carrosMarcas.put("Range Rover", "Land Rover");
        carrosMarcas.put("Pacifica", "Chrysler");
        carrosMarcas.put("Cayenne", "Porsche");
        carrosMarcas.put("A3", "Audi");
        carrosMarcas.put("Q5", "Audi");
        carrosMarcas.put("Model S", "Tesla");
        carrosMarcas.put("Camaro", "Chevrolet");
    }
    public void menuPrincipal() {
        System.out.println("""
                                                                 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:
                                                                 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:
                                                                 @@@@@@@@@@@@@@@@@@@@@@@@@@@@   :       =@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:
                                                                 @@@@@@@@@@@@@@@@@@@@@@@@@  @@-@@@@@@@@@@@@@@@@+@@  @@@@@@@  @@@@@@@@@@@@@:
                                                                 @@@@@@@@@@@@@@@@@@@@@@@ @@ @@@@              #@@@ @@  @@@ @@  @@@@@@@@@@@:
                                                                 @@@@@@@@@@@@@@@@@@@@@ =@ @@*   @@@@@@@@@@@@@@-   @@@@@ @@  @  @@@@@@@@@@@:
                                                                 @@@@@@@@@@@@@@@@@@@@ @ @@   @@@              @@@   @@ @ @@@@@@@@@@@@@@@@@:
                                                                 @@@@@@@@@@@@@@@@@@  @@@.  @@   @@@@@@@@@@@@@@   @@   @=@.=@@@@@@@@@@@@@@@:
                                                                 @@@@@@@@@@@@@@@@@@ @@@  @@=  @@@ @@@@@@@@-@@@@@  @@@  @@@-@@       @@@@@@:
                                                                 @@@@@@@@@@@@@@@@  @@@  @@  @@@@            @@@@@@  @@  @ @ @@@@@@@@@    @:
                                                                 @@@@@@@@@@@@@@@@ @@  @@  @@ @@  @@@@@@@@@@  @@@@@ @@  @@ @@@@@@@@@@@@@@@@:
                                                                 @@@@@@@@@@@@@@@@ @@  @@ @@@@@ @@@@@@@@@@@@@@ @@@@  @@ ,@ @ @@@@@@@@@@@@@@:
                                                                 @@@@@@@@@@@@@@@@ @@=  @ @@@@                   @@@@  @@  @@@ @@@:*@###@@@#
                                                                 @@@@@@@@@@@@@@@@ @@@@%@ @@@  @@@@@@@@@@@@@@@@   @@@ @@@@@@@ @@@@@@@@@@@@@*
                                                                 @@@@@@@@@@@@@@@@ @@@  @  @@@     @@@@@@@@@@    @@@ @@@  @@@ @@@*+-=+*-+-%.
                                                                 @@@@@@@@@@@@@@@@@ @@  @@  @@ @@@           @@@ @@  @@ @@  @@ @@@%@@@@@@@@*
                                                                 @@@@@@@@@@@@@@@@@ @@@  @@  @@   @@@@@@@@@@@@   @@  @@  @=@ @@@@@@@@@@@@@@#
                                                                 @@@@@@@@@@@@@@@@@# @@@  @@  @@@@@@@@@@@@@@=@@@@  @@@  @@ @ @@@@@@@%*-:.+#-
                                                                 @@@@@@@@@@@@@@@@@@  @@@  @@@   @@@@@  @@@@@@    @@   @@ @ @@@@@@@@@@@@@@@+
                                                                 @@@@@@@@@@@@@@@@@@@  @@@@  @@@%    +-        @@@@  @@ @  @         %@@@@@:
                                                                 @@@@@@@@@@@@@@@@@@@@@ @@@@@   @@@@@#  -@@@@@@@   @@*:@ @@@@@@@@@@@@@@@@@@=
                                                                 @@@@@@@@@@@@@@@@@@@@@@  @@@@@@    #@@@@@@     @@@@:@ #@@@@@@@@#@@@@@@@@@@*
                                                                 @@@@@@@@@@@@@@@@@@@@@@@@@  @@@@@@@@@ @@-@@@@@@@@@  @@@@@@@@@@@%@@@@@@@@@@+
                                                                 @@@@@@@@@@@@@@%#@#%#@@@@@@@*   @@@@@@@@@@@@@    @@@@@@@@@@@@@@@@@@@@@@@@@:
                                                                 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  @@@@@@    @@@@@@@@@@@@@%@@@@@@@@@@@@@@@=
                                                                 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@@@@@@@@@@@@@@@=
                                                                 @@@@@@   @@@@@@@       @@@@@@@         @@@@@         @@@@@@         @@@@@=
                                                                 @@@@@@   @@@@@@  @@@@@  @@@@@   @@@@@@@@@@@@   @@@@@@@@@@@@   @@@@@@@@@@@=
                                                                 @@@@@@   @@@@@   @@@@@   @@@@@         @@@@@         @@@@@@        @@@@@@
                                                                 @@@@@@   @@@@@%  @@@@@  @@@@@@@@@@@@@  @@@@@   @@@@@@@@@@@@   @@@@@@@@@@@*
                                                                 @@@@@@   @@@@@@@       @@@@@@         @@@@@@         @@@@@@   @@@@@@@@@@@=
                                                                 @@@@@@@@@@@@@@@@@@@@@@@@@@@@%#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:
                """);
        System.out.println("1. Nuestros Autos          2.Nuestros Locales          3.Camionetas         4.Deportivos          5.Seminuevos            6.Servicio PostVenta         7.Cotizar           8.Tallers           0.Salir");
        opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                this.autos();
                break;
            case 2:
                this.sedes();
                break;
            case 3:
                this.camionetas();
                break;
            case 4:
                this.deportivos();
                break;
            case 5:
                this.seminuevos();
                break;
            case 6:
                this.postventa();
                break;
            case 7:
                this.cotizar();
                break;
            case 8:
                this.talleres();
                break;
            case 0:
                System.out.println("Saliendo del programa.");
                break;
            default:
                this.menuPrincipal();
        }
    }
    public void autos() {
        for (String auto : carrosMarcas.keySet()) {
            i++;
            System.out.println(i);
            System.out.println("Auto: " + auto);
            System.out.println("Marca: " + carrosMarcas.get(auto));
            System.out.println();
        }
    }
    public void sedes(){
        System.out.println("Tenemos las siguientes sedes");
        for(String sede:sedes){
            i++;
            System.out.println(i+ ". " +sede);
        }
        System.out.println("9.Elegir por ubicacion");
        System.out.println("Elija una sede:");
        opcion=sc.nextInt();
        switch (opcion) {
            case 1,2,3,4,5,6,7,8:
                break;
            case 9:
                this.locales();
                break;
            default:
        }
    }
    public void locales() {
        i = 0;
        sc.nextLine();
        for (String depa : departamentos) {
            System.out.println(depa);
        }
    System.out.println("Elija el departamento para ver la sede mas cercana");
        departamento = sc.nextLine();
        System.out.println("Departamento: " + departamento + " -> Sede más cercana: " + departamentoSede.get(departamento));
    }
    public void camionetas() {
        for (String camioneta: camionetas) {
            System.out.println((i+1)+ "." +camioneta);
            System.out.println(precioscamionetas[i]);
            i++;
            System.out.println();
            }
        }
    public void deportivos() {
        for (String depor: deportivo) {
            System.out.println((i+1)+ "." +depor);
            System.out.println(preciosdeportivos[i]);
            i++;
            System.out.println();
        }
    }
    public void postventa() {
    }
    public void cotizar() {
    }
    public void talleres() {
    }
    public void seminuevos() {
        for (String semi: seminuevos) {
            System.out.println((i+1)+ "." +semi);
            System.out.println(preciosseminuevos[i]);
            i++;
            System.out.println();
        }
    }
    public void AgendarCitaenTaller() {
    }
    public void promociones() {
    }
    public static void main(String[] args) {
        ConcesionarioIosef concesionarioIosef = new ConcesionarioIosef();
        concesionarioIosef.menuPrincipal();
    }
}


