package com.laioffer.tinnews.network;

import com.laioffer.tinnews.model.NewsResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;

public class OldSchoolNewsApi {// implements NewsApi {
//  @Override
//  public Call<NewsResponse> getTopHeadlines(String country) {
//
//    ObjectMapper mapper = new ObjectMapper();
//    CloseableHttpClient httpClient = HttpClients.createDefault();
//
//    HttpPost request = new HttpPost(EXTRACT_URL);
//    request.setHeader("Content-type", "application/json");
//    request.setHeader("Authorization", "Token " + AUTH_TOKEN);
//    ExtractRequestBody body = new ExtractRequestBody(articles, 3);
//
//    String jsonBody;
//    try {
//      jsonBody = mapper.writeValueAsString(body);
//    } catch (JsonProcessingException e) {
//      return Collections.emptyList();
//    }
//
//    try {
//      request.setEntity(new StringEntity(jsonBody));
//    } catch (UnsupportedEncodingException e) {
//      return Collections.emptyList();
//    }
//
//    ResponseHandler<List<Set<String>>> responseHandler = response -> {
//      if (response.getStatusLine().getStatusCode() != 200) {
//        return Collections.emptyList();
//      }
//      HttpEntity entity = response.getEntity();
//      if (entity == null) {
//        return Collections.emptyList();
//      }
//      ExtractResponseItem[] results = mapper.readValue(entity.getContent(), ExtractResponseItem[].class);
//      List<Set<String>> keywordList = new ArrayList<>();
//      for (ExtractResponseItem result : results) {
//        Set<String> keywords = new HashSet<>();
//        for (Extraction extraction : result.extractions) {
//          keywords.add(extraction.parsedValue);
//        }
//        keywordList.add(keywords);
//      }
//      return keywordList;
//    };
//
//    try {
//      return httpClient.execute(request, responseHandler);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    return Collections.emptyList()
//  }
//
//  @Override
//  public Call<NewsResponse> getEverything(String query, int pageSize) {
//    ObjectMapper mapper = new ObjectMapper();
//    CloseableHttpClient httpClient = HttpClients.createDefault();
//
//    HttpPost request = new HttpPost(EXTRACT_URL);
//    request.setHeader("Content-type", "application/json");
//    request.setHeader("Authorization", "Token " + AUTH_TOKEN);
//    ExtractRequestBody body = new ExtractRequestBody(articles, 3);
//
//    String jsonBody;
//    try {
//      jsonBody = mapper.writeValueAsString(body);
//    } catch (JsonProcessingException e) {
//      return Collections.emptyList();
//    }
//
//    try {
//      request.setEntity(new StringEntity(jsonBody));
//    } catch (UnsupportedEncodingException e) {
//      return Collections.emptyList();
//    }
//
//    ResponseHandler<List<Set<String>>> responseHandler = response -> {
//      if (response.getStatusLine().getStatusCode() != 200) {
//        return Collections.emptyList();
//      }
//      HttpEntity entity = response.getEntity();
//      if (entity == null) {
//        return Collections.emptyList();
//      }
//      ExtractResponseItem[] results = mapper.readValue(entity.getContent(), ExtractResponseItem[].class);
//      List<Set<String>> keywordList = new ArrayList<>();
//      for (ExtractResponseItem result : results) {
//        Set<String> keywords = new HashSet<>();
//        for (Extraction extraction : result.extractions) {
//          keywords.add(extraction.parsedValue);
//        }
//        keywordList.add(keywords);
//      }
//      return keywordList;
//    };
//
//    try {
//      return httpClient.execute(request, responseHandler);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    return Collections.emptyList()
//  }
}
