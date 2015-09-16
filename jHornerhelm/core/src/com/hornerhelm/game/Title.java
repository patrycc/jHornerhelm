package com.hornerhelm.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Title implements Screen {

	final Hornerhelm game;

    Stage stage;
	
	OrthographicCamera camera;
	Texture background;
	
    MenuButton editorButton;
    MenuButton battleButton;
	
	public Title(final Hornerhelm gam) {
		game = gam;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 540, 540);
		
		background = new Texture(Gdx.files.internal("title_bg.png"));
		
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        
        editorButton = new MenuButton(game, "Editor", "empty-button90x90", 0, 0);
        battleButton = new MenuButton(game, "Battle", "empty-button90x90", 90, 0);        
        
        stage.addActor(editorButton.getButton());
        stage.addActor(battleButton.getButton());
        
        editorButton.getButton().addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
    			game.setScreen(new Editor(game));
    			dispose();
            }
        });
        
        battleButton.getButton().addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
    			game.setScreen(new Battle(game));
    			dispose();
            }
        });          
        
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
 
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		//camera.zoom = (float) (0.0 + Math.random() * Math.random());
 
		game.batch.begin();
		game.batch.draw(background, 0, 0);
		game.batch.end();
 
        stage.draw();
	}	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
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
		//this.dispose();
	}
	
}
