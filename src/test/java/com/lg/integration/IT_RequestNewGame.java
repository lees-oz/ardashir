package com.lg.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lg.messages.commands.RequestNewGame;
import com.lg.messages.queries.GetGame;
import com.lg.utils.JsonSerializer;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.Test;
import java.util.UUID;

public class IT_RequestNewGame {

    private JsonSerializer serializer = new JsonSerializer();

    @Test
    public void When_command_request_Should_process() throws Exception {
        // Arrange
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:4567/command/RequestNewGame");
        httpPost.setEntity(new StringEntity(serializer.serialize(new RequestNewGame(UUID.randomUUID(), UUID.randomUUID()))));

        // Act
        CloseableHttpResponse response = httpClient.execute(httpPost);

        // Assert
        Assert.assertNotNull(response.getEntity().getContent().toString());
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test
    public void When_query_request_Should_process() throws Exception {
        // Arrange
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut("http://localhost:4567/query/GetGame");
        httpPut.setEntity(new StringEntity(serializer.serialize(new GetGame(UUID.randomUUID().toString()))));

        // Act
        CloseableHttpResponse response = httpClient.execute(httpPut);

        // Assert
        Assert.assertNotNull(response.getEntity().getContent().toString());
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
    }
}
