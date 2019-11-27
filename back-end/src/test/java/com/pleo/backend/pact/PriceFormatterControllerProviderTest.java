package com.pleo.backend.pact;

import com.pleo.backend.service.PriceFormatterService;

import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@DirtiesContext
@Provider("backend")
@PactFolder("src/test/resources/pact")
public class PriceFormatterControllerProviderTest {

    @Value("${local.server.port}")
    private int serverPort;

    @MockBean
    private PriceFormatterService priceFormatterService;

    @BeforeEach
    void setupTestTarget(PactVerificationContext context) {
        context.setTarget(new HttpTestTarget("localhost", serverPort, "/"));
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void pactVerificationTestTemplate(PactVerificationContext context) {
        context.verifyInteraction();
    }

    @State({"price is formatted correctly"})
    public void correctPriceState() {
        when(priceFormatterService.formatPrice(any(String.class)))
                .thenReturn("1234");
    }
}