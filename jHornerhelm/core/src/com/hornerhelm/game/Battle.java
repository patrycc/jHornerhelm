package com.hornerhelm.game;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Battle  implements Screen{
	
	final Hornerhelm game;
	
	OrthographicCamera camera;
	
    Stage stage;
    
	Texture background;
	Texture menu;
	
	Skin skin;
    BitmapFont font;
	Texture testTexture;
    TextureAtlas buttonAtlas;
	
    TextureRegion einherregion;

	MenuButton selectMenuButton;
	MenuButton attackMenuButton;
	MenuButton aufgebenMenuButton;
	MenuButton meleeMenuButton;
	MenuButton defendMenuButton;
	
	EntitiesManager entitiesMgr;
	
	int numberOfEinherjar = 0;
    
	public Battle(final Hornerhelm gam) {
		
		this.game = gam;
		
		stage = new Stage();

        buttonAtlas = new TextureAtlas(Gdx.files.internal("icons.pack"));
        
        einherregion = new TextureRegion();
        einherregion = buttonAtlas.findRegion("einherjar");

        selectMenuButton = new MenuButton(game, "", "select-button", 20, 20);
        attackMenuButton = new MenuButton(game, "", "attack-button", 460, 20);
        meleeMenuButton = new MenuButton(game, "", "melee-button", 95, 15);
        defendMenuButton = new MenuButton(game, "", "defend-button", 165, 15);
        
        aufgebenMenuButton = new MenuButton(game, "", "aufgeben", 495, 115);
		
		camera = new OrthographicCamera();
        camera.setToOrtho(false, 540, 540);
        
        background = new Texture(Gdx.files.internal("battle_bg.png"));
        menu = new Texture(Gdx.files.internal("battle_frame.png"));
 
        entitiesMgr = new EntitiesManager(game.entities);
        entitiesMgr.resetEinherjarPositions();
        
        stage.addActor(selectMenuButton.getButton());
        stage.addActor(attackMenuButton.getButton());
        stage.addActor(aufgebenMenuButton.getButton());
        stage.addActor(meleeMenuButton.getButton());
        stage.addActor(defendMenuButton.getButton());
		
		System.out.println("hm:"+entitiesMgr.countEinherjar());
		System.out.println("hm2:"+entitiesMgr.countEinherjar());
		System.out.println("hm3:"+entitiesMgr.countEinherjar());
        
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
 
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		
		game.batch.begin();		
		game.batch.draw(background, 0, 0);
		game.batch.draw(menu, 0, 0);
		
		for (int i = 0 ; i != entitiesMgr.countEinherjar() ; i++){
			if (entitiesMgr.getEntity(i).isLoyal() ){
				game.batch.draw(einherregion, entitiesMgr.getEntity(i).getX(),entitiesMgr.getEntity(i).getY());
			}
		}

		game.batch.end();
		
        stage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
