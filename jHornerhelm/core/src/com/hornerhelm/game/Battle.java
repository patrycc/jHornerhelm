package com.hornerhelm.game;

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

	private MenuButton selectMenuButton;
	private MenuButton attackMenuButton;
    
	public Battle(final Hornerhelm gam) {
		
		this.game = gam;
		
		stage = new Stage();

        buttonAtlas = new TextureAtlas(Gdx.files.internal("icons.pack"));
        
        einherregion = new TextureRegion();
        einherregion = buttonAtlas.findRegion("einherjar");

        selectMenuButton = new MenuButton(game, "", "select-button", 20, 20);
        attackMenuButton = new MenuButton(game, "", "attack-button", 460, 20);
		
		camera = new OrthographicCamera();
        camera.setToOrtho(false, 540, 540);
        
        background = new Texture(Gdx.files.internal("battle_bg.png"));
        menu = new Texture(Gdx.files.internal("battle_frame.png"));
 
        stage.addActor(selectMenuButton.getButton());
        stage.addActor(attackMenuButton.getButton());
        
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
		/*
		for (int i = 0 ; i != game.entities.size() ; i++){
			if (game.entities.get(i).isEinherjar() ){
				game.batch.draw(einherregion, i*108,90);
			}
		}		
		*/
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
