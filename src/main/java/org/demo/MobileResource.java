package org.demo;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/mobile/api")
public class MobileResource {
    List<String> mobilelist=new ArrayList<>();
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getMobilelist()
    {
        //return mobilelist;
        return Response.ok(mobilelist).build();
    }
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response addMobile(String mobileName)
    {
        mobilelist.add(mobileName);
        return Response.ok(mobileName).build();
    }

    @PUT
    @Path("/{oldmobilename}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateMobileName(@PathParam("oldmobilename")String oldmobilename,@QueryParam("newmobilename") String newmobilename)
    {
        mobilelist=mobilelist.stream().map(mobile ->{
            if(mobile.equals(oldmobilename))
            {
                return newmobilename;
            }
            else
            {
                return mobile;
            }
        }).collect(Collectors.toList());
        return Response.ok(mobilelist).build();
    }
@DELETE
@Path("{mobilename}")
    public Response deleteMobile(@PathParam("mobilename")String mobilename)
    {
        boolean isDeleted=mobilelist.remove(mobilename);
        if(isDeleted)
        {
            return Response.ok(mobilelist).build();
        }else
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
}
