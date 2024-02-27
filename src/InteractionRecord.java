
public class InteractionRecord  

{
	private String Interaction_id;
	private String Description;
	private String Interaction_data;
	private String Interaction_time;
	
	public InteractionRecord(String Interaction_id,String Description,String Interaction_data,
			String Interaction_time)
	{
		
		this.setInteraction_id(Interaction_id);
		this.setDescription(Description);
		this.setInteraction_data(Interaction_data);
		this.setInteraction_time(Interaction_time);
	}
	
	public String addInteractionRecord()
	{
		String InteractionRecord = getInteraction_id() + 
				getDescription() + getInteraction_data() + getInteraction_time();
		return InteractionRecord;
	}
	
	public String getInteraction_id() {
		return Interaction_id;
	}

	public void setInteraction_id(String interaction_id) {
		Interaction_id = interaction_id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getInteraction_data() {
		return Interaction_data;
	}

	public void setInteraction_data(String interaction_data) {
		Interaction_data = interaction_data;
	}

	public String getInteraction_time() {
		return Interaction_time;
	}

	public void setInteraction_time(String interaction_time) {
		Interaction_time = interaction_time;
	}
}
