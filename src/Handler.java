
import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
    
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    // ws 1-4 are weapon slots 
    private boolean up = false, down = false, right = false, left = false, pause = false, resume = false, weaponP = false, weaponM = false, fire = false;

    //Player movement keys
    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }
    
    // enter pause state
	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}
	//enter game state
	public boolean isResume() {
		return resume;
	}

	public void setResume(boolean resume) {
		this.resume = resume;
	}
   

	public void tick(){
    	
    	
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            
            tempObject.tick();
            
        }
    }
    public void render (Graphics g){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject =  object.get(i);
            tempObject.render(g);
        }
    }
    public void addObject(GameObject object){
        this.object.add(object);
        
    }
    public void removeObject(GameObject object){
        this.object.remove(object);
    }

	public boolean isFire() {
		return fire;
	}

	public void setFire(boolean fire) {
		this.fire = fire;
	}

	public boolean isWeaponM() {
		return weaponM;
	}

	public void setWeaponM(boolean weaponM) {
		this.weaponM = weaponM;
	}

	public boolean isWeaponP() {
		return weaponP;
	}

	public void setWeaponP(boolean weaponP) {
		this.weaponP = weaponP;
	}



}
