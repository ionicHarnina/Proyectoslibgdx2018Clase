package com.mygdx.game;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class MyActor extends Actor {
	Texture texture = new Texture(Gdx.files.internal("001.png"));
	public boolean started = false;
	
	public MyActor() {
		super();
		
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(texture, this.getX(), this.getY());
	}
	@Override
	public void act(float delta) {
		super.act(delta);
		this.addAction(Actions.moveBy(1, 1));
	}
}
