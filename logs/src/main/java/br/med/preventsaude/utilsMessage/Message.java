package br.med.preventsaude.utilsMessage;

public enum Message {

    UPLOAD_SUCESSO(0, "Upload Realizado com sucesso !!"),
    UPLOAD_ERROR(1, "Erro ao Realizar Upload"),
    LISTAR_LOGS_SUCESSO(2, "Sucesso ao listar Logs"),
    LISTAR_LOGS_ERROR(3, "Falha ao listar Logs"),
    FIND_BY_ID_ERROR(3, "Log não encontrado com esse ID :");

    private final Integer code;
    private final String description;

    private Message(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
