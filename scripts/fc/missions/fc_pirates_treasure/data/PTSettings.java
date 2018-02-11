package scripts.fc.missions.fc_pirates_treasure.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import scripts.fc.framework.quest.InvBankBool;
import scripts.fc.framework.quest.InvBankBool.TYPE;
import scripts.fc.framework.quest.ItemBool;
import scripts.fc.framework.quest.Order;
import scripts.fc.framework.quest.QuestBool;
import scripts.fc.framework.quest.QuestJournalBool;
import scripts.fc.framework.quest.QuestJournalBool.JOURNAL_STATUS;
import scripts.fc.framework.quest.QuestState;
import scripts.fc.framework.quest.SettingBool;
import scripts.fc.missions.fc_pirates_treasure.FCPiratesTreasure;

public enum PTSettings
{
	START_QUEST
	(
		new QuestState
		(
			new SettingBool(FCPiratesTreasure.SETTING, 0, true, Order.EQUALS)
		)
	),
	
	BUY_RUM
	(
		new QuestState
		(
			new SettingBool(FCPiratesTreasure.SETTING, 1, true, Order.EQUALS),
			new QuestJournalBool(FCPiratesTreasure.QUEST_NAME, "I need to go to Karamja and buy some rum", JOURNAL_STATUS.CONTAINS_AND_ISNT_COMPLETE, true),
			new InvBankBool(PTReqs.RUM, 1, TYPE.NOT_IN_EITHER, true)
		)
	),
	
	LUTHAS_FIRST_DIALOGUE
	(
		new QuestState
		(
			new SettingBool(FCPiratesTreasure.SETTING, 1, true, Order.EQUALS),
			new QuestJournalBool(FCPiratesTreasure.QUEST_NAME, "I have taken employment on the banana plantation", JOURNAL_STATUS.CONTAINS_STRING, false)
		)
	),
	
	HIDE_RUM
	(
		new QuestState
		(
			new SettingBool(FCPiratesTreasure.SETTING, 1, true, Order.EQUALS),
			new InvBankBool(PTReqs.RUM, 1, TYPE.IN_ONE, true),
			new QuestJournalBool(FCPiratesTreasure.QUEST_NAME, "I have hidden my rum in the crate", JOURNAL_STATUS.CONTAINS_STRING, false)
		)
	),
	
	PICK_BANANAS
	(
		new QuestState
		(
			new SettingBool(FCPiratesTreasure.SETTING, 1, true, Order.EQUALS),
			new ItemBool(PTReqs.BANANA, 10, false),
			new QuestJournalBool(FCPiratesTreasure.QUEST_NAME, "I have hidden my rum in the crate", JOURNAL_STATUS.CONTAINS_AND_ISNT_COMPLETE, true)
		)
	),
	
	FILL_CRATE
	(
		new QuestState
		(
			new SettingBool(FCPiratesTreasure.SETTING, 1, true, Order.EQUALS),
			new ItemBool(PTReqs.BANANA, 10, true),
			new QuestJournalBool(FCPiratesTreasure.QUEST_NAME, "and filled it with bananas", JOURNAL_STATUS.CONTAINS_STRING, false)
		)
	),
	
	LUTHAS_SECOND_DIALOGUE
	(
		new QuestState
		(
			new SettingBool(FCPiratesTreasure.SETTING, 1, true, Order.EQUALS),
			new QuestJournalBool(FCPiratesTreasure.QUEST_NAME, "I should speak to Luthas and have it shipped", JOURNAL_STATUS.CONTAINS_AND_ISNT_COMPLETE, true)
		)
	),
	
	GET_APRON
	(
		new QuestState
		(
			new SettingBool(FCPiratesTreasure.SETTING, 1, true, Order.EQUALS),
			new InvBankBool(PTReqs.APRON, 1, TYPE.NOT_IN_EITHER, true),
			new QuestJournalBool(FCPiratesTreasure.QUEST_NAME, "has been shipped", JOURNAL_STATUS.CONTAINS_AND_ISNT_COMPLETE, true)
		)
	),
	
	COLLECT_RUM
	(
		new QuestState
		(
			new SettingBool(FCPiratesTreasure.SETTING, 1, true, Order.EQUALS),
			new InvBankBool(PTReqs.RUM, 1, TYPE.NOT_IN_EITHER, true),
			new QuestJournalBool(FCPiratesTreasure.QUEST_NAME, "has been shipped", JOURNAL_STATUS.CONTAINS_AND_ISNT_COMPLETE, true)
		)
	),
	
	GIVE_RUM_TO_FRANK
	(
		new QuestState
		(
			new SettingBool(FCPiratesTreasure.SETTING, 1, true, Order.EQUALS),
			new InvBankBool(PTReqs.RUM, 1, TYPE.IN_ONE, true),
			new QuestJournalBool(FCPiratesTreasure.QUEST_NAME, "I have the Karamja Rum", JOURNAL_STATUS.CONTAINS_AND_ISNT_COMPLETE, true)
		)
	),
	
	;
	
	private QuestState[] states;
	
	PTSettings(QuestState... states)
	{
		this.states = states;
	}
	
	public void resetJournalCaches()
	{
		Arrays.stream(getBools())
			.filter(b -> b instanceof QuestJournalBool)
			.forEach(qjb -> {((QuestJournalBool)(qjb)).resetCache();});
	}
	
	public QuestBool[] getBools()
	{
		List<QuestBool> bools = new ArrayList<>();
		Arrays.stream(states).forEach(s -> Arrays.stream(s.getBools()).forEach(b -> bools.add(b)));
		return bools.toArray(new QuestBool[bools.size()]);
	}
	
	public boolean isValid()
	{
		return Arrays.stream(states).allMatch(s -> s.validate());
	}
}
