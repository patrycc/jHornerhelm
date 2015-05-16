package com.hornerhelm.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.hornerhelm.game.Hornerhelm;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Hornerhelm - Tales of the Einherjar [conceptual]";
		config.width = 540;
		config.height = 540;
		config.resizable = false;
		new LwjglApplication(new Hornerhelm(), config);
	}
}
