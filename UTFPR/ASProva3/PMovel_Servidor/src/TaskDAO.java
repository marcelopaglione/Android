import java.util.ArrayList;
import java.util.List;
/*
 * Marcelo Ortiz Paglione Junior
 * RA: 1256300
 */

public class TaskDAO {
	private List<Task> tasks;
	
	public TaskDAO(){
		tasks = new ArrayList<>();
		tasks.add(new Task(1,"Lista de Exercícios","Exerícios da prova"));
		tasks.add(new Task(2,"Dormir","Tarefa Diária","FECHADA"));
		tasks.add(new Task(3,"Walking dead","Assistir nas férias"));
		tasks.add(new Task(4,"Rede Social","Dar uma olhada no face","FECHADA"));
		
	}

	public List<Task> getAllTasks() {
		System.out.println("Get all Tasks: "+tasks.toString());
		return tasks;
	}

	public Task getById(int id) {
		for(Task task:tasks){
			if (task.getId()==id){
				System.out.println("Get task: "+task);
				return task;
			}
		}
		return new Task(0,"","");
	}

	public Task amazenar(Task task) {
		tasks.add(task);
		System.out.println("Add Task: "+task);
		return task;
	}

	public Task apagar(int id) {
		for (int i = 0; i < tasks.size(); i++) {
			if(tasks.get(i).getId()==id){
				tasks.get(i).setStatus("FECHADA");
				System.out.println("Remove Task: "+tasks.get(i));
				Task t = tasks.get(i);
				tasks.remove(i);
				return t;
			}
		}
		return new Task(0,"","");
	}
}
