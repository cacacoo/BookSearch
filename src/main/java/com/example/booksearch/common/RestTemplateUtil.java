package com.example.booksearch.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class RestTemplateUtil {
    /**
     * @param url             is the URI address of the WebService
     * @param parameterObject the object where all parameters are passed.
     * @param returnType      the return type you are expecting. Exemple : someClass.class
     */
    public static <T> T getObject(RestTemplate restTemplate, String url, Object parameterObject, Class<T> returnType) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<T> entity = new HttpEntity<T>((T) parameterObject, headers);

            String json = mapper.writeValueAsString(
                restTemplate.exchange(url, org.springframework.http.HttpMethod.POST, entity, returnType).getBody());
            return new Gson().fromJson(json, returnType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param url             is the URI address of the WebService
     * @param parameterObject the object where all parameters are passed.
     * @param returnType      the type of the returned object. Must be an array. Exemple : someClass[].class
     */
    public static <T> List<T> getListOfObjects(RestTemplate restTemplate, String url, Object parameterObject,
        Class<T[]> returnType) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<T> entity = new HttpEntity<>((T) parameterObject, headers);
            ResponseEntity<Object[]> results = restTemplate.exchange(url, org.springframework.http.HttpMethod.POST,
                entity, Object[].class);
            String json = mapper.writeValueAsString(results.getBody());
            T[] arr = new Gson().fromJson(json, returnType);
            return Arrays.asList(arr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
