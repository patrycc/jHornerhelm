package com.hornerhelm.game;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hornerhelm extends Game {
	SpriteBatch batch;
	Texture img;
	BitmapFont font;
	String test = new String("hallo?");

	ArrayList<Integer[]> party = new ArrayList<Integer[]>();
	
	@Override
	public void create () {
		
		//this.party.add(new Integer[]{0,0,0,0,0});
		
		batch = new SpriteBatch();
		font = new BitmapFont();
		this.setScreen(new Title(this));
	}

	public void render() {
		super.render();
	}
 
	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}
