package controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import api.Notification;






@Path("/notifications")
public class NotificationController {



@GET
@Path("/ping")
public Response ping() {
return Response.ok().entity("Service online").build();
}



@GET
@Path("/get/{id}")
@Produces(MediaType.APPLICATION_JSON)
public Response getNotification(@PathParam("id") int id) {
return Response.ok().entity(new Notification(id, "john", "test notification")).build();
}



@GET
@Path("/get/{id}/name")
@Produces(MediaType.APPLICATION_JSON)
public Response getNotificationWithParameters(@PathParam("id") int id, @QueryParam("name") String name) {
return Response.ok().entity(new Notification(id, name, "test notification")).build();
}



@GET
@Path("/getXML/{id}")
@Produces(MediaType.APPLICATION_XML)
public Response getNotificationXML(@PathParam("id") int id) {
return Response.ok().entity(new Notification(id, "john", "test notification")).build();
}



@POST
@Path("/post/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response postNotification(Notification notification) {
return Response.status(201).entity(notification).build();
}



}