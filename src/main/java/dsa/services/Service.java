package dsa.services;

import dsa.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;

@Api(value = "/GameManager", description = "Endpoint to Text Service")
@Path("/bikes")
public class Service {

    private GameManager mb;

    public Service(){
        this.mb = GameManagerImpl.getInstance();
    }

    @POST
    @ApiOperation(value = "add user", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/adduser")
    @Consumes(MediaType.APPLICATION_JSON)

    public Response addUser(User s1) {
        String idUser = s1.getId();
        String name = s1.getName();
        String surname = s1.getSurname();
        this.mb.addUser(id, name, surname);

        return Response.status(201).build();
    }

    @POST
    @ApiOperation(value = "update User", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/updateuser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(User s) {
        String id = s.getId();
        this.mb.addUser(id, name, surname);

        return Response.status(201).build();
    }

    @POST
    @ApiOperation(value = "modificar usuario", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "StationFullException"),
            @ApiResponse(code = 402, message = "StationNotFoundException")
    })
    @Path("/addbike")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(User b) {
        String id = b.getId();
        String name = b.getName();
        try {
            this.mb.addBike(id, name, surname);
            return Response.status(201).build();
        } catch (StationFullException e) {
            e.printStackTrace();
            return Response.status(402).build();
        } catch (StationNotFoundException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }

    @GET
    @ApiOperation(value = "get bikes of a station sorted by kms asc", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Bike.class, responseContainer = "List of Bikes sorted by kms"),
            @ApiResponse(code = 404, message = "StationFullException"),

    })
    @Path("/sortbikesbykm/{idStation}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bikesByStationOrderByKms(@PathParam("idStation") String idStation) {
        try {
            LinkedList<Bike> bikes = this.mb.bikesByStationOrderByKms(idStation);
            GenericEntity<LinkedList<Bike>> entity = new GenericEntity<LinkedList<Bike>>(bikes){};
            return Response.status(201).entity(entity).build();
        } catch (StationNotFoundException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }

    @GET
    @ApiOperation(value = "get bike", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Bike.class, responseContainer = "Bike"),
            @ApiResponse(code = 404, message = "UserNotFoundException"),
            @ApiResponse(code = 402, message = "StationNotFoundException")
    })
    @Path("/getbike/{idStation}/{idUser}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getBike(@PathParam("idStation") String idStation, @PathParam("idUser") String idUser) {
        try {
            Bike bike = this.mb.getBike(idStation, idUser);
            return Response.status(201).entity(bike).build();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return Response.status(404).build();
        } catch (StationNotFoundException e) {
            e.printStackTrace();
            return Response.status(402).build();
        }
    }



    @POST
    @ApiOperation(value = "create a new Product", notes = "We have a brand new product")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Product.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newProduct(Product product) {

        if (product.getName()==null || product.getPrice()==0)  return Response.status(500).entity(product).build();
        this.tm.addProduct(product.name, product.description, product.price);
        return Response.status(201).entity(product).build();
    }

}

    @Path("/getItem/{idUser}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response itemsByUser(@PathParam("idUser") String id) {
        LinkedList<Item> listaItem = null;
        try {
            listaItem = this.mb.itembyUser(id);
            GenericEntity<LinkedList<Item>> entity = new GenericEntity<LinkedList<Bike>>(listaItem){};
            return Response.status(201).entity(entity).build();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }

}
