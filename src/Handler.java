
import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
    
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    // ws 1-4 are weapon slots 
    private boolean up = false, down = false, right = false, left = false, pause = false, resume = false, ws1 = false, ws2 = false, ws3 = false, ws4 = false;

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
    public boolean isWs1() {
		return ws1;
	}

	public void setWs1(boolean ws1) {
		this.ws1 = ws1;
	}

	public boolean isWs2() {
		return ws2;
	}

	public void setWs2(boolean ws2) {
		this.ws2 = ws2;
	}

	public boolean isWs3() {
		return ws3;
	}

	public void setWs3(boolean ws3) {
		this.ws3 = ws3;
	}

	public boolean isWs4() {
		return ws4;
	}

	public void setWs4(boolean ws4) {
		this.ws4 = ws4;
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



}
