package com.hornerhelm.game;

import java.util.HashMap;

public class Entity {
	
	private String label = new String("Entity");

	private boolean isEinherjar = false;
	private boolean loyal = false;
	private boolean alive = true;
	
	//the basic number of HP. should be 5000.
	private Integer basic_HP = new Integer(5000);
	//the current maximum HP, after buffs and bonuses. equals basic_HP by default.
	private Integer actual_HP = new Integer(basic_HP);
	//the current HP. may vary during battle. equals actual_HP by default.
	private Integer current_HP = new Integer(actual_HP);
	//--------------------------------------------------
	
	//basic stats
	private Integer meleeStat = 0;
	private Integer magicStat = 0;
	private Integer healStat = 0;
	//----------------------------
	
	//various stats
	private Integer avoidChance = 0;
	private Integer critChance = 0;
	//----------------------------
	
	//bonuses
	private Integer meleeDamageBonus = 0;
	private Integer hpBonus = 0;
	private Integer aggroBonus = 0;
	private Integer magicDamageBonus = 0;
	private Integer healBonus = 0;
	//----------------------------
	
	//melee, magic, heal
	private Integer[] kriegStats = {60,0,0};
	private Integer[] schutzStats = {20,0,0};
	private Integer[] machtStats = {10,50,0};
	private Integer[] heilStats = {10,0,50};
	private Integer[] tricksterStats = {20,20,20};

	public boolean isEinherjar() {
		return isEinherjar;
	}	
	
	public void setEinherjar(Integer[] ein){
		
		isEinherjar = true;
		
		for (Integer e : ein){
			
			//if krieg
			if (e == 1){
				meleeStat += kriegStats[0];
				meleeDamageBonus += 16;
			}
			
			//if schutz
			if (e == 2){
				meleeStat += schutzStats[0];
				hpBonus += 20;
				aggroBonus += 25;
			}
			
			//if macht
			if (e == 3){
				meleeStat += machtStats[0];
				magicStat += machtStats[1];
				magicDamageBonus += 8;
				
			}
			
			//if trickster
			if (e == 4){
				meleeStat += tricksterStats[0];
				magicStat += tricksterStats[1];
				healStat += tricksterStats[2];
				avoidChance += 4;
				critChance += 4;
			}
			
			//if heil
			if (e == 5){
				meleeStat += heilStats[0];
				healStat += heilStats[2];
			}
			
		}
		
	}
	
	public Entity() {
		
	}
	
}
