import java.util.List;
/*
 * Marcelo Ortiz Paglione Junior
 * RA: 1256300
 */

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("tasks")
public class TaskResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Task> getAll() {
		TaskDAO dao = new TaskDAO();
		return dao.getAllTasks();
	}

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Task getById(@PathParam("id") int id) {
		TaskDAO dao = new TaskDAO();
		return dao.getById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Task addCategoria(Task task) {
		TaskDAO dao = new TaskDAO();
		return dao.amazenar(task);
	}

	@Path("{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Task apagar(@PathParam("id") int id) {
		TaskDAO dao = new TaskDAO();
		return dao.apagar(id);
	}
}
