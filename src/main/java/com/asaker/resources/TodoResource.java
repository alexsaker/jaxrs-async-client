package com.asaker.resources;

import com.asaker.clients.TodosAsyncClient;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 *
 * @author Alex
 */
@Path("todos")
public class TodoResource {

    @Inject
    TodosAsyncClient tac;
    
    @GET
    public void getTodos(@Suspended AsyncResponse response) {
        tac.fetchData()
                .thenApply(r -> r.readEntity(String.class))
                .thenAccept(response::resume);
    }

}
