package com.springTest.test.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Description lilicat @Date 2023/3/4 18:17
 */
public class ChatGptServiceImpl {

  private static final String API_KEY = "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";
  private static final String API_URL =
      "https://api.openai.com/v1/engines/davinci-codex/completions";
  private static final String PROMPT = "Hello, ChatGPT!";

  public static void main(String[] args) throws IOException {
    CloseableHttpClient httpClient = HttpClients.createDefault();

    HttpPost request = new HttpPost(API_URL);

    request.addHeader("Authorization", "Bearer " + API_KEY);
    request.addHeader("Content-Type", "application/json");

    JSONObject inputJson = new JSONObject();
    inputJson.put("prompt", PROMPT);
    inputJson.put("max_tokens", 50);

    StringEntity requestEntity = new StringEntity(inputJson.toString());
    request.setEntity(requestEntity);

    HttpResponse response = httpClient.execute(request);

    String responseJsonString = EntityUtils.toString(response.getEntity());
    System.out.println(responseJsonString);
//    JSONObject responseJson = new JSONObject(responseJsonString);
//
//    String generatedText = responseJson.getJSONArray("choices").getJSONObject(0).getString("text");
//
//    System.out.println("Generated text: " + generatedText);
  }
}
