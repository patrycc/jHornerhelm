package com.hornerhelm.game;

import java.util.ArrayList;

public class EntitiesManager {
	
	private Integer numberOfEinherjar = 0;
	
	ArrayList<Entity> localEntities = new ArrayList<Entity>();
	Entity tmpEntity = new Entity();
	
	public EntitiesManager( ArrayList<Entity> entities ){
		this.localEntities = entities;
	}
	
	public Integer countEinherjar(){
		
		numberOfEinherjar = 0;
		
		for (int i = 0 ; i != this.localEntities.size() ; i++){
			if (this.localEntities.get(i).isEinherjar() ){
				this.numberOfEinherjar++;
			}
		}
		
		return numberOfEinherjar; 
	}
	
	public void resetEinherjarPositions() {
		
		int unterkante = 100;
		int startkante = 45;
		
		this.numberOfEinherjar = countEinherjar();
		
		startkante +=  450 - (this.numberOfEinherjar * 90);
		
		for ( int i = 0; i != countEinherjar(); i++ ){
			localEntities.get(i).setInherentPos(startkante/2 + (i*90), unterkante );
		}
			
	}
	
	public Entity getEntity(int pos){
		return localEntities.get(pos);
	}

}
