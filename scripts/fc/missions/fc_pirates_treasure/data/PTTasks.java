package scripts.fc.missions.fc_pirates_treasure.data;

import java.util.Arrays;

import scripts.fc.framework.task.Task;

public enum PTTasks
{
	;
	
	public final Task TASK;
	PTTasks(Task t)
	{
		TASK = t;
	}
	
	public static Task[] getTasks()
	{
		return Arrays.stream(values())
				.map(ks -> ks.TASK)
				.toArray(Task[]::new);
	}
}
