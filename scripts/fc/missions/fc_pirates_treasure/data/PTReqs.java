package scripts.fc.missions.fc_pirates_treasure.data;

import scripts.fc.framework.requirement.item.ItemRequirement;
import scripts.fc.framework.requirement.item.ReqItem;
import scripts.fc.framework.script.FCMissionScript;

public class PTReqs extends ItemRequirement
{
	public static final int RUM = 431, APRON = 1005, CHEST_KEY = 432, PIRATE_MESSAGE = 433,
			SPADE = 952, CASKET = 7956, BANANA = 1963;
	public PTReqs(FCMissionScript script)
	{
		super(script);
	}

	@Override
	public ReqItem[] getReqItems()
	{
		return new ReqItem[]
		{
			
		};
	}

}
