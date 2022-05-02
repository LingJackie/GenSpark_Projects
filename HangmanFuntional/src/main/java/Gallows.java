public class Gallows {
    private String[] gallowsAscii = {"  +---+","  |   |","      |","      |","      |","      |","========="};
    private int state;// 0 - 6; with 0 the gallows is empty and 6 being the full stick man is in the gallows


    public int getState() { return this.state; }
    public void setState(int state){
        if(state > 6){
            this.state = 6;
        }else if(state < 0){
            this.state = 0;
        }else{
            this.state = state;
        }
    }


    public Gallows(int state){
        this.setState(state);
        this.updateGallowsAscii();
    }

    // Increases the state by one and updates the ascii representation of the gallows
    public String incrementState(){
        if(state < 6){
            addLimb(++state);
        }
        return this.toString();
    }

    // Goes through and adds each limp to the ascii gallows art depending on the state
    public String updateGallowsAscii(){
        for(int i = 1; i <= this.state; i++){
            this.addLimb(i);
        }
        return this.toString();
    }

    // Adds a limb to the ascii gallows art
    public void addLimb(int state){
        switch (state){
            case 1:
                gallowsAscii[2] = "  O   |";
                break;
            case 2:
                gallowsAscii[3] = "  |   |";
                break;
            case 3:
                gallowsAscii[3] = " /|   |";
                break;
            case 4:
                gallowsAscii[3] = " /|\\  |";
                break;
            case 5:
                gallowsAscii[4] = " /    |";
                break;
            case 6:
                gallowsAscii[4] = " / \\  |";
                break;
        }
    }

    @Override
    public String toString() {
        String gallows ="";
        for(String s:this.gallowsAscii){
            gallows+= s + "\n";
        }
        return gallows;
    }

}
