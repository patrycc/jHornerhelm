package com.hornerhelm.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class Editor implements Screen{

	final Hornerhelm game;	
	
	OrthographicCamera camera;
	
    Stage stage;
	
    TextButton kriegButton;
    TextButton schutzButton;
    TextButton machtButton;
    TextButton tricksterButton;
    TextButton heilButton;
    
    TextButtonStyle kriegButtonStyle;
    TextButtonStyle schutzButtonStyle;
    TextButtonStyle machtButtonStyle;
    TextButtonStyle tricksterButtonStyle;
    TextButtonStyle heilButtonStyle;
	
    Skin skin;
    BitmapFont font;
	Texture background;
    TextureAtlas buttonAtlas;
	
	public Editor(final Hornerhelm gam) {
		this.game = gam;
		
		camera = new OrthographicCamera();
        camera.setToOrtho(false, 540, 540);
        
        background = new Texture(Gdx.files.internal("editor_bg.png"));
        
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont();
        
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("icons"));
        skin.addRegions(buttonAtlas);
        
        kriegButtonStyle = new TextButtonStyle();
        kriegButtonStyle.font = font;
        kriegButtonStyle.up = skin.getDrawable("krieg-button");
        kriegButton = new TextButton("Krieg", kriegButtonStyle);
        kriegButton.setPosition(0, 0);
        stage.addActor(kriegButton);
        
        schutzButtonStyle = new TextButtonStyle();
        schutzButtonStyle.font = font;
        schutzButtonStyle.up = skin.getDrawable("schutz-button");
        schutzButton = new TextButton("Schutz", schutzButtonStyle);
        schutzButton.setPosition(90, 0);
        stage.addActor(schutzButton);
        
        machtButtonStyle = new TextButtonStyle();
        machtButtonStyle.font = font;
        machtButtonStyle.up = skin.getDrawable("macht-button");
        machtButton = new TextButton("Macht", machtButtonStyle);
        machtButton.setPosition(180, 0);
        stage.addActor(machtButton);           
        
        tricksterButtonStyle = new TextButtonStyle();
        tricksterButtonStyle.font = font;
        tricksterButtonStyle.up = skin.getDrawable("trickster-button");
        tricksterButton = new TextButton("Trickster", tricksterButtonStyle);
        tricksterButton.setPosition(270, 0);
        stage.addActor(tricksterButton);
        
        heilButtonStyle = new TextButtonStyle();
        heilButtonStyle.font = font;
        heilButtonStyle.up = skin.getDrawable("heil-button");
        heilButton = new TextButton("Heilung", heilButtonStyle);
        heilButton.setPosition(360, 0);
        stage.addActor(heilButton);            
        
		System.out.println("Editor");
		
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
		//camera.zoom = (float) (0.0 + Math.random() * Math.random());
 
		game.batch.begin();
		game.batch.draw(background, 0, 0);
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
