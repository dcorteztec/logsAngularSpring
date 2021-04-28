package br.med.preventsaude.controller;

import br.med.preventsaude.mock.MockReturn;
import br.med.preventsaude.model.LogModel;
import br.med.preventsaude.services.LogServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;

import static org.mockito.BDDMockito.given;


@WebMvcTest(controllers = LogController.class)
@RunWith(SpringRunner.class)
public class LogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LogServiceImpl service;

    @Test
    public void listAllLogs() throws Exception {

        given(service.findAll()).willReturn(MockReturn.listLogModel());

        this.mockMvc.perform(get("/listLogs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(MockReturn.listLogModel().size())));
    }

    @Test
    public void listAllLogsNull() throws Exception {

        given(service.findAll()).willReturn(null);

        this.mockMvc.perform(get("/listLogs"))
                .andExpect(status().isOk());
    }

    @Test
    public void createLog400() throws Exception {

        LogModel log = new LogModel(LocalDateTime.now(),
                "192.168.234.82","GET / HTTP/1.1","200","swcd (unknown version) CFNetwork/808.2.16 Darwin/15.6.0");

        given(service.insert(log))
        .willReturn(log);

        this.mockMvc.perform(post("/create-log"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getLogById() throws Exception {

        LogModel log = new LogModel(LocalDateTime.now(),
                "192.168.234.82","GET / HTTP/1.1","200","swcd (unknown version) CFNetwork/808.2.16 Darwin/15.6.0");

        given(service.findById(Mockito.anyLong()))
                .willReturn(Optional.of(log));

        this.mockMvc.perform(get("/log/1"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.ip", is("192.168.234.82")));
    }

    @Test
    public void updateLog() throws Exception {

        LogModel log = new LogModel(LocalDateTime.now(),
                "192.168.234.82","GET / HTTP/1.1","200","swcd (unknown version) CFNetwork/808.2.16 Darwin/15.6.0");

        given(service.findById(Mockito.anyLong()))
                .willReturn(Optional.of(log));

        this.mockMvc.perform(put("/edit-log/1"))
                .andExpect(status().is4xxClientError());
    }
}
