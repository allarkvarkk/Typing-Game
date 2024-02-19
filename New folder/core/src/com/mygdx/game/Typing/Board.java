package com.mygdx.game.Typing;

import com.badlogic.gdx.Screen;

import java.util.ArrayList;

public class Board implements Screen {
    private ArrayList<String> s;
    public Board(){
        s= new ArrayList<>();
        s = Logic.getNewRandomString();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

      System.out.println(s);
        //System.out.println(Logic.getRandomWord());
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
