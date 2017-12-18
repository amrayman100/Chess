
package chess;

/**
 *
 * @author LoayHamdy
 */
public class Knight implements piece{

    @Override
    public void move(point newPosition) {
    }

    @Override
    public boolean canMove(point position) {
        
  if(position.x<8&&position.x>-1&&position.y>-1&&position.x<8) return true;
            return false;    }

    @Override
    public void generate() {
     int arr1[]={1,-1},arr2[]={-2,2};
        for(int i=0;i<2;i++)
            for(int j=0;j<2;j++)
            {
                point pos1=new point(pos.x+arr1[i],pos.y+arr2[j]),pos2=new point(pos.x+arr2[i],pos.y+arr1[j]);
                if(canMove(pos2))posmoves.add(pos2);
                if(canMove(pos1))posmoves.add(pos1);
            }
    } 
     
    }
    
    

