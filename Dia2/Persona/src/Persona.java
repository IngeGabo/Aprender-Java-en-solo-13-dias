public class Persona {
    private int id;
    private String nombre;
    private String numero;
    private String email;
    private static int numeroPersonas = 0;

    //Constructor Vació
    public Persona(){
        this.id = ++Persona.numeroPersonas;
    }
    //Constructor con argumentos
    public Persona(String nombre, String numero, String email){
        this();
        this.nombre = nombre;
        this.numero = numero;
        this.email = email;
    }
    //Metodo para obtener el valor
    public int getId(){
        return id;
    }
    //Metodo para darle valor a un atributo
    public void setId(int id){
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numero='" + numero + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan Perez", "553232342", "Gabo@gmail.com");
        System.out.println("persona1 = " + persona1);
    }
}
