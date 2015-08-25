package com.hornerhelm.game;

import java.util.ArrayList;

public class EntitiesManager {
	
	private Integer numberOfEinherjar = 0;
	private Integer numberOfEnemies = 0;
	
	ArrayList<Entity> localEntities = new ArrayList<Entity>();
	Entity tmpEntity = new Entity();
	
	public EntitiesManager( ArrayList<Entity> entities ){
		this.localEntities = entities;
	}
	
	public Integer countEinherjar(){
		
		if ( numberOfEinherjar == 0 )
		{
			for (int i = 0 ; i != this.localEntities.size() ; i++){
				if (this.localEntities.get(i).isEinherjar() ){
					this.numberOfEinherjar++;
				}
			}	
		}
		
		return numberOfEinherjar; 
	}
	
	public Integer countEnemies(){
		
		if ( numberOfEnemies == 0 )
		{
			for (int i = 0 ; i != this.localEntities.size() ; i++){
				if (this.localEntities.get(i).isLoyal() == false ){
					this.numberOfEnemies++;
				}
			}	
		}
		
		return numberOfEinherjar;
	}
	
	public void resetEinherjarPositions() {
		
		int unterkante = 100;
		int startkante = 45;
		int ganzkante = 450;
		
		this.numberOfEinherjar = countEinherjar();
		
		ganzkante -= (this.numberOfEinherjar * 90);
		ganzkante = ganzkante /2;
		
		for ( int i = 0; i != countEinherjar(); i++ ){
			localEntities.get(i).setInherentPos(startkante + ganzkante + (i*90), unterkante );
		}
			
	}
	
	public void addEntity(Entity addedEntity){
		this.localEntities.add(addedEntity);
	}
	
	public Entity getEntity(int pos){
		return localEntities.get(pos);
	}
	
	public int getNumberOfEntitites(){
		return localEntities.size();
	}

}
