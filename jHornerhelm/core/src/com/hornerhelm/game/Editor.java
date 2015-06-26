package com.hornerhelm.game;

import java.util.ArrayList;
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
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Editor implements Screen{

	final Hornerhelm game;	
	
	OrthographicCamera camera;
	
    Stage stage;

    MenuButton kriegMenuButton;
    MenuButton schutzMenuButton;
    MenuButton machtMenuButton;
    MenuButton tricksterMenuButton;
    MenuButton heilMenuButton;
    MenuButton acceptMenuButton;
    
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
        
        kriegMenuButton = new MenuButton(game, "Krieg", "krieg-button", 0, 0);
        schutzMenuButton = new MenuButton(game, "Schutz", "schutz-button", 90, 0);
        machtMenuButton = new MenuButton(game, "Asir", "macht-button", 180, 0);
        tricksterMenuButton = new MenuButton(game, "Lokir", "trickster-button", 270, 0);
        heilMenuButton = new MenuButton(game, "Vanir", "heil-button", 360, 0);
        acceptMenuButton = new MenuButton(game, "OK", "okay-button", 450, 0);
        
        stage.addActor(kriegMenuButton.getButton());
        stage.addActor(schutzMenuButton.getButton());
        stage.addActor(machtMenuButton.getButton());
        stage.addActor(tricksterMenuButton.getButton());
        stage.addActor(heilMenuButton.getButton());
        stage.addActor(acceptMenuButton.getButton());
        
        temparray = new Integer[5];
        
        kriegMenuButton.getButton().addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                add(1);
            }
        });
        
        schutzMenuButton.getButton().addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                add(2);
            }
        });
        
        machtMenuButton.getButton().addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                add(3);
            }
        });
        
        tricksterMenuButton.getButton().addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                add(4);
            }
        });

        heilMenuButton.getButton().addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                add(5);
            }
        });        
        
        acceptMenuButton.getButton().addListener(new ClickListener() {
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
			
			boolean keinenull = true;
			
			for (int y = 0; y != 5; y++){
				
				System.out.println("5 mal " + y + " " + i);
				
				if (game.party.get(i)[y] == 0 && ausstehend) {
					
					System.out.println("DRIN");
					
					temparray = game.party.get(i);
					temparray[y] = entry;

					game.party.set(i, temparray);
					ausstehend = false;
				}
				
				if (game.party.get(i)[y] == 0){
					keinenull = false;
				}
				
				if (y == 4 && keinenull && game.party.size() != game.entities.size() ){
					System.out.println("NEW ENTITY HERE");
					Entity einherjar = new Entity();
					einherjar.setEinherjar(game.party.get(i));
					game.entities.add(einherjar);
					System.out.println(game.entities.size());
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
				acceptMenuButton.setState(false);
			}
			else{
				System.out.println("0 NICHT enthalten "+i);
				acceptMenuButton.setState(true);
				if (i+1 == 5){
					System.out.println("fertig und voll");
					kriegMenuButton.setState(false);
					schutzMenuButton.setState(false);
					machtMenuButton.setState(false);
					tricksterMenuButton.setState(false);
					heilMenuButton.setState(false);
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
