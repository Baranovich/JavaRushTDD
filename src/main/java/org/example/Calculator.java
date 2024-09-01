package org.example;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Calculator {

    int localNumber;

    public Integer sum(Integer a, Integer b) {
        return a + b;
    }

}
