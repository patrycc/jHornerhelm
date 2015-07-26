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
		int ganzkante = 450;
		
		this.numberOfEinherjar = countEinherjar();
		
		ganzkante -= (this.numberOfEinherjar * 90);
		ganzkante = ganzkante /2;
		
		for ( int i = 0; i != countEinherjar(); i++ ){
			localEntities.get(i).setInherentPos(startkante + ganzkante + (i*90), unterkante );
		}
			
	}
	
	public Entity getEntity(int pos){
		return localEntities.get(pos);
	}

}
