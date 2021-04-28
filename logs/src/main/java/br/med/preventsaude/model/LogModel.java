package br.med.preventsaude.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "log_tab")
public class LogModel {


    @Id
    @SequenceGenerator(name="logs_seq",
            sequenceName="logs_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="logs_seq")
    private Long id;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime dateTime;
    private String ip;
    private String httpMethod;
    private String statusMethod;
    private String userAgent;

    public LogModel(){

    }

    public LogModel(LocalDateTime dateTime,String ip,String httpMethod,String statusMethod,String userAgent){
        this.dateTime = dateTime;
        this.ip = ip;
        this.httpMethod = httpMethod;
        this.statusMethod = statusMethod;
        this.userAgent = userAgent;
    }
}
