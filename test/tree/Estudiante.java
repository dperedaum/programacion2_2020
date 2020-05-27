package tree;

public class Estudiante implements Comparable<Estudiante> {

    private long cedula;

    private long pasaporte;

    private String nombre;

    private String apellido;

    public Estudiante(long cedula) {
        this.cedula = cedula;
    }

    public Estudiante(long cedula, long pasaporte, String nombre, String apellido) {
        this.cedula = cedula;
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public long getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(long pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public int compareTo(Estudiante o) {
        int value = 0;

        if (this.getCedula() >  o.getCedula()) {
            value = 1;
        } else if (this.getCedula() > o.getCedula()) {
            value = -1;
        }

        return value;
    }

    @Override
    public String toString() {
        return "cedula: " + this.cedula + "\nnombre:" + this.getNombre() + "\napellido:" + this.getApellido();
    }

    @Override
    public int hashCode() {
        int hashCode = 0;

        for (int i = 0; i < this.apellido.length(); i++) {
            hashCode += this.apellido.charAt(i);
        }

        return hashCode;
    }
}
