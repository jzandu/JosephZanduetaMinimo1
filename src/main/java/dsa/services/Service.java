package dsa.services;

import dsa.models.User;
import dsa.utils.GameManager;
import dsa.utils.GameManagerImp;
import dsa.utils.UserNotFoundException;
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

    public Service() {
        this.mb = GameManagerImp.getInstance();
    }

    @POST
    @ApiOperation(value = "add user", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/adduser")
    @Consumes(MediaType.APPLICATION_JSON)

    public Response addUser(User s1) {
        String id = s1.getId();
        String name = s1.getName();
        String surname = s1.getSurname();
        this.mb.addUser(id, name, surname);

        return Response.status(201).build();
    }

    @POST
    @ApiOperation(value = "update User", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")})
    @Path("/updateuser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(User s) throws UserNotFoundException {
        this.mb.updateUser(s);

        return Response.status(201).build();
    }
}
