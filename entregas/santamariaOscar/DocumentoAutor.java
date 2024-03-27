public class DocumentoAutor {
    private int documentoId;
    private int authorId;

    public DocumentoAutor(int documentoId, int authorId) {
        this.documentoId = documentoId;
        this.authorId = authorId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(int documentoId) {
        this.documentoId = documentoId;
    }
    


}
