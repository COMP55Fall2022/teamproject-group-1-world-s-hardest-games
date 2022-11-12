package classes;
//The main screen where everything is displayed
import acm.program.GraphicsProgram;

public class Play_game extends GraphicsProgram{
	//screen windows
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	//title screen background music
	public static final String MUSIC_FOLDER = "songs";
	private static final String[] SOUND_FILES = { "tutorial.mp3"};
	
	//private Menu_screen menu;
	//private Pass_screen pass;
	//private Fail_screen fail;
	private int count;
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	public void run() {
		System.out.println("Turnt Up Tofu!");
		//menu = new Menu_screen(this);
		//setupInteractions();
	}
	
	
	public void switchToMenu() {
		playBackgroundNoise();
		count++;
		//switchToScreen(menu);
	}
	
	public void switchToFail() {
		//switchToScreen(fail);
	}
	
	public void switchToPass() {
		//switchToScreen(pass);
	}
	
	private void playBackgroundNoise() {
		Song test = Song.getInstance();
		test.playSound(MUSIC_FOLDER, SOUND_FILES[count % SOUND_FILES.length]);
	}
	
	public static void main(String[] args) {
		new Play_game().start();
	}
}