package bomberman;

import java.util.ArrayList;
import java.util.List;

public class Map {
    int size;
    String[][] map;

    List<int[]> startRocks;
    List<int[]> enhancerRock;
    public Map(){

    }
    public Map(int size) {
        this.size = size;
        this.map = new String[size][size];
        this.startRocks =new ArrayList();
        this.enhancerRock=new ArrayList();
    }
    Map trigger(){
        for(int i=0;i<this.map.length;i++) {
            for (int j = 0; j < this.map[i].length; j++) {
                if (this.map[i][j] == "o") {
                  this.map[i][j]=null;
                  this.checkBomber(new int[]{i,j});
                  this.checkRock(new int[]{i,j});
                }
            }
        }
        return this;
    }
    void checkRock(int[] position){
        for(int i=0;i<this.map.length;i++) {
            for (int j = 0; j < this.map[i].length; j++) {
                if (this.map[i][j] == "X") {
                    for(int y=1;y<=Bomberman.rangeBomb;y++){
                        if(position[0]+y==i&&position[1]==j||position[0]-y==i&&position[1]==j||position[0]==i&&position[1]+y==j||position[0]==i&&position[1]-y==j){
                            boolean flag=false;
                            for(int[] rockeStar:startRocks){
                                if(rockeStar[0]==i&&rockeStar[1]==j){
                                    this.map[i][j]="*";
                                    flag=true;
                                    break;
                                }
                            }
                            for(int[] enRock:this.enhancerRock){
                                if(enRock[0]==i&&enRock[1]==j){
                                    this.map[i][j]=""+enRock[2];
                                    flag=true;
                                    break;
                                }
                            }
                            if(!flag){
                                this.map[i][j]=null;
                            }

                        }
                    }


                }
            }
        }
    }
    void checkBomber(int[] position){
      if(position[0]==Bomberman.currentPosition[0]&&position[1]==Bomberman.currentPosition[1]){
          this.map[Bomberman.currentPosition[0]][Bomberman.currentPosition[1]]="D";
      }
        if(position[0]+1==Bomberman.currentPosition[0]&&position[1]==Bomberman.currentPosition[1]){
            this.map[Bomberman.currentPosition[0]][Bomberman.currentPosition[1]]="D";
            this.map[position[0]][position[1]]=null;
        }
        if(position[0]-1==Bomberman.currentPosition[0]&&position[1]==Bomberman.currentPosition[1]){
            this.map[Bomberman.currentPosition[0]][Bomberman.currentPosition[1]]="D";
            this.map[position[0]][position[1]]=null;
        }
        if(position[0]==Bomberman.currentPosition[0]&&position[1]+1==Bomberman.currentPosition[1]){
            this.map[Bomberman.currentPosition[0]][Bomberman.currentPosition[1]]="D";
            this.map[position[0]][position[1]]=null;
        }
        if(position[0]==Bomberman.currentPosition[0]&&position[1]-1==Bomberman.currentPosition[1]){
            this.map[Bomberman.currentPosition[0]][Bomberman.currentPosition[1]]="D";
            this.map[position[0]][position[1]]=null;
        }
    }
    String draw(){

        String mp="";
        for(int i=0;i<this.map.length;i++) {
            for (int j = 0; j < this.map[i].length; j++) {
                if (this.map[i][j] == null) {
                    mp = mp + " ";
                } else {
                    mp = mp + this.map[i][j];
                }
            }
            if (i != this.map.length - 1) {
                mp = mp + "\n";
            }
        }
        return mp;
    }
    }
