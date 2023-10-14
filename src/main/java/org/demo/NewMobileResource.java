package org.demo;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.demo.entity.Mobile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/newmobile/api")
public class NewMobileResource {

    List<Mobile> newMobileList= new ArrayList<>();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listMobiles()
    {
        System.out.println(newMobileList);
        return Response.ok(newMobileList).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addenewMobile(Mobile newMobile)
    {
        newMobileList.add(newMobile);
        return Response.ok(newMobile).build();
    }
@PUT
@Path("/{id}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
    public Response updateMobile(@PathParam("id") int id, Mobile udpatedmobile)
    {
        newMobileList=newMobileList.stream().map(mobile->{
            if(mobile.getId()==id)
            {
                return udpatedmobile;
            }
            else
            {
                return  mobile;
            }
        }).collect(Collectors.toList());
        return Response.ok(newMobileList).build();
    }
@DELETE
@Path("/{id}")
    public Response deleteNewMobile(@PathParam("id") int mobileIdtoDelete)
    {
       Optional<Mobile> firstMobile= newMobileList.stream().filter(mobile ->

            mobile.getId()==mobileIdtoDelete).findFirst();
       if(firstMobile.isPresent())
       {
           newMobileList.remove(mobileIdtoDelete);
           return  Response.ok(newMobileList).build();
       }
       else
       {
            return  Response.status(Response.Status.BAD_REQUEST).build();
       }



    }
}
