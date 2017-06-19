package com.praveen.praveen.support.serialization;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.praveen.praveen.support.ApiRequestJsonSerializationSettings;
import com.praveen.praveen.support.GoogleGsonSerializerHelper;
import com.praveen.praveen.support.service.ToApiJsonSerializer;



@Component
public final class DefaultToApiJsonSerializer<T> implements ToApiJsonSerializer<T> {

 /*   private final ExcludeNothingWithPrettyPrintingOffJsonSerializerGoogleGson excludeNothingWithPrettyPrintingOff;
    private final ExcludeNothingWithPrettyPrintingOnJsonSerializerGoogleGson excludeNothingWithPrettyPrintingOn;
    private final CommandProcessingResultJsonSerializer commandProcessingResultSerializer;*/
    private final GoogleGsonSerializerHelper helper;

    @Autowired
    public DefaultToApiJsonSerializer( final GoogleGsonSerializerHelper helper) {
        this.helper = helper;
    }

    @Override
    public String serializeResult(final Object object) {
        return "";
    }

    @Override
    public String serialize(final Object object) {
        return "";
    }

    @Override
    public String serializePretty(final boolean prettyOn, final Object object) {
        String json = "";

        if (prettyOn) {
            json = "";
        } else {
            json = serialize(object);
        }
        return json;
    }

    @Override
    public String serialize(final ApiRequestJsonSerializationSettings settings, final Collection<T> collection,
            final Set<String> supportedResponseParameters) {
     /*   final Gson delegatedSerializer = findAppropriateSerializer(settings, supportedResponseParameters);
        return serializeWithSettings(delegatedSerializer, settings, collection.toArray());*/
    	return"";
    }

    @Override
    public String serialize(final ApiRequestJsonSerializationSettings settings, final T singleObject,
            final Set<String> supportedResponseParameters) {
        /*final Gson delegatedSerializer = findAppropriateSerializer(settings, supportedResponseParameters);
        return serializeWithSettings(delegatedSerializer, settings, singleObject);*/
    	return"";
    }

    @Override
    public String serialize(final ApiRequestJsonSerializationSettings settings, final Page<T> singleObject,
            final Set<String> supportedResponseParameters) {
       /* final Gson delegatedSerializer = findAppropriateSerializer(settings, supportedResponseParameters);
        return serializeWithSettings(delegatedSerializer, settings, singleObject);*/
    	return"";
    }

    @Override
    public String serialize(final ApiRequestJsonSerializationSettings settings, final Collection<T> collection) {
        final Gson delegatedSerializer = findAppropriateSerializer(settings);
        return serializeWithSettings(delegatedSerializer, settings, collection.toArray());
    }

    @Override
    public String serialize(final ApiRequestJsonSerializationSettings settings, final T singleObject) {
        final Gson delegatedSerializer = findAppropriateSerializer(settings);
        return serializeWithSettings(delegatedSerializer, settings, singleObject);
    }

    @Override
    public String serialize(final ApiRequestJsonSerializationSettings settings, final Page<T> singleObject) {
        final Gson delegatedSerializer = findAppropriateSerializer(settings);
        return serializeWithSettings(delegatedSerializer, settings, singleObject);
    }

    private String serializeWithSettings(final Gson gson, final ApiRequestJsonSerializationSettings settings, final Object[] dataObject) {
        String json = null;
        if (gson != null) {
            json = this.helper.serializedJsonFrom(gson, dataObject);
        } else {
            if (settings.isPrettyPrint()) {
                json = "";
            } else {
                json = serialize(dataObject);
            }
        }
        return json;
    }

    private String serializeWithSettings(final Gson gson, final ApiRequestJsonSerializationSettings settings, final Object dataObject) {
        String json = null;
        if (gson != null) {
            json = this.helper.serializedJsonFrom(gson, dataObject);
        } else {
            if (settings.isPrettyPrint()) {
                json = "";
            } else {
                json = serialize(dataObject);
            }
        }
        return json;
    }

    private Gson findAppropriateSerializer(final ApiRequestJsonSerializationSettings settings, final Set<String> supportedResponseParameters) {
        Gson gson = null;
        if (settings.isPartialResponseRequired()) {
            gson = this.helper.createGsonBuilderWithParameterExclusionSerializationStrategy(supportedResponseParameters,
                    settings.isPrettyPrint(), settings.getParametersForPartialResponse());
        }
        return gson;
    }

    private Gson findAppropriateSerializer(final ApiRequestJsonSerializationSettings settings) {
        Gson gson = null;
        if (settings.isPartialResponseRequired()) {
            gson = this.helper.createGsonBuilderForPartialResponseFiltering(settings.isPrettyPrint(),
                    settings.getParametersForPartialResponse());
        }
        return gson;
    }
}