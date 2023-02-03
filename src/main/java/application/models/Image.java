package application.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "image")
public class Image {
    @Id
    private String id;
    private String idLot;
    private String source;

    public Image() {
    }

    public Image(String id, String idLot, String source) {
        this.id = id;
        this.idLot = idLot;
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdLot() {
        return idLot;
    }

    public void setIdLot(String idLot) {
        this.idLot = idLot;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
