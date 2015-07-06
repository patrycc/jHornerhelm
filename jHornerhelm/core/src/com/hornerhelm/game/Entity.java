package com.hornerhelm.game;

public class Entity {
	
	private String label = new String("Entity");

	private boolean isEinherjar = false;
	private boolean isLoyal = false;
	private boolean alive = true;
	private Integer inherent_x = 0;
	private Integer inherent_y = 0;
	
	//the basic number of HP. should be 5000.
	private Integer basic_HP = new Integer(5000);
	
	//the current maximum HP, after buffs and bonuses. equals basic_HP by default.
	private Integer actual_HP = new Integer(basic_HP);
	
	//the current HP. may vary during battle. equals actual_HP by default.
	private Integer current_HP = new Integer(actual_HP);
	//--------------------------------------------------
	
	//basic stats
	private Integer meleeStat = 0;
	//----------------------------
	
	//various stats
	private Integer avoidChance = 0;
	private Integer critChance = 0;
	//----------------------------
	
	//bonuses
	private Integer meleeDamageBonus = 0;
	private Integer hpBonus = 0;
	private Integer aggroBonus = 0;
	//----------------------------

	public Entity() {
		
	}	
	
	public boolean isEinherjar() {
		return isEinherjar;
	}	
	
	public void setEinherjar(Integer[] ein){
		
		isEinherjar = true;
		isLoyal = true;
	
		/*
		for (Integer e : ein){
			
		}
		*/
	}
	
}
