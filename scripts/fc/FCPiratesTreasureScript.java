package scripts.fc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Ending;
import org.tribot.script.interfaces.Painting;
import org.tribot.script.interfaces.Starting;

import scripts.fc.framework.mission.Mission;
import scripts.fc.framework.paint.FCPaintable;
import scripts.fc.framework.script.FCMissionScript;
import scripts.fc.missions.fc_pirates_treasure.FCPiratesTreasure;

@ScriptManifest(
	authors     = { 
	    "Final Calibur",
	}, 
	category    = "Quests", 
	name        = "FC Pirate's Treasure", 
	version     = 0.1, 
	description = "Completes Pirate's Treasure for you. Start anywhere.", 
	gameMode    = 1)
public class FCPiratesTreasureScript extends FCMissionScript implements FCPaintable, Painting, Starting, Ending
{
	@Override
	protected Queue<Mission> getMissions()
	{
		return new LinkedList<>(Arrays.asList(new FCPiratesTreasure(this)));
	}

	@Override
	protected String[] scriptSpecificPaint()
	{
		return new String[]{};
	}
}
