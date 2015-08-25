package com.hornerhelm.game;

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

public class Battle  implements Screen{
	
	final Hornerhelm game;
	
	OrthographicCamera camera;
	
    Stage stage;
    
	Texture background;
	Texture menu;
	Texture dummy;
	
	Skin skin;
    BitmapFont font;
	Texture testTexture;
    TextureAtlas buttonAtlas;
	
    TextureRegion einherregion;
    TextureRegion handRegion;

	MenuButton selectMenuButton;
	MenuButton attackMenuButton;
	MenuButton aufgebenMenuButton;
	MenuButton meleeMenuButton;
	MenuButton defendMenuButton;
	
	EntitiesManager entitiesMgr;
	
	Integer numberOfEinherjar;
    Integer activeLoyalist;
    
    Entity testGegner1 = new Entity();
    Entity testGegner2 = new Entity();
    Entity testGegner3 = new Entity();
    
    Integer[][][] targets;
	
	public Battle(final Hornerhelm gam) {
		
		this.game = gam;
		
		stage = new Stage();

        buttonAtlas = game.buttonAtlas;
        
        einherregion = new TextureRegion();
        einherregion = buttonAtlas.findRegion("einherjar");

        handRegion = new TextureRegion();
        handRegion = buttonAtlas.findRegion("hand");
        
        activeLoyalist = 0;
        
        selectMenuButton = new MenuButton(game, "", "select-button", 20, 20);
        attackMenuButton = new MenuButton(game, "", "attack-button", 460, 20);
        meleeMenuButton = new MenuButton(game, "", "melee-button", 95, 15);
        defendMenuButton = new MenuButton(game, "", "defend-button", 165, 15);
        
        aufgebenMenuButton = new MenuButton(game, "", "aufgeben", 495, 115);
		
		camera = new OrthographicCamera();
        camera.setToOrtho(false, 540, 540);
        
        background = new Texture(Gdx.files.internal("battle_bg.png"));
        menu = new Texture(Gdx.files.internal("battle_frame.png"));
        dummy = new Texture(Gdx.files.internal("dummy.png"));
        
        entitiesMgr = new EntitiesManager(game.entities);
        entitiesMgr.resetEinherjarPositions();
        
        testGegner1.setInherentPos(100, 250);
        testGegner1.setEnemy();
        
        testGegner2.setInherentPos(200, 250);
        testGegner2.setEnemy();
        
        testGegner3.setInherentPos(300, 250);
        testGegner3.setEnemy();
        
        entitiesMgr.addEntity(testGegner1);
        entitiesMgr.addEntity(testGegner2);
        entitiesMgr.addEntity(testGegner3);
        
        //0: targeting entity.
        //1: targeted entity. only used for loyal entities.
        //2: used action.
        targets = new Integer[entitiesMgr.getNumberOfEntitites()][entitiesMgr.getNumberOfEntitites()][entitiesMgr.getNumberOfEntitites()];
        
        stage.addActor(selectMenuButton.getButton());
        stage.addActor(attackMenuButton.getButton());
        stage.addActor(aufgebenMenuButton.getButton());
        stage.addActor(meleeMenuButton.getButton());
        stage.addActor(defendMenuButton.getButton());
        
		System.out.println("hm:"+entitiesMgr.countEinherjar());
		
		System.out.println(activeLoyalist);
		
        selectMenuButton.getButton().addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
            	System.out.println("select");
        		System.out.println("active: "+activeLoyalist);
            	nextOne();
            }
        });
        
        attackMenuButton.getButton().addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
            	System.out.println("attack!");
        		System.out.println("active: "+activeLoyalist);
            }
        });
        
        aufgebenMenuButton.getButton().addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
            	System.out.println("aufgeben");
            }
        });
        
        Gdx.input.setInputProcessor(stage);
		
	}
	
	public void nextOne(){
		
		System.out.println("total menge: "+entitiesMgr.countEinherjar());
		
		if (activeLoyalist != entitiesMgr.countEinherjar()-1){
			activeLoyalist++;	
		}
		else{
			activeLoyalist = 0;
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
		
		game.batch.begin();		
		game.batch.draw(background, 0, 0);
		game.batch.draw(menu, 0, 0);
		
		for (int i = 0 ; i != entitiesMgr.getNumberOfEntitites() ; i++){
			
			if (entitiesMgr.getEntity(i).isLoyal() ){
				game.batch.draw(einherregion, entitiesMgr.getEntity(i).getX(),entitiesMgr.getEntity(i).getY());
			}
			
			if (entitiesMgr.getEntity(i).isLoyal() == false){
				game.batch.draw(dummy, entitiesMgr.getEntity(i).getX(),entitiesMgr.getEntity(i).getY());
			}
		}
		
		game.batch.draw(handRegion, entitiesMgr.getEntity(activeLoyalist).getX(),entitiesMgr.getEntity(activeLoyalist).getY() + einherregion.getRegionHeight() );

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
