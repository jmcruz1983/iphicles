package com.pleo.backend.api;

import com.pleo.backend.service.PriceFormatterService;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PriceFormatterControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PriceFormatterService priceFormatterService;

    @InjectMocks
    private PriceFormatterController priceFormatterController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(priceFormatterController).build();
    }

    @Test
    public void formatPriceTest() throws Exception {
        when(priceFormatterService.formatPrice(anyString()))
                .thenReturn("54321");
        mockMvc.perform(post("/api/formatPrice")
                .content("12345")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"price\":\"54321\"}"));
    }
}
