package dsa.services;

import edu.upc.eetac.dsa.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;

@Api(value = "/electricalbikes", description = "Endpoint to Text Service")
@Path("/bikes")
public class Service {

    private MyBike mb;

    public Service(){
        this.mb = MyBikeImpl.getInstance();
    }

    @POST
    @ApiOperation(value = "add user", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/adduser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User u) {
        String idUser = u.getIdUser();
        String name = u.getName();
        String surname = u.getSurname();
        this.mb.addUser(idUser, name, surname);

        return Response.status(201).build();
    }

    @POST
    @ApiOperation(value = "add station", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/addstation")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStation(Station s) {
        String idStation = s.getIdStation();
        String description = s.getDescription();
        int max = s.getMax();
        double lat = s.getLat();
        double lon = s.getLon();
        this.mb.addStation(idStation, description, max, lat, lon);

        return Response.status(201).build();
    }

    @POST
    @ApiOperation(value = "add bike", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "StationFullException"),
            @ApiResponse(code = 402, message = "StationNotFoundException")
    })
    @Path("/addbike")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBike(Bike b) {
        String idBike = b.getIdBike();
        String description = b.getDescription();
        double kms = b.getKms();
        String idStation = b.getIdStation();

        try {
            this.mb.addBike(idBike, description, kms, idStation);
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

    @GET
    @ApiOperation(value = "get bikes by user", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Bike.class, responseContainer = "List of Bikes sorted by kms"),
            @ApiResponse(code = 404, message = "UserNotFoundException"),

    })
    @Path("/getbikes/{idUser}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bikesByUser(@PathParam("idUser") String userId) {
        LinkedList<Bike> bikes = null;
        try {
            bikes = this.mb.bikesByUser(userId);
            GenericEntity<LinkedList<Bike>> entity = new GenericEntity<LinkedList<Bike>>(bikes){};
            return Response.status(201).entity(entity).build();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }

}
