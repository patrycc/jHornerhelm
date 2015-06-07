package com.hornerhelm.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Title implements Screen {

	final Hornerhelm game;

    Stage stage;
    TextButton editorButton;
    TextButton battleButton;
    TextButtonStyle editorButtonStyle;
    TextButtonStyle battleButtonStyle;
    
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;	
	
	OrthographicCamera camera;
	Texture background;
	
	public Title(final Hornerhelm gam) {
		game = gam;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 540, 540);
		
		background = new Texture(Gdx.files.internal("title_bg.png"));
		
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont();
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("icons.pack"));
        skin.addRegions(buttonAtlas);
        
        editorButtonStyle = new TextButtonStyle();
        editorButtonStyle.font = font;
        editorButtonStyle.up = skin.getDrawable("empty-button");
        editorButton = new TextButton("Editor", editorButtonStyle);
        editorButton.setPosition(0, 0);
        
        battleButtonStyle = new TextButtonStyle();
        battleButtonStyle.font = font;
        battleButtonStyle.up = skin.getDrawable("empty-button");
        battleButton = new TextButton("Battle", editorButtonStyle);
        battleButton.setPosition(90, 0);
        
        stage.addActor(editorButton);
        stage.addActor(battleButton);
        
		System.out.println("Title");        
        
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
		
		if (editorButton.isPressed() ) {
			game.setScreen(new Editor(game));
			dispose();
		}
		
		if (battleButton.isPressed() ) {
			game.setScreen(new Battle(game));
			dispose();
		}
		
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
