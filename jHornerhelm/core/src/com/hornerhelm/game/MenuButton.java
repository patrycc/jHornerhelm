package com.hornerhelm.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class MenuButton {

    final Hornerhelm game;	
	
	private TextButton menuButton;
	
	private TextButtonStyle menuButtonStyle;
	private TextButtonStyle neinButtonStyle;
	
	private Skin skin;
	private BitmapFont font;
	private TextureAtlas buttonAtlas;
	
	public MenuButton(final Hornerhelm gam, String label, String buttonID, int x, int y){
		
		this.game = gam;
		
		skin = game.skin;
		font = game.font;
		buttonAtlas = game.buttonAtlas;
		skin.addRegions(buttonAtlas);		
		
		menuButtonStyle = new TextButtonStyle();
		neinButtonStyle = new TextButtonStyle();
		
		menuButtonStyle.font = font;
		neinButtonStyle.font = font;
		
		
		menuButtonStyle.up = skin.getDrawable(buttonID);
		neinButtonStyle.up = skin.getDrawable("nein-button");
		
		menuButton = new TextButton(label, menuButtonStyle);
		menuButton.setPosition(x, y);
		
	}
	
	public void setState( boolean schalter ){
		
		if (schalter){
			menuButton.setStyle(menuButtonStyle);
			menuButton.setTouchable(Touchable.enabled);
		}
		else
		{
			//menuButton.get
			menuButton.setStyle(neinButtonStyle);
			menuButton.setTouchable(Touchable.disabled);
		}
		
	}
	
	public TextButton getButton(){
		return menuButton;
	}
	
}
