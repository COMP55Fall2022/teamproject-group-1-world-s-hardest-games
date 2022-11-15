package classes;

public class Level{
	
	Conductor conductor;
	Conveyor[] conveyorBelts;
	Food[] foodItems;
	Song song;
	HitCircle hitCircle;
	Spawner spawner;
	
	Level(Conductor currConductor, Conveyor[] currBelts, Food[] currItems, Song currSong, HitCircle currCircle, Spawner currSpawner) {
		conductor = currConductor;
		conveyorBelts = currBelts;
		foodItems = currItems;
		song = currSong;
		hitCircle = currCircle;
		spawner = currSpawner;
		
	}

	public Conductor getConductor() {
		return conductor;
	}
	
	public Conveyor[] getConveyorBelts() {
		return conveyorBelts;
	}
	
	public Food[] getFoodItems(){
		return foodItems;
	}
	
	public Song getSong(){
		return song;
	}
	
	public HitCircle getHitCircle() {
		return hitCircle;
	}
	
	public Spawner getSpawner() {
		return spawner;
	}
	
	
}