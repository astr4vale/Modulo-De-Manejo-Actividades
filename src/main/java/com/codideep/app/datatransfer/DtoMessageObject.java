
package com.codideep.app.datatransfer;

import java.util.ArrayList;
import java.util.List;

public class DtoMessageObject {

    private final List<String> listMessage;
    private String type;

    public DtoMessageObject() {
        this.listMessage = new ArrayList<>();
        this.type = "error";
    }

    public boolean existsMessage() {
        return !this.listMessage.isEmpty();
    }

    public void addMessage(String message) {
        this.listMessage.add(message);
    }

    public void setSuccess() {
        this.type = "success";
    }

    public void setWarning() {
        this.type = "warning";
    }

    public void setError() {
        this.type = "error";
    }

    public void setException() {
        this.type = "error";
    }

    public List<String> getListMessage() {
        return listMessage;
    }

    public String getType() {
        return type;
    }
}
