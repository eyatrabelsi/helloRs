package webservice;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Path("employee")
@Api
public class EmployeeWS {
	static List<Employee> list = new ArrayList<Employee>();
	public EmployeeWS() {
		// TODO Auto-generated constructor stub
		//this.list.add(new Employee("0000", "Ali", "Ben ahmed"));
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation( value = "GET all Employee")
	@ApiResponses({
		@ApiResponse(code=200 , message="Success")
	})
	public Response getEmployee() {
		return Response.status(200).entity(list).build();
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation( value = "CREATE all Employee")
	@ApiResponses({
		@ApiResponse(code=200 , message="Success")
	})
    public Response addEmployee(Employee employee) {
		this.list.add(employee);
		return Response.status(201).entity("Done").build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation( value = "UPDATE all Employee")
	@ApiResponses({
		@ApiResponse(code=200 , message="Success")
	})
	public Response updateEmploye(Employee e) {
		int index = getIndexByCin(e.getCin());

		if (index != -1) {
			list.set(index, e);
			return Response.status(200).entity("Done").build();
		}
		return  Response.status(200).entity("Echec").build();
	}
	
	@Path("/delete/{cin}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation( value = "DELETE all Employee")
	@ApiResponses({
		@ApiResponse(code=200 , message="Success")
	})
	public Response deleteEmploye(@PathParam(value="cin")String cin) {
		int index = getIndexByCin(cin);
		if (index != -1) {
			this.list.remove(index);
			return Response.status(200).entity("Done").build();
		} else
			return Response.status(200).entity("Echec").build();
	}

	public int getIndexByCin(String cin) {
		for (Employee emp : this.list) {
			if (emp.getCin().equals(cin))
				return this.list.indexOf(emp);
		}
		return -1;
	}

}
