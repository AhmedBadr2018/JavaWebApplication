package upload.download;

import java.sql.Blob;

/**
 *
 * @author nemo
 */
public class Attachment {

    long id;
    String fileName;
    Blob fileData;
    String description;

    public Attachment() {}

    public Attachment(long id, String fileName, Blob fileData, String description) {
        this.id = id;
        this.fileName = fileName;
        this.fileData = fileData;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Blob getFileData() {
        return fileData;
    }

    public void setFileData(Blob fileData) {
        this.fileData = fileData;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
