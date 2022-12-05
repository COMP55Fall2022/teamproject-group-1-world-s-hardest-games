package classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Map_graphics extends Map implements KeyListener {

	
	
	
	public void run() {
		addKeyListeners();
		//play game background
		GImage blue = new GImage("title_screen_bluebackground.jpg", 200, 200);
		add(blue);
		// Score Streak box
		int score_streak_SIZE_x = 60;
		int score_streak_SIZE_y = 50;
		int score_streak_loc_x = 0;
		int score_streak_loc_y = 40;
		int score_streak_ms = 50;
		GRect score_streak = new GRect(score_streak_loc_x, score_streak_loc_y, score_streak_SIZE_x,score_streak_SIZE_y );
		Timer score_streak_graphic = new Timer(score_streak_ms, this);
		GLabel score1;
		GLabel streak1;
		GLabel fail;
		add(score_streak);
		score1 = new GLabel("Score: " + box.get_score(),0, 50);
		streak1 = new GLabel("Streak: " + box.get_streak(),0, 60);
		int fail_x = 0;
		fail = new GLabel("Fail: " ,0, 70);
		add(fail);
		fail_x += 25;
		for (int i = 0; i < + box.get_failCount(); i++) {
			fail = new GLabel("X " , fail_x, 70);
			fail_x += 10;
			add(fail);
		}
		
		score_streak_graphic.start();
		add(score1);
		add(streak1);
		
		// Conveyor
		final int x1 = 0; //still need to initialize these
		final int y1 = 500; 
		final int x2 = 400;
		final int y2 = 500; 
	  	if (current.getConveyorBelt().getNumConveyors() == 1) {
	  		GImage singleConveyor = new GImage("longconveyor.png", x1, y1);
	  		add(singleConveyor);
	  	}
	  	
	  	if (current.getConveyorBelt().getNumConveyors() ==2) {
	  		GImage conveyor1 = new GImage("conveyor2.png", x1, y1);
	  		add(conveyor1);
	  		
	  		GImage conveyor2 = new GImage("conveyor2.png", x2, y2);
	  		add(conveyor2);
	  	}
		// Spawner
		spawn.spawnFood(current); 
		
		// hit Circle

	}
	boolean fail() {
		System.out.println("fail");
		//activates when buttons are pressed
		// looks at current map --> fail screen
		if (box.get_failCount() == 3) {
			box.reset_fail();
			return true;
		}
		return false;
	}
	boolean pass(int score, Level level) {
		System.out.println("pass");
		if(score == level.get_food_length()) {
			box.reset();
			curr_level_num ++;
			if (curr_level_num < 3) {
				current = level_arr[curr_level_num];
			}
			pass.run();
			return true;
		}
		return false;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyChar());
		int key = e.getKeyCode();
		current.getConductor().playSong(current.get_string());
		Food curr_food = current.getConductor().getCurrentNote(current.get_string());
		if (key == KeyEvent.VK_W) {
			if (curr_food.getFoodType().toString() == "bun" && current.getHitCircle().isHit(curr_food, current)) {
				box.incrementScore();
			}
			else {
				box.reset_streak();
				box.incrementFail();
				
			}
			if (fail()) {
				current.getConductor().stopSong(current.get_string());
				fail.start();
			}
			if (pass(box.get_score(), current)) {
				current.getConductor().stopSong(current.get_string());
				pass.start();
			}
			
		}
		if (key == KeyEvent.VK_A) {
			if (curr_food.getFoodType().toString()== "tomato" && current.getHitCircle().isHit(curr_food, current)) {
				box.incrementScore();
			}
			else {
				box.reset_streak();
				box.incrementFail();
			}
			if (fail()) {
				current.getConductor().stopSong(current.get_string());
				fail.start();
			}
			if (pass(box.get_score(), current)) {
				current.getConductor().stopSong(current.get_string());
				pass.start();
			}
		}
		if (key == KeyEvent.VK_S) {
			if (curr_food.getFoodType().toString()== "tofu" && current.getHitCircle().isHit(curr_food, current)) {
				box.incrementScore();
			}
			else {
				box.reset_streak();
				box.incrementFail();
			}
			if (fail()) {
				current.getConductor().stopSong(current.get_string());
				fail.start();
			}
			if (pass(box.get_score(), current)) {
				current.getConductor().stopSong(current.get_string());
				pass.start();
			}
		}
		if (key == KeyEvent.VK_D) {
			if (curr_food.getFoodType().toString()== "bun" && current.getHitCircle().isHit(curr_food, current)) {
				box.incrementScore();
			}
			else {
				box.reset_streak();
				box.incrementFail();
			}
			if (fail()) {
				current.getConductor().stopSong(current.get_string());
				fail.start();
			}
			if (pass(box.get_score(), current)) {
				current.getConductor().stopSong(current.get_string());
				pass.start();
			}
		}
		
		
	}
	
	public static void main(String args[]) {
		//new Map_graphics().start();
	}
	
	
}