package com.fulfilment.application.monolith.warehouses.api;

import com.warehouse.api.beans.Warehouse;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import java.util.List;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/warehouse")
public interface WarehouseResource {
  @GET
  @Produces("application/json")
  List<Warehouse> listAllWarehousesUnits();

  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Warehouse createANewWarehouseUnit(@NotNull Warehouse data);

  @Path("/{id}")
  @GET
  @Produces("application/json")
  Warehouse getAWarehouseUnitByID(@PathParam("id") String id);

  @Path("/{id}")
  @DELETE
  void archiveAWarehouseUnitByID(@PathParam("id") String id);
}
