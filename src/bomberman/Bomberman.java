package bomberman;

public class Bomberman{
    String name;
    char direct='e';
    static int rangeBomb=1;
    int stepForward=1;
    boolean changedStepParm=false;
    Map map=new Map();
    static int[] currentPosition={0,0};
    public Bomberman(String name){
        this.name=name;

    }
    public void startIn(Map map){
        map.map[0][0]=String.valueOf(this.name.charAt(0)).toLowerCase();
        currentPosition=new int[]{0,0};
        this.map=map;
    }
    Bomberman forward(){
        this.caseForwardMvm();
        switch (this.direct){
            case 'e':
                if(currentPosition[1]<this.map.map.length){
                    if(this.map.map[currentPosition[0]][currentPosition[1]+1]!="X") {

                        this.checkBomb();
                        currentPosition=new int[]{currentPosition[0],currentPosition[1]+1};
                        this.checkStarRockEnhancer();
                        this.map.map[currentPosition[0]][currentPosition[1]] = String.valueOf(this.name.charAt(0)).toLowerCase();


                    }
                }
                break;
            case 'n':
                if(currentPosition[0]>0) {
                    if (this.map.map[currentPosition[0]-1][currentPosition[1]]!="X") {
                        if(this.map.map[currentPosition[0]][currentPosition[1]]!="o") {
                            this.map.map[currentPosition[0]][currentPosition[1]] = null;
                        }
                        currentPosition=new int[]{currentPosition[0]-1,currentPosition[1]};
                        this.checkStarRockEnhancer();
                        this.checkEnhancer();
                        this.map.map[currentPosition[0]][currentPosition[1]] = String.valueOf(this.name.charAt(0)).toLowerCase();

                    }
                }
                break;
            case 'w':
                if(currentPosition[1]>0) {
                    if (this.map.map[currentPosition[0]][currentPosition[1] -1]!="X") {
                       this.checkBomb();
                        currentPosition=new int[]{currentPosition[0],currentPosition[1]-1};
                        this.checkStarRockEnhancer();

                        this.map.map[currentPosition[0]][currentPosition[1]] = String.valueOf(this.name.charAt(0)).toLowerCase();

                    }
                }
                break;
            case 's':
                if(currentPosition[0]<this.map.map.length) {
                    if (this.map.map[currentPosition[0]+1][currentPosition[1]]!="X") {
                        this.checkBomb();
                        currentPosition=new int[]{currentPosition[0]+1,currentPosition[1]};
                        this.checkStarRockEnhancer();
                        this.map.map[currentPosition[0]][currentPosition[1]] = String.valueOf(this.name.charAt(0)).toLowerCase();

                    }
                }
                break;
        }

        return this;
    }
    void checkBomb(){
        if(this.map.map[currentPosition[0]][currentPosition[1]]!="o") {
            this.map.map[currentPosition[0]][currentPosition[1]] = null;
        }
    }
    void caseForwardMvm(){
      if(this.stepForward==2&&this.changedStepParm){
          this.stepForward=1;
          this.changedStepParm=false;
          this.forward();
      }
    }
    void checkStarRockEnhancer(){
        if(this.map.map[currentPosition[0]][currentPosition[1]]=="*"){
            this.stepForward=2;
            this.changedStepParm=true;
        }
    }
    void checkEnhancer(){
        if(this.map.map[currentPosition[0]][currentPosition[1]]!="*"
                &&this.map.map[currentPosition[0]][currentPosition[1]]!="o"
                &&this.map.map[currentPosition[0]][currentPosition[1]]!="X"
                &&this.map.map[currentPosition[0]][currentPosition[1]]!=null){

            rangeBomb=Integer.valueOf(this.map.map[currentPosition[0]][currentPosition[1]]);

        }
    }
    Bomberman right(){
        switch (this.direct){
            case 'e':
                this.direct='s';
                break;
            case 's':
                this.direct='w';
                break;
            case 'w':
                this.direct='n';
                break;
            case 'n':
                this.direct='e';
                break;
        }
    return this;
    }
    Bomberman left(){
        switch (this.direct){
            case 'e':
                this.direct='n';
                break;
            case 's':
                this.direct='e';
                break;
            case 'w':
                this.direct='s';
                break;
            case 'n':
                this.direct='w';
                break;
        }
        return this;
    }
    Bomberman bomb(){
        this.map.map[currentPosition[0]][currentPosition[1]]="o";
        return this;
    }

}
