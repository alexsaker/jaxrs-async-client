/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asaker.clients;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Alex
 */
@Stateless
public class TodosAsyncClient {

    private Client client;
    private WebTarget todosTarget;

    public TodosAsyncClient() {
    }
    
    
    @PostConstruct
    public void init(){
        this.client =  ClientBuilder
                .newBuilder()
                .connectTimeout(2, TimeUnit.SECONDS)
                .readTimeout(2, TimeUnit.SECONDS)
                .build();
        this.todosTarget = this.client.target("https://jsonplaceholder.typicode.com/todos");
    }
    
    public  CompletionStage<Response> fetchData(){
        return this.todosTarget.request(MediaType.APPLICATION_JSON_TYPE).rx().get();
    }
}
