package tlob.model;

public abstract class Item implements Tick, Hitbox {
	private int xPos;
	private int yPos;
	private String name;
	private int actualFrame = 1;
	private int t = 0;
	private int myTick = 0;
	private int tick = 0;
	
	private int width;
	private int height;
	
	public Item(int xPos,int yPos,String name){
		this.xPos = xPos;
		this.yPos = yPos;
		this.name = name;
		width = height = 35;
	}
	
	public int getMyTick(){
		return this.myTick;
	}

	public void setMyTick(int a)
	{
		this.myTick =a;
	}
	
	public int getActualFrame(){
		return this.actualFrame;
	}

	public void setActualFrame(int a)
	{
		this.actualFrame=a;
	}
	
	public int getXPos()
	{ 
		return xPos;
	}
	
	public void setXPos(int xPos)
	{
		this.xPos = xPos;
	}
	
	public int getYPos()
	{
		return yPos;
	}
	
	public void setYPos(int yPos)
	{ 
		this.yPos = yPos;
	}
	
	public int[] getPos() {
		return new int[]{xPos, yPos};
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int[] getSize() {
		return new int[]{width, height};
	}
	
	public void setPos(int[] pos)
	{ 
		xPos = pos[0];
		yPos = pos[1];
	}
	
	public int[] nextPos(Direction d, int vitesse) {
		if(d == null)
			return getPos();
		return new int[]{xPos + d.dx * vitesse, yPos + d.dy * vitesse};
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name=name;
	}

	public int getTime(){
		return this.t;
	}
	
	public void setTime(int t){
		this.t = t;
	}
	
	@Override
	public void tick(int constante) {
		tick++;
		if(tick == constante) {
			t++;
			tick = 0;
		}
	}

	@Override
	public void tick(int frames, int constante) {
		myTick++;
		if(myTick == constante) {
			actualFrame++;
			myTick = 0;
			if(actualFrame == frames +1)
				this.actualFrame = 1;
		}
	}

}
