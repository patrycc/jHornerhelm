package com.hornerhelm.game;

import java.util.Arrays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Editor implements Screen{

	final Hornerhelm game;	
	
	OrthographicCamera camera;
	
    Stage stage;

    TextButton kriegButton;
    TextButton schutzButton;
    TextButton machtButton;
    TextButton tricksterButton;
    TextButton heilButton;
    TextButton acceptButton;
    
    TextButton deleteButton;
    
    TextButtonStyle kriegButtonStyle;
    TextButtonStyle schutzButtonStyle;
    TextButtonStyle machtButtonStyle;
    TextButtonStyle tricksterButtonStyle;
    TextButtonStyle heilButtonStyle;
    TextButtonStyle acceptButtonStyle;
    TextButtonStyle neinButtonStyle;
	
    Skin skin;
    BitmapFont font;
	Texture background;
	Texture testTexture;
    TextureAtlas buttonAtlas;
    
    private TextureRegion kriegRegion, schutzRegion, machtRegion, tricksterRegion, heilRegion, neinRegion;
    
    Integer[] temparray;
    boolean ausstehend;
    
	public Editor(final Hornerhelm gam) {
		this.game = gam;
		
		System.out.println("ok:"+game.test);
		
		camera = new OrthographicCamera();
        camera.setToOrtho(false, 540, 540);
        
        background = new Texture(Gdx.files.internal("editor_bg.png"));
        
        stage = new Stage();
        font = new BitmapFont();
        
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("icons.pack"));
        skin.addRegions(buttonAtlas);
        
        kriegRegion = new TextureRegion();
        kriegRegion = buttonAtlas.findRegion("krieg-select");
        
        schutzRegion = new TextureRegion();
        schutzRegion = buttonAtlas.findRegion("schutz-select");
        
        machtRegion = new TextureRegion();
        machtRegion = buttonAtlas.findRegion("macht-select");
        
        tricksterRegion = new TextureRegion();
        tricksterRegion = buttonAtlas.findRegion("trickster-select");
        
        heilRegion = new TextureRegion();
        heilRegion = buttonAtlas.findRegion("heil-select");
        
        neinRegion = new TextureRegion();
        neinRegion = buttonAtlas.findRegion("nein-select");  
        
        neinButtonStyle = new TextButtonStyle();
        neinButtonStyle.font = font;
        neinButtonStyle.up = skin.getDrawable("nein-button");
        
        
        
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
        
        acceptButtonStyle = new TextButtonStyle();
        acceptButtonStyle.font = font;
        acceptButtonStyle.up = skin.getDrawable("okay-button");
        acceptButton = new TextButton("OK", acceptButtonStyle);
        acceptButton.setPosition(450, 0);
        stage.addActor(acceptButton);
        
        temparray = new Integer[5];
        
        kriegButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.test = "krieg";
                System.out.println(game.test);
                add(1);
            }
        });
        
        schutzButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.test = "schutz";
                System.out.println(game.test);
                add(2);
            }
        });
        
        machtButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.test = "macht";
                System.out.println(game.test);
                add(3);
            }
        });
        
        tricksterButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.test = "trickster";
                System.out.println(game.test);
                add(4);
            }
        });

        heilButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.test = "heil";
                System.out.println(game.test);
                add(5);
            }
        });        
        
        acceptButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
    			game.setScreen(new Title(game));
    			dispose();
            }
        });
        
		System.out.println("Editor");
		
        Gdx.input.setInputProcessor(stage);
		
        updateEditor();
        
	}
	
	private void add(Integer entry) {
		
		System.out.println("lenge: "+game.party.size());
		
		ausstehend = true;
		
		for (int i = 0 ; i != game.party.size(); i++){
			
			System.out.println("los gehts");
			
			for (int y = 0; y != 5; y++){
				
				System.out.println("5 mal " + y + " " + i);
				
				if (game.party.get(i)[y] == 0 && ausstehend) {

					System.out.println("DRIN");
					
					temparray = game.party.get(i);
					temparray[y] = entry;

					game.party.set(i, temparray);
					ausstehend = false;
				}
				
				System.out.println("reihe:"+i+" "+Arrays.asList(game.party.get(i)));
			}
			
			System.out.println(" i:" + i + " lenge: "+ game.party.size());
		}
		
		if (game.party.size() != 5 && ausstehend)
		{
			System.out.println("add einherjar");
			game.party.add(new Integer[]{entry,0,0,0,0});
			ausstehend = false;
		}
		
		System.out.println("--------------------------------------------------------------");
		
		updateEditor();
		
	}
	
	private void updateEditor(){
		
		for (int i = 0 ; i != game.party.size(); i++){
			
			if(Arrays.asList(game.party.get(i)).contains(0)){
				System.out.println("0 enthalten");
				acceptButton.setTouchable(Touchable.disabled);
				acceptButton.setStyle(neinButtonStyle);
			}
			else{
				System.out.println("0 NICHT enthalten "+i);
				acceptButton.setTouchable(Touchable.enabled);
				acceptButton.setStyle(acceptButtonStyle);
				if (i+1 == 5){
					System.out.println("fertig und voll");
					kriegButton.setTouchable(Touchable.disabled);
					schutzButton.setTouchable(Touchable.disabled);
					machtButton.setTouchable(Touchable.disabled);
					tricksterButton.setTouchable(Touchable.disabled);
					heilButton.setTouchable(Touchable.disabled);
					
					kriegButton.setStyle(neinButtonStyle);
					schutzButton.setStyle(neinButtonStyle);
					machtButton.setStyle(neinButtonStyle);
					tricksterButton.setStyle(neinButtonStyle);
					heilButton.setStyle(neinButtonStyle);
				}
			}
			
		}
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
		
		for (int i = 0 ; i != game.party.size(); i++){
			
			for (int y = 0; y != game.party.get(i).length; y++){
				int aspect = game.party.get(i)[y];
				if (aspect == 1)
				{
					game.batch.draw(kriegRegion, y*90,450-(90*i));
				}
				else if (aspect == 2){
					game.batch.draw(schutzRegion, y*90,450-(90*i));
				}
				else if (aspect == 3){
					game.batch.draw(machtRegion, y*90,450-(90*i));
				}
				else if (aspect == 4){
					game.batch.draw(tricksterRegion, y*90,450-(90*i));
				}
				else if (aspect == 5){
					game.batch.draw(heilRegion, y*90,450-(90*i));
				}
				else if (aspect == 0){
					game.batch.draw(neinRegion, y*90,450-(90*i));
				}
			}
		}
		game.batch.end();
		
		stage.act();
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
