package com.hornerhelm.game;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Hornerhelm extends Game {
	SpriteBatch batch;
	BitmapFont font;
	
	TextureAtlas buttonAtlas;
	Skin skin;
	
	ArrayList<Integer[]> party = new ArrayList<Integer[]>();
	ArrayList<Entity> entities = new ArrayList<Entity>();
	
	@Override
	public void create () {
		
		//this.party.add(new Integer[]{0,0,0,0,0});
		
		batch = new SpriteBatch();
		font = new BitmapFont();
		
		buttonAtlas = new TextureAtlas(Gdx.files.internal("icons.pack"));
		skin = new Skin();
		
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
