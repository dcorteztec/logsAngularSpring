package br.med.preventsaude.mock;

import br.med.preventsaude.model.LogModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MockReturn {

    public static List<LogModel> listLogModel(){
        List<LogModel> list = new ArrayList<>();
        list.add(new LogModel(LocalDateTime.now(),
                "192.168.234.82","GET / HTTP/1.1","200","swcd (unknown version) CFNetwork/808.2.16 Darwin/15.6.0"));
        list.add(new LogModel(LocalDateTime.now(),
                "192.168.234.82","POST / HTTP/1.1","500","swcd (unknown version) CFNetwork/808.2.16 Darwin/15.6.0"));
        list.add(new LogModel(LocalDateTime.now(),
                "192.168.234.82","GET / HTTP/1.1","200","swcd (unknown version) CFNetwork/808.2.16 Darwin/15.6.0"));
        return list;
    }
}
