package com.app;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class StringOperation {
    public String km() {
        return "KM";
    }

    public long countLength(List<String> expressions, int length) {
        return expressions
                .stream()
                .filter(e -> e.length() == length)
                .count();
    }
}
