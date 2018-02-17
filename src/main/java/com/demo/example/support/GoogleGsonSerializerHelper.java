package com.demo.example.support;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.MonthDay;
import org.springframework.stereotype.Service;

import com.demo.example.support.exception.UnsupportedParameterException;
import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public final class GoogleGsonSerializerHelper {
	
	public GoogleGsonSerializerHelper() {
		// TODO Auto-generated constructor stub
		System.out.println("successful Gson service");
	}

	public Gson createGsonBuilder(final boolean prettyPrint) {
		final GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(LocalDate.class, new JodaLocalDateAdapter());
		builder.registerTypeAdapter(DateTime.class, new JodaDateTimeAdapter());
		builder.registerTypeAdapter(MonthDay.class, new JodaMonthDayAdapter());
		if (prettyPrint) {
			builder.setPrettyPrinting();
		}
		return builder.create();
	}

	public Gson createGsonBuilderForPartialResponseFiltering(final boolean prettyPrint,
			final Set<String> responseParameters) {

		final ExclusionStrategy strategy = new ParameterListInclusionStrategy(responseParameters);

		final GsonBuilder builder = new GsonBuilder().addSerializationExclusionStrategy(strategy);
		builder.registerTypeAdapter(LocalDate.class, new JodaLocalDateAdapter());
		builder.registerTypeAdapter(DateTime.class, new JodaDateTimeAdapter());
		builder.registerTypeAdapter(MonthDay.class, new JodaMonthDayAdapter());
		if (prettyPrint) {
			builder.setPrettyPrinting();
		}
		return builder.create();
	}

	public Gson createGsonBuilderWithParameterExclusionSerializationStrategy(final Set<String> supportedParameters,
            final boolean prettyPrint, final Set<String> responseParameters) {

        final Set<String> parameterNamesToSkip = new HashSet<>();

        if (!responseParameters.isEmpty()) {

            // strip out all known support parameters from expected response to
            // see if unsupported parameters requested for response.
            final Set<String> differentParametersDetectedSet = new HashSet<>(responseParameters);
            differentParametersDetectedSet.removeAll(supportedParameters);

            if (!differentParametersDetectedSet.isEmpty()) { throw new UnsupportedParameterException(new ArrayList<>(
                    differentParametersDetectedSet)); }

            parameterNamesToSkip.addAll(supportedParameters);
            parameterNamesToSkip.removeAll(responseParameters);
        }

        final ExclusionStrategy strategy = new ParameterListExclusionStrategy(parameterNamesToSkip);

        final GsonBuilder builder = new GsonBuilder().addSerializationExclusionStrategy(strategy);
        builder.registerTypeAdapter(LocalDate.class, new JodaLocalDateAdapter());
        builder.registerTypeAdapter(DateTime.class, new JodaDateTimeAdapter());
        builder.registerTypeAdapter(MonthDay.class, new JodaMonthDayAdapter());
        if (prettyPrint) {
            builder.setPrettyPrinting();
        }
        return builder.create();
    }

	public String serializedJsonFrom(final Gson serializer, final Object[] dataObjects) {
		return serializer.toJson(dataObjects);
	}

	public String serializedJsonFrom(final Gson serializer, final Object singleDataObject) {
		return serializer.toJson(singleDataObject);
	}
}
