
public  class Documento {
    private String titulo;
    private int añoDePublicacion;
    private String tipo;
    private int id;

    public Documento(String titulo, int anoDePublicacion,  String tipo, int id ) {
        this.titulo = titulo;
        this.añoDePublicacion = anoDePublicacion;
        this.tipo = tipo;
        this.id=id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoDePublicacion() {
        return añoDePublicacion;
    }

    public void setAnoDePublicacion(int anoDePublicacion) {
        this.añoDePublicacion = anoDePublicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Documento [Titulo: " + titulo + ", AñoDePublicacion: " + añoDePublicacion + ", Tipo: " + tipo
                 + ", ID: " + id + "]";
    }

}
