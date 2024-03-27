
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestion {
    private ArrayList<Documento> documentos;
    private Scanner scanner;
    private ArrayList<Autor> autores;
    private ArrayList<DocumentoAutor> documentoAutores;

    public Gestion(ArrayList<Documento> documentos) {
        this.documentos = documentos;
        this.scanner = new Scanner(System.in);
        this.autores = new ArrayList<Autor>();
        this.documentoAutores = new ArrayList<DocumentoAutor>();
    }

    private void listarDocumento() {
        for (int i = 0; i < documentos.size(); i++) {
            System.out.println(documentos.get(i));
        }
    }

    private void agregarDocumento() {

        System.out.println("Ingrese el titulo del documento");
        String titulo = scanner.nextLine();

        System.out.println("Ingrese el año de publicacion del documento");
        int añoDePublicacion = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el tipo de documento [Libro, Revista, Artículo, Paper, otros]");
        String tipo = scanner.nextLine();

        System.out.println("Ingrese el id del documento");
        int id = scanner.nextInt();
        scanner.nextLine();

        Documento documento = new Documento(titulo, añoDePublicacion, tipo, id);
        agregarDocumento(documento);
    }

    private void agregarDocumento(Documento documento) {
        listarAutor();
        System.out.println("Ingrese el id del autor");
        int id=scanner.nextInt();

        if (buscarAutorPorID(id)== null) {
            id=agregarAutor(documento);
        }

        agregarRelacion(documento.getId(), id);;


        documentos.add(documento);
    }

    private int agregarAutor(Documento documento) {
        System.out.println("Ingrese el nombre del autor");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el id del autor");
        int id = scanner.nextInt();
        scanner.nextLine();

        Autor autor = new Autor(nombre, id);
        agregarAutor(autor);
        return id;

    }

    private void agregarAutor(Autor autor) {
        autores.add(autor);
    
    }

    private void agregarRelacion(int bookID, int authorID) {
        DocumentoAutor documentoAutor = new DocumentoAutor(bookID, authorID);
        documentoAutores.add(documentoAutor);
    }

    private List<Autor> autoresPorBookID(int bookID) {
        List<Autor> autores = new ArrayList<Autor>();

        for (int i = 0; i < documentoAutores.size(); i++) {
            DocumentoAutor documentoAutor = documentoAutores.get(i);
            if (documentoAutor.getDocumentoId() == bookID) {
                for (int j = 0; j < autores.size(); j++) {
                    Autor autor = autores.get(j);
                    if (autor.getId() == documentoAutor.getAuthorId()) {
                        autores.add(autor);
                    }
                }
            }
        }

        return autores;
    }

    private List<Documento> getDocumentoPorAutorID(int autorID) {
        List<Documento> documentos = new ArrayList<Documento>();

        for (int i = 0; i < documentoAutores.size(); i++) {
            DocumentoAutor documentoAutor = documentoAutores.get(i);
            if (documentoAutor.getAuthorId() == autorID) {
                for (int j = 0; j < documentos.size(); j++) {
                    Documento documento = documentos.get(j);
                    if (documento.getId() == documentoAutor.getDocumentoId()) {
                        documentos.add(documento);
                    }
                }
            }
        }

        return documentos;
    }

    private Documento buscarDocumentoPorID(int id) {
        for (int i = 0; i < documentos.size(); i++) {
            Documento documento = documentos.get(i);
            if (documento.getId() == id) {
                return documento;
            }
        }

        return null;
    }

    private Autor buscarAutorPorID(int id) {
        for (int i = 0; i < autores.size(); i++) {
            Autor autor = autores.get(i);
            if (autor.getId() == id) {
                return autor;
            }
        }

        return null;
    }

    private void listarAutor() {
        for (int i = 0; i < autores.size(); i++) {
            System.out.println(autores.get(i));
        }
    }

    public void menu() {

        int opcion = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Bienvenido a la gestion de documentos, seleccione la opción que quieras ejecutar:");
            System.out.println("1. Agregar Documento");
            System.out.println("2. Listar Documentos");
            System.out.println("3. Agregar Autor");
            System.out.println("4. Listar Autores");
            System.out.println("5. Agregar Relacion");
            System.out.println("6. Listar Autores por Documento");
            System.out.println("7. Listar Documentos por Autor");
            System.out.println("8. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarDocumento();
                    break;
                case 2:
                    listarDocumento();
                    break;
                case 3:
                    agregarAutor(new Documento("", 0, "", 0));
                    break;
                case 4:
                    listarAutor();
                    break;
                case 5:
                    System.out.println("Ingrese el id del documento");
                    int bookID = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Ingrese el id del autor");
                    int authorID = scanner.nextInt();
                    scanner.nextLine();

                    agregarRelacion(bookID, authorID);
                    break;
                case 6:
                    System.out.println("Ingrese el id del documento");
                    int bookID2 = scanner.nextInt();
                    scanner.nextLine();

                    List<Autor> autores = autoresPorBookID(bookID2);
                    for (int i = 0; i < autores.size(); i++) {
                        System.out.println(autores.get(i));
                    }
                    break;
                case 7:
                    System.out.println("Ingrese el id del autor");
                    int authorID2 = scanner.nextInt();
                    scanner.nextLine();

                    List<Documento> documentos = getDocumentoPorAutorID(authorID2);
                    for (int i = 0; i < documentos.size(); i++) {
                        System.out.println(documentos.get(i));
                    }
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    break;
            }

        } while (opcion != 8);

    }

}