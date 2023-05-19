package com.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class StringOperationTest {
    @Test
    void test1() {
        assertEquals("KM", StringOperation.km());
        try (var mockedStatic
                     = Mockito.mockStatic(StringOperation.class)) {
            var expectedExpression = "KM JAVA";
            mockedStatic
                    .when(StringOperation::km)
                    .thenReturn(expectedExpression);
            assertEquals(expectedExpression, StringOperation.km());

            var expectedCounter = 10L;
            mockedStatic
                    .when(() -> StringOperation.countLength(
                            anyList(), anyInt()))
                    .thenReturn(11L);
            assertEquals(expectedCounter, StringOperation.countLength(List.of(), 2));
        }
    }
}
