package scripts.fc.missions.fc_pirates_treasure;

import java.util.Arrays;
import java.util.LinkedList;

import scripts.fc.framework.quest.QuestScriptManager;
import scripts.fc.framework.requirement.Requirement;
import scripts.fc.framework.script.FCMissionScript;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_pirates_treasure.data.PTReqs;
import scripts.fc.missions.fc_pirates_treasure.data.PTTasks;

public class FCPiratesTreasure extends QuestScriptManager
{
	public static final String QUEST_NAME = "Pirate's Treasure";
	public static final int SETTING = -1;
	
	public FCPiratesTreasure(FCMissionScript fcScript)
	{
		super(fcScript);
	}

	@Override
	public boolean canStart()
	{
		return true;
	}

	@Override
	public boolean hasReachedEndingCondition()
	{
		return false;
	}

	@Override
	public String getMissionName()
	{
		return "FC Pirate's Treasure";
	}

	@Override
	public String getEndingMessage()
	{
		return "FC Pirate's Treasure has ended";
	}

	@Override
	public String[] getMissionSpecificPaint()
	{
		return new String[]{};
	}

	@Override
	public void resetStatistics()
	{
	}

	@Override
	public Requirement[] getRequirements()
	{
		return new Requirement[]{new PTReqs(missionScript)};
	}

	@Override
	public LinkedList<Task> getTaskList()
	{
		return new LinkedList<>(Arrays.asList(PTTasks.getTasks()));
	}

}
