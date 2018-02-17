package com.demo.example.support;

import java.util.Set;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class ParameterListExclusionStrategy implements ExclusionStrategy {

    private final Set<String> parameterNamesToSkip;

    public ParameterListExclusionStrategy(final Set<String> parameterNamesToSkip) {
        this.parameterNamesToSkip = parameterNamesToSkip;
    }

    @Override
    public boolean shouldSkipField(final FieldAttributes f) {
        return this.parameterNamesToSkip.contains(f.getName());
    }

    @SuppressWarnings("unused")
    @Override
    public boolean shouldSkipClass(final Class<?> clazz) {
        return false;
    }
}