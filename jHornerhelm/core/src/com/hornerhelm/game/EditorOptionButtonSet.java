package com.hornerhelm.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class EditorOptionButtonSet {
	
	TextButton detailsButton, deleteButton, upButton, downButton;
	
	TextButtonStyle detailsButtonStyle, deleteButtonStyle, upButtonStyle, downButtonStyle;
	
    Skin skin;
    BitmapFont font;
	Texture background;
	Texture testTexture;
    TextureAtlas buttonAtlas;
    int global_x = 0;
    int global_y = 0;
    
	
    public void setPosition(int x, int y){
    	global_x = x;
    	global_y = y;
    	
    }
    
	public EditorOptionButtonSet() {
		
        font = new BitmapFont();
		
		skin = new Skin();
		buttonAtlas = new TextureAtlas(Gdx.files.internal("icons.pack"));
		skin.addRegions(buttonAtlas);
		
		deleteButtonStyle = new TextButtonStyle();
		deleteButtonStyle.font = font;
		deleteButtonStyle.up = skin.getDrawable("delete-option");
        deleteButton = new TextButton("", deleteButtonStyle);
        deleteButton.setPosition(global_x+45, global_y);
	}

}
